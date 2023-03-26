package org.siit.homework.week7;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        if (student.getDateOfBirth().isBefore(LocalDate.of(1900, 1, 1)) ||
                student.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("The date should be between 1900 and current year - 18.");
        }
        if (student.getFirstName().isEmpty()) {
            throw new IllegalArgumentException("The first name should not be empty.");
        }
        if (student.getLastName().isEmpty()) {
            throw new IllegalArgumentException("The last name should not be empty.");
        }
        if (!(student.getGender().equalsIgnoreCase("m") ||
                student.getGender().equalsIgnoreCase("f") ||
                student.getGender().equalsIgnoreCase("male") ||
                student.getGender().equalsIgnoreCase("female"))) {
            throw new IllegalArgumentException("The gender should be m, f, male or female.");
        }
        studentList.add(student);
    }

    public void deleteByCNP(int CNP) {
        Student studentToBeRemoved = null;
        for (Student s : studentList) {
            if (s.getCNP() == CNP) {
                studentToBeRemoved = s;
                break;
            }
        }
        if (studentToBeRemoved == null) {
            throw new IllegalArgumentException("The student with the CNP " + CNP + " not found.");
        }
        studentList.remove(studentToBeRemoved);
    }

    public List<Student> retrieveAllByAge(int age) {
        List<Student> studentsByAge = new ArrayList<>();

        for (Student s : studentList) {
            if (s.ageCalculator() == age) {
                studentsByAge.add(s);
            }
        }
        return studentsByAge;
    }

    public void orderStudentByLastName() {
        List<Student> orderedList = new ArrayList<>(studentList);
        Collections.sort(orderedList, new StudentComparatorByLastName());
        for (Student s : orderedList) {
            System.out.println(s);
        }
        System.out.println();

    }

    public void listStudents() {
        for (Student s : studentList) {
            System.out.println(s);
        }
        System.out.println();
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}