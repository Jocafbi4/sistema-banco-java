public class Cliente {
    private String nome;
    private String cpf;
    private double saldo;
    private TipoConta tipoConta;

    public Cliente(String nome, String cpf, double saldoInicial, TipoConta tipoConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldoInicial;
        this.tipoConta = tipoConta;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
