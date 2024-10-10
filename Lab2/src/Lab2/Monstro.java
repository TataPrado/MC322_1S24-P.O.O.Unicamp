package Lab2;

import java.util.List;

public class Monstro {
    //Attributes
    private String nomeMonstro;
    private int poder;
    private List <Item> tesouros;
    private int niveisPerdidos;

    //Methods
    public Monstro (String nomeMonstro, int poder, List<Item> tesouros, int niveisPerdidos){
        this.nomeMonstro = nomeMonstro;
        this.poder = poder;
        this.tesouros = tesouros;
        this.niveisPerdidos= niveisPerdidos;
    }
    public String toString() {
        return String.format ("Nome do Monstro: " + this.nomeMonstro + "\n"
                + "Nível de poder: " + this.poder + "\n"
                + "Tesouro: " + tesouros);
    }
}
