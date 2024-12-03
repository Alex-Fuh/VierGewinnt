public class Spielfeld {
    private int[][] feld;
    private int reihen;
    private int spalten;

    public Spielfeld(int reihen, int spalten) {
        this.reihen = reihen;
        this.spalten = spalten;
        feld = new int[reihen][spalten];
    }

    public void initialisiereSpielfeld() {

        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < spalten; j++) {
                feld[i][j] = 0;
            }
        }
    }

    public void druckeSpielfeld() {

        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < spalten; j++) {
                System.out.print(feld[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean setzeSpielstein(int spalte, int spielerNr) {

        if (spalte < 0 || spalte >= spalten) {
            return false;
        }

        for (int i = reihen - 1; i >= 0; i--) {
            if (feld[i][spalte] == 0) {
                feld[i][spalte] = spielerNr;
                return true;
            }
        }
        return false;
    }

    public boolean istVoll() {

        for (int j = 0; j < spalten; j++) {
            if (feld[0][j] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean testeSieg(int spielerNr) {

        // Horizontal

        for (int i = 0; i < reihen; i++) {
            for (int j = 0; j < spalten - 3; j++) {
                if (feld[i][j] == spielerNr && feld[i][j + 1] == spielerNr &&
                    feld[i][j + 2] == spielerNr && feld[i][j + 3] == spielerNr) {
                    return true;
                }
            }
        }

        // Vertikal

        for (int i = 0; i < reihen - 3; i++) {
            for (int j = 0; j < spalten; j++) {
                if (feld[i][j] == spielerNr && feld[i + 1][j] == spielerNr &&
                    feld[i + 2][j] == spielerNr && feld[i + 3][j] == spielerNr) {
                    return true;
                }
            }
        }

        // von links oben nach rechts unten

        for (int i = 0; i < reihen - 3; i++) {
            for (int j = 0; j < spalten - 3; j++) {
                if (feld[i][j] == spielerNr && feld[i + 1][j + 1] == spielerNr &&
                    feld[i + 2][j + 2] == spielerNr && feld[i + 3][j + 3] == spielerNr) {
                    return true;
                }
            }
        }

        // von rechts oben nach links unten

        for (int i = 0; i < reihen - 3; i++) {
            for (int j = 3; j < spalten; j++) {
                if (feld[i][j] == spielerNr && feld[i + 1][j - 1] == spielerNr &&
                    feld[i + 2][j - 2] == spielerNr && feld[i + 3][j - 3] == spielerNr) {
                    return true;
                }
            }
        }

        return false;
    }
}
