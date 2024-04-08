package br.com.versaooito.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsoDosMethodsReferences {
	
	public static void main(String[] args) {
		
		List<String> letras = Arrays.asList("a", "b", "c");
		
		letras.forEach(letra -> System.out.println(letra));
		
		letras.forEach(System.out::println);
		
		letras.forEach(letra -> letra.toUpperCase());
		
		letras.forEach(String :: toUpperCase);
		
		letras.stream()
		.map(letra -> letra.toUpperCase())
		.collect(Collectors.toList())
		.forEach(letra -> System.out.println(letra));
		
		letras.stream()
		.map(String :: toUpperCase)
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		letras.stream()
		.map(letra -> letra.toLowerCase())
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		letras.stream()
		.map(String :: toLowerCase)
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		usoDeStringsImutaveisEMutaveis();
	}

	private static void usoDeStringsImutaveisEMutaveis() {
		String nome = "Lucas";
		
		nome = nome.toUpperCase().replace("u", "a");
		
		System.out.println(nome);
		
		String sb = new StringBuilder("L")
				.append("u")
				.append("c")
				.append("a")
				.append("s")
				.toString();
		
		System.out.println(sb);
		
		System.out.println("anderson" + "piotto");
	}

}
