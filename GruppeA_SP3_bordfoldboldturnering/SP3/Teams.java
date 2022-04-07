package SP3;

import java.util.Scanner;

public class Teams implements Comparable<Teams> {

    //****** FIELDS ******
    public Scanner scan = new Scanner(System.in);
    public String teamName;
    private int currentScore;
    private int updatedScore;
    private int finalScore;
    private int currentPoint;
    private int updatedPoint;
    private int finalPoint;

    //****** METHODS ******

    //make, set and get team name
    public void makeTeam() {
        this.teamName = scan.nextLine();
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getTeamName() {
        return this.teamName;
    }

    //getters to get different scores
    public int getCurrentScore() {
        return currentScore;
    }
    public int getUpdatedScore() {
        return updatedScore;
    }
    public int getFinalScore() {
        return finalScore;
    }

    public int getTotalScore() {
        int totalScore = currentScore + updatedScore + finalScore;
        return totalScore;
    }

    //setters to set different scores
    public int setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
        return currentScore;
    }
    public void setUpdatedScore(int updatedScore) {
        this.updatedScore = updatedScore;
    }
    public void setFinalScore(int finalScore) { this.finalScore = finalScore; }

    //setters to set different points
    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }
    public void setUpdatedPoint(int updatedPoint) {
        this.updatedPoint = updatedPoint;
    }
    public void setFinalPoint(int finalPoint) {
        this.finalPoint = finalPoint;
    }


    //getters to get different points
    public int getCurrentPoint() {
        return currentPoint;
    }
    public int getUpdatedPoint() {
        return updatedPoint;
    }
    public int getFinalPoint() {
        return finalPoint;
    }

    public int getTotalPoint() {
        int totalPoint = currentPoint + updatedPoint + finalPoint;
        return totalPoint;
    }

    //override method that is used to compare the totalpoints of two teams and by this used to sort the ranklist
    @Override
    public int compareTo(Teams other) {
        int otherTotalPoint = other.getTotalPoint();
        int thisTotalPoint = this.getTotalPoint();
        int otherTotalScore = other.getTotalScore();
        int thisTotalScore = this.getTotalScore();


        if (thisTotalPoint == otherTotalPoint) {
            if (otherTotalScore == thisTotalScore) {
                return 0; //  if equal points return 0
            } else if (otherTotalScore < thisTotalScore) {
                return -1; //  if lesser points return -1
            }
            return 0;
        }

        if (thisTotalPoint < otherTotalPoint) {
                return 1;   // if team 1's points are smaller than team 2's points - move team 2 up the ranklist
            } else {
                return -1;  // if team 1's points are bigger than team 2's points - move team 2 down the ranklist
            }
        }
}



