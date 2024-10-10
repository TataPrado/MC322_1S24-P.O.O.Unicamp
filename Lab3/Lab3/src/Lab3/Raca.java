package Lab3;

public class Raca {
    public enum Racas {
        HUMANO, ELFO, ANAO
    }

    public Racas raca;

    public Raca (Racas raca){
        this.raca = raca;
    }

    public void definicaoRaca (){
        switch(raca){
            case HUMANO:
                System.out.println("Sua raça é Humano");
                break;
            case ELFO:
                System.out.println("Sua raça é elfo");
                break;
            case ANAO:
                System.out.println("Sua raça é anão");
                break;
            default:
                System.out.println("Sua raça ainda não foi definida");
                break;
        }
    }
}
