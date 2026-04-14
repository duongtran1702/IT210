package atmin.theory.dto;

import atmin.theory.model.Gender;
import org.springframework.web.multipart.MultipartFile;

public class StudentDTO {
    private Long id;
    private String name;
    private Integer age;
    private Gender gender;
    private MultipartFile avatar;

    public StudentDTO() {}

    public StudentDTO(Long id, String name, Integer age, Gender gender) {
        this(id, name, age, gender, null);
    }

    public StudentDTO(Long id, String name, Integer age, Gender gender, MultipartFile avatar) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
