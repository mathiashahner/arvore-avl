package arvore;

public class ArvoreBinaria {
	private No<Integer> raiz;

	public No<Integer> getRaiz() {
		return raiz;
	}

	public void inserir(int valor) {
		raiz = inserir(valor, raiz);
	}

	private No<Integer> inserir(int valor, No<Integer> noPai) {
		if (noPai == null) {
			return new No<Integer>(valor);
		}

		if (valor < noPai.getValor()) {
			noPai.setEsquerdo(inserir(valor, noPai.getEsquerdo()));
		} else if (valor > noPai.getValor()) {
			noPai.setDireito(inserir(valor, noPai.getDireito()));
		} else {
			return (No<Integer>)noPai;
		}

		return (No<Integer>) noPai;
	}
}
