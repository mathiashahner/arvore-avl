package arvore;

import java.util.Objects;

public class No {

	private int valor;
	private int altura;
	private No direito;
	private No esquerdo;

	public No(int valor) {
		this.valor = valor;
		this.altura = 1;
		this.direito = null;
		this.esquerdo = null;
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

	public No atualizarFilhoUnico(int valor, No noFilho) {
		if (Objects.nonNull(this.getEsquerdo()) && valor == this.getEsquerdo().getValor()) {
			this.setEsquerdo(noFilho);
		} else {
			this.setDireito(noFilho);
		}
		return noFilho;
	}
}
