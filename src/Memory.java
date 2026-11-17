package Memory;

import java.util.Random;

public class Memory {

	private char[][] versteckt = new char[4][6];
	private char[][] gezeiget = new char[4][6];

	public char[][] getVersteckt() {
		return versteckt;
	}

	public char[][] getGezeiget() {
		return gezeiget;
	}

	public void init() {
		for (int i = 0; i < versteckt.length; i++) {
			for (int j = 0; j < versteckt[i].length; j++) {
				gezeiget[i][j] = '-';

			}
		}
	}

	public void ausgabe(char[][] feld) {
		for (int i = 0; i < feld.length; i++) {
			for (int j = 0; j < feld[i].length; j++) {
				System.out.print(feld[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void ausfuellen() {
		Random r = new Random();
		char gross = 65;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < versteckt.length; j++) {
				versteckt[i][j] = gross;
				gross++;
			}
		}
		char klein = 97;
		for (int i = 2; i < versteckt.length; i++) {
			for (int j = 0; j < versteckt[i].length; j++) {
				versteckt[i][j] = klein;
				klein++;
			}
		}
		for (int z = versteckt.length - 1; z > 0; z--) {
			for (int s = versteckt[z].length - 1; s > 0; s--) {
				int rd1 = r.nextInt(z + 1);
				int rd2 = r.nextInt(s + 1);
				char zw = versteckt[z][s];
				versteckt[z][s] = versteckt[rd1][rd2];
				versteckt[rd1][rd2] = zw;
			}
		}
	}

	public char eingabe(int zeile, int spalte) {
		System.out.println("An der Stelle befindet sich ein " + versteckt[zeile][spalte]);
		return versteckt[zeile][spalte];
	}

	public boolean prüfen(char c1, char c2, int z1, int s1, int z2, int s2, Spieler sp) {
		if (c1 + 32 == c2 || c2 + 32 == c1) {
			gezeiget[z1][s1] = versteckt[z1][s1];
			gezeiget[z2][s2] = versteckt[z1][s2];
			sp.setPunkte();
			return true;

		}
		return false;
	}

	public boolean testEnde() {
		for (int i = 0; i < gezeiget.length; i++) {
			for (int j = 0; j < gezeiget[i].length; j++) {
				if (gezeiget[i][j] != versteckt[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
