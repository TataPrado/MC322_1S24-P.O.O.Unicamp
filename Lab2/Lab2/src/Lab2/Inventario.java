package Lab2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventario {
    //Attributes
    public int limiteInventario;
    public List<Item> inventario;

    //Methods
    public Inventario(int limiteInventario){
        this.limiteInventario = limiteInventario;
        this.inventario = new ArrayList<Item>();
    }

    public boolean adicionarItem(Item item) {
        // Verificar se o inventário atingiu o limite
        if (inventario.size() >= limiteInventario) {
            System.out.println("Limite de inventário atingido. Não é possível adicionar mais itens.");
            return false;
        }
        else if (inventario.stream().anyMatch(Item::getItemGrande) && item.getItemGrande()){
            System.out.println("Não pode ser adicionado mais de um item grande no mesmo inventário.");
            return false;
        }
        else {
            inventario.add(item);
            System.out.println("Item " + item.getNomeItem() + " adicionado com sucesso ao inventário.");
            return true;
        }
    }

    private Item acessarItem (String nomeItem){
        for (Item item: inventario){
            if (item.getNomeItem().equals(nomeItem)){
                return item;
            }
        }
        System.out.println ("Não há essa carta de item no inventário");
        return null;
    }

    public void removerItem(String nomeItem){
        Iterator<Item> iterator = inventario.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getNomeItem().equals(nomeItem)) {
                iterator.remove();
                System.out.println("Item: " + nomeItem + " foi removido do inventário");
            }
        }
    }
    public String listarInventario() {
        StringBuilder inventarioString = new StringBuilder("Inventário atual: [");
        for (Item item : inventario) {
            inventarioString.append(item.toString()); // Aqui acessamos o método toString() de cada item
            inventarioString.append(", ");
        }
        if (!inventario.isEmpty()) {
            inventarioString.delete(inventarioString.length() - 2, inventarioString.length()); // Removendo a última vírgula
        }
        inventarioString.append("]");
        return inventarioString.toString();
    }
}
