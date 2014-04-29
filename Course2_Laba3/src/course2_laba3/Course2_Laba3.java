package course2_laba3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Course2_Laba3 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Tree listStudent = new Tree();
        int numberStudent = listStudent.createList();
        for (int i = 0; i < numberStudent; i++) {
            Student newStudent = createStudent();
            listStudent.addStudent(newStudent);
        }

        System.out.println("\nСписок студентов до удаления");
        listStudent.showStudentList();

        System.out.print("Удалить из таблицы студентов \n  "
                + "которые родились зимой [y] -> ");
        Scanner inp = new Scanner(System.in);
        if (inp.next().equals("y")) {
            listStudent.delete();
            listStudent.showStudentList();
        } else {
            System.out.println("Ничего не удалено!");
        }
    }

    private static Student createStudent() {
        String surname, name, birthday = "";
        int course, studentTicket;
        Scanner sc = new Scanner(System.in);
        String surnaneArr[] = {"Иваненко", "Петренко", "Зубович", "Григор", "Копыл", "Котляр", "Скляр"};
        String nameArr[] = {"Иван", "Сергей", "Ольга", "Игорь", "Анна", "Николай", "Нина", "Алла"};
        surname = surnaneArr[(int) (Math.random() * 100) % surnaneArr.length];
        name = nameArr[(int) (Math.random() * 100) % nameArr.length];

        while (true) {
            System.out.print("\nВведите номер студенческого билета: ");
            try {
                studentTicket = sc.nextInt();
                if (studentTicket > 0) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Необходимо ввести целое число! ");
                sc.next();
                
            }
        }

        while (true) {
            System.out.print("Введите номер курса: ");
            try {
                course = sc.nextInt();
                if (course > 0 && course < 7) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Необходимо ввести целое число! ");
                sc.next();
            }
        }

        int day, month, year;

        while (true) {
            System.out.print("Введите число рождения: ");
            try {
                day = sc.nextInt();
                if (day > 0 && day <= 31) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Необходимо ввести целое число! ");
                sc.next();
            }
        }

        while (true) {
            System.out.print("Введите месяц рождения: ");
            try {
                month = sc.nextInt();
                if (month > 0 && month <= 12) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Необходимо ввести целое число! ");
                sc.next();
            }
        }

        while (true) {
            System.out.print("Введите год рождения: ");
            try {
                year = sc.nextInt();
                if (year > 1950 && year <= 1996) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Необходимо ввести целое число! ");
                sc.next();
            }
        }

        if (day < 10) {
            birthday += "0";
        }
        birthday += day + ".";
        if (month < 10) {
            birthday += "0";
        }
        birthday += month + "." + year;

        return new Student(surname, name, course, studentTicket, birthday);
    }
}