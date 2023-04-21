package main;

import java.util.Objects;
import java.util.Scanner;

import arvore.ArvoreBinaria;
import arvore.No;
import ui.Arvore;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

		arvoreBinaria.inserir(4);
		arvoreBinaria.inserir(2);
		arvoreBinaria.inserir(1);
		arvoreBinaria.inserir(3);
		arvoreBinaria.inserir(6);
		arvoreBinaria.inserir(5);
		arvoreBinaria.inserir(7);
		
//		arvoreBinaria.inserir(8);
//		arvoreBinaria.inserir(4);
//		arvoreBinaria.inserir(18);
//		arvoreBinaria.inserir(2);
//		arvoreBinaria.inserir(6);
//		arvoreBinaria.inserir(12);
//		arvoreBinaria.inserir(20);
//		arvoreBinaria.inserir(10);
//		arvoreBinaria.inserir(16);
//		arvoreBinaria.inserir(14);
		
//		arvoreBinaria.inserir(120);
//		arvoreBinaria.inserir(110);
//		arvoreBinaria.inserir(150);
//		arvoreBinaria.inserir(100);
//		arvoreBinaria.inserir(130);
//		arvoreBinaria.inserir(200);
//		arvoreBinaria.inserir(80);

		Arvore.printNode(arvoreBinaria.getRaiz());
		
		int opcao = -1;
		int numero = 0;

		while (opcao != 4) {
			exibirMenu();
			opcao = getInteiro("\nDigite a opcao que deseja: ");

			switch (opcao) {
			case 1:
				numero = getInteiro("\nQual valor deseja buscar? ");
				No no = arvoreBinaria.buscar(numero);

				if (Objects.isNull(no)) {
					System.out.println("\nValor não encontrado na árvore.");
				} else {
					System.out.println("\nAltura do nó: " + no.getAltura() + "\n");
					Arvore.printNode(no);
				}
				break;
			case 2:
				numero = getInteiro("\nQual valor deseja inserir? ");
				arvoreBinaria.inserir(numero);
				Arvore.printNode(arvoreBinaria.getRaiz());
				break;
			case 3:
				numero = getInteiro("\nQual valor deseja excluir? ");

				if (arvoreBinaria.excluir(numero)) {
					Arvore.printNode(arvoreBinaria.getRaiz());
				} else {
					System.out.println("\nValor não encontrado na árvore.");
				}
				break;
			case 4:
				System.out.println("\nSair...");
				break;
			default:
				System.out.println("\nOpção inválida!");
				break;
			}
		}
	}

	private static int getInteiro(String mensagem) {
		System.out.println(mensagem);
		return scanner.nextInt();
	}

	private static void exibirMenu() {
		System.out.println("\n1 - Buscar");
		System.out.println("2 - Inserir");
		System.out.println("3 - Excluir");
		System.out.println("4 - Sair");
	}
}

// https://stackoverflow.com/a/4973083
// https://www.baeldung.com/java-binary-tree