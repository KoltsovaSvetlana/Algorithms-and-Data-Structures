package course2_laba2;

import java.util.Formatter;

public class HashTable {

    private Triangle hash[];
    int lengthTable;

    HashTable(int length) {
        hash = new Triangle[length];
        lengthTable = length;
    }

    private int calculateKey(Triangle tr) {
        double f = (tr.key * 0.6180339887499) % 1;
        int key = (int) (f * hash.length);
        return key;
    }

    public boolean insert(Triangle tr) {
        int key = calculateKey(tr);
        if (hash[key] == null) {
            hash[key] = tr;
            return true;
        }
        return false;
    }

    public boolean insertWithCollision(Triangle tr) {
        int key = calculateKey(tr);
        int index;
        for (int p = 0; p < hash.length; p++) {
            index = (key + p) % hash.length;
            if (hash[index] == null) {
                hash[index] = tr;
                return true;
            }
        }
        return false;
    }

    public void showHashTable() {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == null) {
                System.out.println(i + " : --->;");
            } else {
                Formatter forma = new Formatter();
                forma.format(i + " : key = %.2f; A = ( %.2f, %.2f);"
                        + " B = ( %.2f, %.2f); C = ( %.2f, %.2f); P = %.2f;\n",
                        hash[i].key, hash[i].x1, hash[i].y1,
                        hash[i].x2, hash[i].y2, hash[i].x3, hash[i].y3, hash[i].calculatePerimeter());
                System.out.print(forma);
            }
        }
    }

    public void delete(double valueDel) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i].calculatePerimeter() > valueDel) {
                hash[i] = null;
            }
        }
    }
}

