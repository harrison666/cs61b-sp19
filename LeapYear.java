/** To check whether the year is leap year. A leap year is either 
divisible by 400 or divisible by 4 and not by 100.*/
public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }else if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }else{
            return false;
        }
    }
}