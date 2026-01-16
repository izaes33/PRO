package Ej05;

public class CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular) {
        this.titular = titular;
    }

    public CuentaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            this.saldo = saldo;
            System.out.println("Depósito de " + cantidad + "€. Nuevo saldo: " + saldo + "€\n");
        } else {
            System.out.println("Cantidad inválida para depositar.\n");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
                this.saldo = saldo;
                System.out.println("Retiro de " + cantidad + "€. Nuevo saldo: " + saldo + "€\n");
            } else {
                System.out.println("No hay suficiente saldo para retirar " + cantidad + "€.\n");
            }
        } else {
            System.out.println("Cantidad inválida para retirar.\n");
        }
    }
}
