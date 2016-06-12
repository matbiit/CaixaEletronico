package br.ita.infra;

import java.util.Random;

import br.ita.exceptions.FalhaDeHardwareException;

public class MockHardware implements Hardware {

	private int numeroFalho = 5;
	
	@Override
	public String pegarNumeroDaContaCartao() throws FalhaDeHardwareException {
		if(new Random().nextInt(5) == numeroFalho)
			throw new FalhaDeHardwareException();
		return "12345-6";
	}

	@Override
	public void entregarDinheiro() throws FalhaDeHardwareException {
		if(new Random().nextInt(5) == numeroFalho)
			throw new FalhaDeHardwareException();

	}

	@Override
	public void lerEnvelope()  throws FalhaDeHardwareException {
		if(new Random().nextInt(5) == numeroFalho)
			throw new FalhaDeHardwareException();

	}

}
