import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date("02/23/2004");
        System.out.println(Validate.checkDate(date));
    }
}
