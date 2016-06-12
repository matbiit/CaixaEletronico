package br.ita.services;

import br.ita.model.ContaCorrente;

public class MockServicoRemoto implements ServicoRemoto {

	private ContaCorrente contaCorrente;
	
	public MockServicoRemoto(){
		contaCorrente = new ContaCorrente("12345-6", "cft66tfc", 0);
	}
	
	@Override
	public ContaCorrente recuperarConta(String numeroConta) {
		if(contaCorrente.getNumeroConta().equals(numeroConta))
				return contaCorrente;
		return null;
	}

	@Override
	public void persistirConta(ContaCorrente contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

}
