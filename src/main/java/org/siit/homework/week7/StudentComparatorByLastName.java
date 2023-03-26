package org.siit.homework.week7;

import java.util.Comparator;

public class StudentComparatorByLastName implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getLastName().compareTo(student2.getLastName());

    }
}