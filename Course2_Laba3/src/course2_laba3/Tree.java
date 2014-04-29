package course2_laba3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tree {

    class Node {

        Student dataStudent;
        Node left, right;

        Node(Student student) {
            this.dataStudent = student;
        }
    }
    Node root;

    Tree() {
        root = null;
    }

    public boolean addStudent(Student element) {
        Node newNode = new Node(element);
        if (root == null) {
            root = newNode;
        } else {
            return insertStudent(root, newNode);
        }
        return true;
    }

    public boolean insertStudent(Node current, Node element) {
        while (true) {
            if (current.dataStudent.studentTicket > element.dataStudent.studentTicket) {
                if (current.left == null) {
                    current.left = element;
                    break;
                } else {
                    current = current.left;
                }
            } else if (current.dataStudent.studentTicket < element.dataStudent.studentTicket) {
                if (current.right == null) {
                    current.right = element;
                    break;
                } else {
                    current = current.right;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void showStudentList() {
        System.out.println("|---------|---------------|---------------|------|---------------|");
        System.out.println("|  Номер  |    Фамилия    |      Имя      | Курс | Дата рождения |");
        System.out.println("|---------|---------------|---------------|------|---------------|");
        printElem(root);
    }

    private void printElem(Node el) {
        if (el != null) {
            printElem(el.left);
            printElem(el.right);
            el.dataStudent.showStudent();
        }
    }

    void delete() {
        Scanner sc = new Scanner(System.in);
        int course;
        while (true) {
            System.out.println("Введите критерий (номер курса) для удаления - ");
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
        root = delStudent(root, course);
    }

    private Node delStudent(Node current, int course) {
        if (current != null) {
            current.left = delStudent(current.left, course);
            current.right = delStudent(current.right, course);
            int month = Integer.parseInt(current.dataStudent.birthday.substring(3, 5));
            if ((month == 12 || month == 1 || month == 2)&& current.dataStudent.course == course) {
                if (current.left == null) {
                    current = current.right;
                    return current;
                } else if (current.right == null) {
                    current = current.left;
                    return current;
                } else {
                    current.right = replace(current, current.right);
                }
            }
        }
        return current;
    }

    private Node replace(Node firstNode, Node secondNode) {
        if (secondNode.left != null) {
            secondNode.left = replace(firstNode, secondNode.left);
        } else {
            firstNode.dataStudent.course = secondNode.dataStudent.course;
            firstNode.dataStudent.surname = secondNode.dataStudent.surname;
            firstNode.dataStudent.name = secondNode.dataStudent.name;
            firstNode.dataStudent.studentTicket = secondNode.dataStudent.studentTicket;
            firstNode.dataStudent.birthday = secondNode.dataStudent.birthday;
            secondNode = secondNode.right;
        }
        return secondNode;
    }

    public int createList() {
        int numberStudent = 0;
        Scanner scn = new Scanner(System.in);
        boolean marker = true;
        while (true) {
            System.out.print("\nВведите количество студентов:  ");
            try {
                numberStudent = scn.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("\nНеобходимо ввести целое число!");
                scn.next();
            }
            if (numberStudent > 0) {
                return numberStudent;
            }
        }
    }
}

