import java.util.ArrayList;

public class Pedido{

    ArrayList<Pizza> pizzas;
    Pessoa cliente;
    double valorPedido;

    public Pedido(ArrayList<Pizza> pizzas, Pessoa cliente, double valorPedido){
        this.pizzas = pizzas;
        this.cliente = cliente;
        this.valorPedido = valorPedido;
    }

    public double calcularValorTotalPedido(){
        return this.valorPedido;  // nao tem muito a parte do calcular aqui
    }

    public void addPizza(Pizza p){
        this.pizzas.add(p);
        this.valorPedido += p.getPreco();
    }

    public void addCliente(Pessoa p){ // nao devia ser setCliente()?
        this.cliente = p;
    }

    public Pessoa getCliente(){
        return this.cliente;
    }
    public ArrayList<Pizza> getPizzas(){
        return this.pizzas;
    }
}