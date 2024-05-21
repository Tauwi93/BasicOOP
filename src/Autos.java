/**
 * Autos.java
 *
 * @author Thawrit Soeun
 * @version 1.0
 */
public class Autos {

    // Alle private Attribute
    private final String markenname;
    private final String modell;
    private final int baujahr;

    private int kilometerstand;
    private String farbe;
    private int preis;

    private String ganzename;
    private String adresse;
    private int geburtsdatum;

    /**
     * Konstruktor für Objekte der Klasse Autos. Von außen nicht zugänglich.
     *
     * @param markenname     Die Marke des Autos.
     * @param modell         Das Modell des Autos.
     * @param baujahr        Das Baujahr des Autos.
     * @param kilometerstand Der Kilometerstand des Autos.
     * @param farbe          Die Farbe des Autos.
     * @param preis          Der Preis des Autos.
     * @return Eine neue Instanz der Klasse Autos.
     */
    private Autos(String markenname, String modell, int baujahr, int kilometerstand, String farbe, int preis) {
        this.markenname = markenname;
        this.modell = modell;
        this.baujahr = baujahr;
        this.kilometerstand = kilometerstand;
        this.farbe = farbe;
        this.preis = preis;
    }

    /**
     * Erstellt und liefert eine neue Instanz der Klasse Autos basierend auf den angegebenen Parametern.
     *
     * @param markenname     Der Markenname des Fahrzeugs.
     * @param modell         Das Modell des Fahrzeugs.
     * @param baujahr        Das Baujahr des Fahrzeugs.
     * @param kilometerstand Der Kilometerstand des Fahrzeugs.
     * @param farbe          Die Farbe des Fahrzeugs.
     * @param preis          Der Preis des Fahrzeugs.
     * @return Eine neue Instanz der Klasse Autos mit den angegebenen Eigenschaften.
     */
    public static Autos erstelleAuto(String markenname, String modell, int baujahr, int kilometerstand, String farbe, int preis) {
        return new Autos(markenname, modell, baujahr, kilometerstand, farbe, preis);
    }


    /**
     * Get-Method: String Attribut "Marke" vom Autos object
     *
     * @return
     */
    public String getMarke() {
        return markenname;
    }

    /**
     * Get-Method: String Attribut "Modell" vom Autos object
     * @return
     */
    public String getModell() {
        return modell;
    }

    /**
     * Get-Method: int Attribut "Baujahr" vom Autos object.
     *
     * @return
     */
    public int getBaujahr() {
        return baujahr;
    }

    /**
     * Get-Method: int Attribut "Kilometerstand" vom Autos object.
     *
     * @return
     */
    public int getKilometerstand() {
        return kilometerstand;
    }

    /**
     * Get-Method: String Attribut "Farbe" vom Autos object.
     *
     * @return
     */
    public String getFarbe() {
        return farbe;
    }

    /**
     * Get-Method: int Attribut "Preis" vom Autos object.
     *
     * @return
     */
    public int getPreis() {
        return preis;
    }

    /**
     * Get-Method: gibt einen String aus allen Attributen zurück
     *
     * @return String ganzename, String adresse, int geburtsdatum
     */
    public String kundenDetailsToString() {
        return "Name: " + ganzename + ", Adresse: " + adresse + ", Geburtsjahr: " + geburtsdatum;
    }

    /**
     * Set-Methode: Alle Kundendetails setzen.
     *
     * @param newName
     * @param newAdresse
     * @param newGeburtsjahr
     * @return void
     */
    public void setKundenDetails(String newName, String newAdresse, int newGeburtsjahr) {
        ganzename = newName;
        adresse = newAdresse;
        geburtsdatum = newGeburtsjahr;
    }

    /**
     * Diese Methode berechnet die monatliche Finanzierungsrate für ein Fahrzeug.
     *
     * @param laufzeit  Die Laufzeit der Finanzierung in Monaten.
     * @param zinssatz  Der jährliche Zinssatz für die Finanzierung.
     * @param anzahlung Die Anzahlung für das Fahrzeug.
     * @return Die berechnete monatliche Finanzierungsrate.
     */
    public double berechneFinanzierungsRate(int laufzeit, double zinssatz, double anzahlung) {
        // Berechnung des Zinssatzes
        double zinssatzFormel = 1 + (zinssatz / 100);

        // Berechnung der monatlichen Rate basierend auf dem Fahrzeugpreis
        double finanzierungsRate = (getPreis() - anzahlung) * (zinssatzFormel / laufzeit);

        return finanzierungsRate;
    }

    /**
     * Diese Methode berechnet die monatliche Leasingrate für ein Fahrzeug.
     *
     * @param laufzeitInMonaten Die Laufzeit des Leasingvertrags in Monaten.
     * @param zinssatz          Der jährliche Zinssatz für das Leasing.
     * @return Die berechnete monatliche Leasingrate.
     */
    public double berechneLeasingRate(int laufzeitInMonaten, double zinssatz) {
        //Leasingpreis basierend auf dem Fahrzeugpreis
        double fahrzeugpreis = this.preis;

        // Berechnung der monatlichen Leasingrate basierend auf dem Fahrzeugpreis
        double zinsfaktor = (zinssatz / 100) / 12;
        double leasingRate = (fahrzeugpreis * zinsfaktor) / (1 - Math.pow(1 + zinsfaktor, -laufzeitInMonaten));

        return leasingRate;
    }

    /**
     * Diese Methode erzeugt eine Ausgabe aller relevanten Markeneigenschaften eines Autos.
     *
     * @return void
     */
    public void schreibeMarkenDetails() {
        System.out.println("Marke:" + this.getMarke() + " Modell:" + this.getModell() + " Baujahr:" + this.getBaujahr() + " Kilometerstand:" + this.getKilometerstand() + " Farbe:" + this.getFarbe() + " Verkaufpreis:" + this.getPreis());
    }
}