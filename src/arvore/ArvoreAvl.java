package arvore;

public class ArvoreAvl {

	public static No rebalancearInsercao(No no, int valor) {
		int fatorBalanceamento = calcularFatorBalanceamento(no);

		if (fatorBalanceamento > 1 && valor < no.getEsquerdo().getValor()) {
			return rotacaoDireita(no);
		}
		if (fatorBalanceamento < -1 && valor > no.getDireito().getValor()) {
			return rotacaoEsquerda(no);
		}
		if (fatorBalanceamento > 1 && valor > no.getEsquerdo().getValor()) {
			no.setEsquerdo(rotacaoEsquerda(no.getEsquerdo()));
			return rotacaoDireita(no);
		}
		if (fatorBalanceamento < -1 && valor < no.getDireito().getValor()) {
			no.setDireito(rotacaoDireita(no.getDireito()));
			return rotacaoEsquerda(no);
		}
		return no;
	}

	public static No rebalancearRemocao(No no) {
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

	public static int calcularAltura(No no) {
		if (no == null)
			return 0;
		return no.getAltura();
	}

	private static int calcularFatorBalanceamento(No no) {
		if (no == null)
			return 0;
		return calcularAltura(no.getEsquerdo()) - calcularAltura(no.getDireito());
	}

	private static No rotacaoDireita(No y) {
		No x = y.getEsquerdo();
		No T2 = x.getDireito();

		x.setDireito(y);
		y.setEsquerdo(T2);

		y.setAltura(Math.max(calcularAltura(y.getEsquerdo()), calcularAltura(y.getDireito())) + 1);
		x.setAltura(Math.max(calcularAltura(x.getEsquerdo()), calcularAltura(x.getDireito())) + 1);

		return x;
	}

	private static No rotacaoEsquerda(No x) {
		No y = x.getDireito();
		No T2 = y.getEsquerdo();

		y.setEsquerdo(x);
		x.setDireito(T2);

		x.setAltura(Math.max(calcularAltura(x.getEsquerdo()), calcularAltura(x.getDireito())) + 1);
		y.setAltura(Math.max(calcularAltura(y.getEsquerdo()), calcularAltura(y.getDireito())) + 1);

		return y;
	}
}
