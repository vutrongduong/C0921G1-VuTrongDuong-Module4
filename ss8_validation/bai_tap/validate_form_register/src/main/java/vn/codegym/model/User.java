package vn.codegym.model;

import javax.validation.constraints.*;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private Integer age;
    private String email;

    public User() {
    }

    public User(@NotBlank @Size(min = 5, max = 45) String firstName, @NotBlank @Size(min = 5, max = 45) String lastName, @Size(min = 10, max = 12) @Pattern(regexp = "^0[0-9]*$") String phone, @Min(18) Integer age, @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
