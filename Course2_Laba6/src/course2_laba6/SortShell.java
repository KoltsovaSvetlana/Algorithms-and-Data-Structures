package course2_laba6;

public class SortShell {

    private int[] array;

    SortShell(int[] arr) {
        array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
    }

    public void sortShellArray() {
        int temp;
        int i, j;
        int h = 1;
        while (h <= array.length / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (i = h; i < array.length; i++) {
                temp = array[i];
                j = i;
                while ((j > h - 1) && (array[j - h] >= temp)) {
                    array[j] = array[j - h];
                    j = j - h;
                }
                array[j] = temp;
            }
            h = (h - 1) / 3;
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
