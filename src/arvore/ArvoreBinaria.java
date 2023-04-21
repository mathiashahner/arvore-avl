package arvore;

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
			return new No(valor, noPai);
		}

		if (valor < noPai.getValor()) {
			No no = inserir(valor, noPai.getEsquerdo());
			no.setPai(noPai);
			no.setAltura(noPai.getAltura() + 1);
			noPai.setEsquerdo(no);
		} else if (valor > noPai.getValor()) {
			No no = inserir(valor, noPai.getDireito());
			no.setPai(noPai);
			no.setAltura(noPai.getAltura() + 1);
			noPai.setDireito(no);
		} else {
			return noPai;
		}

		return ArvoreAvl.rebalancear(noPai, valor);
	}

	public No buscar(int valor) {
		return buscar(valor, raiz);
	}

	private No buscar(int valor, No noPai) {
		if (Objects.isNull(noPai)) {
			return null;
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

	public boolean excluir(int numero) {
		No no = buscar(numero);

		if (Objects.isNull(no)) {
			return false;
		} else if (Objects.isNull(no.getEsquerdo()) && Objects.isNull(no.getDireito())) {
			no.atualizarFilhoUnico(null);
		} else if (Objects.nonNull(no.getEsquerdo()) ^ Objects.nonNull(no.getDireito())) {
			No noFilho = Objects.nonNull(no.getEsquerdo()) ? no.getEsquerdo() : no.getDireito();
			noFilho.setPai(no.getPai());
			noFilho.setAltura(noFilho.getAltura() - 1);
			no.atualizarFilhoUnico(noFilho);
		} else if (Objects.nonNull(no.getEsquerdo()) && Objects.nonNull(no.getDireito())) {
			No maiorNoEsquerdo = no.getEsquerdo();

			while (Objects.nonNull(maiorNoEsquerdo.getDireito())) {
				maiorNoEsquerdo = maiorNoEsquerdo.getDireito();
			}

			excluir(maiorNoEsquerdo.getValor());

			no.atualizarFilhoUnico(maiorNoEsquerdo);
			no.getEsquerdo().setPai(maiorNoEsquerdo);
			no.getDireito().setPai(maiorNoEsquerdo);

			maiorNoEsquerdo.setEsquerdo(no.getEsquerdo());
			maiorNoEsquerdo.setDireito(no.getDireito());
			maiorNoEsquerdo.setAltura(maiorNoEsquerdo.getEsquerdo().getAltura() - 1);
		}
		return true;
	}
}
