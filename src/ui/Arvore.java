package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import arvore.No;

public class Arvore {

	public static <T extends Comparable<?>> void printNode(No<T> root) {
		int maxLevel = Arvore.maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static <T extends Comparable<?>> void printNodeInternal(List<No<T>> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || Arvore.isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		Arvore.printWhitespaces(firstSpaces);

		List<No<T>> newNodes = new ArrayList<No<T>>();

		for (No<T> node : nodes) {
			if (node != null) {
				System.out.print(node.getValor());
				newNodes.add(node.getEsquerdo());
				newNodes.add(node.getDireito());
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			Arvore.printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				Arvore.printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					Arvore.printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).getEsquerdo() != null)
					System.out.print("/");
				else
					Arvore.printWhitespaces(1);

				Arvore.printWhitespaces(i + i - 1);

				if (nodes.get(j).getDireito() != null)
					System.out.print("\\");
				else
					Arvore.printWhitespaces(1);

				Arvore.printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static <T extends Comparable<?>> int maxLevel(No<T> node) {
		if (node == null)
			return 0;

		return Math.max(Arvore.maxLevel(node.getEsquerdo()), Arvore.maxLevel(node.getDireito())) + 1;
	}

	private static <T> boolean isAllElementsNull(List<T> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}

}
