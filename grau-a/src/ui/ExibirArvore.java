package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import arvore.No;

public class ExibirArvore {

	public static void imprimirNo(No root) {
		int nivelMaximo = nivelMaximo(root);

		imprimirNo(Collections.singletonList(root), 1, nivelMaximo);
	}

	private static void imprimirNo(List<No> nos, int level, int maxLevel) {
		if (nos.isEmpty() || elementosSaoNulos(nos))
			return;

		int floor = maxLevel - level;
		int extremidade = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int primeirosEspacos = (int) Math.pow(2, (floor)) - 1;
		int espacosIntermediarios = (int) Math.pow(2, (floor + 1)) - 1;

		imprimirEspacosEmBranco(primeirosEspacos);

		List<No> novosNos = new ArrayList<No>();

		for (No no : nos) {
			if (no != null) {
				System.out.print(no.getValor());
				novosNos.add(no.getEsquerdo());
				novosNos.add(no.getDireito());
			} else {
				novosNos.add(null);
				novosNos.add(null);
				System.out.print(" ");
			}

			imprimirEspacosEmBranco(espacosIntermediarios);
		}
		System.out.println("");

		for (int i = 1; i <= extremidade; i++) {
			for (int j = 0; j < nos.size(); j++) {
				imprimirEspacosEmBranco(primeirosEspacos - i);
				if (nos.get(j) == null) {
					imprimirEspacosEmBranco(extremidade + extremidade + i + 1);
					continue;
				}

				if (nos.get(j).getEsquerdo() != null)
					System.out.print("/");
				else
					imprimirEspacosEmBranco(1);

				imprimirEspacosEmBranco(i + i - 1);

				if (nos.get(j).getDireito() != null)
					System.out.print("\\");
				else
					imprimirEspacosEmBranco(1);

				imprimirEspacosEmBranco(extremidade + extremidade - i);
			}

			System.out.println("");
		}

		imprimirNo(novosNos, level + 1, maxLevel);
	}

	private static void imprimirEspacosEmBranco(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int nivelMaximo(No no) {
		if (no == null)
			return 0;

		return Math.max(nivelMaximo(no.getEsquerdo()), nivelMaximo(no.getDireito())) + 1;
	}

	private static boolean elementosSaoNulos(List<No> lista) {
		for (Object objeto : lista) {
			if (objeto != null)
				return false;
		}

		return true;
	}
}
