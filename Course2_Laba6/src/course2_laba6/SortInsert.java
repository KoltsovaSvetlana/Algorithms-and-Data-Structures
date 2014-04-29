package course2_laba6;

public class SortInsert {

    private int[] array;

    SortInsert(int[] arr) {
        array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
    }

    public void sortInsertionArray() {
        int temp;
        int i, j;
        for (i = 1; i < array.length; i++) {
            temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    public void printArray() {
        System.out.print("A = ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\n");
    }
}
