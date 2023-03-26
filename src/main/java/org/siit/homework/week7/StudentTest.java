package org.siit.homework.week7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class StudentTest {

    @Test
    public void testAddValidStudent() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Popescu", "Marian", LocalDate.of(1997, 7, 4), "M", 4071997);
        studentRepository.addStudent(student);
        List<Student> studentList = studentRepository.getStudentList();

        Assertions.assertTrue(studentList.contains(student));

    }

    @Test
    public void testAddStudentWithInvalidDate() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Popescu", "Marin", LocalDate.of(1899, 7, 4), "M", 4071997);

        Exception thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.addStudent(student));
        Assertions.assertEquals("The date should be between 1900 and current year - 18.", thrownException.getMessage());

    }

    @Test
    public void testAddStudentWithEmptyFirstName() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("", "Marin", LocalDate.of(2000, 7, 4), "M", 4071997);

        Exception thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.addStudent(student));
        Assertions.assertEquals("The first name should not be empty.", thrownException.getMessage());

    }

    @Test
    public void testAddStudentWithInvalidGender() {
        StudentRepository studentRepository = new StudentRepository();
        Student student = new Student("Ion", "Stanca", LocalDate.of(1997, 7, 4), "L", 4071997);

        Exception thrownException = Assertions.assertThrows(IllegalArgumentException.class, () -> studentRepository.addStudent(student));
        Assertions.assertEquals("The gender should be m, f, male or female.", thrownException.getMessage());

    }

    @Test
    public void testRetrieveAllByAge() {
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(new Student("Ion", "Stanca", LocalDate.of(1997, 7, 4), "M", 4071997));
        studentRepository.addStudent(new Student("Cotovanu", "Ana", LocalDate.of(2000, 5, 14), "f", 5983465));
        studentRepository.addStudent(new Student("Ionescu", "Ionela", LocalDate.of(1999, 11, 11), "f", 22111999));
        List<Student> studentList = studentRepository.retrieveAllByAge(23);
        System.out.println(studentList);

        Assertions.assertEquals(1, studentList.size());

    }
}
