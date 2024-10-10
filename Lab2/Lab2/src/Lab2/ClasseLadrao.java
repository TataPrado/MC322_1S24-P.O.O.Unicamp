package Lab2;

import Lab2.Classe;

public class ClasseLadrao extends Classe {
    private Item itemCorpo;

    public ClasseLadrao(Item itemCorpo, String descricao, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        super(descricao, itemMaoDireita, itemMaoEsquerda, itemPe);
        this.itemCorpo = itemCorpo;
    }
    public ClasseLadrao() {
        super();
    }
    public String toString() {
        return super.toString() + ", Item do Corpo: " + itemCorpo;
    }
}
