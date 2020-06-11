package br.com.codenation.paymentmethods;

public class Transfer implements PriceStrategy {

	private final Double DESCOUNT = 0.92;

	@Override
	public Double calculate(Double price) {
		return price * DESCOUNT;
	}
}
