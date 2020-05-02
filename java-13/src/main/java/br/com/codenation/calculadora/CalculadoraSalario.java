package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {

		if(salarioBase > 1039) {
			double salarioBrutoInss = calcularInss(salarioBase);;
			double salarioBrutoIrrf = calcularIrrf(salarioBrutoInss);;

			return Math.round(salarioBrutoIrrf);
		}

		return Math.round(0.0);
	}

	private double calcularInss(double salarioBase) {

		if (salarioBase <= 1500) {
			salarioBase = calcularPorcentagem(salarioBase, 8);
		} else if (salarioBase >= 1500.01 && salarioBase <= 4000 ) {
			salarioBase = calcularPorcentagem(salarioBase, 9);
		} else {
			salarioBase = calcularPorcentagem(salarioBase, 11);
		}

		return salarioBase;
	}

	private double calcularIrrf(double salarioBruto) {
		if(salarioBruto <= 3000) {
			salarioBruto = salarioBruto;
		} else if (salarioBruto >= 3000.01 && salarioBruto <= 6000) {
			salarioBruto = calcularPorcentagem(salarioBruto, 7.5);
		} else {
			salarioBruto = calcularPorcentagem(salarioBruto, 15);
		}

		return salarioBruto;
	}

	private double calcularPorcentagem(double salario, double porcentagem) {
		return salario - (salario * (porcentagem/100));
	}

}