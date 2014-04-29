package course2_laba5;

import java.util.Formatter;

public class Student {

    String surname, name, gender, hostel;
    int course;

    Student(String surname, String name, int course, String gender, String hostel) {
        this.surname = surname;
        this.name = name;
        this.course = course;
        this.gender = gender;
        this.hostel = hostel;
    }

    public void printStudent(int i) {
        Formatter data = new Formatter();
        data.format("|%-6d|%-15s|%-15s|%-5d|%-8s|%-11s|", i, surname, name, course, gender, hostel);
        System.out.println(data);
        System.out.println("|------|---------------|---------------|-----|--------|-----------|");
    }
}
