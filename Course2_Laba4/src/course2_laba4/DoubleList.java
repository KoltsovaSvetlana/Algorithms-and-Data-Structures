package course2_laba4;

public class DoubleList {

   class ElementList {

        ElementList next;
        ElementList previous;
        Student data;

        public ElementList(Student data) {
            next = null;
            previous = null;
            this.data = data;
        }
    }
    
    private ElementList first;
    private ElementList last;

    public DoubleList() {
        first = null; 
        last = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public int getSize() {
        int count = 0;
        ElementList current = first;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void add(Student student) {
        ElementList newNode = new ElementList(student);
        if(isEmpty()) {
            last = newNode;
            first = last;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("В списке нету записей!");
        } else {
            System.out.println("|---------------|---------------|------------|--------------------|");
            System.out.println("|    Фамилия    |      Имя      |К-во занятий|К-во пропущ. занятий|");
            System.out.println("|---------------|---------------|------------|--------------------|");
            ElementList current = first;
            while (current != null) {
                current.data.printStudent();
                current = current.next;
            }
        }
    }
    
    public ElementList getFirst(){
        return first;
    }
    
    public ElementList getLast(){
        return last;
    }

    public void setFirst(ElementList first){
        this.first = first; 
    }
    
    public void setLast(ElementList last){
        this.last = last;
    }
}


    