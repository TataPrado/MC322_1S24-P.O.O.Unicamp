package Lab3;

public class TipoItem {
    public TiposItens tiposItens;
    public enum TiposItens {
        CABECA, CORPO, MAO, PE
    }

    public TipoItem (TiposItens tiposItens){
        this.tiposItens = tiposItens;
    }

    public TiposItens getTipo() {
        return tiposItens;
    }
    public void definicaoTipoItem (){
        switch(tiposItens){
            case CABECA:
                System.out.println("Seu item será equipado na Cabeça");
                break;
            case CORPO:
                System.out.println("Seu item será equipado no Corpo");
                break;
            case MAO:
                System.out.println("Seu item será equipado na Mão");
                break;
            case PE:
                System.out.println("Seu item será equipado no Pé");
                break;
            default:
                System.out.println("Seu item não será equipado");
                break;
        }
    }
}