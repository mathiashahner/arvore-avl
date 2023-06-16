package arvore;

import java.util.Date;
import java.util.Objects;

public class ArvoreBinaria<T extends Comparable<T>> {

	private No<T> raiz;
	private ArvoreAvl<T> arvoreAvl = new ArvoreAvl<>();

	public No<T> getRaiz() {
		return raiz;
	}

	public void inserir(T valor, int posicao) {
		raiz = inserir(valor, posicao, raiz);
	}

	private No<T> inserir(T valor, int posicao, No<T> noPai) {
		if (Objects.isNull(noPai)) {
			return new No<T>(valor, posicao);
		}

		if (valor.compareTo(noPai.getValor()) < 0) {
			noPai.setEsquerdo(inserir(valor, posicao, noPai.getEsquerdo()));
		} else if (valor.compareTo(noPai.getValor()) > 0) {
			noPai.setDireito(inserir(valor, posicao, noPai.getDireito()));
		} else {
			return noPai;
		}

		noPai.setAltura(Math.max(arvoreAvl.calcularAltura(noPai.getEsquerdo()),
				arvoreAvl.calcularAltura(noPai.getDireito())) + 1);

		return arvoreAvl.rebalancearInsercao(noPai, valor);
	}

	public No<T> buscar(T valor) {
		return buscar(valor, raiz);
	}

	private No<T> buscar(T valor, No<T> noPai) {
		if (Objects.isNull(noPai)) {
			return noPai;
		}

		if (valor.compareTo(noPai.getValor()) == 0) {
			return noPai;
		} else if (valor.compareTo(noPai.getValor()) < 0) {
			return buscar(valor, noPai.getEsquerdo());
		} else if (valor.compareTo(noPai.getValor()) > 0) {
			return buscar(valor, noPai.getDireito());
		}
		return null;
	}

	public String percorrerEmOrdem(No<T> noAtual, String valor) {
		StringBuilder sb = new StringBuilder();

		if (noAtual != null) {
			sb.append(percorrerEmOrdem(noAtual.getEsquerdo(), valor));

			if (noAtual.getValor().toString().startsWith(valor))
				sb.append(String.valueOf(noAtual.getPosicao()) + ";");

			sb.append(percorrerEmOrdem(noAtual.getDireito(), valor));
		}

		return sb.toString();
	}

	public String percorrerEmOrdemDate(No<Date> noAtual, Date valorInicio, Date valorFim) {
		StringBuilder sb = new StringBuilder();

		if (noAtual != null) {
			sb.append(percorrerEmOrdemDate(noAtual.getEsquerdo(), valorInicio, valorFim));

			if (noAtual.getValor().after(valorInicio) && noAtual.getValor().before(valorFim))
				sb.append(String.valueOf(noAtual.getPosicao()) + ";");

			sb.append(percorrerEmOrdemDate(noAtual.getDireito(), valorInicio, valorFim));
		}

		return sb.toString();
	}

	public No<T> buscarString(T valor) {
		return buscarString(valor, raiz);
	}

	private No<T> buscarString(T valor, No<T> noPai) {
		if (Objects.isNull(noPai)) {
			return noPai;
		}

		if (noPai.getValor().toString().startsWith(valor.toString())) {
			return noPai;
		} else if (valor.compareTo(noPai.getValor()) < 0) {
			return buscarString(valor, noPai.getEsquerdo());
		} else if (valor.compareTo(noPai.getValor()) > 0) {
			return buscarString(valor, noPai.getDireito());
		}
		return null;
	}

	public No<Date> buscarDate(Date valorInicio, Date valorFim) {
		return buscarDate(valorInicio, valorFim, (No<Date>) raiz);
	}

	private No<Date> buscarDate(Date valorInicio, Date valorFim, No<Date> noPai) {
		if (Objects.isNull(noPai)) {
			return noPai;
		}

		if (noPai.getValor().after(valorInicio) && noPai.getValor().before(valorFim)) {
			return noPai;
		} else if (valorInicio.compareTo(noPai.getValor()) < 0) {
			return buscarDate(valorInicio, valorFim, noPai.getEsquerdo());
		} else if (valorFim.compareTo(noPai.getValor()) > 0) {
			return buscarDate(valorInicio, valorFim, noPai.getDireito());
		}
		return null;
	}
}
