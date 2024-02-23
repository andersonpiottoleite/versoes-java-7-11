package br.com.versaooito.lambda;

public class UsoDoLambdaSemParametros {
	
	public static void main(String[] args) {
		metodo(new Classe1());
		metodo(new Classe2());
		metodo(new InterfaceFuncional() {
			
			@Override
			public void metodo() {
				System.out.println("chamando metodo a partir da classe anonima");
			}
		});
		
		metodo(() -> System.out.println("chamando o metodo a partir do lambda"));
		metodo(() -> metodoQueDevolveVoid());
	}
	
	public static void metodoQueDevolveVoid() {
		System.out.println("AAA");
	}
	
	public static void metodo(InterfaceFuncional interfaceFuncional) {
		interfaceFuncional.metodo();
	}
	
	public static boolean metodoBooleano() {
		return true;
	}
}


@FunctionalInterface
interface InterfaceFuncional{
	void metodo();
}


class Classe1 implements InterfaceFuncional{

	@Override
	public void metodo() {
		System.out.println("chamando metodo da Classe1");
	}
	
}

class Classe2 implements InterfaceFuncional{

	@Override
	public void metodo() {
		System.out.println("chamando metodo da Classe2");	
	}
	
}



