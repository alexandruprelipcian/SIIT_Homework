package org.siit.homework.week9;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final String INVALID_FILE_NAME = "The given file name is invalid.";
    static final String INVALID_MONTH = "The given month is invalid.";
    public static List<Person> personArrayList = new ArrayList<>();

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

    public static void crateAListOfPersonsWithDataFromCsv(ArrayList<String> words) throws Exception {
        try {
            for (int i = 0; i < words.size(); i = i + 3) {
                Person person = new Person();
                person.setFirstName(words.get(i));
                person.setLastName(words.get(i + 1));
                person.setDateOfBirth(LocalDate.parse(words.get(i + 2)));
                personArrayList.add(person);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static List<Person> sortDataByMonthAndName(Integer month, List<Person> personArrayList) throws Exception {
        if (month <= 0 || month > 12) {
            throw new RuntimeException(INVALID_MONTH);
        }
        List<Person> people = personArrayList.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == month)
                .map(person -> new Person(person.getFirstName(), person.getLastName(), person.getDateOfBirth()))
                .sorted(Comparator.comparing(Person::getFirstName)).sorted(Comparator.comparing(Person::getLastName))
                .collect(Collectors.toList());
        return people;
    }

    public static void writeToFile(List<Person> personArrayList, String outputFileName) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            for (Person person : personArrayList) {
                writer.write(person.toString());
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void writeFromAFileInAFileByMonth(String inputFileName, Integer targetMonth, String outputFileName) throws Exception {
        try {
            ArrayList<String> wordsList = readFromCsv(inputFileName);
            crateAListOfPersonsWithDataFromCsv(wordsList);
            writeToFile(sortDataByMonthAndName(targetMonth, personArrayList), outputFileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {
        String inputFileName = "src/main/java/resources/inventors.csv";
        String outputFileName = "persons.csv";
        Integer targetMonth = 8;
        writeFromAFileInAFileByMonth(inputFileName, targetMonth, outputFileName);

    }
}
