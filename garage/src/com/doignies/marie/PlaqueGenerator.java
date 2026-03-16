
package com.doignies.marie;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PlaqueGenerator {
	private static final String LETTRES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final Random random = new Random();
	private static final Set<String> plaquesGenerees = new HashSet<>();

	public static String genererPlaque() {
		String plaque;

		do {
			plaque = genererPlaqueAleatoire();
		} while (plaquesGenerees.contains(plaque));

		plaquesGenerees.add(plaque);
		return plaque;
	}

	private static String genererPlaqueAleatoire() {
		return new StringBuilder()
			.append(lettre())
			.append(lettre())
			.append(chiffre())
			.append(chiffre())
			.append(chiffre())
			.append(lettre())
			.append(lettre())
			.toString();
	}

	private static char lettre() {
		return LETTRES.charAt(random.nextInt(LETTRES.length()));
	}

	private static int chiffre() {
		return random.nextInt(10);
	}
}