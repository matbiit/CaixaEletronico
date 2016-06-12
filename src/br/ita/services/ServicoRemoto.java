package br.ita.services;

import br.ita.model.ContaCorrente;

public interface ServicoRemoto {

	public ContaCorrente recuperarConta(String numeroConta);
	
	public void persistirConta(ContaCorrente contaCorrente);
}
