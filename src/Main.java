package Memory;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Memory m = new Memory();
		Scanner sc = new Scanner(System.in);
		m.init();
		m.ausfuellen();
		int auswahl = 0;
		do {
			System.out.println("MEMORY");
			System.out.println("1- Ein neues Spiel");
			System.out.println("2- Programm beenden ");
			auswahl = sc.nextInt();
			if (auswahl == 1) {
				System.out.println("Geben Sie den Namen von Spieler 1 ein ");
				String name1 = sc.next();
				Spieler sp1 = new Spieler(name1);
				System.out.println("Geben Sie den Namen von Spieler 2 ein ");
				String name2 = sc.next();
				Spieler sp2 = new Spieler(name2);
				int zeile1 = 0;
				int spalte1 = 0;
				int zeile2 = 0;
				int spalte2 = 0;
				char c1 = ' ';
				char c2 = ' ';
				do {
					do {
						if (m.testEnde())
							break;
						System.out.println(name1 + " ist an der Reihe ");
						m.ausgabe(m.getGezeiget());
						System.out.println("zeile 1: ");
						zeile1 = sc.nextInt();
						System.out.println("Spalte 1: ");
						spalte1 = sc.nextInt();
						c1 = m.eingabe(zeile1, spalte1);
						System.out.println("zeile 2: ");
						zeile2 = sc.nextInt();
						System.out.println("spalte 2: ");
						spalte2 = sc.nextInt();
						c2 = m.eingabe(zeile2, spalte2);
						if (m.prüfen(c1, c2, zeile1, spalte2, zeile2, spalte2, sp1)) {
							
						}
						printErg(sp1, sp2);
					} while (m.prüfen(c1, c2, zeile1, spalte2, zeile2, spalte2, sp1));
					do {
						if (m.testEnde())
							break;
						System.out.println(name2 + " ist an der Reihe ");
						m.ausgabe(m.getGezeiget());
						System.out.println("zeile 1: ");
						zeile1 = sc.nextInt();
						System.out.println("Spalte 1: ");
						spalte1 = sc.nextInt();
						c1 = m.eingabe(zeile1, spalte1);
						System.out.println("zeile 2: ");
						zeile2 = sc.nextInt();
						System.out.println("spalte 2: ");
						spalte2 = sc.nextInt();
						c2 = m.eingabe(zeile2, spalte2);
						if (m.prüfen(c1, c2, zeile1, spalte2, zeile2, spalte2, sp1)) {
							
						}
						printErg(sp1, sp2);

					} while (m.prüfen(c1, c2, zeile1, spalte1, zeile2, spalte2, sp2));
				} while (!m.testEnde());
			}

		} while (auswahl != 2);

	}

	public static void printErg(Spieler sp1, Spieler sp2) {
		System.out.println("Der aktuelle Spielstand lautet:  ");
		System.out.println(sp1.getName() + " : " + sp1.getPunkte() + " Punkte");
		System.out.println(sp2.getName() + " : " + sp2.getPunkte() + " Punkte");
	}

}
