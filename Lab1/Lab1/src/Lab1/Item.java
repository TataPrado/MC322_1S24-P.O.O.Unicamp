package Lab1;

public class Item{
	//Attributes
	private String nomeItem;
	private int bonusPoder;
	private int valor;
	private String tipo;


	//Methods
	public Item (String nomeItem, int bonusPoder, int valor, String tipo){
		this.nomeItem = nomeItem;
		this.bonusPoder = bonusPoder;
		this.valor = valor;
		this.tipo= tipo;
	}
	public String toString() {
		return "Nome do Item: " + this.nomeItem;
	}
}