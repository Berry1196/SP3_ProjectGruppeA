package SP3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RankList {

    //method to display data from files to display the ranklist
    public void displayRankList() throws FileNotFoundException {

    String output = "";

    File file = new File("ranklist.txt");
        String data;

        try {
            Scanner scan = new Scanner(file);
            //String header = scan.nextLine();
            while (scan.hasNextLine()) {
                data = scan.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println(".. Ingen fil fundet");
        }
    }


    public void theRankListThatWorks(ArrayList<Teams> teams) throws IOException {
        String space = "       ";
        Collections.sort((teams));
        FileWriter fileData = new FileWriter("ranklist.txt", true);
        fileData.write("****** RANGLISTE ******\n");
        fileData.write("Position" + space + "Hold" + space + "Point" + space + "Målscore\n");

        System.out.println("\n****** RANGLISTE ******");
        System.out.println("Her kan du se en oversigt over hvilke kampe der er spillet\n" +
                "holdenes placering ud fra point og holdenes samlede målscore.\n");

        System.out.println("Position" + space + "Hold" + space + "Point" + space + "Målscore");
        System.out.println("-------------------------------------------------------");

        //sort the rank list in points
        for (int i = 0; i < teams.size(); i++) {
            System.out.println(i + 1 + ".plads. " + space + teams.get(i).getTeamName() + space + teams.get(i).getTotalPoint() + space + teams.get(i).getTotalScore()
                    + "\n-------------------------------------------------------");
            fileData.write(i + 1 + ".plads. " + space + teams.get(i).getTeamName() + space + teams.get(i).getTotalPoint() + space + teams.get(i).getTotalScore() + "\n");
        }
        fileData.close();
    }


}