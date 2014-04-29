package course2_laba1;

public class SinglyLinkedList {

    private Node head;
    private int listCount;

    public SinglyLinkedList() {
        head = new Node(null);
        listCount = 0;
    }

    public boolean isEmpty() {
        return head.getNext() == null;
    }

// вставляет элемент в конец списка
    public boolean add(int data) {
        Node temp = new Node(data);
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
        return true;
    }

// возвращает элемент в указанной позиции в этом списке
    public Integer get(int index) {
        if (index <= 0) {
            return null;
        }
        Node current = head.getNext();
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        return current.getData();
    }

    @Override
    public String toString() {
        String output = "";
        if (isEmpty()) {
            output += "Linked list is empty!";
        } else {
            Node current = head.getNext();
            output += "Elements of linked list:\n";
            int i = 1;
            while (current != null) {
                output += "[" + i + "] = " + current.getData() + ";\n";
                current = current.getNext();
                i++;
            }
        }
        return output;
    }

// удаляет элемент в указанной позиции в этом списке
    public Integer remove(int index) {

        if (index < 1 || index > size()) {
            return null;
        }

        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        int delElement = current.getNext().getData();
        if (current.getNext().getNext() != null) {
            current.setNext(current.getNext().getNext());
        } else {
            current.setNext(null);
        }
        listCount--;
        return delElement;
    }

    public void showRemove(int index) {
        System.out.println("Delete " + index + " element :" + remove(index));
    }

    public int size() {
        return listCount;
    }

    public void showSize() {
        System.out.println("Linked list has " + size() + " elements!");
    }

    private class Node {

        Node next;
        Integer data;

        public Node(Integer _data) {
            next = null;
            data = _data;
        }

        public int getData() {
            return data;
        }

        public void setData(Integer _data) {
            data = _data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node _next) {
            next = _next;
        }
    }
}

