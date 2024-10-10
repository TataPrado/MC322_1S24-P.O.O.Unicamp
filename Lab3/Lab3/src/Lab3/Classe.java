package Lab3;

public class Classe {
    public enum Classes {
        GUERREIRO, LADRAO, MAGO
    }
    public Classes classe;

    public Classe (Classes classe){
        this.classe = classe;
    }

    public void definicaoClasse (){
        switch(classe){
            case GUERREIRO:
                System.out.println("Sua classe é Guerreiro");
                break;
            case LADRAO:
                System.out.println("Sua classe é Ladrão");
                break;
            case MAGO:
                System.out.println("Sua classe é Mago");
                break;
            default:
                System.out.println("Sua classe ainda não foi definida");
                break;
        }
    }
}