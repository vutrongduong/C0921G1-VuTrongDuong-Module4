package vn.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.model.contract_detail.Contract;
import vn.codegym.model.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class CustomerDto implements Validator {
    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Customer ID has the format KH-XXXX (X is number from 0-9)")
    private String customerId;
    @NotNull(message = "Please select customer type")
    private CustomerType customerType;
    @NotEmpty(message = "PLease input name")
    private String customerName;
    @NotNull(message = "PLease input birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerBirthday;
    @NotNull(message = "Please select your gender")
    private Boolean customerGender;
    @Pattern(regexp = "^\\d{12}|\\d{9}$", message = "Invalid id card format")
    private String customerIdCard;
    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91){1}\\d{7}$", message = "Invalid phone format")
    private String customerPhone;
    @NotEmpty(message = "PLease input email")
    @Email(message = "Invalid email format")
    private String customerEmail;
    @NotEmpty(message = "PLease input address")
    private String customerAddress;
    private Contract contract;

    public CustomerDto() {
    }

    public CustomerDto(@Pattern(regexp = "^KH-[0-9]{4}$") String customerId, @NotEmpty CustomerType customerType, @NotEmpty String customerName, Date customerBirthday, Boolean customerGender, @Pattern(regexp = "^\\d{12}|\\d{9}$") String customerIdCard, @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91){1}\\d{7}$") String customerPhone, @Email String customerEmail, @NotEmpty String customerAddress, Contract contract) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.contract = contract;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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
        CustomerDto customerDto = (CustomerDto) target;
        if (!checkDate(customerDto.customerBirthday)) {
            errors.rejectValue("customerBirthday","birthDay","Customer is under 18 years old");
        }
    }
}
