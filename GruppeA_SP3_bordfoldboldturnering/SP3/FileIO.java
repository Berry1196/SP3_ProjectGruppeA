package SP3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
    //****** FIELDS ******
    public ArrayList<String> roundData;
    public ArrayList<String> infoData;
    public ArrayList<String> teamData;

    //****** METHODS ******
    //All methods that start with 'read' are read from file and 'show' are methods to display

    public ArrayList<String> readTeamAndPlayerData() throws FileNotFoundException {
        File file = new File("teams.txt");
        teamData = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                teamData.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            teamData = null;
        }
        showSavedTeamsData(teamData);
        return teamData;
    }

    public ArrayList<String> readRoundsData() throws FileNotFoundException {
        File file = new File("rounds.txt");
        roundData = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            //String header = scan.nextLine();
            while (scan.hasNextLine()) {
                roundData.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            roundData = null;
        }
        showSavedRoundsData(roundData);
        return roundData;
    }

    public ArrayList<String> readTournamentInfoData() throws FileNotFoundException {
        File file = new File("tournamentInfo.txt");
        infoData = new ArrayList<>();

        try {
            Scanner scan = new Scanner(file);
            //String header = scan.nextLine();              NEED FIX
            while (scan.hasNextLine()) {
                infoData.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            infoData = null;
        }
        showSavedInfoData(infoData);
        return infoData;
    }

    private void showSavedTeamsData(ArrayList teamData) throws FileNotFoundException {
         System.out.println(teamData);
    }

    private void showSavedRoundsData(ArrayList roundData) throws FileNotFoundException {
         System.out.println(roundData);
    }

    private void showSavedInfoData(ArrayList infoData) throws FileNotFoundException {
         System.out.println(infoData);
    }
}
