package course2_laba3;

import java.util.Formatter;

class Student {

    String surname, name, birthday;
    int course, studentTicket;

    Student(String surname, String name, int course, int studentTicket, String birthday) {
        this.surname = surname;
        this.name = name;
        this.course = course;
        this.studentTicket = studentTicket;
        this.birthday = birthday;
    }
    
    public void showStudent(){
        Formatter dataStudent = new Formatter();
        dataStudent.format("|%-9d|%-15s|%-15s|%-6d|%-15s|", studentTicket, surname, name, course, birthday);
        System.out.println( dataStudent );
        System.out.println("|---------|---------------|---------------|------|---------------|");
    }
}