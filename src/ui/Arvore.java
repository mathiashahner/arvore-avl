package ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import arvore.No;

public class Arvore {

	public static void printNode(No root) {
		int maxLevel = maxLevel(root);

		printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	}

	private static void printNodeInternal(List<No> nodes, int level, int maxLevel) {
		if (nodes.isEmpty() || isAllElementsNull(nodes))
			return;

		int floor = maxLevel - level;
		int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
		int firstSpaces = (int) Math.pow(2, (floor)) - 1;
		int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

		printWhitespaces(firstSpaces);

		List<No> newNodes = new ArrayList<No>();

		for (No node : nodes) {
			if (node != null) {
//				System.out.print(node.getValor()+"-"+node.getAltura());
				System.out.print(node.getValor());
				newNodes.add(node.getEsquerdo());
				newNodes.add(node.getDireito());
			} else {
				newNodes.add(null);
				newNodes.add(null);
				System.out.print(" ");
			}

			printWhitespaces(betweenSpaces);
		}
		System.out.println("");

		for (int i = 1; i <= endgeLines; i++) {
			for (int j = 0; j < nodes.size(); j++) {
				printWhitespaces(firstSpaces - i);
				if (nodes.get(j) == null) {
					printWhitespaces(endgeLines + endgeLines + i + 1);
					continue;
				}

				if (nodes.get(j).getEsquerdo() != null)
					System.out.print("/");
				else
					printWhitespaces(1);

				printWhitespaces(i + i - 1);

				if (nodes.get(j).getDireito() != null)
					System.out.print("\\");
				else
					printWhitespaces(1);

				printWhitespaces(endgeLines + endgeLines - i);
			}

			System.out.println("");
		}

		printNodeInternal(newNodes, level + 1, maxLevel);
	}

	private static void printWhitespaces(int count) {
		for (int i = 0; i < count; i++)
			System.out.print(" ");
	}

	private static int maxLevel(No node) {
		if (node == null)
			return 0;

		return Math.max(maxLevel(node.getEsquerdo()), maxLevel(node.getDireito())) + 1;
	}

	private static boolean isAllElementsNull(List<No> list) {
		for (Object object : list) {
			if (object != null)
				return false;
		}

		return true;
	}
}
