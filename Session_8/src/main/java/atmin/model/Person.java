package atmin.model;

import java.time.LocalDate;

public class Person {
    int id;
    String name;
    String email;
    LocalDate birthDate;
    boolean gender;

    public Person(int id, String name, String email, LocalDate birthDate, boolean gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
