package main;

import arvore.ArvoreBinaria;
import ui.Arvore;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

		arvoreBinaria.inserir(4);
		arvoreBinaria.inserir(7);
		arvoreBinaria.inserir(6);
		arvoreBinaria.inserir(4);
		arvoreBinaria.inserir(2);

		Arvore.printNode(arvoreBinaria.getRaiz());
	}
}

// https://stackoverflow.com/a/4973083
// https://www.baeldung.com/java-binary-tree