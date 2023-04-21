package arvore;

import java.util.Objects;

public class ArvoreAvl {

	public static No rebalancear(No no, int valor) {
		int fatorBalanceamento = calcularFatorBalanceamento(no);
		System.out.println(fatorBalanceamento);

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

	private static int calcularFatorBalanceamento(No no) {
		if (no == null)
			return 0;
		return calcularAltura(no.getEsquerdo()) - calcularAltura(no.getDireito());
	}

	private static int calcularAltura(No no) {
		if (no == null)
			return 0;
		return no.getAltura();
	}

	private static No rotacaoDireita(No y) {
		No x = y.getEsquerdo();
		No T2 = x.getDireito();

		x.setDireito(y);
		y.setEsquerdo(T2);

		x.setPai(y.getPai());
		y.setPai(x);
		if (Objects.nonNull(T2)) {
			T2.setPai(y);
		}

		x.setAltura(calcularAltura(x.getPai()) + 1);
		y.setAltura(calcularAltura(x) + 1);
		x.getEsquerdo().setAltura(x.getAltura() + 1);

		return x;
	}

	private static No rotacaoEsquerda(No x) {
		No y = x.getDireito();
		No T2 = y.getEsquerdo();

		y.setEsquerdo(x);
		x.setDireito(T2);

		y.setPai(x.getPai());
		x.setPai(y);
		if (Objects.nonNull(T2)) {
			T2.setPai(x);
		}

		y.setAltura(calcularAltura(x.getPai()) + 1);
		x.setAltura(calcularAltura(y) + 1);
		y.getDireito().setAltura(y.getAltura() + 1);

		return y;
	}
}
