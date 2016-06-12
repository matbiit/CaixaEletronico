package br.ita.model;

import br.ita.exceptions.FalhaDeHardwareException;
import br.ita.infra.Hardware;
import br.ita.services.ServicoRemoto;

public class CaixaEletronico {

	private ContaCorrente contaCorrente;
	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	
	public CaixaEletronico(Hardware hardware){
		this.hardware = hardware; 
	}
	
	public String logar(String numeroConta, String senha){
		if((contaCorrente.getNumeroConta().equals(numeroConta))
			&& (contaCorrente.getSenha().equals(senha)))
			return "Usu�rio Autenticado";
		else
			return "N�o foi poss�vel autenticar o usu�rio";
	}
	
	public String sacar(int valor) throws FalhaDeHardwareException{
		if(contaCorrente.getSaldo() >= valor){
			contaCorrente.setSaldo(contaCorrente.getSaldo() - valor);
			this.servicoRemoto.persistirConta(contaCorrente);
			hardware.entregarDinheiro();
			return "Retire seu dinheiro";
		}
		else
			return "Saldo insuficiente";
	}
	
	public String depositar(int valor) throws FalhaDeHardwareException{
		hardware.lerEnvelope();
		if(valor > 0){
			contaCorrente.setSaldo(contaCorrente.getSaldo() + valor);
			this.servicoRemoto.persistirConta(contaCorrente);
			return "Dep�sito realizado com sucesso";
		} 
		return "Valor do dep�sito precisa ser maior que 0";
	}
	
	public String saldo(){
		return String.format("O saldo � R$%.2f", contaCorrente.getSaldo());
	}

	public void setServicoRemoto(ServicoRemoto servicoRemoto) {
		this.servicoRemoto = servicoRemoto;
	}

	public void setContaCorrente(ContaCorrente caixaCorrente) {
		this.contaCorrente = caixaCorrente;
	}
}
