package exemplos.base;

public class UsoDefaultMethods {
	
	public static void main(String[] args) {
		B b = new B();
		b.metodo1();
		b.metodo2();
		b.metodo3();
		
		C c = new C();
		c.metodo1();
		c.metodo2();
		c.metodo3();
		
		//ver a interface List
		//regra de sobrescrita -> quem sobrescreve permanece
	}
}


interface A{
	void metodo1();
	void metodo2();
	default void metodo3() {
		System.out.println("implementacao comum a todos no metodo3");
	}
}

class B implements A{

	@Override
	public void metodo1() {
		System.out.println("implementacao metodo1 por B");
	}

	@Override
	public void metodo2() {
		System.out.println("implementacao metodo2 por B");
	}

	/*@Override
	public void metodo3() {
		System.out.println("implementacao metodo3");
	}*/
	
}

class C implements A{

	@Override
	public void metodo1() {
		System.out.println("implementacao metodo1 por C");
	}

	@Override
	public void metodo2() {
		System.out.println("implementacao metodo2 por C");
		
	}

	/*@Override
	public void metodo3() {
		System.out.println("implementacao metodo3");
	}*/
	
}
