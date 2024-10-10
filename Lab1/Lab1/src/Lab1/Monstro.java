package Lab1;

public class Monstro{
	//Attributes
	private String nomeMonstro;
	private int poder;
	private int quantidadeDeTesouros;
	private int niveisPerdidos;
	
	//Methods
	public Monstro (String nomeMonstro, int poder, int quantidadeDeTesouros, int niveisPerdidos){
		this.nomeMonstro = nomeMonstro;
		this.poder = poder;
		this.quantidadeDeTesouros = quantidadeDeTesouros;
		this.niveisPerdidos= niveisPerdidos;
		}
		public String toString() {
			return "Nome do Monstro: " + this.nomeMonstro;
		}
}
