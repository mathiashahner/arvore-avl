package main;

import java.util.Scanner;

import arvore.ArvoreBinaria;
import ui.Arvore;

public class Main {

	public static void main(String[] args) {
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
		
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		int numero = 0;
		while(flag) {
			System.out.println("Digite a opcao que deseja: ");
            numero = scanner.nextInt();
            arvoreBinaria.inserir(numero);
            Arvore.printNode(arvoreBinaria.getRaiz());
		}
		

		//arvoreBinaria.inserir(4);
		//arvoreBinaria.inserir(7);
		//arvoreBinaria.inserir(6);
		//arvoreBinaria.inserir(4);
		//arvoreBinaria.inserir(2);

		//Arvore.printNode(arvoreBinaria.getRaiz());
	}
}

// https://stackoverflow.com/a/4973083
// https://www.baeldung.com/java-binary-tree