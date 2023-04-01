package arvore;

public class No<T extends Comparable<?>> {

	private int valor;
	private int altura;
	private No<T> direito;
	private No<T> esquerdo;

	public No(int valor) {
		this.valor = valor;
		this.direito = null;
		this.esquerdo = null;
	}

	public No<T> getDireito() {
		return direito;
	}

	public void setDireito(No<T> direito) {
		this.direito = direito;
	}

	public No<T> getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No<T> esquerdo) {
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
}
