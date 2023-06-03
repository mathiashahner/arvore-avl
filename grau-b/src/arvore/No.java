package arvore;

import java.util.Objects;

public class No<T> {

	private T valor;
	private int posicao;
	private int altura;
	private No<T> direito;
	private No<T> esquerdo;

	public No(T valor, int posicao) {
		this.valor = valor;
		this.posicao = posicao;
		this.altura = 1;
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

	public int getPosicao() {
		return posicao;
	}
	
	public T getValor() {
		return valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public No<T> atualizarFilhoUnico(T valor, No<T> noFilho) {
		if (Objects.nonNull(this.getEsquerdo()) && valor == this.getEsquerdo().getValor()) {
			this.setEsquerdo(noFilho);
		} else {
			this.setDireito(noFilho);
		}
		return noFilho;
	}
}
