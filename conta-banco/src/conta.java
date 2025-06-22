public class conta {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public conta(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta: " + numero + ", Agência: " + agencia + ", Cliente: " + nomeCliente + ", Saldo: " + saldo;
    }
    public int getNumero() {
    return numero;
    }

    public double getSaldo() {
    return saldo;
    } 

    public void setSaldo(double saldo) {
    this.saldo = saldo;
   }
}


