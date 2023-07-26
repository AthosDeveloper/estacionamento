package model;

public class Carro {
private String nome;
private String placa;
private String dono;
private int permanencia;
private double valorPago;

    public Carro(String nome, String placa, String dono, int permanencia, double valorPago) {
        this.nome = nome;
        this.placa = placa;
        this.dono = dono;
        this.permanencia = permanencia;
        this.valorPago = valorPago;
    }

    public Carro(String placa, String dono, int permanencia, double valorPago) {
        this.placa = placa;
        this.dono = dono;
        this.permanencia = permanencia;
        this.valorPago = valorPago;
    }

    public Carro(String placa, int permanencia, double valorPago){
        this.placa = placa;
        this.permanencia = permanencia;
        this.valorPago = valorPago;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public int getPermanencia() {
        return permanencia;
    }

    public void setPermanencia(int permanencia) {
        this.permanencia = permanencia;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }
}
