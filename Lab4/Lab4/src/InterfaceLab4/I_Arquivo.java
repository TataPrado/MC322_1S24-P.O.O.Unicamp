package InterfaceLab4;

import java.util.List;

public interface I_Arquivo<T> {
    List<T> lerArquivo(Jogo jogo, String caminhoArquivo);
}

