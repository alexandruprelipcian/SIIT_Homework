package org.siit.homework.week9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.siit.homework.week9.Main.*;


public class Test {

    @org.junit.jupiter.api.Test
    public void test_whenFileIsNotFound_thenRuntimeExceptionIsThrown() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> readFromCsv("filePath"));
        assertEquals(INVALID_FILE_NAME, exception.getMessage());
    }

    @org.junit.jupiter.api.Test
    public void test_whenMonthIsInvalid() throws Exception {
        ArrayList<Person> personArrayList = new ArrayList<>();
        Integer month = 0;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> sortDataByMonthAndName(month, personArrayList));
        assertEquals(INVALID_MONTH, exception.getMessage());
    }

//    @org.junit.jupiter.api.Test
//    public void test_whenMonthIsValid() throws Exception {
//        Integer month = 8;
//        List<Person> expectedList = new ArrayList<>();
//        expectedList.add(new Person("Traian", "a", LocalDate.of(2020, 8, 8)));
//        expectedList.add(new Person("Traian", "b", LocalDate.of(2020, 8, 8)));
//
//        List<Person> actual= sortDataByMonthAndName(month, expectedList);
//        assertEquals(expectedList, actual);
//    }

    @org.junit.jupiter.api.Test
    public void testReadCSVFile_whenFileIsFound_thenResponseIsPresent() {
        ArrayList<String> result = readFromCsv("src/main/java/resources/inventors.csv");
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

}
