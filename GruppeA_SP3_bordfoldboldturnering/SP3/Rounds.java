package SP3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Rounds {
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Teams> allTeams = new ArrayList<>();
    public ArrayList<Teams> quarterTeams = new ArrayList<>();
    public ArrayList<Teams> semiTeams = new ArrayList<>();
    public ArrayList<Teams> finalTeams = new ArrayList<>();
    public RankList ranklist = new RankList();

    private final String stringHasScored = ". holds navn:";
    private final Teams team1 = new Teams();
    private final Teams team2 = new Teams();
    private final Teams team3 = new Teams();
    private final Teams team4 = new Teams();
    private final Teams team5 = new Teams();
    private final Teams team6 = new Teams();
    private final Teams team7 = new Teams();
    private final Teams team8 = new Teams();

    public void initializingTeams() throws IOException {
        String stringTeamName = ". holds navn:";
        System.out.println("------------------------------------");
        System.out.println("Registrer de hold der skal spille mod hinanden");

        System.out.println(1 + stringTeamName);
        team1.makeTeam();
        allTeams.add(team1);

        System.out.println(2 + stringTeamName);
        team2.makeTeam();
        allTeams.add(team2);

        System.out.println(3 + stringTeamName);
        team3.makeTeam();
        allTeams.add(team3);

        System.out.println(4 + stringTeamName);
        team4.makeTeam();
        allTeams.add(team4);

        System.out.println(5 + stringTeamName);
        team5.makeTeam();
        allTeams.add(team5);

        System.out.println(6 + stringTeamName);
        team6.makeTeam();
        allTeams.add(team6);

        System.out.println(7 + stringTeamName);
        team7.makeTeam();
        allTeams.add(team7);

        System.out.println(8 + stringTeamName);
        team8.makeTeam();
        allTeams.add(team8);

        System.out.println(allTeams.get(4).getTeamName());
        quarterFinal();
    }

    public void quarterFinal() throws IOException {
        String stringHasScored = " har scoret:";
        String stringTeam = ". Hold: ";

        System.out.println("\n# Indtast hvor mange mål hvert hold har scoret i kvartfinalen");

        System.out.println(team1.getTeamName() + stringHasScored);
        team1.setCurrentScore(scan.nextInt());

        System.out.println(team2.getTeamName() + stringHasScored);
        team2.setCurrentScore(scan.nextInt());

        System.out.println(team3.getTeamName() + stringHasScored);
        team3.setCurrentScore(scan.nextInt());

        System.out.println(team4.getTeamName() + stringHasScored);
        team4.setCurrentScore(scan.nextInt());

        System.out.println(team5.getTeamName() + stringHasScored);
        team5.setCurrentScore(scan.nextInt());

        System.out.println(team6.getTeamName() + stringHasScored);
        team6.setCurrentScore(scan.nextInt());

        System.out.println(team7.getTeamName() + stringHasScored);
        team7.setCurrentScore(scan.nextInt());

        System.out.println(team8.getTeamName() + stringHasScored);
        team8.setCurrentScore(scan.nextInt());

        System.out.println("---------------------------------------------");
        System.out.println("Vinderne af kvartfinalen er følgende hold: ");

        if (team1.getCurrentScore() > team2.getCurrentScore()) {
            quarterTeams.add(team1);
            team1.setCurrentPoint(2);
            team2.setCurrentPoint(0);
            System.out.println(stringTeam + team1.getTeamName());

        } else {
            quarterTeams.add(team2);
            team2.setCurrentPoint(2);
            team1.setCurrentPoint(0);
            System.out.println(stringTeam + team2.getTeamName());
        }

        if (team3.getCurrentScore() > team4.getCurrentScore()) {
            quarterTeams.add(team3);
            team3.setCurrentPoint(2);
            team4.setCurrentPoint(0);
            System.out.println(stringTeam + team3.getTeamName());

        } else {
            quarterTeams.add(team4);
            team4.setCurrentPoint(2);
            team3.setCurrentPoint(0);
            System.out.println(stringTeam + team4.getTeamName());
        }

        if (team5.getCurrentScore() > team6.getCurrentScore()) {
            quarterTeams.add(team5);
            team5.setCurrentPoint(2);
            team6.setCurrentPoint(0);
            System.out.println(stringTeam + team5.getTeamName());

        } else {
            quarterTeams.add(team6);
            team6.setCurrentPoint(2);
            team5.setCurrentPoint(0);
            System.out.println(stringTeam + team6.getTeamName());
        }

        if (team7.getCurrentScore() > team8.getCurrentScore()) {
            quarterTeams.add(team7);
            team7.setCurrentPoint(2);
            team8.setCurrentPoint(0);
            System.out.println(stringTeam + team7.getTeamName());

        } else {
            quarterTeams.add(team8);
            team8.setCurrentPoint(2);
            team7.setCurrentPoint(0);
            System.out.println(stringTeam + team8.getTeamName());
        }
        semiFinal();
    }

    public void semiFinal() throws IOException {
        String stringHasScored = " har scoret: ";
        semiTeams = new ArrayList<>(2);

        System.out.println("\n# Indtast hvor mange mål hvert hold har scoret i semifinalen"); //FIX
        System.out.println(quarterTeams.get(0).getTeamName() + stringHasScored);
        quarterTeams.get(0).setUpdatedScore(scan.nextInt());

        System.out.println(quarterTeams.get(1).getTeamName() + stringHasScored);
        quarterTeams.get(1).setUpdatedScore(scan.nextInt());

        System.out.println(quarterTeams.get(2).getTeamName() + stringHasScored);
        quarterTeams.get(2).setUpdatedScore(scan.nextInt());

        System.out.println(quarterTeams.get(3).getTeamName() + stringHasScored);
        quarterTeams.get(3).setUpdatedScore(scan.nextInt());
        System.out.println("---------------------------------------------");
        System.out.println("Vinderne af semifinalen er følgende hold: ");


        if (quarterTeams.get(0).getUpdatedScore() > quarterTeams.get(1).getUpdatedScore()) {
            semiTeams.add(quarterTeams.get(0));
            quarterTeams.get(0).setUpdatedPoint(2);
            quarterTeams.get(1).setUpdatedPoint(0);
            System.out.println(semiTeams.get(0).getTeamName());

        } else {
            semiTeams.add(quarterTeams.get(1));
            quarterTeams.get(0).setUpdatedPoint(0);
            quarterTeams.get(1).setUpdatedPoint(2);
            System.out.println(semiTeams.get(0).getTeamName());
        }

        if (quarterTeams.get(2).getUpdatedScore() > quarterTeams.get(3).getUpdatedScore()) {
            semiTeams.add(quarterTeams.get(2));
            quarterTeams.get(2).setUpdatedPoint(2);
            quarterTeams.get(3).setUpdatedPoint(0);
            System.out.println(semiTeams.get(1).getTeamName());

        } else {
            semiTeams.add(quarterTeams.get(3));
            quarterTeams.get(2).setUpdatedPoint(0);
            quarterTeams.get(3).setUpdatedPoint(2);
            System.out.println(semiTeams.get(1).getTeamName());
        }
        finalRound();
    }

    public void finalRound() throws IOException {
        String stringHasScored = " har scoret:";
        System.out.println("\n# Indtast hvor mange mål hvert hold har scoret i finalen");
        System.out.println(semiTeams.get(0).getTeamName() + stringHasScored);
        semiTeams.get(0).setFinalScore(scan.nextInt());
        System.out.println(semiTeams.get(1).getTeamName() + stringHasScored);
        semiTeams.get(1).setFinalScore(scan.nextInt());

        System.out.println("Vinderen af bordfodboldturneringen er hold: ");
        if (semiTeams.get(0).getFinalScore() > semiTeams.get(1).getFinalScore()) {
            finalTeams.add(semiTeams.get(0));
            semiTeams.get(0).setFinalPoint(2);
            semiTeams.get(1).setFinalPoint(0);
            System.out.println(semiTeams.get(0).getTeamName());

        } else if ((semiTeams.get(0).getFinalScore() < semiTeams.get(1).getFinalScore())) {
            finalTeams.add(semiTeams.get(1));
            semiTeams.get(1).setFinalPoint(2);
            semiTeams.get(0).setFinalPoint(0);
            System.out.println(semiTeams.get(1).getTeamName());
        }
        ranklist.theRankListThatWorks(allTeams);
    }
}

