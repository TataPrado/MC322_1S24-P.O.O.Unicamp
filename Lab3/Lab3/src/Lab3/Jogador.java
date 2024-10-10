package Lab3;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    //Attributes
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

    //Methods
    public Jogador(String nome, int nivel, Raca.Racas raca, Classe.Classes classe, Inventario inventario, Item itemCabeca,
                   Item itemCorpo, Item itemMaoDireita, Item itemMaoEsquerda, Item itemPe){
        this.nome = nome;
        this.nivel = nivel;
        this.raca = raca;
        this.classe= classe;
        this.inventario = inventario;
        this.itemCabeca = itemCabeca;
        this.itemCorpo = itemCorpo;
        this.itemMaoDireita = itemMaoDireita;
        this.itemMaoEsquerda = itemMaoEsquerda;
        this.itemPe = itemPe;
    }

    protected int poderJogador(){
        int valor = nivel;
        for (Item item:inventario.itens){
            nivel+= item.getValor();
        }
        return valor + nivel;
    }

    public boolean venderItens(List<Item> itens) {
        int totalValue = 0;
        for (Item item : itens) {
            totalValue += item.getValor();
        }

        if (totalValue >= 1000) {
            // Encontrando todas as combinações de itens
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
                        // Removendo itens do inventario
                        for (Item item : combo) {
                            inventario.removerItem(item.getNomeItem());
                        }
                        nivel += 1; // Increment level by 1
                        System.out.println("Itens no Inventário somaram 1000 ou mais e foram vendidos.");
                        System.out.println("Combinação vendida: " + combo);
                        System.out.println("Você subiu de nível para " + nivel);
                        System.out.println("Inventário atual: " + inventario.listarNomesItens());
                        return true;
                    }
                }
            }

            // Nenhuma combinação de itens somou 1000
            System.out.println("Nenhuma combinação de itens no inventário soma 1000 ou mais.");
            System.out.println("Nenhum item foi vendido.");
            System.out.println("Inventário atual: " + inventario.listarNomesItens());
            return false;
        } else {
            // Valores totais menores que 1000
            System.out.println("Itens no Inventário não somaram 1000 e nenhum item foi vendido");
            System.out.println("Você permanece no mesmo nível");
            System.out.println("O poder de ataque do jogador é: " + poderJogador());
            System.out.println("Inventário atual: " + inventario.listarNomesItens());
            return false;
        }
    }

    public String toString(){
        return "Jogador: " + getNome() + "\n" +
                "Nivel " + getNivel()  + "\n" +
                "Raça: " + getRaca() + "\n" +
                "Classe: " + getClasse() + "\n";
    }

    public int getNivel() {
        return nivel;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String getNome(){
        return nome;
    }

    public Raca.Racas getRaca(){
        return raca;
    }

    public Classe.Classes getClasse(){
        return classe;
    }

    public Item getItemCabeca(){
        return itemCabeca;
    }

    public void setItemCabeca(Item item) {
        this.itemCabeca = item;
    }

    public Item getItemCorpo(){
        return itemCorpo;
    }

    public void setItemCorpo(Item item) {
        this.itemCorpo = item;
    }

    public Item getItemMaoDireita(){
        return itemMaoDireita;
    }

    public void setItemMaoDireita(Item item) {
        this.itemMaoDireita = item;
    }
    public Item getItemMaoEsquerda(){
        return itemMaoEsquerda;
    }

    public void setItemMaoEsquerda(Item item) {
        this.itemMaoEsquerda = item;
    }

    public Item getItemPe(){
        return itemPe;
    }

    public void setItemPe(Item item) {
        this.itemPe = item;
    }
}
