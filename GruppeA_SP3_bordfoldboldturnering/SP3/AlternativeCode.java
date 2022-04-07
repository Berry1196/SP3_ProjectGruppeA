package SP3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//VI HAR FORSØGT AT LAVE EN ANDEN MÅDE OG REGISTRERE HOLD + SCORE bl.a. ved at anvende loops - (virker dog ikke)

public class AlternativeCode {
    private Scanner scan = new Scanner(System.in);
    public Teams team1 = new Teams();
    public Teams team2 = new Teams();
    public Teams team3 = new Teams();
    public Teams team4 = new Teams();
    public Teams team5 = new Teams();
    public Teams team6 = new Teams();
    public Teams team7 = new Teams();
    public Teams team8 = new Teams();
    public ArrayList<Teams> winningTeams = new ArrayList<>();
    private ArrayList<Teams> allTeams = new ArrayList<>();
    private FileWriter fileData;

    public void findRoundWinner() throws IOException {
            fileData = new FileWriter("rounds.txt", true);
            System.out.println("Tast første hold: ");
            team1.teamName = scan.nextLine();
            System.out.println("Tast andet hold: ");
            team2.teamName = scan.nextLine();

            System.out.println(team1.getTeamName() + " har scoret:");
            fileData.write(team1.setCurrentScore(scan.nextInt()));
            allTeams.add(team1);

            System.out.println(team2.getTeamName() + " har scoret:");
            team2.setCurrentScore(scan.nextInt());
            allTeams.add(team2);

            if (team1.getCurrentScore() > team2.getCurrentScore()) {
                winningTeams.add(team1);
                team1.setCurrentPoint(2);
                team2.setCurrentPoint(0);
                System.out.println("Vinder af kampen er: " + team1.getTeamName());
            } else {
                winningTeams.add(team2);
                team2.setCurrentPoint(2);
                team1.setCurrentPoint(0);
                System.out.println("Vinder af kampen er: " + team2.getTeamName());
            }
        }

    public void quarterFinals() throws IOException {
        Teams[] quarterTeamss = new Teams[8];

        quarterTeamss[0] = team1; //hent hold fra fil
        quarterTeamss[1] = team2;
        quarterTeamss[2] = team3;
        quarterTeamss[3] = team4;
        quarterTeamss[4] = team5;
        quarterTeamss[5] = team6;
        quarterTeamss[6] = team7;
        quarterTeamss[7] = team8;

        for (int i = 0; i < quarterTeamss.length; i++)
        {
            System.out.println("Tast holdnavn: ");

            quarterTeamss[i].setTeamName(scan.nextLine());
        }
        //System.out.println(quarterTeamss[3].getTeamName());


        System.out.println("Skriv hvor mange mål hvert hold har scoret i kvartfinalen, efterfulgt af ENTER");

        for (int i = 0; i < quarterTeamss.length; i++) {
            System.out.println(quarterTeamss[i].getTeamName() + " har score:");
            quarterTeamss[i].setCurrentScore(scan.nextInt());
        }

        // her opgøres point og hvem der er de 4 vinderhold af kvartfinalen
        System.out.println("---------------------------------------------");
        System.out.println("Vinderne af kvartfinalen er følgende hold: ");

        String winnerOne = "";

        for (int i = 0; i < quarterTeamss.length; i++) {
            for (int j = 0; j < quarterTeamss.length-1; j++) {
                if (quarterTeamss[i].getCurrentScore() > quarterTeamss[i+1].getCurrentScore()) {
                    quarterTeamss[i].setCurrentPoint(2);
                    quarterTeamss[i+1].setCurrentPoint(0);
                }
                else if(quarterTeamss[i].getCurrentScore() < quarterTeamss[i+1].getCurrentScore()) {
                    quarterTeamss[i+1].setCurrentPoint(2);
                    quarterTeamss[i].setCurrentPoint(0);
                }
                else if(quarterTeamss[i].getCurrentScore() == quarterTeamss[i+1].getCurrentScore()) {
                    //if((quarterTeamss[i].getCurrentScore() > quarterTeamss[i+1].getCurrentScore()))
                        quarterTeamss[i].setCurrentPoint(2);
                        quarterTeamss[i+1].setCurrentPoint(0);
                }
            }
            // if(quarterTeamss[i].getCurrentPoint() > quarterTeamss[i+1].getCurrentPoint())
            System.out.println("Vinder af kampen er: " + quarterTeamss[i].getTeamName());
        }
        System.out.println("---------------------------------------------");
    }

    public void semiFinals() throws IOException {
        for (int i = 0; i < 3; i++) {
            //findRoundWinner();
        }
    }

    public void Finals() throws IOException {
        for (int i = 0; i < 2; i++) {
            //  findRoundWinner();
        }
    }
}

