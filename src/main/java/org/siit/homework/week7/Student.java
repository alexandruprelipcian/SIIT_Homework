package org.siit.homework.week7;

import java.time.LocalDate;
import java.time.Period;

public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private int CNP;


    public int ageCalculator() {
        LocalDate now = LocalDate.now();
        return Period.between(dateOfBirth, now).getYears();
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, int CNP) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.CNP = CNP;
    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", Gender='" + gender + '\'' +
                ", CNP=" + CNP +
                '}';
    }

    public int getCNP() {
        return CNP;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }
}