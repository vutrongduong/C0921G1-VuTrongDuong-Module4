import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        Date date = new Date("02/23/2004");
//        System.out.println(Validate.checkDate(date));
        Date start =new Date("2000/01/22");
        Date end =new Date("2000/01/26");
        Boolean flag = Validate.checkDateContract(start,end);
        System.out.println(flag);
    }
}
