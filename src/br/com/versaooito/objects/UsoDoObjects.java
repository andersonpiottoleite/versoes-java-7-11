package br.com.versaooito.objects;

import java.util.Objects;

public class UsoDoObjects {
	
	public static void main(String[] args) {
		
		String palavra = getPalavra();
		
		if (Objects.nonNull(palavra)) {
			System.out.println(palavra.length());	
		}
		
	}
	
	public static String getPalavra() {
		return "mamae";
	} 

}
