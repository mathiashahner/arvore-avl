package arvore;

public class No {

	private int valor;
	private int altura;
	private No pai;
	private No direito;
	private No esquerdo;

	public No(int valor, No pai) {
		this.valor = valor;
		this.pai = pai;
		this.altura = 1;
		this.direito = null;
		this.esquerdo = null;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void atualizarFilhoUnico(No noFilho) {
		if (this.getValor() < this.getPai().getValor()) {
			this.getPai().setEsquerdo(noFilho);
		} else {
			this.getPai().setDireito(noFilho);
		}
	}
}
