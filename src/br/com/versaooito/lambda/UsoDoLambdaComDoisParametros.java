package br.com.versaooito.lambda;

import java.util.HashMap;
import java.util.Map;

public class UsoDoLambdaComDoisParametros {
	
	public static void main(String[] args) {
		Map<String, String> jogadores = new HashMap<>();
		jogadores.put("Jogador 1", " Pelé");
		jogadores.put("Jogador 2", " Gabi Gol");
		jogadores.put("Jogador 3", " Maradona");
		jogadores.put("Jogador 4234", " Yuri alberto");
		// o metodo forEach usa a interface funcional BiConsumer
		jogadores.forEach((chave, jogador) -> System.out.println(jogador));
	}
}