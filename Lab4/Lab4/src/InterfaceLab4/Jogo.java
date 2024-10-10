package InterfaceLab4;

import Lab4.*;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private Masmorra masmorra;
    private List<Jogador> jogadores;
    private Inventario inventario;

    public Jogo() {
        this.masmorra = new Masmorra();
        this.inventario = new Inventario();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        boolean jogando = true;

        while (jogando) {
            // Ação do jogador
            for (Jogador jogador : jogadores) {
                System.out.println("Jogador " + jogador.getNome() + ":");
            }
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
                    for (Item item : inventario.listarItens()) {
                        System.out.println("- " + item.getNomeItem() + " - nível " + item.getBonusPoder());
                    }
                    System.out.println("--------------");
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha2 = scanner.nextInt();
                    break;
                case 2:
                    boolean itemEquipped = false;
                    for (Jogador jogador : jogadores) {
                        for (Iterator<Item> iterator = inventario.listarItens().iterator(); iterator.hasNext();) {
                            Item item = iterator.next();
                            if (item != null) {
                                if (jogador.getItemCabeca() == null && item.getTipo() == TipoItem.TiposItens.CABECA) {
                                    jogador.setItemCabeca(item);
                                    System.out.println("Item de cabeça equipado para " + jogador.getNome() + ": " + item.getNomeItem());
                                    itemEquipped = true;
                                    iterator.remove();
                                } else if (jogador.getItemCorpo() == null && item.getTipo() == TipoItem.TiposItens.CORPO) {
                                    jogador.setItemCorpo(item);
                                    System.out.println("Item de corpo equipado para " + jogador.getNome() + ": " + item.getNomeItem());
                                    itemEquipped = true;
                                    iterator.remove();
                                } else if (jogador.getItemMaoDireita() == null && item.getTipo() == TipoItem.TiposItens.MAO) {
                                    jogador.setItemMaoDireita(item);
                                    System.out.println("Item da mão direita equipado para " + jogador.getNome() + ": " + item.getNomeItem());
                                    itemEquipped = true;
                                    iterator.remove();
                                } else if (jogador.getItemMaoEsquerda() == null && item.getTipo() == TipoItem.TiposItens.MAO) {
                                    jogador.setItemMaoEsquerda(item);
                                    System.out.println("Item da mão esquerda equipado para " + jogador.getNome() + ": " + item.getNomeItem());
                                    itemEquipped = true;
                                    iterator.remove();
                                } else if (jogador.getItemPe() == null && item.getTipo() == TipoItem.TiposItens.PE) {
                                    jogador.setItemPe(item);
                                    System.out.println("Item do pé equipado para " + jogador.getNome() + ": " + item.getNomeItem());
                                    itemEquipped = true;
                                    iterator.remove();
                                }
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
                    for (Jogador jogador : jogadores) {
                        jogador.venderItens(inventario.listarItens());
                    }
                    System.out.println("Todos os jogadores venderam seus itens.");
                    System.out.println("--------------");
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha4 = scanner.nextInt();
                    break;
                case 4:
                    for (Jogador jogador : jogadores) {
                        System.out.println(jogador);
                        System.out.println("--------------");
                    }
                    System.out.println("[Pressione 1 para voltar]");
                    System.out.println("--------------");
                    int escolha5 = scanner.nextInt();
                    break;
                case 5:
                    Random random = new Random();
                    boolean abrirPortaMonstro = random.nextBoolean();

                    if (abrirPortaMonstro) {
                        if (jogadores != null && !jogadores.isEmpty()) {
                            for (Jogador jogador : jogadores) {
                                masmorra.abrirPortaMonstro(jogador);
                            }
                        } else {
                            System.out.println("Não há jogadores para enfrentar os monstros!");
                        }
                    } else {
                        if (jogadores != null && !jogadores.isEmpty()) {
                            Jogador primeiroJogador = jogadores.get(0);
                            Item itemEncontrado = masmorra.abrirPortaItem(primeiroJogador);
                            if (itemEncontrado != null) {
                                System.out.println("Você encontrou um item: " + itemEncontrado.getNomeItem());
                            } else {
                                System.out.println("Você não encontrou nenhum item.");
                            }
                        } else {
                            System.out.println("Não há jogadores para abrir a porta.");
                        }
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

    // Getters e setters

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Masmorra getMasmorra() {
        return masmorra;
    }

    public void setMasmorra(List<Monstro> monstros) {
        this.masmorra = new Masmorra(new BauDeTesouros(), monstros);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(List<Item> itens) {
        this.inventario.getItens().addAll(itens);
    }
}
