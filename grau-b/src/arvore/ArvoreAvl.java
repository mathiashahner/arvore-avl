package arvore;

public class ArvoreAvl<T extends Comparable<T>> {

	public No<T> rebalancearInsercao(No<T> no, T valor) {
		int fatorBalanceamento = calcularFatorBalanceamento(no);

		if (fatorBalanceamento > 1 && valor.compareTo(no.getEsquerdo().getValor()) < 0) {
			return rotacaoDireita(no);
		}
		if (fatorBalanceamento < -1 && valor.compareTo(no.getDireito().getValor()) > 0) {
			return rotacaoEsquerda(no);
		}
		if (fatorBalanceamento > 1 && valor.compareTo(no.getEsquerdo().getValor()) > 0) {
			no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
			return rotacaoDireita(no);
		}
		if (fatorBalanceamento < -1 && valor.compareTo(no.getDireito().getValor()) < 0) {
			no.setDireito(rotacaoDireita(no.getDireito()));
			return rotacaoEsquerda(no);
		}
		return no;
	}

	public No<T> rebalancearRemocao(No<T> no) {
		int fatorBalanceamento = calcularFatorBalanceamento(no);

		if (fatorBalanceamento > 1 && calcularFatorBalanceamento(no.getEsquerdo()) >= 0) {
			return rotacaoDireita(no);
		}
		if (fatorBalanceamento > 1 && calcularFatorBalanceamento(no.getEsquerdo()) < 0) {
			no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
			return rotacaoDireita(no);
		}
		if (fatorBalanceamento < -1 && calcularFatorBalanceamento(no.getDireito()) <= 0) {
			return rotacaoEsquerda(no);
		}
		if (fatorBalanceamento < -1 && calcularFatorBalanceamento(no.getDireito()) > 0) {
			no.setDireito(rotacaoDireita(no.getDireito()));
			return rotacaoEsquerda(no);
		}
		return no;
	}

	public int calcularAltura(No<T> no) {
		if (no == null)
			return 0;
		return no.getAltura();
	}

	private int calcularFatorBalanceamento(No<T> no) {
		if (no == null)
			return 0;
		return calcularAltura(no.getEsquerdo()) - calcularAltura(no.getDireito());
	}

	private No<T> rotacaoDireita(No<T> y) {
		No<T> x = y.getEsquerdo();
		No<T> T2 = x.getDireito();

		x.setDireito(y);
		y.setEsquerdo(T2);

		y.setAltura(Math.max(calcularAltura(y.getEsquerdo()), calcularAltura(y.getDireito())) + 1);
		x.setAltura(Math.max(calcularAltura(x.getEsquerdo()), calcularAltura(x.getDireito())) + 1);

		return x;
	}

	private No<T> rotacaoEsquerda(No<T> x) {
		No<T> y = x.getDireito();
		No<T> T2 = y.getEsquerdo();

		y.setEsquerdo(x);
		x.setDireito(T2);

		x.setAltura(Math.max(calcularAltura(x.getEsquerdo()), calcularAltura(x.getDireito())) + 1);
		y.setAltura(Math.max(calcularAltura(y.getEsquerdo()), calcularAltura(y.getDireito())) + 1);

		return y;
	}
}
