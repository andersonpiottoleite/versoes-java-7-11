package exemplos.base;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class UsoDoLambdaComDoisParametros {
	
	public static void main(String[] args) {
		Map<String, String> jogadores = new HashMap<>();
		jogadores.put("Jogador 1", " Messi");
		jogadores.put("Jogador 1 2", "CR7");
		
		jogadores.forEach((x,y) -> System.out.println(x.concat(y)));
		
		metodo("Anderson", "Piotto", (x, y) -> imprime(x,y));
		
	}
	
	public static void metodo(String s1, String s2, BiConsumer<String, String> consumerString) {
		
		consumerString.accept(s1, s2);
	}
	
	public static void imprime(String s1, String s2) {
		System.out.println(s1.concat(s2));
	}
	
}