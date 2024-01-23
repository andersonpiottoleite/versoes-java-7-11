package br.com.versaosete.multicatch;

public class MultiCatch {
	
	public static void main(String[] args) {
		
		try {
			
			System.out.println("logica critica que possivelmente gerará erro.....");
			
		} catch (NullPointerException | IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
