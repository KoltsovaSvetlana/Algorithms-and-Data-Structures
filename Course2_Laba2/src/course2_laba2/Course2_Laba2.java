package course2_laba2;

import java.util.*;

public class Course2_Laba2 {

    public static void main(String[] args) {

//************************************* Level 1 *************************************
        System.out.println("\n\n*************************************** Level 1 "
                + "***************************************\n");
        int length1 = getSize();
        HashTable hash1 = new HashTable(length1);
        int count1 = getCountElement();
        while (count1 > length1) {
            count1 = getCountElement();
        }

        for (int j = 0; j < count1; j++) {
            hash1.insert(getElement());
        }
        System.out.println("\nHash table with open addressing : ");
        hash1.showHashTable();

//************************************* Level 2 *************************************
        System.out.println("\n\n*************************************** Level 2 "
                + "***************************************\n");
        int length2 = getSize();
        HashTable hash2 = new HashTable(length2);
        int count2 = getCountElement();
        while (count2 > length2) {
            count2 = getCountElement();
        }

        for (int i = 0; i < count2; i++) {
            hash2.insertWithCollision(getElement());
        }
        System.out.println("\nHash table with multiplicative zondyrovanyem : ");
        hash2.showHashTable();

//************************************* Level 3 *************************************
        System.out.println("\n\n*************************************** Level 3 "
                + "***************************************\n");
        int length3 = getSize();
        HashTable hash3 = new HashTable(length3);
        int count3 = getCountElement();
        while (count3 > length3) {
            count3 = getCountElement();
        }

        for (int i = 0; i < count3; i++) {
            hash3.insertWithCollision(getElement());
        }
        System.out.println("\nHash table with multiplicative zondyrovanyem : ");
        hash3.showHashTable();

        double perimeter = getPerimeter();
        hash3.delete(perimeter);
        System.out.println("\nAfter delete elements with perimeter more than " + perimeter + " from hash table :");
        hash3.showHashTable();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

    private static int getSize() {
        System.out.print("The dimension of tables -> ");
        int dimension;
        Scanner in = new Scanner(System.in);

        try {
            dimension = in.nextInt();

            if (dimension < 0) {
                return getSize();
            }
            return dimension;
        } catch (Exception e) {
            System.out.print("Error! \nPlease enter a positive integer -> ");
            return getSize();
        }
    }

    private static int getCountElement() {
        System.out.print("How many elements do you want enter? Enter count -> ");
        int dimension;
        Scanner in = new Scanner(System.in);

        try {
            dimension = in.nextInt();

            if (dimension < 0) {
                return getCountElement();
            }
            return dimension;
        } catch (Exception e) {
            System.out.print("Error! \nPlease enter a positive integer -> ");
            return getCountElement();
        }
    }

    private static Triangle getElement() {
        double[] coord = new double[6];
        for (int i = 0; i < 6; i++) {
            coord[i] = Math.random() * 100;
        }
        Triangle element = new Triangle(coord[0], coord[1], coord[2], coord[3], coord[4], coord[5]);
        while (!element.isTriangle()) {
            element = getElement();
        }
        return element;
    }

    private static double getPerimeter() {
        System.out.print("\nEnter the value of P for delete -> ");
        double perimeter;
        Scanner in = new Scanner(System.in);

        try {
            perimeter = Double.parseDouble(in.nextLine());

            if (perimeter < 0) {
                return getPerimeter();
            }
            return perimeter;
        } catch (Exception e) {
            System.out.print("Error! \nPlease enter a positive double -> ");
            return getPerimeter();
        }
    }
}