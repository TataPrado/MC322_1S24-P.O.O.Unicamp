package Lab3;

public class Resultado {
    public Resultados resultado;
    public enum Resultados {
        VITORIA, DERROTA, FUGA
    }

    public Resultado (Resultados resultado){
        this.resultado = resultado;
    }

    public void definicaoResultado (){
        switch(resultado){
            case VITORIA:
                System.out.println("Você venceu!!!");
                break;
            case DERROTA:
                System.out.println("Você foi vencido pelo Monstro");
                break;
            case FUGA:
                System.out.println("Você conseguiu fugir");
                break;
            default:
                System.out.println("Batalha não foi concluída");
                break;
        }
    }
}