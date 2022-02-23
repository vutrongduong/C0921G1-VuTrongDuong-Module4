package vn.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.User;
import vn.codegym.model.employee.Division;
import vn.codegym.model.employee.EducationDegree;
import vn.codegym.model.employee.Position;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class EmployeeDto implements Validator {

    private Long employeeId;
    @NotEmpty(message = "PLease input name")
    private String employeeName;
    @NotNull(message = "PLease input birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;
    @Pattern(regexp = "^\\d{12}|\\d{9}$", message = "Invalid id card format")
    private String employeeIdCard;
    @NotNull(message = "PLease input salary")
    @Pattern(regexp = "^([1-9])([0-9]*)$", message = "Salary must be a positive integer")
    private String employeeSalary;
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91){1}\\d{7}$", message = "Invalid phone format")
    private String employeePhone;
    @NotEmpty(message = "PLease input email")
    @Email(message = "Invalid email format")
    private String employeeEmail;
    @NotEmpty(message = "PLease input address")
    private String employeeAddress;
    @NotNull(message = "Please select position")
    private Position position;
    @NotNull(message = "Please select education degree")
    private EducationDegree educationDegree;
    @NotNull(message = "Please select division")
    private Division division;
    @NotNull(message = "Please input user")
    private User user;

    public EmployeeDto() {
    }

    public EmployeeDto(Long employeeId, @NotEmpty(message = "PLease input name") String employeeName, @NotNull(message = "PLease input birthday") Date employeeBirthday, @Pattern(regexp = "^\\d{12}|\\d{9}$", message = "Invalid id card format") String employeeIdCard, @NotNull(message = "PLease input salary") @Pattern(regexp = "^([1-9])([0-9].*)$", message = "Salary must be a positive integer") String employeeSalary, @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91){1}\\d{7}$", message = "Invalid phone format") String employeePhone, @NotEmpty(message = "PLease input email") @Email(message = "Invalid email format") String employeeEmail, @NotEmpty(message = "PLease input address") String employeeAddress, @NotNull(message = "Please select position") Position position, @NotNull(message = "Please select education degree") EducationDegree educationDegree, @NotNull(message = "Please select division") Division division, User user) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static boolean checkDate(Date ngaySinh) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(ngaySinh);
        LocalDate date = LocalDate.of(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH) + 1,
                cal.get(Calendar.DAY_OF_MONTH));
        boolean flag = false;
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(date, currentDate).getYears();
        if (age < 100 && age >= 18) {
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (!checkDate(employeeDto.employeeBirthday)) {
            errors.rejectValue("employeeBirthday", "birthDay", "Employee is under 18 years old");
        }
    }
}
