package br.com.versaooito.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UsoDoOptional {
	
	public static void main(String[] args) {
		
		/*Carro carro = getCarroPorMarca("GM");
		
		if (Objects.nonNull(carro)) {			
			System.out.println(carro.getMarca());
		}*/
		
		Optional<Carro> carroOptional = getOptionalCarroPorMarca("Ford");
		if (carroOptional.isPresent()) {
			System.out.println(carroOptional.get().getMarca());
		}
		
		Carro carroPlanoB = carroOptional.orElse(new Carro("GM"));
		System.out.println(carroPlanoB.getMarca());
		
		// Carro carroOuPauNaAplicacao = carroOptional.orElseThrow(() -> new IllegalArgumentException("Marca inexistente"));
		
		//Optional.of(null);
		Optional.ofNullable(null);
		
		carroOptional.ifPresent( c -> System.out.println(c.getMarca() + " - aqui"));
		
		
		
	}
	
	private static Optional<Carro> getOptionalCarroPorMarca(String marca) {
		List<Carro> carros = Arrays.asList(new Carro("Ford"), new Carro("Fiat"));
		
		for (Carro carro : carros) {
			if (carro.getMarca().equals(marca)) {
				return Optional.of(carro) ;
			}
		}
		
		return Optional.empty();
	}
	
	
	private static Carro getCarroPorMarca(String marca) {
		List<Carro> carros = Arrays.asList(new Carro("Ford"), new Carro("Fiat"));
		
		for (Carro carro : carros) {
			if (carro.getMarca().equals(marca)) {
				return carro;
			}
		}
		
		return null;
	}

}

class Carro{
	private String marca;

	public Carro(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
}
