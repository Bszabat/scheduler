package scheduler;
import java.util.Arrays;
import java.util.List;
 
 
 public class App {
     public static void main(String[] args) throws Exception {
 
         Calendar calendar = new Calendar("09:00", "19:00", Arrays.asList(
             new String[]{"09:00", "10:30"},
             new String[]{"12:00", "13:00"},
             new String[]{"16:00", "18:00"}
             ));
         Calendar calendar2 = new Calendar("10:00", "20:30", Arrays.asList(
             new String[]{"10:00", "11:30"},
             new String[]{"12:30", "14:30"},
             new String[]{"14:30", "15:00"},
             new String[]{"16:00", "17:00"}
             ));
         List<int[]> commonSlots = calendar.findCommonFreeSlots(30, calendar2);
         calendar.printSlots(commonSlots);
     }
 }
 
