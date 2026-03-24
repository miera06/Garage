
package com.doignies.marie.utils;

public class Console {
	public static void info(final String message) {
		System.out.println(message);
	}

	public static void error(final String message) {
		System.err.println("ERREUR : " + message);
	}
}