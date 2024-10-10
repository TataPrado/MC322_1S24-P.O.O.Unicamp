package Lab5;

import java.util.List;

public class JogadorController {
    private Jogador model;
    private JogadorView view;

    public JogadorController(Jogador model, JogadorView view) {
        this.model = model;
        this.view = view;
    }

    public void setJogadorNome(String nome) {
        model.setNome(nome);
    }

    public String getJogadorNome() {
        return model.getNome();
    }

    public void setJogadorNivel(int nivel) {
        model.setNivel(nivel);
    }

    public int getJogadorNivel() {
        return model.getNivel();
    }

    public void updateView() {
        view.displayJogadorDetails(model.getNome(), model.getNivel(), model.getRaca().toString(), model.getClasse().toString(), model.getInventario().listarNomesItens());
    }

    public void venderItens(List<Item> itens) {
        if (model.venderItens(itens)) {
            view.displayMessage("Itens vendidos com sucesso! Nível aumentado para: " + model.getNivel());
        } else {
            view.displayMessage("Falha ao vender itens. Nenhuma combinação válida encontrada.");
        }
        updateView();
    }
}
