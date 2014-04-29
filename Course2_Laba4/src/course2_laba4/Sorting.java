package course2_laba4;

public class Sorting {

    public Student arrStud[];
    private DoubleList listStud;

    Sorting(Student array[]) {
        arrStud = array;
    }

    Sorting(DoubleList list) {
        listStud = list;
    }

    public void insertionSortArray() {
        Student temp;
        for (int i = 1; i < arrStud.length; i++) {
            temp = arrStud[i];
            for (int j = i - 1; j >= 0 && arrStud[j].calculateIndex() > temp.calculateIndex(); j--) {
                arrStud[j + 1] = arrStud[j];
                arrStud[j] = temp;
            }
        }
    }

    public void insertionSortList() {
        if (listStud.isEmpty()) {
            return;
        }
        DoubleList.ElementList curr;
        DoubleList.ElementList marker = listStud.getFirst().next;
        while (marker != null) {
            curr = marker;
            while (curr != null && curr.previous != null && curr.data.calculateIndex() < curr.previous.data.calculateIndex()) {
                swap(curr.previous, curr);
            }
            marker = marker.next;
        }
    }
    
    private void swap(DoubleList.ElementList node, DoubleList.ElementList node2) {
        if (node.previous != null) {
            node.previous.next = node2;
        } else {
            listStud.setFirst(node2);
        }
        if (node2.next != null) {
            node2.next.previous = node;
        }

        node.next = node2.next;
        node2.previous = node.previous;

        node2.next = node;
        node.previous = node2;
    }

    public void bucketSortArray() {
        class Share {

            Student dataSt;
            Share next;

            Share(Student st) {
                dataSt = st;
            }
        }

        Share bucket[] = new Share[10];
        Share newStud;
        int index;
        for (int i = 0; i < arrStud.length; i++) {
            index = (int) (arrStud[i].calculateIndex() * 10);
            newStud = new Share(arrStud[i]);
            if (bucket[index] == null) {
                bucket[index] = newStud;
            } else {
                Share cur = bucket[index];
                if (cur.dataSt.calculateIndex() > newStud.dataSt.calculateIndex()) {
                    newStud.next = cur;
                    bucket[index] = newStud;
                } else {
                    while (cur.next != null) {
                        if (cur.next.dataSt.calculateIndex() > newStud.dataSt.calculateIndex()) {
                            newStud.next = cur.next;
                            cur.next = newStud;
                            break;
                        } else {
                            cur = cur.next;
                        }
                    }
                    if (cur.next == null) {
                        cur.next = newStud;
                    }
                }
            }
        }

        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != null) {
                Share curr = bucket[i];
                while (curr != null) {
                    arrStud[index++] = curr.dataSt;
                    curr = curr.next;
                }
            }
        }
    }
    
    public void printListStudent() {
        listStud.printList();
    }

    public void printArrayStudent() {
        System.out.println("|---------------|---------------|------------|--------------------|");
        System.out.println("|    Фамилия    |      Имя      |К-во занятий|К-во пропущ. занятий|");
        System.out.println("|---------------|---------------|------------|--------------------|");
        for (int i = 0; i < arrStud.length; i++) {
            if (arrStud[i] != null) {
                arrStud[i].printStudent();
            }
        }
    }
}


