package br.com.codenation.service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {

		return items.stream()
				.mapToDouble((orderItem) -> {
					Product product = verifyProduct(orderItem.getProductId());
					if(product.getIsSale()) {
						return (product.getValue() * orderItem.getQuantity()) - ((product.getValue() * orderItem.getQuantity()) * 0.20);
					} else {
						return product.getValue() * orderItem.getQuantity();
					}
				})
				.sum();

	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {

		return ids.stream()
				.map(id -> verifyProduct(id))
				.filter(product -> product != null)
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {

		return orders.stream()
				.mapToDouble(this::calculateOrderValue)
				.sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {

		return productIds.stream()
				.map(id-> verifyProduct(id))
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

	private Product verifyProduct(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

}