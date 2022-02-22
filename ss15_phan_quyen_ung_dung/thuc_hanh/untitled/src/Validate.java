import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class Validate {
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

    public static Boolean checkDateContract(Date startDate, Date endDate) {
        boolean flag;
        if (startDate.compareTo(endDate) > 0) {
            flag = false;
        } else if (startDate.compareTo(endDate) < 0) {
            flag = true;
        } else {
            flag = true;
        }
        return flag;
    }
}
