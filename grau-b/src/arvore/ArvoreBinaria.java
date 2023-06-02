package arvore;

import static arvore.ArvoreAvl.calcularAltura;

import java.util.Objects;

public class ArvoreBinaria {
	private No raiz;

	public No getRaiz() {
		return raiz;
	}

	public void inserir(int valor) {
		raiz = inserir(valor, raiz);
	}

	private No inserir(int valor, No noPai) {
		if (Objects.isNull(noPai)) {
			return new No(valor);
		}

		if (valor < noPai.getValor()) {
			noPai.setEsquerdo(inserir(valor, noPai.getEsquerdo()));
		} else if (valor > noPai.getValor()) {
			noPai.setDireito(inserir(valor, noPai.getDireito()));
		} else {
			return noPai;
		}

		noPai.setAltura(Math.max(calcularAltura(noPai.getEsquerdo()), calcularAltura(noPai.getDireito())) + 1);
		return ArvoreAvl.rebalancearInsercao(noPai, valor);
	}

	public No buscar(int valor) {
		return buscar(valor, raiz);
	}

	private No buscar(int valor, No noPai) {
		if (Objects.isNull(noPai)) {
			return noPai;
		}

		if (valor == noPai.getValor()) {
			return noPai;
		} else if (valor < noPai.getValor()) {
			return buscar(valor, noPai.getEsquerdo());
		} else if (valor > noPai.getValor()) {
			return buscar(valor, noPai.getDireito());
		}
		return null;
	}

	public No excluir(int valor) {
		raiz = excluir(valor, raiz, null);
		return raiz;
	}

	private No excluir(int valor, No no, No noPai) {
		if (Objects.isNull(no)) {
			return no;
		}

		if (valor < no.getValor()) {
			no.setEsquerdo(excluir(valor, no.getEsquerdo(), no));
		} else if (valor > no.getValor()) {
			no.setDireito(excluir(valor, no.getDireito(), no));
		} else {
			if (Objects.isNull(no.getEsquerdo()) && Objects.isNull(no.getDireito())) {
				return noPai.atualizarFilhoUnico(no.getValor(), null);
			} else if (Objects.nonNull(no.getEsquerdo()) ^ Objects.nonNull(no.getDireito())) {
				No noFilho = Objects.nonNull(no.getEsquerdo()) ? no.getEsquerdo() : no.getDireito();
				return noPai.atualizarFilhoUnico(no.getValor(), noFilho);
			} else if (Objects.nonNull(no.getEsquerdo()) && Objects.nonNull(no.getDireito())) {
				No maiorNoEsquerdo = no.getEsquerdo();

				while (Objects.nonNull(maiorNoEsquerdo.getDireito())) {
					maiorNoEsquerdo = maiorNoEsquerdo.getDireito();
				}

				no.setValor(maiorNoEsquerdo.getValor());
				no.setEsquerdo(excluir(maiorNoEsquerdo.getValor(), no.getEsquerdo(), no));
			}
		}

		no.setAltura(Math.max(calcularAltura(no.getEsquerdo()), calcularAltura(no.getDireito())) + 1);
		return ArvoreAvl.rebalancearRemocao(no);
	}

	public String percorrerEmOrdem() {
		return percorrerEmOrdem(raiz);
	}

	private String percorrerEmOrdem(No noAtual) {
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

	private String percorrerPreOrdem(No noAtual) {
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

	private String percorrerPosOrdem(No noAtual) {
		StringBuilder sb = new StringBuilder();

		if (noAtual != null) {
			sb.append(percorrerPosOrdem(noAtual.getEsquerdo()));
			sb.append(percorrerPosOrdem(noAtual.getDireito()));
			sb.append(String.valueOf(noAtual.getValor()) + "  ");
		}

		return sb.toString();
	}
}
