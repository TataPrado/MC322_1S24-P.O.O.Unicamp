package Lab4;

public class Monstro {
    //Attributes
    private String nomeMonstro;
    private int poder;
    private int tesouros;
    private int niveisPerdidos;

    //Methods
    public Monstro (String nomeMonstro, int poder, int tesouros, int niveisPerdidos){
        this.nomeMonstro = nomeMonstro;
        this.poder = poder;
        this.tesouros = tesouros;
        this.niveisPerdidos= niveisPerdidos;
    }

    public int getPoder(){
        return poder;
    }

    public int getNivel() {
        return niveisPerdidos;
    }

    public int getTesouros() {
        return tesouros;
    }

    public String toString() {
        return String.format ("Nome do Monstro: " + this.nomeMonstro + "\n"
                + "Nível de poder: " + this.poder + "\n"
                + "Tesouro: " + tesouros);
    }
}
