package arvore;

import java.util.Objects;

public class ArvoreBinaria<T extends Comparable<T>> {
	private No<T> raiz;
	private ArvoreAvl<T> arvoreAvl = new ArvoreAvl<>();

	public No<T> getRaiz() {
		return raiz;
	}

	public void inserir(T valor) {
		raiz = inserir(valor, raiz);
	}

	private No<T> inserir(T valor, No<T> noPai) {
		if (Objects.isNull(noPai)) {
			return new No<T>(valor, 0);
		}

		if (valor.compareTo(noPai.getValor()) < 0) {
			noPai.setEsquerdo(inserir(valor, noPai.getEsquerdo()));
		} else if (valor.compareTo(noPai.getValor()) > 0) {
			noPai.setDireito(inserir(valor, noPai.getDireito()));
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

		if (valor == noPai.getValor()) {
			return noPai;
		} else if (valor.compareTo(noPai.getValor()) < 0) {
			return buscar(valor, noPai.getEsquerdo());
		} else if (valor.compareTo(noPai.getValor()) > 0) {
			return buscar(valor, noPai.getDireito());
		}
		return null;
	}

	public No<T> excluir(T valor) {
		raiz = excluir(valor, raiz, null);
		return raiz;
	}

	private No<T> excluir(T valor, No<T> no, No<T> noPai) {
		if (Objects.isNull(no)) {
			return no;
		}

		if (valor.compareTo(no.getValor()) < 0) {
			no.setEsquerdo(excluir(valor, no.getEsquerdo(), no));
		} else if (valor.compareTo(no.getValor()) > 0) {
			no.setDireito(excluir(valor, no.getDireito(), no));
		} else {
			if (Objects.isNull(no.getEsquerdo()) && Objects.isNull(no.getDireito())) {
				return noPai.atualizarFilhoUnico(no.getValor(), null);
			} else if (Objects.nonNull(no.getEsquerdo()) ^ Objects.nonNull(no.getDireito())) {
				No<T> noFilho = Objects.nonNull(no.getEsquerdo()) ? no.getEsquerdo() : no.getDireito();
				return noPai.atualizarFilhoUnico(no.getValor(), noFilho);
			} else if (Objects.nonNull(no.getEsquerdo()) && Objects.nonNull(no.getDireito())) {
				No<T> maiorNoEsquerdo = no.getEsquerdo();

				while (Objects.nonNull(maiorNoEsquerdo.getDireito())) {
					maiorNoEsquerdo = maiorNoEsquerdo.getDireito();
				}

				no.setValor(maiorNoEsquerdo.getValor());
				no.setEsquerdo(excluir(maiorNoEsquerdo.getValor(), no.getEsquerdo(), no));
			}
		}

		no.setAltura(
				Math.max(arvoreAvl.calcularAltura(no.getEsquerdo()), arvoreAvl.calcularAltura(no.getDireito())) + 1);
		return arvoreAvl.rebalancearRemocao(no);
	}

	public String percorrerEmOrdem() {
		return percorrerEmOrdem(raiz);
	}

	private String percorrerEmOrdem(No<T> noAtual) {
		StringBuilder sb = new StringBuilder();

		if (noAtual != null) {
			sb.append(percorrerEmOrdem(noAtual.getEsquerdo()));
			sb.append(String.valueOf(noAtual.getValor()) + "  ");
			sb.append(percorrerEmOrdem(noAtual.getDireito()));
		}

		return sb.toString();
	}

	public String percorrerPreOrdem() {
		return percorrerPreOrdem(raiz);
	}

	private String percorrerPreOrdem(No<T> noAtual) {
		StringBuilder sb = new StringBuilder();

		if (noAtual != null) {
			sb.append(String.valueOf(noAtual.getValor()) + "  ");
			sb.append(percorrerPreOrdem(noAtual.getEsquerdo()));
			sb.append(percorrerPreOrdem(noAtual.getDireito()));
		}

		return sb.toString();
	}

	public String percorrerPosOrdem() {
		return percorrerPosOrdem(raiz);
	}

	private String percorrerPosOrdem(No<T> noAtual) {
		StringBuilder sb = new StringBuilder();

		if (noAtual != null) {
			sb.append(percorrerPosOrdem(noAtual.getEsquerdo()));
			sb.append(percorrerPosOrdem(noAtual.getDireito()));
			sb.append(String.valueOf(noAtual.getValor()) + "  ");
		}

		return sb.toString();
	}
}
