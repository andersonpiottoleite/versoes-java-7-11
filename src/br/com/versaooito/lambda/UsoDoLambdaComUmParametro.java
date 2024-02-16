package br.com.versaooito.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UsoDoLambdaComUmParametro {
	
	public static void main(String[] args) {
		List<String> herois = Arrays.asList("Jaspion", "Chengeman", "Jiraya");
		for (String heroi : herois) {
			System.out.println(heroi);
		}
		
		System.out.println("------------------------------");
		
		herois.forEach(h -> System.out.println(h));
		
		metodo("Piotto", s -> System.out.println(s.toLowerCase()));
		
	}
	
	public static void metodo(String s/*=Piotto*/, 
			Consumer<String> consumerString /*isso é a ação do accept = s -> System.out.println(s.toLowerCase())*/) {
		
		consumerString.accept(s);
	}
	
	public static void imprime(String s) {
		s = s.toUpperCase();
		System.out.println(s);
	}
	
}