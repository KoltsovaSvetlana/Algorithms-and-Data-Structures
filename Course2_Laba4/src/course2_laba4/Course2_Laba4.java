package course2_laba4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Course2_Laba4 {

    public static void main(String[] args) { 
  
////////////////////////////////// Level 1 //////////////////////////////////////////////////       
        int lengthArray = getLengthArray();  
        Student arrayStudent[] = new Student[lengthArray]; 
        for (int i = 0; i < arrayStudent.length; i++) {  
            arrayStudent[i] = createStudent(); 
        }
        System.out.println("\n           ***** Список студентов до сортировки *****");
        Sorting listStudent1 = new Sorting(arrayStudent);
        listStudent1.printArrayStudent();
        System.out.println("\n      ***** Список студентов после сортировки вставкой *****");
        listStudent1.insertionSortArray();      
        listStudent1.printArrayStudent();
        
////////////////////////////////// Level 2 //////////////////////////////////////////////////       
        int countElement = numberElementList();  
        DoubleList listStud = new DoubleList(); 
        for (int i = 0; i < countElement; i++) {  
            listStud.add(createStudent()); 
        }
        System.out.println("\n           ***** Список студентов до сортировки *****");
        Sorting listStudent2 = new Sorting(listStud);
        listStudent2.printListStudent();
        System.out.println("\n      ***** Список студентов после сортировки вставкой *****");
        listStudent2.insertionSortList();      
        listStudent2.printListStudent();    
        
////////////////////////////////// Level 3 /////////////////////////////////////////////////
        
        lengthArray = getLengthArray();  
        Student arrayStudent3[] = new Student[lengthArray]; 
        for (int i = 0; i < arrayStudent3.length; i++) {  
            arrayStudent3[i] = createStudent(); 
        }
        System.out.println("\n           ***** Список студентов до сортировки *****");
        Sorting listStudent3 = new Sorting(arrayStudent3);
        listStudent3.printArrayStudent();
        System.out.println("\n      ***** Список студентов после карманной сортировки *****");
        listStudent3.bucketSortArray();
        listStudent3.printArrayStudent();
        
    }  
    
    private static int getLengthArray() {
        int lengthArray;
        Scanner scn = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите длинну массива студентов: ");
                lengthArray = scn.nextInt();
                if (lengthArray > 0) {
                    return lengthArray;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка!!! Необходимо ввести целое позитивное число! ");
                scn.next();
            }
        }
    }
    
    private static int numberElementList() {
        int count;
        Scanner scn = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите количество студентов, которых Вы хотитете добавить в список: ");
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
    
    private static Student createStudent(){
        String surname, name;
        int numberAllClasses, numberMissedClasses;
        String surnaneArr[] = {"Антипенко","Панчик","Иваненко","Кольцо","Петренко", "Зубович", "Григор", "Копыл", "Котляр", "Скляр", "Машай", "Василенко", "Бушта"};
        String nameArr[] = {"Иван", "Марина", "Сергей","Михаил", "Ольга", "Игорь", "Анна","Светлана", "Николай", "Нина", "Алла", "Максим", "Валерий", "Галина", "Антон", "Елена"};
        surname = surnaneArr[(int)(Math.random() * 100) % surnaneArr.length ];
        name = nameArr[(int)(Math.random() * 100) % nameArr.length];
        numberAllClasses = (int) (Math.random() * 100 + 60);
        numberMissedClasses = (int) (Math.random() * 40);
        return new Student(surname, name, numberAllClasses, numberMissedClasses);
    }
}
 