package exemplos.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsoStream {
	
	public static void main(String[] args) {
		
		List<Time> times = new ArrayList<>();
		
		times.add(new Time("Flamengo", true));
		times.add(new Time("Curintia", true));
		times.add(new Time("Palmeiras", false));
		
		// fluxo de dados
		Stream<Time> stream = times.stream();
		
		// operacoes intermediarias e finais
		times.stream().filter(time -> time.isTemMundial()).forEach(timeVencedor -> System.out.println("TEM MUNDIAL " + timeVencedor.getNome()));
		
		times.stream().filter(time -> !time.isTemMundial()).forEach(timeVencedor -> System.out.println("NAO TEM MUNDIAL " + timeVencedor.getNome()));
		
		Time primeiroTimeQuetemMundial = times.stream().filter(time -> time.isTemMundial()).findFirst().get();
		
		System.out.println(primeiroTimeQuetemMundial.getNome());
		
		for (int i = 0; i < 50; i++) {
			Time qqTimeQuetemMundial = times.stream().filter(time -> time.isTemMundial()).findAny().get();
			System.out.println(qqTimeQuetemMundial.getNome());	
		}
		
		System.out.println(times.stream().count());
		times.stream().sorted((time1, time2) -> time1.getNome().compareTo(time2.getNome())).forEach(t-> System.out.println(t.getNome()));
		
		times.stream().limit(1).forEach(t-> System.out.println(t.getNome()));
		
		times.stream().skip(1).forEach(t-> System.out.println(t.getNome()));
		
		times.forEach(t -> System.out.println(t));
		
		List<String> nomes = times.stream().map(time -> {
			return time.getNome();
		}).collect(Collectors.toList());
		
		boolean allMatch = times.stream().allMatch(t -> t.getNome().startsWith("F"));
		System.out.println(allMatch);
		
		boolean anyMatch = times.stream().anyMatch(t -> t.getNome().startsWith("F"));
		System.out.println(anyMatch);
		
		long count = times.stream().filter(time -> time.isTemMundial()).count();
		System.out.println(count);
		
		times.stream().peek( t -> {
			t.setNome("teste");
		}).forEach(t -> System.out.println(t.getNome()));
		
		times.parallelStream().forEach(t -> System.out.println(t));
		
		
		List<List<Integer>> matrizDeNumeros = Arrays.asList(
				Arrays.asList(1,2,3),
				Arrays.asList(4,5,5)
				);
		matrizDeNumeros.stream().forEach(t -> System.out.println(t));
		
		matrizDeNumeros.stream().flatMap(n -> n.stream()).forEach(t -> System.out.println(t));
		
		
	}

}

class Time{
	private String nome;
	private boolean temMundial;
	
	public Time(String nome, boolean temMundial) {
		super();
		this.nome = nome;
		this.temMundial = temMundial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isTemMundial() {
		return temMundial;
	}

	public void setTemMundial(boolean temMundial) {
		this.temMundial = temMundial;
	}
	
	
}
