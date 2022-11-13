package org.example;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Random;
import java.io.*;


public class Main {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static Scanner in = new Scanner(System.in);
    private static String file ="class_.json";
    private static Class class_ = new Class();
    private static Random rand = new Random();


    public static void main(String[] args) {
        readData();
        showRules();
        String command;
        while (!(command = in.nextLine()).equals("/exit")) {
            if (command.equals("/r")) {
                if (class_.students.stream().allMatch(val -> val.didAnswer == true)) {
                    System.out.println("Все студенты ответили");
                } else {
                    boolean isAnswer = chooseStudent(class_.students.get(rand.nextInt(class_.students.size())));
                    while (!isAnswer) {
                        isAnswer = chooseStudent(class_.students.get(rand.nextInt(class_.students.size())));
                    }
                }
            } else if (command.equals("/l")) {
                System.out.println(class_);
            }
        }
        saveData();
    }

    private static void showRules() {
        System.out.println("            SMART LMS           ");
        System.out.println("Для выбора студента введите /r");
        System.out.println("Для просмотра списка студентов введите /l");
        System.out.println("Для выхода из системы введите /exit");
        System.out.println("Некорректный ввод игнорируется \n");

    }

    private static boolean chooseStudent(Student student) {
        System.out.println("Отвечает " + student.name);
        System.out.println("Присутствует ли на паре? (y/n)");
        String command = in.nextLine();
        if (command.equals("y")) {
            System.out.print("Введите оценку студента - ");
            student.setGrade(in.nextInt());
            student.didAnswer = true;
            return true;
        } else if (command.equals("n")) {
            System.out.println("Очень жаль, что " + student.name + " не пришел");
        } else {
            System.out.println("Некорректный ввод");
        }
        return false;
    }
    private static void saveData() {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(class_, writer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readData() {
        try {
            Path path = Paths.get("class_.json");
            String read = (Files.readAllLines(path).stream().reduce("", (x, y) -> x + "\n" + y));
            class_ = gson.fromJson(read, Class.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}