package Lab2;

public class Raca {
    //Attributes
    private String descricao;
    private String nomeDaRaca;
    private int minimoPraFugir;

    //Methods
    public Raca(String descricao, String nomeDaRaca, int minimoPraFugir){
        this.descricao = descricao;
        this.nomeDaRaca = nomeDaRaca;
        this.minimoPraFugir = minimoPraFugir;
    }

    public String toString(){
        return String.format ("Descrição da Raça: " + descricao + "\n"
                + "Nome da Raça: " + nomeDaRaca);
    }
}
