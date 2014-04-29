package course2_laba5;

public class ArrayStudent {

    Student arrayStud[];
    int lastIndex;

    ArrayStudent(int lengthArray) {
        arrayStud = new Student[lengthArray];
        lastIndex = -1;
    }

    public boolean addStudent(Student student) {
        if (lastIndex == arrayStud.length + 1) {
            return false;
        } else {
            arrayStud[++lastIndex] = student;
            return true;
        }
    }

    public int searchStudent(int course, String gender, String hostel) {
        int index = -1;
        for (int i = 0; i <= lastIndex; i++) {
            if (arrayStud[i].course == course && arrayStud[i].gender.equals(gender)
                    && arrayStud[i].hostel.equals(hostel)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void deleteStudent(int course, String gender, String hostel) {
        while (true) {
            int indexDel = searchStudent(course, gender, hostel);
            if (indexDel != -1) {
                for (int i = indexDel; i < lastIndex; i++) {
                    arrayStud[i] = arrayStud[i + 1];
                }
                arrayStud[lastIndex] = null;
                lastIndex--;
            } else {
                break;
            }
        }
    }

    public void printArrayStudent() {
        System.out.println("|------|---------------|---------------|-----|--------|-----------|");
        System.out.println("|Номер |    Фамилия    |      Имя      |Курс |   Пол  | Общежитие |");
        System.out.println("|------|---------------|---------------|-----|--------|-----------|");
        for (int i = 0; i <= lastIndex; i++) {
            arrayStud[i].printStudent(i + 1);
        }
    }
}
