package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        List<Integer> teste = new ArrayList<>();

        teste = DesafioApplication.fibonacci();

        System.out.println(teste);
    }
}
