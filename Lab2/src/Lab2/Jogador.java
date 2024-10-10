package Lab2;

public class Jogador {
    //Attributes
    private String nome;
    private int nivel;
    private Raca raca;
    private Classe classe;
    private Inventario inventario;

    //Methods
    public Jogador(String nome, int nivel, Raca raca, Classe classe, Inventario inventario){
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe= classe;
        this.inventario = inventario;
    }

    private int poderJogador(){
        int valor = nivel;
        for (Item item:inventario.inventario){
            nivel+= item.getValor();
        }
        return valor + nivel;
    }

    public String toString(){
        return "O poder de ataque do jogador é: " + poderJogador();
    }
}
