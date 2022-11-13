package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Class {
    List<Student> students = new ArrayList<>();

    @Override
    public String toString() {
        return students.stream()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));
    }
}