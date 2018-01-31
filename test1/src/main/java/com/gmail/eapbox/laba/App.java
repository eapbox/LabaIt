package com.gmail.eapbox.laba;

/**
 * Created by eapbox on 30.01.2018.
 */
public class App {
    public static void main(String[] args) {
        CompetitionImpl competition = new CompetitionImpl();

        int steps = 0;
        try {
            steps = competition.getSteps("2 0 7");
            System.out.println("steps= " + steps);
        } catch (ValidateException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
