package SP3;

import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    //****** FIELDS ******
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Player> players = new ArrayList<>();
    public Teams teams;
    public FileWriter fileData;
    private String input = "Du har tastet: %s\n";
    private String comma = ", ";

    //****** METHODS ******
    //all methods that start with 'add' are methods that save to a txt file

    public void addTeamAndPlayers(ArrayList<Teams> theTeams) throws IOException {
        FileWriter fileData = new FileWriter("teams.txt", true);
        // fileData.write("Holdnavn, spillere [Max 5 spillere pr. hold]" + "\n");               FIX THIS
        teams = new Teams();
        teams.teamName = "";

        System.out.println("Tast navnet på holdet.");
        teams.setTeamName(scan.nextLine());
        theTeams.add(teams);

        for (int i = 1; i < 6; i++) {
            System.out.println("Tast navnet på spiller " + i + ":");
            players.add(new Player(scan.nextLine()));
        }
        fileData.write(teams.getTeamName() + comma + players.toString() + "\n");
        fileData.close();
    }

    //method to enter a date to the tournament
    public void addDate() throws IOException {
        fileData = new FileWriter("tournamentInfo.txt", true);
        //String header = "Dato, lokation, TurneringStart, TurneringSlut, kampStartTid, kampSlutTid\n";
        //fileData.write(header);                                                              FIX THIS
        System.out.println("# Tast dato for turneringen ");
        String date = scan.nextLine();
        fileData.write(date + comma);
        System.out.printf(input, date);
        fileData.close();
    }

    //method to enter a start time to a tournament round
    public void addStartTimeRound() throws IOException {
        fileData = new FileWriter("tournamentInfo.txt", true);
        System.out.println("\nKamp 1 skal starte klokken:");
        String startTime = scan.nextLine();
        fileData.write(startTime + comma);
        System.out.printf(input, startTime);
        fileData.close();
    }

    //method to enter an end time to a tournament round
    public void addEndTimeRounds() throws IOException {
        fileData = new FileWriter("tournamentInfo.txt", true);
        System.out.println("\nKamp 1 skal slutte klokken:");
        String endTime = scan.nextLine();
        fileData.write(endTime + comma + "\n");
        System.out.printf(input, endTime);
        fileData.close();
    }

    //method to enter a start time to the tournament
    public void addStartTimeTournament() throws IOException {
        fileData = new FileWriter("tournamentInfo.txt", true);
        System.out.println("\n# Tast starttidspunktet for turneringen: ");
        String startTime = scan.nextLine();
        fileData.write(startTime + comma);
        System.out.printf(input, startTime);
        fileData.close();
    }

    //method to enter an end time to the tournament
    public void addEndTimeTournament() throws IOException {
        fileData = new FileWriter("tournamentInfo.txt", true);
        System.out.println("\n# Tast sluttidspunktet for turneringen: ");
        String endTime = scan.nextLine();
        fileData.write(endTime + comma);
        System.out.printf(input, endTime);
        fileData.close();
    }

    //method to add a location to the tournament
    public void addLocation() throws IOException {
        fileData = new FileWriter("tournamentInfo.txt", true);
        System.out.println("\n# Tast lokation for kampene:");
        String location = scan.nextLine();
        fileData.write(location + comma);
        System.out.printf(input, location);
        fileData.close();
    }
}
