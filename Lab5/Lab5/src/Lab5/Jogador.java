package Lab5;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    // Attributes
    private String nome;
    private int nivel;
    private Raca.Racas raca;
    private Classe.Classes classe;
    private Inventario inventario;
    private Item itemCabeca;
    private Item itemCorpo;
    private Item itemMaoDireita;
    private Item itemMaoEsquerda;
    private Item itemPe;

    // Methods
    public Jogador(String nome, int nivel, Raca.Racas raca, Classe.Classes classe, Inventario inventario, Item itemCabeca,
                   Item itemCorpo, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe) {
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe = classe;
        this.inventario = inventario;
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }

    protected int poderJogador() {
        int valor = nivel;
        for (Item item : inventario.itens) {
            valor += item.getValor();
        }
        return valor;
    }

    public boolean venderItens(List<Item> itens) {
        int totalValue = 0;
        for (Item item : itens) {
            totalValue += item.getValor();
        }

        if (totalValue >= 1000) {
            for (int i = 0; i < itens.size(); i++) {
                for (int j = i + 1; j < itens.size(); j++) {
                    List<Item> combo = new ArrayList<>();
                    combo.add(itens.get(i));
                    combo.add(itens.get(j));

                    int comboValue = 0;
                    for (Item item : combo) {
                        comboValue += item.getValor();
                    }

                    if (comboValue >= 1000) {
                        for (Item item : combo) {
                            inventario.removerItem(item.getNomeItem());
                        }
                        nivel += 1;
                        return true;
                    }
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Raca.Racas getRaca() {
        return raca;
    }

    public Classe.Classes getClasse() {
        return classe;
    }

    public Item getItemCabeca() {
        return itemCabeca;
    }

    public void setItemCabeca(Item item) {
        this.itemCabeca = item;
    }

    public Item getItemCorpo() {
        return itemCorpo;
    }

    public void setItemCorpo(Item item) {
        this.itemCorpo = item;
    }

    public Item getItemMaoDireita() {
        return itemMaoDireita;
    }

    public void setItemMaoDireita(Item item) {
        this.itemMaoDireita = item;
    }

    public Item getItemMaoEsquerda() {
        return itemMaoEsquerda;
    }

    public void setItemMaoEsquerda(Item item) {
        this.itemMaoEsquerda = item;
    }

    public Item getItemPe() {
        return itemPe;
    }

    public void setItemPe(Item item) {
        this.itemPe = item;
    }
}
