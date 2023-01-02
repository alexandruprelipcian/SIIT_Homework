package org.siit.homework.week8;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.siit.homework.week8.AthleteMethods.*;
import static org.siit.homework.week8.AthleteMethods.readFromCsv;

public class Test {
    @org.junit.jupiter.api.Test
    public void test_whenFileIsNotFound_thenRuntimeExceptionIsThrown() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> readFromCsv("filePath"));
        assertEquals(AthleteMethods.INVALID_FILE_NAME, exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    public void testReadCSVFile_whenFileIsFound_thenResponseIsPresent() {
        ArrayList<String> result = readFromCsv("src/main/java/resources/homework08.csv");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @org.junit.jupiter.api.Test
    public void testCalculateWinners() {
        ArrayList<String> wordsList = readFromCsv("src/main/java/resources/homework08.csv");
        parseInputInObject(wordsList);
        String expected = "Winner: - Piotr Smitzer 30:10 (30:10 + 0)\n" +
                        "Runner-up: - Jimmy Smiles 30:15 (29:15 + 60)\n" +
                        "Third Place: - Umar Jorgson 30:57 (30:27 + 30)\n";
        assertEquals(expected, getResults(athletes));
    }


}
