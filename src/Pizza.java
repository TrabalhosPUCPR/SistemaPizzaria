public class Pizza {

    String tamanho;
    Double preco;
    String sabor;

    public Pizza(String tamanho, Double preco, String sabor){
        this.tamanho = tamanho;
        this.preco = preco;
        this.sabor = sabor;
    }

    public String getSabor(){return this.sabor;}
    public String getTamanho(){return this.tamanho;}
    public double getPreco(){return this.preco;}
}
