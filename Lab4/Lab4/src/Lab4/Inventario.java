package Lab4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventario{
    //Attributes
    private int limiteDeltens;
    protected List<Item> itens;

    //Methods
       public Inventario(int limiteDeltens, List<Item> itens){
        this.limiteDeltens = limiteDeltens;
        this.itens = itens;
       }

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public boolean adicionarItem(Item item) {
        // Verificar se o inventário atingiu o limite
        if (itens.size() >= limiteDeltens) {
            if (item.getItemGrande() != true) {
                System.out.println("Você possui um Item Grande. Não é possível adicionar mais um.");
                return false;
            }
            System.out.println("Limite de inventário atingido. Não é possível adicionar mais itens.");
            return false;
        }
        else {
            itens.add(item);
            System.out.println("Item " + item.getNomeItem() + " adicionado com sucesso ao inventário.");
            return true;
        }
    }

    public Item acessarItem (String nomeItem){
        for (Item item: itens){
            if (item.getNomeItem().equals(nomeItem)){
                return item;
            }
        }
        System.out.println ("Não há essa carta de item no inventário");
        return null;
    }

    public void removerItem(String nomeItem){
        Iterator<Lab4.Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getNomeItem().equals(nomeItem)) {
                iterator.remove();
                System.out.println("Item " + nomeItem + " foi removido do inventário");
            }
        }
    }
    public List<Item> listarItens() {
        // Retornar a lista de itens
        return itens;
    }

    public String listarNomesItens() {
        StringBuilder builder = new StringBuilder();
        for (Item item : itens) {
            builder.append(item.getNomeItem()).append(", ");
        }
        String result = builder.toString();
        // Remove the trailing comma and space
        if (!result.isEmpty()) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public String toString() {
           return getItens().toString();
       }

    }