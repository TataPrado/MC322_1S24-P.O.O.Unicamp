package MainLab3;

import Lab3.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //novos itens
        Item espadaLarga = new Item ("Espada Larga", 3, 400, TipoItem.TiposItens.MAO, false, Arrays.asList(Classe.Classes.GUERREIRO, Classe.Classes.LADRAO), Arrays.asList(Raca.Racas.HUMANO, Raca.Racas.ELFO));
        Item armaduraViscosa= new Item ("Armadura Viscosa", 3, 200, TipoItem.TiposItens.CORPO, false, Arrays.asList(Classe.Classes.GUERREIRO, Classe.Classes.LADRAO), Arrays.asList(Raca.Racas.HUMANO, Raca.Racas.ELFO));
        Item bastaoDeNapalm = new Item ("Bastão de Napalm", 5, 800, TipoItem.TiposItens.MAO, false, Arrays.asList(Classe.Classes.MAGO), Arrays.asList(Raca.Racas.ANAO, Raca.Racas.ELFO));
        Item armaduraFlamejante = new Item ("Armadura Flamejante", 2, 400, TipoItem.TiposItens.CORPO, false, Arrays.asList(Classe.Classes.GUERREIRO,Classe.Classes.MAGO), Arrays.asList(Raca.Racas.HUMANO, Raca.Racas.ANAO, Raca.Racas.ELFO));
        Item arcoComFitinhas = new Item ("Arco com Fitinhas", 4, 800, TipoItem.TiposItens.MAO, true,  Arrays.asList(Classe.Classes.MAGO,Classe.Classes.LADRAO), Arrays.asList(Raca.Racas.ELFO, Raca.Racas.ANAO));
        Item espadaDeDuasMaos = new Item ("Espada de duas mãos", 2, 800, TipoItem.TiposItens.MAO, true,  Arrays.asList(Classe.Classes.GUERREIRO,Classe.Classes.MAGO), Arrays.asList(Raca.Racas.ELFO));


        //criando inventário e bau de tesouro
        Inventario inventario1 = new Inventario(5, new ArrayList<>());
        inventario1.adicionarItem(espadaLarga);
        inventario1.adicionarItem(armaduraViscosa);
        inventario1.adicionarItem(bastaoDeNapalm);
        inventario1.adicionarItem(arcoComFitinhas);
        inventario1.adicionarItem(armaduraFlamejante);
        inventario1.adicionarItem(espadaDeDuasMaos);
        System.out.println("Invent: " + inventario1.toString());

        BauDeTesouros bauDeTesouros = new BauDeTesouros(5, new ArrayList<>());
        bauDeTesouros.adicionarItem(espadaDeDuasMaos);
        bauDeTesouros.adicionarItem(armaduraViscosa);
        bauDeTesouros.adicionarItem(bastaoDeNapalm);
        bauDeTesouros.adicionarItem(armaduraFlamejante);

        //criando monstros e colocando-os em uma lista
        Monstro trollDaInternet = new Monstro("Troll da Internet", 10, 5,1);
        Monstro dragaoDePlutonio = new Monstro("Dragão de Plutônio", 20, 3, 2);
        Monstro squidzila = new Monstro ("Squidizila", 18, 4, 2);
        List<Monstro> monstros = new ArrayList<>();
        monstros.add(trollDaInternet);
        monstros.add(dragaoDePlutonio);
        monstros.add(squidzila);

        // Instanciando objetos necessários
        Jogador jogador = new Jogador("Magic Mike", 1, Raca.Racas.ELFO, Classe.Classes.MAGO, inventario1, null, null, null, null, null);
        Masmorra masmorra = new Masmorra(bauDeTesouros, monstros);


        boolean jogando = true;

        while (jogando) {
            // Ação do jogador
            System.out.println("Jogador " + jogador.getNome() + ":");
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Listar itens do inventário");
            System.out.println("2 - Equipar itens do inventário");
            System.out.println("3 - Vender itens do inventário");
            System.out.println("4 - Ver informações do jogador");
            System.out.println("5 - Passar para abrir a porta");
            System.out.println("0 - Sair do jogo");
            System.out.println("--------------");
            System.out.println("Jogador digita: ");
            int escolha = scanner.nextInt();
            System.out.println("--------------");

            switch (escolha) {
                case 1:
                    System.out.println("Itens no inventário:");
                    for (Item item : inventario1.listarItens()) {
                        System.out.println("- " + item.getNomeItem() + " - nível " + item.getBonusPoder());
                    }
                    System.out.println("--------------");
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha2 = scanner.nextInt();
                    break;
                case 2:
                    boolean itemEquipped = false;

                    for (Item item : inventario1.listarItens()) {
                        if (item != null) {
  
                            if (jogador.getItemCabeca() == null && item.getTipo() == TipoItem.TiposItens.CABECA) {
                                jogador.setItemCabeca(item);
                                System.out.println("Item de cabeça equipado: " + item.getNomeItem());
                                itemEquipped = true;
                            } else if (jogador.getItemCorpo() == null && item.getTipo() == TipoItem.TiposItens.CORPO) {
                                jogador.setItemCorpo(item);
                                System.out.println("Item de corpo equipado: " + item.getNomeItem());
                                itemEquipped = true;
                            } else if (jogador.getItemMaoDireita() == null && item.getTipo() == TipoItem.TiposItens.MAO) {
                                jogador.setItemMaoDireita(item);
                                System.out.println("Item da mão direita equipado: " + item.getNomeItem());
                                itemEquipped = true;
                            } else if (jogador.getItemMaoEsquerda() == null && item.getTipo() == TipoItem.TiposItens.MAO) {
                                jogador.setItemMaoEsquerda(item);
                                System.out.println("Item da mão esquerda equipado: " + item.getNomeItem());
                                itemEquipped = true;
                            } else if (jogador.getItemPe() == null && item.getTipo() == TipoItem.TiposItens.PE) {
                                jogador.setItemPe(item);
                                System.out.println("Item do pé equipado: " + item.getNomeItem());
                                itemEquipped = true;
                            }
                        }
                    }

                    if (!itemEquipped) {
                        System.out.println("Não há itens disponíveis no inventário ou todos os slots estão ocupados.");
                    }
                    System.out.println("--------------");
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha3 = scanner.nextInt();
                    break;

                case 3:
                    jogador.venderItens(inventario1.listarItens());
                    System.out.println("--------------");
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha4 = scanner.nextInt();
                    break;
                case 4:
                    System.out.println(jogador);
                    System.out.println("--------------");
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha5 = scanner.nextInt();
                    break;
                case 5:
                    Random random = new Random();
                    boolean abrirPortaMonstro = random.nextBoolean();

                    if (abrirPortaMonstro) {
                        //não consegui arrumar o erro que está dando, basicamente a linha 19 de CampoDeBatalha não está
                        //virando uma lista da maneira como escrevi
                        masmorra.abrirPortaMonstro(jogador);
                    } else {
                        masmorra.abrirPortaItem(jogador);
                    }
                    System.out.println("--------------");
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha6 = scanner.nextInt();
                    break;
                case 0:
                    jogando = false;
                    System.out.println("Jogo encerrado.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
