package Lab2;

import Lab2.Classe;

public class ClasseGuerreiro extends Classe {
    //Attributes
    private Item itemCorpo;
    private Item itemCabeca;

    //Methods
    public ClasseGuerreiro(Item itemCorpo, Item itemCabeca, String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCorpo = itemCorpo;
        this.itemCabeca = itemCabeca;
    }

    public String toString() {
        return String.format(super.toString() + "Item de Cabeça: " + itemCabeca + "\n" +
                "Item do Corpo" + itemCorpo);
    }
}
