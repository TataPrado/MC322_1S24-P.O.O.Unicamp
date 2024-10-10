package Lab5;

public class JogadorView {
    public void displayJogadorDetails(String nome, int nivel, String raca, String classe, String inventario) {
        System.out.println("Jogador: " + nome);
        System.out.println("Nivel: " + nivel);
        System.out.println("Raça: " + raca);
        System.out.println("Classe: " + classe);
        System.out.println("Inventário: " + inventario);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
