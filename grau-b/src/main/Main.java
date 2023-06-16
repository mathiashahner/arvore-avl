package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import arvore.ArvoreBinaria;
import ui.Tela;

public class Main {

	private static final String NOME_ARQUIVO = "src//main//PessoasArvore.csv";

	public static void main(String[] args) {

		ArvoreBinaria<BigInteger> arvoreInteger = new ArvoreBinaria<>();
		ArvoreBinaria<String> arvoreString = new ArvoreBinaria<>();
		ArvoreBinaria<Date> arvoreDate = new ArvoreBinaria<>();

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {
			int contador = 0;
			String linha = "";
			BufferedReader leitor = new BufferedReader(new FileReader(NOME_ARQUIVO));

			while ((linha = leitor.readLine()) != null) {

				String[] fileira = linha.split(";");
				Date data = new SimpleDateFormat("dd/MM/yyyy").parse(fileira[3]);

				pessoas.add(new Pessoa(fileira[1], fileira[0], fileira[2], data, fileira[4]));
				arvoreInteger.inserir(new BigInteger(fileira[1]), contador);
				arvoreString.inserir(fileira[2].toUpperCase(), contador);
				arvoreDate.inserir(data, contador);
				contador++;
			}

			leitor.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<ArvoreBinaria<?>> arvoresBinarias = new ArrayList<>();
		arvoresBinarias.add(arvoreString);
		arvoresBinarias.add(arvoreInteger);
		arvoresBinarias.add(arvoreDate);

		new Tela(arvoresBinarias, pessoas);
	}
}
