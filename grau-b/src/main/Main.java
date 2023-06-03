package main;

import java.util.Date;
import java.util.GregorianCalendar;

import arvore.ArvoreBinaria;
import ui.ExibirArvore;

public class Main {

//	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArvoreBinaria<Date> arvoreBinaria = new ArvoreBinaria<>();

//		arvoreBinaria.inserir(4);
//		arvoreBinaria.inserir(2);
//		arvoreBinaria.inserir(1);
//		arvoreBinaria.inserir(3);
//		arvoreBinaria.inserir(6);
//		arvoreBinaria.inserir(5);
//		arvoreBinaria.inserir(7);
			
//		arvoreBinaria.inserir("d");
//		arvoreBinaria.inserir("b");
//		arvoreBinaria.inserir("a");
//		arvoreBinaria.inserir("c");
//		arvoreBinaria.inserir("f");
//		arvoreBinaria.inserir("e");
//		arvoreBinaria.inserir("g");

		arvoreBinaria.inserir(new GregorianCalendar(2023, 06, 04).getTime());
		arvoreBinaria.inserir(new GregorianCalendar(2023, 06, 02).getTime());
		arvoreBinaria.inserir(new GregorianCalendar(2023, 06, 01).getTime());
		arvoreBinaria.inserir(new GregorianCalendar(2023, 06, 03).getTime());
		arvoreBinaria.inserir(new GregorianCalendar(2023, 06, 06).getTime());
		arvoreBinaria.inserir(new GregorianCalendar(2023, 06, 05).getTime());
		arvoreBinaria.inserir(new GregorianCalendar(2023, 06, 07).getTime());
		
		ExibirArvore.imprimirNo(arvoreBinaria.getRaiz());
		
//		int opcao = -1;
//		Date numero = null;
//
//		while (opcao != 5) {
//			exibirMenu();
//			opcao = getInteiro("\nDigite a opcao que deseja: ");
//
//			switch (opcao) {
//			case 1:
////				numero = getInteiro("\nQual valor deseja buscar? ");
////				No<T> no = arvoreBinaria.buscar(numero);
////
////				if (Objects.isNull(no)) {
////					System.out.println("\nValor não encontrado na árvore.");
////				} else {
////					System.out.println("\nAltura do nó: " + no.getAltura() + "\n");
////					ExibirArvore.imprimirNo(no);
////				}
//				break;
//			case 2:
////				numero = getInteiro("\nQual valor deseja inserir? ");
//				arvoreBinaria.inserir(numero);
////				ExibirArvore.imprimirNo(arvoreBinaria.getRaiz());
//				break;
//			case 3:
////				numero = getInteiro("\nQual valor deseja excluir? ");
//
//				if (arvoreBinaria.excluir(numero) != null) {
//					ExibirArvore.imprimirNo(arvoreBinaria.getRaiz());
//				} else {
//					System.out.println("\nValor não encontrado na árvore.");
//				}
//				break;
//			case 4:
//				ExibirArvore.imprimirNo(arvoreBinaria.getRaiz());
//				System.out.println("Pré-Ordem: " + arvoreBinaria.percorrerPreOrdem());
//				System.out.println("Em-Ordem:  " + arvoreBinaria.percorrerEmOrdem());
//				System.out.println("Pós-Ordem: " + arvoreBinaria.percorrerPosOrdem());
//				break;
//			case 5:
//				System.out.println("\nSair...");
//				break;
//			default:
//				System.out.println("\nOpção inválida!");
//				break;
//			}
//		}
	}

//	private static int getInteiro(String mensagem) {
//		System.out.println(mensagem);
//		return scanner.nextInt();
//	}
//
//	private static void exibirMenu() {
//		System.out.println("\n1 - Buscar");
//		System.out.println("2 - Inserir");
//		System.out.println("3 - Excluir");
//		System.out.println("4 - Percorrer");
//		System.out.println("5 - Sair");
//	}
}
