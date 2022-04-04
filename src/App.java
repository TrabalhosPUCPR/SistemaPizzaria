import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        menu();
    }

    private static void menu(){
        try{
            boolean loop = true;
            println_bonito("\nBem vindo a pizzaria\n");
            Pedido pedido = cadastroPedido();
            while(loop){
                println_bonito("\nBem vindo a pizzaria, "+pedido.getCliente().getNome() +" \nDigite uma opcao:\n\n");
                println_bonito("1 - Cadastrar novo pedido\n2 - Editar informacoes pessoais\n3 - Adicionar uma pizza ao pedido\n4 - Calcular o valor\n5 - Mostrar dados do pedido\n6 - Sair\nR: ");
                int res = Integer.parseInt(sc.nextLine());
                switch(res){
                    case 1:
                        pedido = cadastroPedido();
                    break;
                    case 2:
                        pedido.addCliente(criarCliente());
                    break;
                    case 3:
                        pedido.addPizza(adicionarPizza());
                    break;
                    case 4:
                        println_bonito("O seu pedido esta com um custo atual de " + pedido.calcularValorTotalPedido());
                    break;
                    case 5:
                        println_bonito("\nCliente: " + pedido.getCliente().getNome() + ", Telefone: " + pedido.getCliente().getTelefone() + ", Endereco: " + pedido.getCliente().getEndereco()+"\n");
                        println_bonito("O seu pedido esta com um custo atual de " + pedido.calcularValorTotalPedido()+", voce adicionou as pizzas: \n\n");
                        for(int i = 0;i<pedido.getPizzas().size();i++){
                            println_bonito("Pizza sabor " + pedido.getPizzas().get(i).getSabor() + ", Tamanho: " + pedido.getPizzas().get(i).getTamanho() + ", Preco: " + pedido.getPizzas().get(i).getPreco()+"\n");
                        }
                    break;
                    case 6:
                        println_bonito("Trabalho feito por Leonardo Matthew Knight");
                        Thread.sleep(600);
                        loop = false;
                    break;
                    default:
                        println_bonito("Digite uma opcao valida");
                    break;
                }
            }
        }catch(Exception e){
            println_bonito("Digite uma opcao valida");
        }
    }

    static Pessoa criarCliente(){
        println_bonito("Digite o seu nome: ");
        String nome = sc.nextLine();
        println_bonito("Digite o seu telefone: ");
        String telefone = sc.nextLine();
        println_bonito("Digite o seu endereco: ");
        String endereco = sc.nextLine();
        return new Pessoa(nome, telefone, endereco);
    }

    static Pedido cadastroPedido() throws InterruptedException{
        Pessoa cliente = criarCliente();
        boolean res = true;
        ArrayList<Pizza> pizzas = new ArrayList<>();
        while(res){
            pizzas.add(adicionarPizza());
            println_bonito("Gostaria de adicionar mais alguma pizza?\nDigite 's' ou 'n'");
            if(sc.nextLine().toLowerCase() != "s"){
                res = false;
            }
        }
        double valorpizzas = 0;
        for(int i = 0; i< pizzas.size();i++){
            valorpizzas += pizzas.get(i).getPreco();
        }
        Pedido pedido = new Pedido(pizzas, cliente, valorpizzas);
        println_bonito("Pedido cadastrado com sucesso");
        Thread.sleep(600);
        System.out.println("");
        return pedido;
    }

    static Pizza adicionarPizza(){
        try{
            println_bonito("Digite o sabor pizza que gostaria de adicionar: ");
            String sabor = sc.nextLine();
            println_bonito("Digite o tamanho da pizza que gostaria de adicionar: ");
            String tamanho = sc.nextLine();
            println_bonito("Digite o preco da pizza que gostaria de adicionar: ");
            double preco = Double.parseDouble(sc.nextLine());
            println_bonito("Pizza sabor de "+sabor+" adicionado com sucesso\n");
            Thread.sleep(600);
            return new Pizza(tamanho, preco, sabor); 
        }catch(Exception e){
            println_bonito("Digite uma opcao valida");
        }
        return null;
    }

    private static void println_bonito(Object ms){
        String msg = ms.toString();
        int tempo = 500;
        int n = 0;
        for(int i = 0; i < msg.length();i++){
            n++; // primeiro ele ve quantos digitos existem na mensagem pra dividi o tempo por isso
        }
        tempo = tempo/n;
        for(int i = 0; i < n;i++){
            System.out.print(msg.charAt(i));
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
