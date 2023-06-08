package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import arvore.ArvoreBinaria;
import ui.Tela;

public class Main {

	public static void main(String[] args) {

		ArvoreBinaria<Integer> arvoreInteger = new ArvoreBinaria<>();
		ArvoreBinaria<String> arvoreString = new ArvoreBinaria<>();
		ArvoreBinaria<Date> arvoreDate = new ArvoreBinaria<>();

		arvoreInteger.inserir(4);
		arvoreInteger.inserir(2);
		arvoreInteger.inserir(1);
		arvoreInteger.inserir(3);
		arvoreInteger.inserir(6);
		arvoreInteger.inserir(5);
		arvoreInteger.inserir(7);

		arvoreString.inserir("d");
		arvoreString.inserir("b");
		arvoreString.inserir("a");
		arvoreString.inserir("c");
		arvoreString.inserir("f");
		arvoreString.inserir("e");
		arvoreString.inserir("g");

		arvoreDate.inserir(new GregorianCalendar(2023, 06, 04).getTime());
		arvoreDate.inserir(new GregorianCalendar(2023, 06, 02).getTime());
		arvoreDate.inserir(new GregorianCalendar(2023, 06, 01).getTime());
		arvoreDate.inserir(new GregorianCalendar(2023, 06, 03).getTime());
		arvoreDate.inserir(new GregorianCalendar(2023, 06, 06).getTime());
		arvoreDate.inserir(new GregorianCalendar(2023, 06, 05).getTime());
		arvoreDate.inserir(new GregorianCalendar(2023, 06, 07).getTime());

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("12345678901", "3214445566", "Mathias Hahner",
				new GregorianCalendar(2001, 05, 30).getTime(), "Rolante"));
		pessoas.add(new Pessoa("00011122233", "3217895786", "Emily Specht",
				new GregorianCalendar(2001, 01, 23).getTime(), "Venâncio Aires"));

		List<ArvoreBinaria<?>> arvoresBinarias = new ArrayList<>();
		arvoresBinarias.add(arvoreString);
		arvoresBinarias.add(arvoreInteger);
		arvoresBinarias.add(arvoreDate);

		new Tela(arvoresBinarias, pessoas);
	}
}
