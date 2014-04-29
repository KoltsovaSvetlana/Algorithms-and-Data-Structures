package course2_laba6;

import java.util.Formatter;

public class Course2_Laba6 {

    public static void main(String[] args) {

//////////////////////////////// Level 1 ///////////////////////////////////////
        printHeadTable1();
        Formatter data;

        int lengthArray[] = {100, 1000, 10000, 100000, 1000000};
        SortShell arrShell;

        for (int j = 0; j < lengthArray.length; j++) {

            arrShell = new SortShell(createArray(lengthArray[j]));

            long sortingTime = calculateSortingTime(arrShell);

            data = new Formatter();
            data.format(" |      %-16d|      %-13d   |", lengthArray[j], sortingTime);
            System.out.println(data);
            System.out.println(" |----------------------|----------------------|");
        }

//////////////////////////////// Level 2 ///////////////////////////////////////

        printHeadTable2();
        int lengthArray2[] = {100, 10000, 1000000};
        int arraySort2[];

        SortShell arrShell2;
        SortInsert arrInsert2;

        for (int j = 0; j < lengthArray2.length; j++) {
            arraySort2 = createArray(lengthArray2[j]);

            arrShell2 = new SortShell(arraySort2);
            arrInsert2 = new SortInsert(arraySort2);

            long shellTime = calculateSortingTime(arrShell2);
            long insertTime = calculateSortingTime(arrInsert2);

            data = new Formatter();
            data.format(" |      %-16d|      %-18d   |      %-21d   |", lengthArray2[j], shellTime, insertTime);
            System.out.println(data);
            System.out.println(" |----------------------|---------------------------|------------------------------|");
        }
        
//////////////////////////////// Level 3 ///////////////////////////////////////
        
        int []arrSort3 = createArray(10000);
        
        SortShell arrShellS1 = new SortShell(arrSort3);
        SortInsert arrInsertS1 = new SortInsert(arrSort3);
        
        SortShell arrShellS2 = new SortShell(sortToMin(arrSort3));
        SortShell arrShellS3 = new SortShell(sortToMax(arrSort3));
        
        
        SortInsert arrInsertS2 = new SortInsert(sortToMin(arrSort3));
        SortInsert arrInsertS3 = new SortInsert(sortToMax(arrSort3)); 
        
        System.out.println("Время выполнения сортировки Шелла для неупорядоченного массива :               " + calculateSortingTime(arrShellS1));
        System.out.println("Время выполнения сортировки вставкой для неупорядоченного массива :            " + calculateSortingTime(arrInsertS1));
        System.out.println("Время выполнения сортировки Шелла для упорядоченного  по убыванию массива :    " + calculateSortingTime(arrShellS2));
        System.out.println("Время выполнения сортировки вставкой для упорядоченного  по убыванию массива : " + calculateSortingTime(arrInsertS2));
        System.out.println("Время выполнения сортировки Шелла для упорядоченного массива :                 " + calculateSortingTime(arrShellS3));
        System.out.println("Время выполнения сортировки вставкой для упорядоченного массива :              " + calculateSortingTime(arrInsertS3));
        System.out.println("\n\n");
        
        
    }

    private static int[] createArray(int lengthArr) {
        int[] array = new int[lengthArr];
        for (int i = 0; i < lengthArr; i++) {
            array[i] = (int) (Math.random() * 1000000);
        }
        return array;
    }

    private static void printHeadTable1() {
        System.out.println("Зависимость время выполнения сортировки Шелла от количества элементов в массиве:");
        System.out.println(" |----------------------|----------------------|");
        System.out.println(" | Количество элементов | Время сортировки, нс |");
        System.out.println(" |----------------------|----------------------|");
    }

    private static void printHeadTable2() {
        System.out.println("Зависимость время выполнения сортировки Шелла и сортировки вставкой от количества элементов в массиве:");
        System.out.println(" |----------------------|---------------------------|------------------------------|");
        System.out.println(" | Количество элементов | Время сортировки Шелла,нс | Время сортировки вставкой,нс |");
        System.out.println(" |----------------------|---------------------------|------------------------------|");
    }

    private static long calculateSortingTime(SortShell arr) {
        long sortingTime = System.nanoTime();
        arr.sortShellArray();
        sortingTime = System.nanoTime() - sortingTime;
        return sortingTime;
    }

    private static long calculateSortingTime(SortInsert arr) {
        long sortingTime = System.nanoTime();
        arr.sortInsertionArray();
        sortingTime = System.nanoTime() - sortingTime;
        return sortingTime;
    }

    private static int[] sortToMax(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    private static int[] sortToMin(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i-1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
//проверка  работы сортировок
//        int lengthArray = 20;
//        int array[] = new int[lengthArray];
//        for(int i = 0; i < lengthArray; i++){
//            array[i] = (int)(Math.random()*100000);
//        }
//        
//        SortShell sort1 = new SortShell(array);
//        sort1.printArr();
//        sort1.sotrShellArray();
//        System.out.println("Массив отсортирован с помощью сортировки Шелла:");
//        sort1.printArr();
//        
//        SortInsert sort2 = new SortInsert(array);
//        sort2.printArr();
//        sort2.sortInsertionArray();
//        System.out.println("Массив отсортирован с помощью сортировки вставками:");
//        sort2.printArr();

