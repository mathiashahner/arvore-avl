package main;

import java.math.BigInteger;
import java.util.Date;

public class Pessoa {

	private BigInteger cpf;
	private BigInteger rg;
	private String nome;
	private Date dataNascimento;
	private String cidade;

	public Pessoa(String cpf, String rg, String nome, Date dataNascimento, String cidade) {
		super();
		this.cpf = new BigInteger(cpf);
		this.rg = new BigInteger(rg);
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
	}

	public BigInteger getCpf() {
		return cpf;
	}

	public BigInteger getRg() {
		return rg;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getCidade() {
		return cidade;
	}
}
