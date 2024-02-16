package exemplos.base;

import java.util.Arrays;
import java.util.List;

public class UsoDeLambdas {
	
	public static void main(String[] args) {
		
		metodo(new Classe1());
		
		metodo(new Classe2());
		
		/*
		metodo(new InterfaceFuncional() {
			
			@Override
			public void unicoMetodo() {
				System.out.println("Chamando o metodo da classe Anonima ");
			}
		});
		
		metodo(() -> System.out.println("Chamando a o metodo a partir do Lambda "));
		
		List<String> camaradas = Arrays.asList("Helaine", "Brian", "Pedro", "Lucas", "Paulo", "Italo");
		
		for (String camarada : camaradas) {
			System.out.println("via for normal: " + camarada);
		}
		
		System.out.println("################################");
		
		camaradas.forEach(c -> System.out.println("via lambda: " + c));*/
		
	}
	
	private static void metodo(InterfaceFuncional interfaceFuncional) {
		interfaceFuncional.unicoMetodo();
	}

}

@FunctionalInterface
interface InterfaceFuncional {
	void unicoMetodo();
}

class Classe1 implements InterfaceFuncional{

	@Override
	public void unicoMetodo() {
		System.out.println("chamando metodo da Classe1 ");
	}
	
}

class Classe2 implements InterfaceFuncional{

	@Override
	public void unicoMetodo() {
		System.out.println("chamando metodo da Classe2 ");
	}
	
}

