package ru.blogspot.feomatr.lab.inheritance;

public class ClassB {
	static {
		System.out.println("static b1");
	}

	{
		System.out.println("b1");
	}

	public ClassB() {
		System.out.println("default constructor ClassB");
	}

	{
		System.out.println("b2");
	}

	static {
		System.out.println("static b2");
	}

}
