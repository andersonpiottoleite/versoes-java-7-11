package exemplos.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsoMethodReference {
	
	public static void main(String[] args) {
		
		List<String> letras = Arrays.asList("a","b", "c");
		
		
		letras.forEach(c -> System.out.println(c));
		letras.forEach(System.out::println);
		
		letras.stream().map(c -> c.toLowerCase()).forEach( l -> System.out.println(l));
		letras.stream().map(String::toUpperCase).forEach(System.out::println);
		
		// por classe (Classe e metodo estatico):
		letras.stream().map(StringUtil::transformaEmMaiuscula).forEach(System.out::println);
		
		// por referencia (objeto e metodo nao estatico)
		StringUtil util = new StringUtil();
		letras.stream().map(util::transformaEmMinuscula).forEach(System.out::println);
		
		// construtor (Nome da classe + o operador new)
		List<SuperLetra> listaSuperLetras = letras.stream().map(l -> {
			return new SuperLetra(l);
		}).collect(Collectors.toList());
		
		List<SuperLetra> listaSuperLetras2 = letras.stream().map(SuperLetra::new).collect(Collectors.toList());
		
		// quando nao vira?
		//quando vc esta operando sobre um parametro e vai referencia um metodo que usa dois parametros
		letras.stream().forEach(l -> System.out.printf(" letra '%s' ", l));
		letras.stream().forEach(System.out::printf);
		
	}
}

class StringUtil{
	public static String transformaEmMaiuscula(String letra) {
		return letra.toUpperCase();
	}
	
	public String transformaEmMinuscula(String letra) {
		return letra.toLowerCase();
	}
}


class SuperLetra{
	
	private String letra;
	
	public SuperLetra(String letra) {
		this.letra = letra;
	}
	
}
		
