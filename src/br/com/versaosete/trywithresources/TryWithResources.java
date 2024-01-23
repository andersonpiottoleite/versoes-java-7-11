package br.com.versaosete.trywithresources;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TryWithResources {
	
	public static void main(String[] args) throws IOException {
		
		PrintStream print = null;
		try {
			print = new PrintStream(new File("arquivo.txt"));
			print.append("jose").append(" de paula");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if(print != null) {
				print.close();
			}
		}
		
		
		try (PrintStream print2 = new PrintStream(new File("arquivo.txt"))){
			print2.append("jose").append(" de paula");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try (Classe1 classe1 = new Classe1();
			Classe2 classe2 = new Classe2();){
			 classe1.metodo1();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Classe1 classe1b = null;
		Classe2 classe2b = null; 
				
		try {
		  classe1b = new Classe1();
		  classe2b = new Classe2();
		  
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (classe1b != null) {				
				classe1b.close();
			}
			if (classe2b != null) {				
				classe2b.close();
			}
		}
		
		List<String> lista = new ArrayList<>();
		for (String string : lista) {
			System.out.println(string);
		}
	}

}



class Classe1 implements Closeable{
	void metodo1() {}

	@Override
	public void close() throws IOException {
		System.out.println("Fechando o objeto de Classe 1");
		
	}

	
}

class Classe2 implements Closeable{
	void metodo2() {}

	@Override
	public void close() throws IOException {
		System.out.println("Fechando o objeto de Classe 2");
		
	};
}
