package course2_laba4;

import java.util.Formatter;

public class Student {

    String surname, name;
    int numberAllClasses, numberMissedClasses;

    Student(String surname, String name, int numberAllClasses, int numberMissedClasses) {
        this.surname = surname;
        this.name = name;
        this.numberAllClasses = numberAllClasses;
        this.numberMissedClasses = numberMissedClasses;
    }
    
    public double calculateIndex(){
        double index = (double)numberMissedClasses/numberAllClasses; 
        return index;
    }  
    
    public void printStudent() {
        Formatter prin = new Formatter();
        prin.format("|%-15s|%-15s|%-12d|%-20d|%-10f", surname, name, numberAllClasses, numberMissedClasses, calculateIndex());
        System.out.println(prin);
        System.out.println("|---------------|---------------|------------|--------------------|");
    }   
}  
   



//    private String getSurname() {
//        System.out.print("Введите Фамилию студента: ");
//        surname = sc.nextLine();
//        return surname;
//    }
//    
//    private String getName() {
//        System.out.print("Введите Имя студента: ");
//        name = sc.nextLine();
//        return name;
//    }
//
//    private int getNumberAllClasses() {
//        while (true) {
//            try {
//                System.out.print("Введите  количество Всех занятий: ");
//                numberAllClasses = sc.nextInt();
//                if(numberAllClasses > 0)
//                    return numberAllClasses;
//            } catch (InputMismatchException e) {
//                System.out.println("Ошибка!!! Необходимо ввести целое позитивное число! ");
//                sc.next();
//            }
//        }
//    }
//    
//    private int getNumberMissedClasses() { 
//        while (true) {
//            try {
//                System.out.print("Введите  количество Пропущенных занятий: ");
//                numberMissedClasses = sc.nextInt();
//                if(numberMissedClasses >= 0)
//                    return numberMissedClasses;
//            } catch (InputMismatchException e) {
//                System.out.println("Ошибка!!! Необходимо ввести целое позитивное число! ");
//                sc.next();
//            }
//        }
//    }

  

