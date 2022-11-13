package org.example;

import java.security.InvalidParameterException;

class Student {
    Student(String name, int grade, Boolean didAnswer) {
        this.grade = grade;
        this.name = name;
        this.didAnswer = didAnswer;
    }

    public String name;
    private int grade;
    public Boolean didAnswer;

    public void setGrade(int newGrade) {
        if (newGrade < 0 || newGrade > 10) {
            throw new InvalidParameterException();
        }
        grade = newGrade;
    }
    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Ученик " + name + ((didAnswer) ? " имеет оценку " + grade : " не отвечал");
    }
}
