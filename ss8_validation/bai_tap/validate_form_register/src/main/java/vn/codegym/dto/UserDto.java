package vn.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Long id;
    @NotBlank(message = "không được để trống")
    @Size(min = 5, max = 45, message = " có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;
    @NotBlank(message = "không được để trống")
    @Size(min = 5, max = 45, message = " có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;
    private String phone;
    @Min(value = 18, message = "tuổi phải >=18")
    private Integer age;
    @Email(message = "không đúng quy tắc của email")
    private String email;

    public UserDto() {
    }

    public UserDto(@NotBlank(message = "không được để trống") @Size(min = 5, max = 45, message = " có độ dài tối thiểu 5, tối đa 45 ký tự") String firstName, @NotBlank(message = "không được để trống") @Size(min = 5, max = 45, message = " có độ dài tối thiểu 5, tối đa 45 ký tự") String lastName, @Size(min = 10, max = 12) @Pattern(regexp = "^0[0-9]*$", message = "Không đúng định dạng số điện thoại") String phone, @Min(value = 18, message = "Age >=18") Integer age, @Email(message = "không đúng quy tắc của email") String email) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phone = userDto.getPhone();
        ValidationUtils.rejectIfEmpty(errors, "phone", "phone.empty");
        if (phone.length()>11 || phone.length()<10){
            errors.rejectValue("phone", "phone.length");
        }
        if (!phone.startsWith("0")){
            errors.rejectValue("phone", "phone.startsWith");
        }
        if (!phone.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone", "phone.matches");
        }
    }
}
