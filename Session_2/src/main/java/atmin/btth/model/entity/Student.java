package atmin.btth.model.entity;

public class Student {
    public String id;
    public String name;
    public String faculty;
    public int year;
    public double gpa;

    public Student(String id, String name, String faculty, int year, double gpa) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.year = year;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear() {
        return year;
    }

    public double getGpa() {
        return gpa;
    }
}
