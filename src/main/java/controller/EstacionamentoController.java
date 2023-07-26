package controller;

import model.Carro;
import model.EstacionamentoModelo;
import view.EstacionamentoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EstacionamentoController {
    private EstacionamentoView view;
    private EstacionamentoModelo modelo;
private  Scanner scanner;

    public EstacionamentoController() {
        view = new EstacionamentoView();
        modelo = new EstacionamentoModelo();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = 0;
        do {
            System.out.println("escolha sua opção: ");
            opcao = scanner.nextInt();
switch (opcao) {

    case 1:
        adicionarCarro();
        break;
    case  2:
        exibirCarros();
break;
    case  3:
        atualizarCarro();
        break;
    case  4:
        excluirCarro();
        break;
    case  5:
        break;
    default:
        view.exibirMensagem("opção inválida");
        break;
}

 } while (opcao != 5);

    }

    public void mostrarMenu() {
        view.exibirMensagem("menu principal");
        view.exibirMensagem("1, adicionar carro");
        view.exibirMensagem("2, exibir carros estacionados");
        view.exibirMensagem("3, atualizar carro");
        view.exibirMensagem("4, excluir carro");
        view.exibirMensagem("5, sair");
    }
public void exibirCarros(){

        view.ExibirCarrosEstacionados(modelo.getCarrosEstacionados());
}
     public void adicionarCarro() {
        String nome = view.lerEntradaTexto("informe o modelo  do carro:");
        String placa = view.lerEntradaTexto("digite a placa do carro");
        String donoDoCarro = view.lerEntradaTexto("informe o proprietário do carro:");
        int permanencia = view.lerNumeroInteiro("digite a permanência do carro:");
        double valorPago = view.lerEntradaNumero("digite o valor a ser pago");
        Carro carro = new Carro(donoDoCarro, placa, permanencia, valorPago);
        if (modelo.verificarAdicao(carro)) {
            view.exibirMensagem("carro adicionado com sucesso!");
        } else {
            view.exibirMensagem("erro, carro já está estacionado.");
        }
    }

    public void atualizarCarro() {
        String placa = view.lerEntradaTexto("digite a placa do carro:");
        int permanencia = view.lerNumeroInteiro("digite o tempo extra que o carro vai permanecer:");
        double valorPago = view.lerEntradaNumero("digite o valor extra a ser cobrado:");


            Carro carro = new Carro(placa, permanencia, valorPago);
            modelo.atualizarCarroEstacionado(carro);
            if (modelo.verificarAtualizacao(carro)) {
                view.exibirMensagem("valor atualizado com sucesso, o valor a ser paggo pelo tempo extra é de: " + valorPago);
            } else {
                view.exibirMensagem("não foi possível atualizar o carro");
            }
        }

    public void excluirCarro() {
        String placa = view.lerEntradaTexto("digite a placa do carro:");
        if (modelo.carroJaEstacionado(placa)) {
            if (modelo.verificarExclusao(placa)) {
                view.exibirMensagem("o carro saiu do estacionamento.");
            } else {
                view.exibirMensagem("erro: não foi possível excluir o carro");


            }
        } else {
            view.exibirMensagem("carro não encontrado");
        }
    }
}


