package Lab2;

public class Classe{
    //Attributes
    private String descricao;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    //Methods
    public Classe(){

    }
    
    protected Classe (String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe){
        this.descricao = descricao;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }
    public String toString() {
        String resultado = "";
        if (itemMaoDireita == null){
            resultado = "Mão direita está vazia \n";
        }
        if (itemMaoEsquerda == null){
            resultado += "Mão esquerda está vazia \n";
        }
        resultado += "Descrição: " + this.descricao;
        return resultado;
    }

    public boolean possuiMaoVazia() {
        if (itemMaoDireita == null || itemMaoEsquerda== null){
            return false;
        }
        else
            return true;
    }
}
