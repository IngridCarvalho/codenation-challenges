package br.com.codenation.paymentmethods;

public class DebitCard implements PriceStrategy {

	private final Double DESCOUNT = 0.95;

	@Override
	public Double calculate(Double price) {
		return price * DESCOUNT;
	}
}
