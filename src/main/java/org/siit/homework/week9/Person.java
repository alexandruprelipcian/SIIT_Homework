package org.siit.homework.week9;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
public class Person {
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private LocalDate dateOfBirth;

    public Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  firstName + ',' + lastName + '\n';
    }
}
