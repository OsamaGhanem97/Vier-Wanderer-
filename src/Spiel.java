package VierWanderer;

import java.util.Scanner;

public class Spiel {
	private boolean woistlampe = true;
	private Wanderer[] wanderer = new Wanderer[4];
	private Ufer uLinks, uRechts;
	private int taschenlampe;

	public Spiel(int zeit) {
		wanderer[0] = new Wanderer('A', 5);
		wanderer[1] = new Wanderer('B', 10);
		wanderer[2] = new Wanderer('C', 20);
		wanderer[3] = new Wanderer('D', 25);
		uLinks = new Ufer(wanderer);
		uRechts = new Ufer(null);
		taschenlampe = zeit;
	}

	public void ausgabe() {
		System.out.println();
		System.out.println("Taschenlampe: " + taschenlampe);
		if (woistlampe) {
			System.out.println("Die Lampe ist links ,diese Wanderer können gehen");
			System.out.println(uLinks);
		} else {
			System.out.println("Die Lampe ist rechts ,diese Wanderer können gehen");
			System.out.println(uRechts);
		}
		System.out.println();

	}

	public boolean testeEnde() {
		if (taschenlampe <= 0 || uRechts.getAnzWanderer() == 4) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Spiel spiel = new Spiel(60);
		Scanner sc = new Scanner(System.in);
		String auswahl = "";
		do {
			spiel.ausgabe();
			System.out.println("Welchr Wanderer sollen gehen(1 oder 2 Zeichen zwischen A und D");
			auswahl = sc.next();
			if (spiel.woistlampe == true) {
				if (auswahl.length() == 2) {
					spiel.taschenlampe -= spiel.uLinks.ueberquere(spiel.uRechts,
							spiel.uLinks.getWanderer(auswahl.charAt(0)), spiel.uLinks.getWanderer(auswahl.charAt(1)));
				} else {
					spiel.taschenlampe -= spiel.uLinks.ueberquere(spiel.uRechts,
							spiel.uLinks.getWanderer(auswahl.charAt(0)), null);
				}

			}
			else if(auswahl.length()==2) {
				spiel.taschenlampe-=spiel.uRechts.ueberquere(spiel.uLinks, spiel.uRechts.getWanderer(auswahl.charAt(0)), spiel.uRechts.getWanderer(auswahl.charAt(1)));
			}else {
				spiel.taschenlampe-=spiel.uRechts.ueberquere(spiel.uLinks, spiel.uLinks.getWanderer(auswahl.charAt(0)), null);
			}
			spiel.woistlampe=!spiel.woistlampe;
			

		} while (!spiel.testeEnde());

		if(spiel.uRechts.getAnzWanderer()<4||spiel.taschenlampe<0) {
			System.out.println("Leider verloren ");
		}else {
			System.out.println("Herzlichen Glückwunsch!! Sie haben gewonnen");
		}
	}

}
