package org.siit.homework.week8;

import java.util.ArrayList;


import static org.siit.homework.week8.AthleteMethods.*;

public class Main {
    private static final String filePath = "src/main/java/resources/homework08.csv";

    public static void main(String[] args) {
        ArrayList<String> wordsList = readFromCsv(filePath);
        parseInputInObject(wordsList);
        System.out.println(getResults(athletes));
    }

}
