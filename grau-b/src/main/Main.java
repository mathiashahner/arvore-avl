package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import arvore.ArvoreBinaria;
import ui.Tela;

public class Main {

	public static void main(String[] args) {

		ArvoreBinaria<BigInteger> arvoreInteger = new ArvoreBinaria<>();
		ArvoreBinaria<String> arvoreString = new ArvoreBinaria<>();
		ArvoreBinaria<Date> arvoreDate = new ArvoreBinaria<>();

//		arvoreInteger.inserir(new BigInteger("30247467065"), 0);
//		arvoreInteger.inserir(new BigInteger("01746886013"), 1);
//		arvoreInteger.inserir(new BigInteger("71578643040"), 2);
//		arvoreInteger.inserir(new BigInteger("94621841009"), 3);
//		arvoreInteger.inserir(new BigInteger("36528729085"), 4);
//		arvoreInteger.inserir(new BigInteger("88284353059"), 5);
//		arvoreInteger.inserir(new BigInteger("42432167031"), 6);
//		arvoreInteger.inserir(new BigInteger("51501937049"), 7);
//		arvoreInteger.inserir(new BigInteger("35170050020"), 8);
//		arvoreInteger.inserir(new BigInteger("66144629033"), 9);
//
//		arvoreString.inserir("Mathias Hahner", 0);
//		arvoreString.inserir("Emily Specht", 1);
//		arvoreString.inserir("Vanessa Hahner", 2);
//		arvoreString.inserir("Silvia Risbacik", 3);
//		arvoreString.inserir("Rafael Klaus", 4);
//		arvoreString.inserir("José Hahner", 5);
//		arvoreString.inserir("Hemerson", 6);
//		arvoreString.inserir("Alan", 7);
//		arvoreString.inserir("Marina", 8);
//		arvoreString.inserir("Jean", 9);
//
//		arvoreDate.inserir(new GregorianCalendar(2001, 5, 30).getTime(), 0);
//		arvoreDate.inserir(new GregorianCalendar(2001, 1, 23).getTime(), 1);
//		arvoreDate.inserir(new GregorianCalendar(2003, 4, 5).getTime(), 2);
//		arvoreDate.inserir(new GregorianCalendar(2010, 5, 11).getTime(), 3);
//		arvoreDate.inserir(new GregorianCalendar(1990, 9, 24).getTime(), 4);
//		arvoreDate.inserir(new GregorianCalendar(1995, 11, 2).getTime(), 5);
//		arvoreDate.inserir(new GregorianCalendar(1980, 12, 7).getTime(), 6);
//		arvoreDate.inserir(new GregorianCalendar(1985, 1, 13).getTime(), 7);
//		arvoreDate.inserir(new GregorianCalendar(1999, 6, 13).getTime(), 8);
//		arvoreDate.inserir(new GregorianCalendar(2000, 8, 20).getTime(), 9);
//
//		List<Pessoa> pessoas = new ArrayList<>();
//		pessoas.add(new Pessoa("30247467065", "211989125", "Mathias Hahner",
//				new GregorianCalendar(2001, 5, 30).getTime(), "Rolante"));
//		pessoas.add(new Pessoa("01746886013", "132034529", "Emily Specht",
//				new GregorianCalendar(2001, 1, 23).getTime(), "Venâncio Aires"));
//		pessoas.add(new Pessoa("71578643040", "413814658", "Vanessa Hahner",
//				new GregorianCalendar(2003, 4, 5).getTime(), "Rolante"));
//		pessoas.add(new Pessoa("94621841009", "264043315", "Silvia Risbacik",
//				new GregorianCalendar(2010, 5, 11).getTime(), "Riozinho"));
//		pessoas.add(new Pessoa("36528729085", "239915914", "Rafael Klaus",
//				new GregorianCalendar(1990, 9, 24).getTime(), "São Leopoldo"));
//		pessoas.add(new Pessoa("88284353059", "339554617", "José Hahner",
//				new GregorianCalendar(1995, 11, 2).getTime(), "Rolante"));
//		pessoas.add(new Pessoa("42432167031", "451627465", "Hemerson",
//				new GregorianCalendar(1980, 12, 7).getTime(), "Canoas"));
//		pessoas.add(new Pessoa("51501937049", "124081502", "Alan",
//				new GregorianCalendar(1985, 1, 13).getTime(), "Porto Alegre"));
//		pessoas.add(new Pessoa("35170050020", "315621722", "Marina",
//				new GregorianCalendar(1999, 6, 13).getTime(), "Venâncio Aires"));
//		pessoas.add(new Pessoa("66144629033", "189312725", "Jean",
//				new GregorianCalendar(2000, 8, 20).getTime(), "Venâncio Aires"));
		String arquivo = "src//main//PessoasArvore.csv";
		BufferedReader leitor = null;
		String linha = "";
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		
		try {
			leitor = new BufferedReader(new FileReader(arquivo));
			int contador = 0;
			while((linha = leitor.readLine()) != null ){
				String[] fileira = linha.split(";");
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
				Date data = null;
				try {
					data = formato.parse(fileira[3]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				Pessoa pessoa = new Pessoa(fileira[1], fileira[0], fileira[2], data, fileira[4]);
				
				arvoreInteger.inserir(new BigInteger(fileira[1]), contador);
				arvoreString.inserir(fileira[2], contador);
				arvoreDate.inserir(data, contador);

				
				pessoas.add(pessoa);
				
				contador++;
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				leitor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//
		List<ArvoreBinaria<?>> arvoresBinarias = new ArrayList<>();
		arvoresBinarias.add(arvoreString);
		arvoresBinarias.add(arvoreInteger);
		arvoresBinarias.add(arvoreDate);

		new Tela(arvoresBinarias, pessoas);
		
	}
}
