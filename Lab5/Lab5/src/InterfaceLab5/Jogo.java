package InterfaceLab5;

import Lab5.*;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Jogo {
    private MasmorraController masmorra;
    private List<Jogador> jogadores;
    private Inventario inventario;

    public Jogo() {
        this.masmorra = new MasmorraController(new Masmorra(), new MasmorraView());
        this.inventario = new Inventario();
    }

    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        boolean jogando = true;

        while (jogando) {
            for (Jogador jogador : jogadores) {
                boolean turnoConcluido = false;

                while (!turnoConcluido) {
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
                            for (Item item : inventario.listarItens()) {
                                System.out.println("- " + item.getNomeItem() + " - nível " + item.getBonusPoder());
                            }
                            System.out.println("--------------");
                            System.out.println("[Pressione qualquer tecla para voltar]");
                            scanner.next();  // Espera o jogador pressionar algo para continuar
                            break;
                        case 2:
                            boolean itemEquipped = false;
                            for (Iterator<Item> iterator = inventario.listarItens().iterator(); iterator.hasNext();) {
                                Item item = iterator.next();
                                if (item != null) {
                                    if (jogador.getItemCabeca() == null && item.getTipo() == TipoItem.TiposItens.CABECA) {
                                        jogador.setItemCabeca(item);
                                        System.out.println("Item de cabeça equipado: " + item.getNomeItem());
                                        itemEquipped = true;
                                        iterator.remove();
                                    } else if (jogador.getItemCorpo() == null && item.getTipo() == TipoItem.TiposItens.CORPO) {
                                        jogador.setItemCorpo(item);
                                        System.out.println("Item de corpo equipado: " + item.getNomeItem());
                                        itemEquipped = true;
                                        iterator.remove();
                                    } else if (jogador.getItemMaoDireita() == null && item.getTipo() == TipoItem.TiposItens.MAO) {
                                        jogador.setItemMaoDireita(item);
                                        System.out.println("Item da mão direita equipado: " + item.getNomeItem());
                                        itemEquipped = true;
                                        iterator.remove();
                                    } else if (jogador.getItemMaoEsquerda() == null && item.getTipo() == TipoItem.TiposItens.MAO) {
                                        jogador.setItemMaoEsquerda(item);
                                        System.out.println("Item da mão esquerda equipado: " + item.getNomeItem());
                                        itemEquipped = true;
                                        iterator.remove();
                                    } else if (jogador.getItemPe() == null && item.getTipo() == TipoItem.TiposItens.PE) {
                                        jogador.setItemPe(item);
                                        System.out.println("Item do pé equipado: " + item.getNomeItem());
                                        itemEquipped = true;
                                        iterator.remove();
                                    }
                                }
                            }
                            if (!itemEquipped) {
                                System.out.println("Não há itens disponíveis no inventário ou todos os slots estão ocupados.");
                            }
                            System.out.println("--------------");
                            System.out.println("[Pressione qualquer tecla para voltar]");
                            scanner.next();  // Espera o jogador pressionar algo para continuar
                            break;
                        case 3:
                            jogador.venderItens(inventario.listarItens());
                            System.out.println("Você vendeu seus itens.");
                            System.out.println("--------------");
                            System.out.println("[Pressione qualquer tecla para voltar]");
                            scanner.next();  // Espera o jogador pressionar algo para continuar
                            break;
                        case 4:
                            System.out.println(jogador);
                            System.out.println("--------------");
                            System.out.println("[Pressione qualquer tecla para voltar]");
                            scanner.next();  // Espera o jogador pressionar algo para continuar
                            break;
                        case 5:
                            Random random = new Random();
                            boolean abrirPortaMonstro = random.nextBoolean();

                            if (abrirPortaMonstro) {
                                masmorra.abrirPortaMonstro(jogador);
                            } else {
                                Item itemEncontrado = masmorra.abrirPortaItem(jogador, this);
                            }
                            System.out.println("--------------");
                            System.out.println("[Pressione qualquer tecla para voltar]");
                            scanner.next();  // Espera o jogador pressionar algo para continuar
                            turnoConcluido = true;  // Turno do jogador concluiu após abrir a porta
                            break;
                        case 0:
                            jogando = false;
                            System.out.println("Jogo encerrado.");
                            turnoConcluido = true;  // Turno do jogador concluiu ao sair do jogo
                            break;
                        default:
                            System.out.println("Escolha inválida. Tente novamente.");
                            break;
                    }
                }

                if (!jogando) {
                    break;  // Sai do loop de jogadores se o jogo foi encerrado
                }
            }
        }

        scanner.close();
    }

    // Getters e setters

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }


    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void addMonstrosToMasmorra(List<Monstro> monstros) {
        for (Monstro monstro : monstros) {
            masmorra.adicionarMonstro(monstro);
        }
    }

    public MasmorraController getMasmorra() {
        return masmorra;
    }

    public void addItensToInventario(List<Item> itens) {
        this.inventario.getItens().addAll(itens);
    }

    public Inventario getInventario() {
        return inventario;
    }
}
