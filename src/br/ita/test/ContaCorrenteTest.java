package br.ita.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ita.model.ContaCorrente;

public class ContaCorrenteTest {

	private ContaCorrente cc;
	
	@Before
	public void inicializarContaCorrente() {
		cc = new ContaCorrente("78945-6", "qwert", 100 );
	}
	
	@Test
	public void testMesmoNumeroConta(){
		assertEquals("78945-6", cc.getNumeroConta());
	}
	
	@Test
	public void testDiferenteNumeroConta(){
		assertNotEquals("12345-6", cc.getNumeroConta());
	}
	
	@Test
	public void testMesmaSenha(){
		assertEquals("qwert", cc.getSenha());
	}
	
	@Test
	public void testDiferenteSenha(){
		assertNotEquals("ssadfds", cc.getSenha());
	}
	
	@Test
	public void testNovoSaldo(){
		cc.setSaldo(150);
		assertEquals(150, cc.getSaldo(), 001);
	}
	
	@Test
	public void testNovoSaldoErrado(){
		cc.setSaldo(150);
		assertNotEquals(2550, cc.getSaldo(), 001);
	}
	

}
