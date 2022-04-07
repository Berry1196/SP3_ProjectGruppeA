package SP3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tournament {

    //****** FIELDS ******
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Teams> allTeams = new ArrayList<>();
    public TextUI textUI = new TextUI();
    public TournamentProgram tournamentprogram = new TournamentProgram();
    public RankList ranklist = new RankList();
    public FileIO fileIO = new FileIO();
    public Rounds rounds = new Rounds();
    private StringBuilder userInput;

    //****** METHODS ******

    //Main method to run different methods in the program
    public void startTournamentProgram() throws IOException {
        displayTitelAndDescription();
        displayProgramMenu();
    }

    //method to display the Tournament Program menu
    private void displayProgramMenu() throws IOException {
        String enter = "# Tast ";
        String to = " for at ";

        System.out.println("\n****** MENU ******");
        System.out.println(enter + "T" + to + "registrere info til turneringen");
        System.out.println(enter + "N" + to + "registrere et hold og spillere");
        System.out.println(enter + "Z" + to + "vise registrerede hold + spillere ");
        System.out.println(enter + "P" + to + "vise programmet for turneringen");
        System.out.println(enter + "D" + to + "vise hvornår næste kamp spilles");
        System.out.println(enter + "X" + to + "indtaste kampe + kampresultater");
        System.out.println(enter + "R" + to + "vise ranglisten");
        System.out.println(enter + "L" + to + "loade din sidste registrering");
        System.out.println(enter + "Q" + to + "afslutte programmet");

        userInput = new StringBuilder(scan.nextLine());
         if (userInput.toString().equalsIgnoreCase("T")) {
            registerTournamentInfo();
        } else if (userInput.toString().equalsIgnoreCase("N")) {
            registerTeams();
        } else if (userInput.toString().equalsIgnoreCase("Z")) {
            tournamentprogram.displayListOfTeamsAndPlayers();
        } else if (userInput.toString().equalsIgnoreCase("P")) {
            tournamentprogram.displayCompetitionCalender();
        } else if (userInput.toString().equalsIgnoreCase("D")) {
            tournamentprogram.displayNextGame();
        } else if (userInput.toString().equalsIgnoreCase("X")) {
            rounds.initializingTeams();
        } else if (userInput.toString().equalsIgnoreCase("R")) {
            ranklist.displayRankList();
        } else if (userInput.toString().equalsIgnoreCase("L")) {
            readSavedData();
        } else if (userInput.toString().equalsIgnoreCase("Q")) {
            endProgram();
        } else {
            System.out.println("Du har ikke trykket rigtigt - prøv igen");
            displayProgramMenu();
        }
    }

    //method to call methods that register Teams and Players
    private void registerTeams() throws IOException {
        textUI.addTeamAndPlayers(allTeams);
        System.out.println("Du har nu registreret et hold + 5 spillere og gemt din data");
    }

    //method to call methods that are tournament information (date time etc.)
    private void registerTournamentInfo() throws IOException {
        textUI.addDate();
        textUI.addLocation();
        textUI.addStartTimeTournament();
        textUI.addEndTimeTournament();
        registerGameTime();
        displayProgramMenu();
    }

    //method to let user choose to register start and end time for a round
    private void registerGameTime() throws IOException {
        System.out.println("\n# Tast A for at tilføje start og slut tidspunkt for 1 kamp:" +
                "ellers tast B for at vende tilbage til menuen");
        userInput = new StringBuilder(scan.nextLine());
        if (userInput.toString().equalsIgnoreCase("A")) {
            textUI.addStartTimeRound();
            textUI.addEndTimeRounds();
        } else if (userInput.toString().equalsIgnoreCase("B")) {
            displayProgramMenu();
        }
    }

    //method to load all previous saved data. Loads all methods from FileIO as all data is saved in these.
    private void readSavedData() throws IOException {
        fileIO.readTeamAndPlayerData();
        fileIO.readRoundsData();
        fileIO.readTournamentInfoData();
        displayProgramMenu();
    }

    //method to display the titel and description of the Tournament Program
    private void displayTitelAndDescription() {
        System.out.println("\n****** BORDFODBOLD TURNERING ******");
        System.out.println("Dette er et program, der kan registrere bordfodboldturneringer.");
        System.out.println("Programmet styres af en turneringsleder - i dette tilfælde er det dig :D");
        System.out.println("Når du opretter en turnering registrerer du 8 hold. Hvert hold skal have 5 spillere.");
        System.out.println(">> Udarbejdet af projektGruppeA - Berry, Martin, Israa & Felicia <<");
    }

    //method to end the program
    private void endProgram() {
        System.out.println("Du har afsluttet programmet");
        scan.close();
    }
}
