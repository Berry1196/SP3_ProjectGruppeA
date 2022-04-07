package SP3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TournamentProgram {

    //****** FIELDS ******
    private String[] data = new String[100];
    private String[] tpInfo;

    //****** METHODS ******
    public void displayCompetitionCalender() throws FileNotFoundException {
        System.out.println("\n" + "****** KAMPPROGRAM ******");
        getVSTeam();

        File file = new File("teams.txt");
        File f = new File("tournamentInfo.txt");
        Scanner scannerOne = new Scanner(file);

        String inputFromFile = "";

        while (scannerOne.hasNextLine()) {
            System.out.println(inputFromFile + "");
            inputFromFile = scannerOne.nextLine();
        }

        Scanner scannerTwo = new Scanner(f);
        while (scannerTwo.hasNextLine()) {
            inputFromFile = scannerTwo.nextLine();
        }

        tpInfo = inputFromFile.split(", ");

        int dateC = 0;
        int locationC = 0;
        int startC = 0;
        int endC = 0;

        for (int i = 0; i < tpInfo.length; i++) {
            System.out.println(tpInfo[0 + dateC] + ", " + tpInfo[1 + locationC] + ", " + tpInfo[4 + startC] + ", " + tpInfo[5 + endC]);
            dateC = dateC + 6;
            locationC = locationC + 7;
            startC = startC + 10;
            endC = endC + 11;
        }
    }

    public void getVSTeam() throws FileNotFoundException {
        File file = new File("teams.txt");
        Scanner scan = new Scanner(file);

        System.out.println("****** VS ******");
        String inputFromFile = "";

        while (scan.hasNextLine()) {
            //System.out.println(inputFromFile + "");
            inputFromFile += scan.nextLine();
        }

        data = inputFromFile.split(",");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[0] + " VS " + data[5]);
        }
    }


    public void displayListOfTeamsAndPlayers() throws FileNotFoundException {
        File file = new File("teams.txt");
        Scanner scan = new Scanner(file);

        System.out.println("****** LISTE OVER TILMELDTE HOLD OG SPILLERE ******");
        String inputFromFile = "";


        while (scan.hasNextLine()) {
            System.out.println(inputFromFile + "");
            inputFromFile = scan.nextLine();
        }
    }

    public void displayNextGame() throws FileNotFoundException {
        File file = new File("tournamentInfo.txt");
        Scanner scan = new Scanner(file);

        System.out.println("\n****** DE NÆSTE KAMPE SPILLES ******");
        String inputFromFile = "";
        while (scan.hasNextLine()) {
            inputFromFile += scan.nextLine();
        }
        data = inputFromFile.split(",");

        int startC = 0;
        int endC = 0;

        for (int i = 1; i < 9; i++) {
            System.out.println("Kamp " + i + ". start: " + data[4 + startC] + " slut: " + data[5 + endC]);
            startC += 6;
            endC += 6;
        }
        System.out.println("");
    }
}