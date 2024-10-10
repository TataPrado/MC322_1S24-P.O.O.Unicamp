package MainLab2;

import Lab2.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //criando classes
        ClasseLadrao ladrao =  new ClasseLadrao();
        ClasseMago mago = new ClasseMago();

        // Criando lista de classes para os itens
        ArrayList<Classe> classesCompativeis1 = new ArrayList<Classe>();
        classesCompativeis1.add(ladrao);
        classesCompativeis1.add(mago);

        ArrayList<Classe> classesCompativeis2 = new ArrayList<Classe>();
        classesCompativeis1.add(ladrao);

        ArrayList<Classe> classesCompativeis3 = new ArrayList<Classe>();
        classesCompativeis1.add(mago);

        //novos itens
        Item espadaLarga = new Item ("Espada Larga", 3, 400, "Arma", false, classesCompativeis1);
        Item armaduraViscosa= new Item ("Armadura Viscosa", 3, 200, "Armadura", false, classesCompativeis2);
        Item bastaoDeNapalm = new Item ("Bastão de Napalm", 5, 800, "Item mágico", false, classesCompativeis3);
        Item armaduraFlamejante = new Item ("Armadura Flamejante", 2, 400, "Armadura", false, classesCompativeis2);
        Item arcoComFitinhas = new Item ("Arco com Fitinhas", 4, 800, "Arma", true, classesCompativeis2);
        Item espadaDeDuasMaos = new Item ("Espada de duas mãos", 2, 800, "Arma", true, classesCompativeis3);

        //criando inventários
        Inventario inventario1 = new Inventario(5);
        System.out.println("Novo inventário");
        inventario1.adicionarItem(espadaLarga);
        inventario1.adicionarItem(armaduraViscosa);
        inventario1.adicionarItem(bastaoDeNapalm);
        inventario1.adicionarItem(arcoComFitinhas);
        inventario1.adicionarItem(espadaDeDuasMaos);
        inventario1.adicionarItem(armaduraFlamejante);

        Inventario inventario2 = new Inventario(5);
        System.out.println("Novo inventário");
        inventario2.adicionarItem(espadaLarga);
        inventario2.adicionarItem(armaduraViscosa);
        inventario2.adicionarItem(bastaoDeNapalm);
        inventario2.adicionarItem(armaduraFlamejante);
        inventario2.adicionarItem(espadaDeDuasMaos);
        inventario2.adicionarItem(espadaLarga);

        //criando as raças
        Raca elfo = new Raca ("Raça ágil e inteligente", "Elfo", 4);
        Raca anao = new Raca ("Raça pequena, forte e perspicaz", "Anao", 7);
        Raca humano = new Raca("Não tem habilidades especiais", "Humano", 1);
        Raca halflings = new Raca ("Raça habilidosa em combates e em fugas", "Halfling", 5);

        //criando classes
        ClasseLadrao ladrao1 =  new ClasseLadrao(armaduraFlamejante, null, bastaoDeNapalm, espadaLarga,null );
        ClasseMago mago1 = new ClasseMago(null, null, espadaDeDuasMaos, espadaDeDuasMaos, null);

        // Criando lista de tesouros para os monstros
        List<Item> tesourosRatoMaul = new ArrayList<>();
        tesourosRatoMaul.add(espadaLarga);

        List<Item> tesourosPolvoRelogio = new ArrayList<>();
        tesourosPolvoRelogio.add(armaduraViscosa);

        //criando monstros
        Monstro ratoMaul = new Monstro ("Rato Maul", 3, tesourosRatoMaul , 1);
        Monstro polvoRelogio = new Monstro("Polvo Relógio", 3, tesourosPolvoRelogio , 0);

        //criando Jogador
        Jogador jogador1 = new Jogador ("Joel", 1, anao, ladrao1, inventario1);
        Jogador jogador2 = new Jogador ("Tina", 4, humano, mago1, inventario2);

        //Prints
        System.out.println(jogador1.toString());
        System.out.println("Inventário 1: " + inventario1.listarInventario());
        System.out.println(jogador2.toString());
        System.out.println("Inventário 2: " + inventario2.listarInventario());
    }
}

