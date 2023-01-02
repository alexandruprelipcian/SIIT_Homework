package org.siit.homework.week8;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AthleteMethods {
    public static final String INVALID_FILE_NAME = "The given file name is invalid.";
    public static ArrayList<Athlete> athletes = new ArrayList<>();

    public static ArrayList<String> readFromCsv(String filePath) {
        ArrayList<String> wordsList = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] words = line.split(",");
                wordsList.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            throw new RuntimeException(INVALID_FILE_NAME);
        }
        return wordsList;
    }

    public static void parseInputInObject(ArrayList<String> words) {
        for (int i = 0; i < words.size(); i = i + 7) {
            Athlete athlete = new Athlete();
            athlete.setNumber(Integer.valueOf(words.get(i)));
            athlete.setName(words.get(i + 1));
            athlete.setState(words.get(i + 2));
            athlete.setTime(words.get(i + 3));
            athlete.setShootingResults(words.get(i + 4) + words.get(i + 5) + words.get(i + 6));
            athletes.add(athlete);
        }
    }

    public static Integer countPenaltySeconds(String shootingResults) {
        int penaltySeconds = 0;
        char[] chars = shootingResults.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'o') {
                penaltySeconds += 10;
            }
        }
        return penaltySeconds;
    }

    public static Integer getTimeInSeconds(String time) {
        char[] chars = time.toCharArray();
        int minutes = Integer.parseInt(String.valueOf(chars[0]) + chars[1]);
        int seconds = Integer.parseInt(String.valueOf(chars[3]) + chars[4]);
        return minutes * 60 + seconds;
    }

    public static Integer finalTime(Integer timeInSeconds, Integer penaltySeconds) {
        return timeInSeconds + penaltySeconds;
    }

    public static String customOutput(Athlete athlete) {
        int min = finalTime(getTimeInSeconds(athlete.getTime()), countPenaltySeconds(athlete.getShootingResults())) / 60;
        int sec = finalTime(getTimeInSeconds(athlete.getTime()), countPenaltySeconds(athlete.getShootingResults())) % 60;

        return athlete.getName() + " " + min + ":" + sec + " (" + athlete.getTime() + " + " + countPenaltySeconds(athlete.getShootingResults()) + ")" + "\n";
    }


    public static String getResults(ArrayList<Athlete> athletes) {
        Athlete winner = new Athlete();
        Athlete runnerUp = new Athlete();
        Athlete thirdPlace = new Athlete();
        int bestTime = Integer.MAX_VALUE;
        for (Athlete athlete : athletes) {
            if (finalTime(getTimeInSeconds(athlete.getTime()), countPenaltySeconds(athlete.getShootingResults())) < bestTime) {
                thirdPlace = runnerUp;
                runnerUp = winner;
                winner = athlete;

            }
        }

        return "Winner: - " + customOutput(winner) +
                "Runner-up: - " + customOutput(runnerUp) +
                "Third Place: - " + customOutput(thirdPlace);

    }
}
