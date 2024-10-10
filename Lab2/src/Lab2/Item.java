package Lab2;

import java.util.ArrayList;

public class Item {
    //Attributes
    private String nomeItem;
    private int bonusPoder;
    public int valor;
    private String tipo;
    private boolean itemGrande;
    private ArrayList<Classe> classesCompativeis;

    //Methods
    public Item (String nomeItem, int bonusPoder, int valor, String tipo, boolean itemGrande, ArrayList<Classe> classesCompativeis){
        this.nomeItem = nomeItem;
        this.bonusPoder = bonusPoder;
        this.valor = valor;
        this.tipo = tipo;
        this.itemGrande = itemGrande;
        this.classesCompativeis = new ArrayList<Classe>(classesCompativeis);
    }
    public int getValor(){
        return valor;
    }
    public String getNomeItem(){
        return nomeItem;
    }
    public ArrayList<Classe> getClassesCompativeis() {
        return classesCompativeis;
    }
    public void setClassesCompativeis(ArrayList <Classe> classesCompativeis) {
        this.classesCompativeis = classesCompativeis;
    }
    public boolean getItemGrande(){
        return itemGrande;
    }

        public String toString() {
        return nomeItem;
    }

}
