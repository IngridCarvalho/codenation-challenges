package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    final int LOTACAO_MAXIMA = 10;
    final int IDADE_MAXIMA_TROCA = 55;
    final int MAIOR_IDADE = 18;
    final int LIMITE_PONTOS = 20;

    List<Carro> carros = new ArrayList<>();

    public void estacionar(Carro carro) {

        if(validaMotorista(carro.getMotorista()))
        {
            if(carros.size() < LOTACAO_MAXIMA) {
                carros.add(carro);
            } else {
                verificaCarros(carro);
            }
        } else {
            throw new EstacionamentoException("Os dados do motorista não permitem utilizar o estacionamento");
        }
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carros.contains(carro);
    }

    public void verificaCarros(Carro carro) {
        boolean encontrouVaga = false;
        for (int i=0; i<carros.size(); i++) {
            if (carros.get(i).getMotorista().getIdade() < IDADE_MAXIMA_TROCA) {
                carros.remove(i);
                carros.add(i, carro);
                encontrouVaga = true;
                break;
            }
        }

        if(!encontrouVaga) {
            throw new EstacionamentoException("Não será possivel estacionar, todos são maiores de "+ IDADE_MAXIMA_TROCA +" anos");
        }
    }

    public boolean validaMotorista(Motorista motorista) {
        return motorista != null
                && !motorista.getHabilitacao().isEmpty()
                && motorista.getIdade() > MAIOR_IDADE
                && motorista.getPontos() <= LIMITE_PONTOS;
    }

}
