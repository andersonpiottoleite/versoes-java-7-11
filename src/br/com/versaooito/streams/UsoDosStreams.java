package br.com.versaooito.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsoDosStreams {
	
	public static void main(String[] args) {
		
		// streams - v8
		// chegaram para nos ajudar a trabalhar com coleções...
		
		List<Time> times = new ArrayList<>();
		times.add(new Time("Flamengo", 9, true));
		times.add(new Time("Curintia", 7, true));
		times.add(new Time("Gremio", 5, true));
		times.add(new Time("Palmeiras", 12, false));
		times.add(new Time("São Paulo", 6, true));
		
		Time primeiroTimeSemMundial = null;
		for (Time time : times) {
			if (! time.isTemMundial()) {
				primeiroTimeSemMundial = time;
				break;
			}
		}
		System.out.println(primeiroTimeSemMundial.getNome());
		
		// todo o código acima pode ser subistituido por?
		String nome = times.stream().filter(time -> !time.isTemMundial()).findFirst().get().getNome();
		System.out.println(nome);
		
		// para obter um stream:
		Stream<Time> stream = times.stream();
		
		//um stream possui operaçoes/ações
		
		//açoes intermediarias, podem ser executadas varias vezes, pois sempre devolvem um novo stream a cada execucao de metodo
		times.stream().filter(time -> !time.isTemMundial())
		.filter(time -> time.getQtdeTitulosBrasileiros() > 8)
		.filter(time -> time.getNome().length() > 5);
		
		//acoes finais (forEach) encerram o Streams, geralmente deveolvem void
		times.stream().forEach(time -> System.out.println(time.getNome()));
		
		// programação funcional é quando posso chamar varios metodos em sequencia .metodo().metodo().metodo().metodo()
		String nome2 = times.stream()
				.filter(time -> time.isTemMundial())
				.findFirst()
				.get()
				.getNome();
		
		// podemos usar varias operações/ações intermediarias seguidas (como o filter)
		// porem quando for executada uma operação final (como o forEach) o stream é encerrado
		 times.stream()
		.filter(time -> time.getQtdeTitulosBrasileiros() > 8)
		.filter(time -> time.isTemMundial())
		.forEach(t -> System.out.println(t.getNome()));
		 
		 times.stream()
		.filter(time -> time.getQtdeTitulosBrasileiros() > 8)
		.forEach(t -> System.out.println(t.getNome()));
		
		// modo tradicional (mais cutoso se comparado com o metodo acima)
		/*List<Time> timescomMaisDeOitoTitulosBrasileiros = new ArrayList<>();
		for (Time time : times) {
			if (time.getQtdeTitulosBrasileiros() > 8) {
				timescomMaisDeOitoTitulosBrasileiros.add(time);
			}
		}
		for (Time time : timescomMaisDeOitoTitulosBrasileiros) {
			System.out.println(time.getNome());
		}*/
		
		// percorre o stream, coleta os nomes, e mapeia para uma lista de Strings
		List<String> nomesDosTimes = times.stream().map(time -> {
			return time.getNome();
			}
		).collect(Collectors.toList());
		
		nomesDosTimes.forEach(n -> System.out.println(n));
		
		// pula dois elementos da lista
		times.stream().skip(2).forEach(t -> System.out.println(t.getNome()));
		
		// limita a aos dois elementos iniciais da lista
		times.stream().limit(2).forEach(t -> System.out.println(t.getNome()));
		
		// efetua comparação por nome e ordena os elementos da lista
		times.stream()
		.sorted((time1, time2) -> time1.getNome().compareTo(time2.getNome()))
		.forEach(t -> System.out.println(t.getNome()));
		
		for (int i = 0; i < 100000; i++) {
			String string = args[i];
		}
		
	}

}


class Time{
	private String nome;
	
	private int qtdeTitulosBrasileitos;
	
	private boolean temMundial;

	public Time(String nome, int qtdeTitulosBrasileitos, boolean temMundial) {
		this.nome = nome;
		this.qtdeTitulosBrasileitos = qtdeTitulosBrasileitos;
		this.temMundial = temMundial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdeTitulosBrasileiros() {
		return qtdeTitulosBrasileitos;
	}

	public void setQtdeTitulosBrasileiros(int qtdeTitulosBrasileitos) {
		this.qtdeTitulosBrasileitos = qtdeTitulosBrasileitos;
	}

	public boolean isTemMundial() {
		return temMundial;
	}

	public void setTemMundial(boolean temMundial) {
		this.temMundial = temMundial;
	}
	
}
