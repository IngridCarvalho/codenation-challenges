package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {

		int sum = 0;

		for(int element : elements) {
			sum += element;
		}

		return sum/elements.length;
	}

	public static int mode(int[] elements) {

		Arrays.sort(elements);

		int prevElement = elements[0];
		int quantity = 0;
		int count = 0;
		int valueMode = 0;

		for(int element : elements) {
			if (element == prevElement) {
				count++;
			} else {

				if (quantity < count) {
					valueMode = prevElement;
					quantity = count;
				}
				prevElement = element;
				count = 1;
			}
		}

		if (quantity < count) {
			valueMode = prevElement;
		}

		return valueMode;
	}

	public static int median(int[] elements) {

		Arrays.sort(elements);

		int sizeArray = elements.length;
		int valueMedian;
		int position = sizeArray/2;

		if (sizeArray % 2 == 0) {
			valueMedian = (elements[position - 1] + elements[position])/2;
		} else {
			valueMedian = elements[position];
		}

		return valueMedian;
	}
}