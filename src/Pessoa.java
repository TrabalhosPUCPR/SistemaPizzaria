public class Pessoa {

    String nome;
    String telefone;
    String endereco;
    public Pessoa cliente;

    public Pessoa(String nome, String telefone, String endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome(){return this.nome;}
    public String getTelefone(){return this.telefone;}
    public String getEndereco(){return this.endereco;}
}
