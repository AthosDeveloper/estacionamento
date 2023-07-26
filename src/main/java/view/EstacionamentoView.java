package view;

import model.Carro;

import java.util.List;
import java.util.Scanner;

/*
a responsabilidade dessa classe é ler, exibir mensagem e exibir os carros cadastrados.
 */
public class EstacionamentoView {
    private Scanner scanner;

    public EstacionamentoView() {
        scanner = new Scanner(System.in);
    }

    public void ExibirCarrosEstacionados(List<Carro> carros) {
        System.out.println("carros estacionados:");
        for (Carro carro : carros) {
            System.out.println("nome: " + carro.getNome());
            System.out.println("placa: " + carro.getPlaca());
            System.out.println("dono: " + carro.getDono());
            System.out.println("permanência: " + carro.getPermanencia());
            System.out.println("valor pago: " + carro.getValorPago());

    }


}

public String lerEntradaTexto(String mensagem){
    System.out.println(mensagem);

    return  scanner.next();

}
public double lerEntradaNumero(String mmensagem){
    System.out.println(mmensagem);
    return  scanner.nextDouble();
}
public int lerNumeroInteiro(String mensagem){
    System.out.println(mensagem);
    return  scanner.nextInt();
}
public void exibirMensagem(String msg){
    System.out.println(msg);
}


}
