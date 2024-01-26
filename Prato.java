
import java.util.Objects;

public class Prato {
    private String nomePrato;
    private double preco;
    private String nomeChefe;
    private int quantidadeVendida;

    // Construtor padrão
    public Prato() {
        // Inicializa os atributos com valores padrão
        this.nomePrato = "";
        this.preco = 0.0;
        this.nomeChefe = "";
        this.quantidadeVendida = 0;
    }

    // Construtor com parâmetros
    public Prato(String nomePrato, double preco, String nomeChefe, int quantidadeVendida ) {
        this.nomePrato = nomePrato;
        this.preco = preco;
        this.nomeChefe = nomeChefe;
        this.quantidadeVendida = quantidadeVendida ; // Inicialmente zero
    }

    // Getters e Setters
    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNomeChefe() {
        return nomeChefe;
    }

    public void setNomeChefe(String nomeChefe) {
        this.nomeChefe = nomeChefe;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    // Método toString
    @Override
    public String toString() {
        return "Prato: " + nomePrato +
               "\nPreço: " + preco +
               "\nChefe: " + nomeChefe +
               "\nQuantidade Vendida: " + quantidadeVendida;
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prato that = (Prato) o;
        return Double.compare(that.preco, preco) == 0 &&
               quantidadeVendida == that.quantidadeVendida &&
               Objects.equals(nomePrato, that.nomePrato) &&
               Objects.equals(nomeChefe, that.nomeChefe);
    }

    // Método hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nomePrato, preco, nomeChefe, quantidadeVendida);
    }
}
