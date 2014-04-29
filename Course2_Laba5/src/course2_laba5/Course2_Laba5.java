package course2_laba5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Course2_Laba5 {

    public static void main(String[] args) {
//////////////////////// Level 1 //////////////////////////////
        System.out.println("-----------------------   Level 1  ---------------------");
        int lengthArr = getLength();
        ArrayStudent arrStudent = new ArrayStudent(lengthArr);
        for (int i = 0; i < lengthArr; i++) {
            arrStudent.addStudent(createStudent());
        }
        arrStudent.printArrayStudent();
        arrStudent.deleteStudent(6, "мужской", "да");
        System.out.println("\n\n************************  После удаления  ************************");
        arrStudent.printArrayStudent();

//////////////////////// Level 2 //////////////////////////////
        System.out.println("-----------------------   Level 2  ---------------------");
        int count = getCount();
        BST tree = new BST();
        for (int i = 0; i < count; i++) {
            tree.rootInsert(createStudent());
            tree.print();
            System.out.println("\n*************************************");
        }
        System.out.println("\n|------|---------------|---------------|-----|--------|-----------|");
        tree.printStudentList(tree.root);
        
        tree.printNode(tree.search("Иван"));

//////////////////////// Level 3 //////////////////////////////
        System.out.println("-----------------------   Level 3  ---------------------");
        count = getCount();
        BST treeBalanced = new BST();
        for (int i = 0; i < count; i++) {
            treeBalanced.insertSplay(createStudent());
            treeBalanced.print();
            System.out.println("\n*************************************");
        }
        System.out.println("\n|------|---------------|---------------|-----|--------|-----------|");
        treeBalanced.printStudentList(treeBalanced.root);
        
        treeBalanced.printNode(treeBalanced.search("Иван"));

    }
    

    private static int getLength() {
        Scanner scn = new Scanner(System.in);
        int length;
        while (true) {
            try {
                System.out.println("Введите длинну массива студентов: ");
                length = scn.nextInt();
                if (length > 0) {
                    return length;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка!!! Необходимо ввести целое позитивное число! ");
                scn.next();
            }
        }
    }

    private static int getCount() {
        Scanner scn = new Scanner(System.in);
        int count;
        while (true) {
            try {
                System.out.println("Введите количество студентов, которых нужно добавить в BST: ");
                count = scn.nextInt();
                if (count > 0) {
                    return count;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка!!! Необходимо ввести целое позитивное число! ");
                scn.next();
            }
        }
    }

    private static Student createStudent() {
        String surname, name, gender, hostel;
        int course;
        String surnaneArr[] = {"Антипенко", "Панчик", "Иваненко", "Кольцо", "Петренко", "Зубович", "Григор", "Копыл", "Котляр", "Скляр", "Машай", "Василенко", "Бушта"};
        String nameArr[] = {"Иван", "Марина", "Сергей", "Михаил", "Ольга", "Игорь", "Анна", "Светлана", "Николай", "Нина", "Алла", "Максим", "Валерий", "Галина", "Антон", "Елена"};
        String hostelArr[] = {"да", "нет"};
        surname = surnaneArr[(int) (Math.random() * 100) % surnaneArr.length];
        name = nameArr[(int) (Math.random() * 100) % nameArr.length];
        course = (int) (Math.random() * 100) % 6 + 1;
        if (name == "Иван" || name == "Сергей" || name == "Михаил"
                || name == "Игорь" || name == "Николай" || name == "Максим"
                || name == "Валерий" || name == "Антон") {
            gender = "мужской";
        } else {
            gender = "женский";
        }
        hostel = hostelArr[(int) (Math.random() * 100) % hostelArr.length];
        return new Student(surname, name, course, gender, hostel);
    }
}
