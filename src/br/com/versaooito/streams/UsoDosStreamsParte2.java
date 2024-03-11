package br.com.versaooito.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class UsoDosStreamsParte2 {
	
	public static void main(String[] args) {
		
		List<String> letras = Arrays.asList("AA","A","B","C","C", "D", "E");
		
		//count - conta quantos itens existe na lista
		long count = letras.stream().count();
		System.out.println(count);
		
		// distinct - elimina os elementos duplicados na lista, considerando o metodo equals, como criterio de igualdade
		letras.stream().distinct().forEach(l -> System.out.println(l));
		
		//anyMatch - avalia se algum item da lista atende um determinado criterio
		boolean anyMatch = letras.stream().anyMatch(l -> l.equals("A"));
		System.out.println(anyMatch);
		
		//allMatch - avalia se todos os item da lista atende um determinado criterio
		boolean allMatch = letras.stream().allMatch(l -> l.equals("A"));
		System.out.println(allMatch);
		
		//noneMatch - avalia se nenhum item da lista atende um determinado criterio
		boolean noneMatch = letras.stream().noneMatch(l -> l.equals("J"));
		System.out.println(noneMatch);
		
		//peek - usado para fazer algo durante o uso do stream, como setar um atributo
		//letras.stream().peek(/*desafio*/).forEach(l -> System.out.println(l));
		
		//max - busca o maior elemento, de acordo com o criterio passado no metodo filter
		String letraMaxima = letras.stream()
		.max((letraAtual, letraSeguinte) -> letraAtual.compareTo(letraSeguinte.toString())).get().toString();
		System.out.println(letraMaxima);
		 
		//min - busca o menor elemento, de acordo com o criterio passado no metodo filter
		String letraMin = letras.stream()
				.min((letraAtual, letraSeguinte) -> letraAtual.compareTo(letraSeguinte.toString())).get().toString();
				System.out.println(letraMin);
		
		//flatMap - achata/une um array multidimencional/matriz em um arrray unico
		//{1,2,3,4,5,6}
		//{{1,2,3},{4,5,6}}
		List<List<Integer>> asList = Arrays.asList(
				Arrays.asList(1,2,3), 
				Arrays.asList(4,5,6));		
		asList.stream().forEach(n -> System.out.println(n));
		
		System.out.println("-------------------------");
		
		asList.stream().flatMap(array -> array.stream()).forEach(n -> System.out.println(n));
		
		// parallelStream e paralell stream - melhora a perfomance quando interamos sobre uma lista, 
		// desde que, a cada interação sejam realizadas tarefas que demandem um certo tempo,
		// como consulta ao banco de dados, leitura e escrita de arquivos, etc.
		System.out.println("-------------------------");
		letras.stream().forEach(n -> System.out.println(n));
		
		System.out.println("-------------------------");
		//letras.stream().parallel().forEach(n -> System.out.println(n));
		letras.parallelStream().forEach(n -> System.out.println(n));
		
		//Criando um Stream a partir de um array
		int[] arrayInteiro = {1,2};
		Stream.of(arrayInteiro);
		
		// Outras maneira de se criar um Stream, para se trabalhar com tipos especificos como Integer, Long, Double, etc
		IntStream.of(1,2,3);
		DoubleStream.of(1.0, 2.3);
		LongStream.of(1,2,3);
	}

}
