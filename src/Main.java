import java.util.Scanner;

/**
 * Main.java
 *
 * @author Thawrit Soeun
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Objekte der Klasse Autos erstellen
        Autos BMW = Autos.erstelleAuto("BMW", "M3", 2019, 0, "Schwarz", 73000);
        Autos Audi = Autos.erstelleAuto("Audi", "RS6", 2023, 0, "Silber", 120000);
        Autos VW = Autos.erstelleAuto("VW", "Golf", 2019, 0, "Blau", 30000);

        Autos Kunde1 = Autos.erstelleAuto("BMW", "M6", 2022, 24000, "Schwarz", 79000);
        Autos Kunde2 = Autos.erstelleAuto("Audi", "RS7", 2023, 15000, "Silber", 130000);
        Autos Kunde3 = Autos.erstelleAuto("Skoda", "Fabia", 2014, 12000, "Grün", 30000);

        // Setter für Kundeninformationen
        Kunde1.setKundenDetails("Thomas Streumann", "Hanspeterburgstrasse 1", 1990);
        Kunde2.setKundenDetails("Daniela Müller", "Floridastrasse 2", 1954);
        Kunde3.setKundenDetails("Jonas Keller", "Kellersackerstrasse 31", 1998);


        //Startauswahl für den User
        System.out.println("""
        Bitte wählen Sie eine Option:
        1: Kundendaten
        2: Verfügbare Autos
        3: Finanzierungsraten berechnen
        4: Leasingrate berechnen
        """);

        // Eingabe von Benutzer
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();


        /*
         Hier kann der User zwischen 4 Optionen wählen:
            1: Kundendaten
            2: Verfügbare Autos
            3: Finanzierungsraten berechnen
            4: Leasingrate berechnen
          Danach wird die entsprechende Methode ausgeführt
        */
        switch (option) {
            case 1:
                System.out.println("Kundendaten:");
                System.out.println("Kunde1:" + Kunde1.kundenDetailsToString());
                Kunde1.schreibeMarkenDetails();
                System.out.println("Kunde2:" + Kunde2.kundenDetailsToString());
                Kunde2.schreibeMarkenDetails();
                System.out.println("Kunde3:" + Kunde3.kundenDetailsToString());
                Kunde3.schreibeMarkenDetails();
                break;
            case 2:
                System.out.println("Verfügbare Autos:");
                BMW.schreibeMarkenDetails();
                Audi.schreibeMarkenDetails();
                VW.schreibeMarkenDetails();
                break;
            // Finanzierungsraten berechnen
            case 3:
                System.out.println("Bitte geben Sie die Laufzeit der Finanzierung in Monaten ein:");
                int finanzierungsLaufzeit = scanner.nextInt();

                System.out.println("Bitte geben Sie den Zinssatz für die Finanzierung in Prozent ein:");
                double finanzierungsZinssatz = scanner.nextDouble();

                // Auswahl des Autos
                System.out.println("Bitte wählen Sie ein Auto für die Finanzierung zwischen 1 bis 3 Verfügbare Autos: ");

                BMW.schreibeMarkenDetails();
                Audi.schreibeMarkenDetails();
                VW.schreibeMarkenDetails();

                int autoAuswahlFinanzierung = scanner.nextInt();
                Autos ausgewaehltesAutoFinanzierung = null;

                switch (autoAuswahlFinanzierung) {
                    case 1:
                        ausgewaehltesAutoFinanzierung = BMW;
                        break;
                    case 2:
                        ausgewaehltesAutoFinanzierung = Audi;
                        break;
                    case 3:
                        ausgewaehltesAutoFinanzierung = VW;
                        break;
                    default:
                        System.out.println("Falsche Option");
                        System.out.println("Programm wird beendet");
                        System.exit(0);
                        break;
                }

                System.out.println("Bitte geben Sie die Anzahlung für die Finanzierung ein:");
                double finanzierungsAnzahlung = scanner.nextDouble();

                double finanzierungsRate = ausgewaehltesAutoFinanzierung.berechneFinanzierungsRate(finanzierungsLaufzeit, finanzierungsZinssatz, finanzierungsAnzahlung);
                System.out.println("Finanzierungsraten für das ausgewählte Auto: " + finanzierungsRate + " CHF pro Monat");
                break;
            // Leasingrate berechnen
            case 4:
                // Auswahl des Autos
                System.out.println("Bitte wählen Sie ein Auto für das Leasing zwischen 1-3 verfügbare Autos: ");
                BMW.schreibeMarkenDetails();
                Audi.schreibeMarkenDetails();
                VW.schreibeMarkenDetails();

                // User input
                int autoAuswahlLeasing = scanner.nextInt();

                Autos ausgewaehltesAutoLeasing = null;

                // Switch-Case für die Autoauswahl
                switch (autoAuswahlLeasing) {
                    case 1:
                        ausgewaehltesAutoLeasing = BMW;
                        break;
                    case 2:
                        ausgewaehltesAutoLeasing = Audi;
                        break;
                    case 3:
                        ausgewaehltesAutoLeasing = VW;
                        break;
                    default:
                        System.out.println("Falsche Option");
                        System.out.println("Programm wird beendet");
                        System.exit(0);
                        break;
                }
                // Leasingmethode
                System.out.println("Bitte geben Sie die Laufzeit des Leasingvertrags in Monaten ein:");
                int laufzeit = scanner.nextInt();

                System.out.println("Bitte geben Sie den Zinssatz für das Leasing in Prozent ein:");
                double zinssatz = scanner.nextDouble();

                double leasingRate = ausgewaehltesAutoLeasing.berechneLeasingRate(laufzeit, zinssatz);
                System.out.println("Leasingrate für das ausgewählte Auto: " + leasingRate + " CHF pro Monat");
                break;
            default:
                System.out.println("Falsche Option");
                System.out.println("Programm wird beendet");
        }
    }

}

