package course2_laba1;

public class Stack {

    private String stack[];
    private int capStack = 0;

    public Stack(int cap) {
        stack = new String[cap];
    }

    public boolean isEmpty() {
        return capStack == 0;
    }

    public int numberElements() {
        return capStack;
    }

    public boolean push(int element) {
        if (capStack == stack.length || element <= 0) {
            return false;
        }
        String elem = "0" + Integer.toString(element, 8);
        stack[capStack++] = elem;
        return true;
    }

    public String pop() {
        if (capStack > 0) {
            String elementDel = stack[--capStack];
            stack[capStack] = null;
            return elementDel;
        }
        return null;
    }

    public void showStack() {
        if (capStack == 0) {
            System.out.println("Stack is empty! ");
        } else {
            System.out.println();
            System.out.println("Number of elements in stack: " + numberElements());
            System.out.println("Elements of stack: ");
            for (int i = capStack - 1; i >= 0; i--) {
                System.out.println("stack[ " + i + " ]" + " = " + stack[i]);
            }
            System.out.println();
        }
    }
}