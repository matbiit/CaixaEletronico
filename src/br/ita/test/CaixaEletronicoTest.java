package br.ita.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ita.exceptions.FalhaDeHardwareException;
import br.ita.infra.Hardware;
import br.ita.infra.MockHardware;
import br.ita.model.CaixaEletronico;
import br.ita.services.MockServicoRemoto;
import br.ita.services.ServicoRemoto;

public class CaixaEletronicoTest {
	
	private CaixaEletronico caixa;
	private ServicoRemoto servicoRemoto;
	private Hardware hardware;
	private String numeroContaLido;
	
	@Before
	public void inicializarCaixa() throws FalhaDeHardwareException{
		hardware = new MockHardware();
		caixa = new CaixaEletronico(hardware);
		servicoRemoto = new MockServicoRemoto();
		numeroContaLido = hardware.pegarNumeroDaContaCartao();
		caixa.setServicoRemoto(servicoRemoto);
		caixa.setContaCorrente(servicoRemoto.recuperarConta("12345-6"));
	}
	
	@Test
	public void testLoginComSucesso() {
		assertEquals("Usuário Autenticado", caixa.logar(numeroContaLido,"cft66tfc"));
	}
	
	@Test
	public void testLoginFalho() {
		assertEquals("Não foi possível autenticar o usuário", caixa.logar(numeroContaLido,"1478"));
	}
	
	@Test
	public void testDepositoComSucesso() throws FalhaDeHardwareException {
		assertEquals("Depósito realizado com sucesso", caixa.depositar(100));
	}
	
	@Test
	public void testDepositoFalho() throws FalhaDeHardwareException {
		assertEquals("Valor do depósito precisa ser maior que 0", caixa.depositar(0));
	}
	
	@Test
	public void testSaqueComSucesso() throws FalhaDeHardwareException {
		caixa.depositar(100);
		assertEquals("Retire seu dinheiro", caixa.sacar(50));
	}
	
	@Test
	public void testSaqueFalho() throws FalhaDeHardwareException {
		caixa.depositar(50);
		assertEquals("Saldo insuficiente", caixa.sacar(100));
	}
	
	@Test
	public void testSaldo() throws FalhaDeHardwareException{ 
		caixa.depositar(50);
		assertEquals("O saldo é R$50,00", caixa.saldo());
	}


}
