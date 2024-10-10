package Lab2;

import Lab2.Classe;

public class ClasseMago extends Classe {
    private Item itemCabeca;

    public ClasseMago(Item itemCabeca, String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCabeca = itemCabeca;
    }
    public ClasseMago() {
        super();
    }    
    public String toString() {
        return super.toString() + ", Item de Cabeça: " + itemCabeca;
    }
}
