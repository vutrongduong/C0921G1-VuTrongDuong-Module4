package vn.codegym.model;


import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "positionId")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree_id",referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division division;
    @OneToOne
    @JoinColumn(name = "user_name",referencedColumnName = "userName")
    private User user;

    public Employee(int employeeId, String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Position position, EducationDegree educationDegree, Division division, User user) {
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
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
}
