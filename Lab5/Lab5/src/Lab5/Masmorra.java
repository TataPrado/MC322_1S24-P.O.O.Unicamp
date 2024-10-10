package Lab5;

import InterfaceLab5.Jogo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Masmorra {
    // Attributes
    protected BauDeTesouros tesouros;
    private List<Monstro> monstros;

    // Methods
    public Masmorra() {
        this.tesouros = BauDeTesouros.getInstance();
        this.monstros = new ArrayList<>();
    }

    public void adicionarMonstro(Monstro monstro) {
        monstros.add(monstro);
    }

    public Monstro obterMonstroAleatorio() {
        if (monstros.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int indiceAleatorio = random.nextInt(monstros.size());
        return monstros.get(indiceAleatorio);
    }

    public List<Item> obterItensDisponiveis(Jogo jogo) {
        return tesouros.listarItens(jogo.getInventario().getItens());
    }

    public void removerItemDoJogo(Jogo jogo, Item item) {
        jogo.getInventario().getItens().remove(item);
    }

    public List<Monstro> getMonstros() {
        return monstros;
    }
}
