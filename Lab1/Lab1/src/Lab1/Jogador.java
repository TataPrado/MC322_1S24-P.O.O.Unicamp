package Lab1;

public class Jogador {
		//Attributes
		public String nome;
		private int nivel;
		private String raça;
		private String classe;
		private String itemCabeça;
		private String itemCorpo;
		public String itemMaoDireita;
		public String itemMaoEsquerda;
		private String itemPe;
		
		//Methods
		public Jogador (String nome, int nivel, String raça, String classe, String itemCabeça,
		 String itemCorpo, String itemMaoDireita, String itemMaoEsquerda, String itemPe){
			this.nome = nome;
			this.nivel = nivel;
			this.raça = raça;
			this.classe= classe;
			this.itemCabeça = itemCabeça;
			this.itemCorpo = itemCorpo;
			this.itemMaoDireita = itemMaoDireita;
			this.itemMaoEsquerda = itemMaoEsquerda;
			this.itemPe = itemPe;
		}

		public String toString() {
			String resultado = "";
			if (itemMaoDireita == ""){
				resultado = "Mão direita está vazia \n";
			}
			if (itemMaoEsquerda == ""){
				resultado += "Mão esquerda está vazia \n";
			}
			resultado += "Nome: " + this.nome;
			return resultado;
		}

		public boolean possuiMaoVazia() {
			if (itemMaoDireita == "" || itemMaoEsquerda== ""){
				return false;
			}
			else
            	return true;
		}
}
