package br.ita.model;

public class ContaCorrente {

	String numeroConta;
	String senha;
	double saldo;
	
	public ContaCorrente(String numeroConta, String senha, double saldo){
		this.numeroConta = numeroConta;
		this.senha = senha;
		this.saldo = saldo;
	}
	
	public String getNumeroConta(){
		return this.numeroConta;
	}
	
	public String getSenha(){
		return this.senha;
	}
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public void setSaldo(double valor){
		this.saldo = valor;
	}
}
