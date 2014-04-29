package course2_laba5;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    class Node {

        Student studentData;
        String key;
        Node right, left;

        Node(Student data) {
            studentData = data;
            key = studentData.name;
            right = null;
            left = null;
        }
    }
    Node root;

    BST() {
        root = null;
    }

    private boolean less(String k1, String k2) {
        if (k1.compareTo(k2) < 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean equalsKey(String k1, String k2) {
        if (k1.compareTo(k2) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Student search(String key) {
        Node current = root;
        while (current != null) {
            if (equalsKey(key, current.key)) {
                return current.studentData;
            } else if (less(key, current.key)) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public void rootInsert(Student val) {
        String keyVal = val.name;
        root = rootInsertNode(root, keyVal, val);
    }

    private Node rootInsertNode(Node current, String key, Student val) {
        if (current == null) {
            return new Node(val);
        }
        if (less(key, current.key)) {
            current.left = rootInsertNode(current.left, key, val);
            current = rotateRight(current);
        } else {
            current.right = rootInsertNode(current.right, key, val);
            current = rotateLeft(current);
        }
        return current;
    }

    public void insertSplay(Student val) {
        Node newNode = new Node(val);
        root = insertSplayNode(root, newNode);
    }

    private Node insertSplayNode(Node current, Node newNode) {
        if (current == null) {
            return newNode;
        }

        if (less(newNode.key, current.key)) {
            if (current.left == null) {
                current.left = newNode;
                current = rotateRight(current);
            } else {
                if (less(newNode.key, current.left.key)) {
                    current.left.left = insertSplayNode(current.left.left, newNode);
                    current = rotateRight(current);
                } else {
                    current.left.right = insertSplayNode(current.left.right, newNode);
                    current.left = rotateLeft(current.left);
                    current = rotateRight(current);
                }
            }
        } 
        
        else {
            if (current.right == null) {
                current.right = newNode;
                current = rotateLeft(current);
            } else {
                if (less(current.right.key, newNode.key)) {
                    current.right.right = insertSplayNode(current.right.right, newNode);
                    current = rotateLeft(current);
                } else {
                    current.right.left = insertSplayNode(current.right.left, newNode);
                    current.right = rotateRight(current.right);
                    current = rotateLeft(current);
                }
            }
        }

        return current;
    }

    private Node rotateLeft(Node current) {
        Node temp = current.right;
        current.right = temp.left;
        temp.left = current;
        return temp;
    }

    private Node rotateRight(Node current) {
        Node temp = current.left;
        current.left = temp.right;
        temp.right = current;
        return temp;
    }

    public void printNode(Student stud) {
        if (stud != null) {
            System.out.println("\nВ BST есть узел с таким ключом:");
            System.out.println("|------|---------------|---------------|-----|--------|-----------|");
            stud.printStudent(1);
        } else {
            System.out.println("В BST нету узла с именем Иван" );
        }
    }

    //обход в ширину в табличном виде
    public void printStudentList(Node root) {
        Queue<Node> level = new LinkedList<>();
        level.add(root);
        int i = 1;
        while (!level.isEmpty()) {
            Node node = level.poll();
            node.studentData.printStudent(i);
            i++;
            if (node.left != null) {
                level.add(node.left);
            }
            if (node.right != null) {
                level.add(node.right);
            }
        }
    }
    //обход в ширину выводит только ключи с отступами 
    public void print(){
        printNode(root, 0);
    }
    
    private void printNode(Node node, int h) {
        if(node != null) {
            for(int i = 0; i < h ; i++) {
                System.out.print("   ");
            }
            System.out.println(node.key);
            printNode(node.left, h+1);
            printNode(node.right, h+1);
        }
    }

    //обход в ширину выводит только ключи
    public void printBSTkey(Node current) {

        Queue<Node> queue = new LinkedList<Node>();
        Queue<Integer> levels = new LinkedList<Integer>();
        queue.add(current);
        levels.add(0);
        int lastLevel = 0;
        while (queue.size() > 0) {
            Node node = queue.remove();
            int level = levels.remove();

            if (level != lastLevel) {
                System.out.println();
                lastLevel = level;
            }

            System.out.print(node.key + "   ");

            if (node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }
        }
    }
}
//
//public void printNode(Node tmpRoot) {
//
//        Queue<Node> currentLevel = new LinkedList<Node>();
//        Queue<Node> nextLevel = new LinkedList<Node>();
//
//        currentLevel.add(tmpRoot);
//
//        while (!currentLevel.isEmpty()) {
//            Iterator<Node> iter = currentLevel.iterator();
//            while (iter.hasNext()) {
//                Node currentNode = iter.next();
//                if (currentNode.left != null) {
//                    nextLevel.add(currentNode.left);
//                }
//                if (currentNode.right != null) {
//                    nextLevel.add(currentNode.right);
//                }
//                System.out.print(currentNode.key + "   ");
//            }
//            System.out.println();
//            currentLevel = nextLevel;
//            nextLevel = new LinkedList<Node>();
//
//        }
//    }
//обход в глубину
//    private void printNode(Node elem, int h) {
//        if (elem != null) {
//            for (int i = 0; i < h; i++) {
//                System.out.print(" ");
//            }
//            System.out.println(elem.key);
//            printNode(elem.left, h + 1);
//            printNode(elem.right, h + 1);
//        }
//}
//    public boolean addStudent(Student element) {
//        Node newNode = new Node(element);
//        if (root == null) {
//            root = newNode;
//        } else {
//            return insertStudent(root, newNode);
//        }
//        return true;
//    }
//    
//    
//
//    public boolean insertStudent(Node current, Node element) {
//        while (true) {
//            if (current.key.compareTo(element.key ) > 0) {
//                if (current.left == null) {
//                    current.left = element;
//                    break;
//                } else {
//                    current = current.left;
//                }
//            } else if (current.key.compareTo(element.key) <= 0) {
//                if (current.right == null) {
//                    current.right = element;
//                    break;
//                } else {
//                    current = current.right;
//                }
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

