import java.util.Scanner;

public class VierGewinnt {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Spieler spieler1 = new Spieler("Spieler 1", 1);
        Spieler spieler2 = new Spieler("Spieler 2", 2);

        Spielfeld spielfeld = new Spielfeld(6, 7);
        spielfeld.initialisiereSpielfeld();

        boolean spielLäuft = true;
        int aktuellerSpieler = 1;

        while (spielLäuft) {
            spielfeld.druckeSpielfeld();

            int spalte = -1;
            boolean gültigeEingabe = false;

            while (!gültigeEingabe) {
                System.out.println(
                        (aktuellerSpieler == 1 ? spieler1.getName() : spieler2.getName())
                                + ", wähle eine Spalte (0-6):");
                String auswahl = scanner.nextLine();
                try {
                    spalte = Integer.parseInt(auswahl);
                    if (spalte >= 0 && spalte <= 6) {
                        gültigeEingabe = true;
                    } else {
                        System.out.println("Ungültige Eingabe. Bitte eine Zahl zwischen 0 und 6 eingeben.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ungültige Eingabe. Bitte eine gültige Zahl eingeben.");
                }
            }

            if (spielfeld.setzeSpielstein(spalte, aktuellerSpieler)) {
                if (spielfeld.testeSieg(aktuellerSpieler)) {
                    spielfeld.druckeSpielfeld();
                    System.out.println(
                            (aktuellerSpieler == 1 ? spieler1.getName() : spieler2.getName()) + " hat gewonnen!");
                    spielLäuft = false;
                } else if (spielfeld.istVoll()) {
                    spielfeld.druckeSpielfeld();
                    System.out.println("Unentschieden! Das Spielfeld ist voll.");
                    spielLäuft = false;
                }
                aktuellerSpieler = (aktuellerSpieler == 1) ? 2 : 1;
            } else {
                System.out.println("Ungültiger Zug. Bitte versuche es erneut.");
            }
        }

        scanner.close();
    }
}
