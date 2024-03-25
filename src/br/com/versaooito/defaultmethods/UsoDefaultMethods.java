package br.com.versaooito.defaultmethods;

import java.util.ArrayList;
import java.util.List;

public class UsoDefaultMethods {
	public static void main(String[] args) {
		A a = new A();
		a.metodo1();
		a.metodo2();
		a.metodoComum();
		System.out.println(a.metodoComum2());
		
		B b = new B();
		b.metodo1();
		b.metodo2();
		b.metodoComum();
		System.out.println(b.metodoComum2());
		
		
		List l = new ArrayList<>();
	}
}

class A implements C{

	@Override
	public void metodo1() {
		System.out.println("Implementação especifica da classe A, para o metodo 1");	
	}

	@Override
	public void metodo2() {
		System.out.println("Implementação especifica da classe A, para o metodo 2");
	}
}

class B implements C{
	@Override
	public void metodo1() {
		System.out.println("Implementação especifica da classe B, para o metodo 1");	
	}

	@Override
	public void metodo2() {
		System.out.println("Implementação especifica da classe B, para o metodo 2");
	}
}

interface C {
	void metodo1();
	void metodo2();
	default void metodoComum() {
		System.out.println("Logica comum");
	}
	default String metodoComum2() {
		return "José";
	}
}



