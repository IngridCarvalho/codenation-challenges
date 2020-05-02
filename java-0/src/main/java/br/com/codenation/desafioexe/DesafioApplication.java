package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {

        List<Integer> fibonacci = new ArrayList<>();
        int next = 0;

        fibonacci.add(0);
        fibonacci.add(1);

        while(next <= 350) {

            next = fibonacci.get(fibonacci.size() - 2) + fibonacci.get(fibonacci.size() - 1);
            fibonacci.add(next);

        }

	    return fibonacci;
	}

	public static Boolean isFibonacci(Integer a) {

        return fibonacci().contains(a);
	}

}