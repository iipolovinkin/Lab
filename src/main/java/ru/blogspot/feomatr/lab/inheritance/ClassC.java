package ru.blogspot.feomatr.lab.inheritance;

public class ClassC {

	static {
		// x++; //compile error
	}

	public static void main(String[] args) {
		System.out.println("main");
		new ClassB();
		System.out.println("main2");
		
		System.out.println(++x);
		System.out.println(x++);
	}

	static int x = 8;

}
