package view;

import controller.EstacionamentoController;
import model.Carro;
import model.EstacionamentoModelo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EstacionamentoController controller = new EstacionamentoController();

controller.mostrarMenu();
        controller.iniciar();
    }
}
