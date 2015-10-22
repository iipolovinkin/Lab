package ru.blogspot.feomatr.lab;

import org.apache.pivot.wtk.DesktopApplicationContext;

import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!1");

        startPivot(args);
		//DesktopApplicationContext.main(JavaPivot.class, args);
//		new Walker();
//		startXStream(args_);
//		readXStream(args_);
		System.out.println("Hello World!");
	}

	static void startPivot(String[] args){
		DesktopApplicationContext.main(JavaBXML.class, args);
	}








}
