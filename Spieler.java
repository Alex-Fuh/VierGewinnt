public class Spieler {
    private String name;
    private int spielerNr;

    public Spieler(String name, int spielerNr) {
        this.name = name;
        this.spielerNr = spielerNr;
    }

    public String getName() {
        return name;
    }

    public int getSpielerNr() {
        return spielerNr;
    }
}
