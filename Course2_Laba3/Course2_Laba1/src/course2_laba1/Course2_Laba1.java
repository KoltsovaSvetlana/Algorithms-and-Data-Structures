package course2_laba1;

import javax.swing.JOptionPane;

public class Course2_Laba1 {

    public static void main(String[] args) {
//************************************* Level 1 *************************************
        int length_s = 0;

        while (length_s == 0) {
            length_s = getSize("стека");
        }

        Stack stack = new Stack(length_s);
        for (int i = 0; i < length_s; i++) {
            int elem = getElement();
            stack.push(elem);
        }
        System.out.println("\n\n************************ Level 1 ************************");
        System.out.println("After create stack ...");
        stack.showStack();

        stack.pop();
        stack.pop();
        System.out.println("After remove 2 elements from stack ...");
        stack.showStack();
        System.out.println("\n\n");

//************************************* Level 2 *************************************
        SinglyLinkedList list = new SinglyLinkedList();
        int length_sp = 0;

        while (length_sp == 0) {
            length_sp = getSize("списка");
        }

        for (int i = 0; i < length_sp; i++) {
            int elem = getElement();
            list.add(elem);
        }
        System.out.println("************************ Level 2 ************************");
        System.out.println("After create linked list ...");
        System.out.println(list.toString());

        System.out.println("Deleted third element: " + list.remove(3));
        System.out.println("Deleted first element: " + list.remove(1));
        System.out.println("\nAfter remove elements from linked list ...");
        System.out.println(list.toString() + "\n\n");

//************************************* Level 3 *************************************   
        int lengthSt = list.size();
        int elementList;
        int elementStack;
        Stack stack2 = new Stack(lengthSt);
        System.out.println("************************ Level 3 ************************");
        for (int i = 1; i <= lengthSt; i++) {
            elementList = list.get(i);
            if (elementList < 0) {
                elementStack = -list.remove(i);
                stack2.push(elementStack);
                i--;
                lengthSt--;
            }
        }

        System.out.println(list.toString());
        stack2.showStack();
    }

    private static int getSize(String name) {
        int length_s = 0;

        try {
            length_s = Integer.valueOf(JOptionPane.showInputDialog("Введите длину " + name + " : "));

            if (length_s < 0) {
                return getSize(name);
            }
        } catch (Exception e) {
            System.out.println("Неверное значение! Ошибка: " + e.toString());
        }

        return length_s;
    }

    private static int getElement() {
        int element = 0;

        try {
            element = Integer.valueOf(JOptionPane.showInputDialog("Введите елемент в стек: "));
        } catch (Exception e) {
            System.out.println("Неверное значение! Ошибка: " + e.toString());
        }

        return element;
    }

}