package Lab4;

import java.util.List;

public class Item{
  //Attributes
  private String nomeItem;
  private int bonusPoder;
  protected int valor;
  private TipoItem.TiposItens tipo;
  private boolean itemGrande;
  private List<Classe.Classes> classesCompativeis;
  private List<Raca.Racas> racasCompativeis;

  //Methods
  public Item (String nomeItem, int bonusPoder, int valor, TipoItem.TiposItens tipo, boolean itemGrande, List<Classe.Classes> classesCompativeis, List<Raca.Racas> racasCompativeis){
      this.nomeItem = nomeItem;
      this.bonusPoder = bonusPoder;
      this.valor = valor;
      this.tipo = tipo;
      this.itemGrande = itemGrande;
      this.classesCompativeis = classesCompativeis;
      this.racasCompativeis = racasCompativeis;
    }

  public int getValor(){
        return valor;
    }
    
  public String getNomeItem(){
        return nomeItem;
    }

    public boolean getItemGrande(){
      return itemGrande;
    }

    public int getBonusPoder(){
      return bonusPoder;
    }

    public String toString() {
        return nomeItem;
    }

    public TipoItem.TiposItens getTipo() {
        return tipo;
    }
}