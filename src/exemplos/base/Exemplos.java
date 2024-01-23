//package exemplos.base;
//
//import java.io.Closeable;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Exemplos {
//	
//	public static void main(String[] args) {
//		usoDoJDK7();
//	}
//
//	private static void usoDoJDK7() {
//		// pakages: br.com.versao-X.topico
//		
//		// JDK7
//		
//		// operador diamante
//		List<String> lista = new ArrayList<>();
//		
//		//multi catch
//		try {
//			
//		}catch (NullPointerException | IllegalArgumentException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("NO PROBLEM");
//		
//		// try with resources e closeabe
//		PrintWriter writer = null;
//		try {
//			writer = new PrintWriter(new File("test.txt"));
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			writer.close();
//		}
//		
//		try (PrintWriter writer2 = new PrintWriter(new File("test.txt"))) {
//		    writer.println("Hello World");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		try (PrintWriter writer2 = new PrintWriter(new File("test.txt"))) {
//		    writer.println("Hello World");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//		try (Classe1 classe1 = new Classe1()) {
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		
//		try (Classe2 classe2 = new Classe2()) {
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//	}
//
//}
//
//class Classe1 implements Closeable{
//
//	@Override
//	public void close() throws IOException {
//		System.out.println("fechando o recurso!");
//		
//	}
//	
//}
//
//class Classe2 implements Closeable{
//
//	public void close() throws IOException {
//		System.out.println("fechando o recurso!");
//		
//	}
//	
//}
//
//
//
