import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
 
public class GregorianCalendar {
     private List<Month> leapYear = new ArrayList<Month>();
     public void setMonths() {
         for(int month = 1; month < 13; month++) {
             leapYear.add(Month.of(month));
         }
     }
     public void daysOfTheMonth(int month) {
         Month whichMonth = leapYear.get(month);
         switch(whichMonth.getDisplayName(TextStyle.FULL, Locale.ENGLISH)) {
         case "April":
         case "June":
         case "September":
         case "November":
                   System.out.println(whichMonth.getDisplayName(TextStyle.FULL, 
                                                     Locale.ENGLISH) + " = 30 days");
                                                     break;
         case "February":
                   System.out.println(whichMonth.getDisplayName(TextStyle.FULL, 
                                                     Locale.ENGLISH) + "  = 29 days");
                                                     break;
         default:
                    System.out.println(whichMonth.getDisplayName(TextStyle.FULL, 
                                                     Locale.ENGLISH) + "  = 31 days");
          }
     }
     public static void main(String[] args) {
         GregorianCalendar aCalendar = new GregorianCalendar();
         aCalendar.setMonths();
         for(int i = 0; i < aCalendar.leapYear.size(); i++)
             aCalendar.daysOfTheMonth(i);
     }
}
