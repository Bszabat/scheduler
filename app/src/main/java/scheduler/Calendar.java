package scheduler;
import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private int start;
    private int end;
    private List<int[]> plannedMeetings;

    Calendar(String start, String end, List<String[]> plannedMeetings) {
        this.start = toMinutes(start);
        this.end = toMinutes(end);
        this.plannedMeetings = new ArrayList<>();
        for (String[] meeting : plannedMeetings) {
            this.plannedMeetings.add(new int[]{toMinutes(meeting[0]), toMinutes(meeting[1])});
        }
    }

    // Find free time slots in the calendar
    public List<int[]> findFreeSlots (int duration)  {
        List<int[]> freeSlots = new ArrayList<>();
        int lastEnd = start;
        for (int[] meeting : plannedMeetings) {
            if (meeting[0] - lastEnd >= duration) {
                freeSlots.add(new int[]{lastEnd, meeting[0]});
            }
            lastEnd = Math.max(lastEnd, meeting[1]);
        }
        if (end - lastEnd >= duration) {
            freeSlots.add(new int[]{lastEnd, end});
        }
        return freeSlots;
    }

    // Find common free time slots for both calendars
    public List<int[]> findCommonFreeSlots(int duration, Calendar calendar2) {
        List<int[]> FreeTimeSlots = findFreeSlots(duration);
        List<int[]> FreeTimeSlots2 = calendar2.findFreeSlots(duration);
        List<int[]> commonSlots = new ArrayList<>();
        int i = 0, j = 0;
        while (i < FreeTimeSlots.size() && j < FreeTimeSlots2.size()) {
            int[] slot1 = FreeTimeSlots.get(i);
            int[] slot2 = FreeTimeSlots2.get(j);
            int start = Math.max(slot1[0], slot2[0]);
            int end = Math.min(slot1[1], slot2[1]);
            if (end - start >= duration) {
                commonSlots.add(new int[]{start, end});
            }
            if (slot1[1] < slot2[1]) {
                i++;
            } else {
                j++;
            }
        }
        return commonSlots;
    }  

    // Print the time slots
    public void printSlots(List<int[]> slots) {
        for (int[] slot : slots) {
            System.out.println(minutesToTime(slot[0]) + " - " + minutesToTime(slot[1]));
        }
    }

    //Converters for String time to int minutes and vice versa
    private int toMinutes(String time) {
        int hours = Integer.parseInt(time.substring(0, 2));
        int minutes = Integer.parseInt(time.substring(3));
        return hours * 60 + minutes;
    }

    private String minutesToTime(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }

    // Getters and Setters
    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<int[]> getPlannedMeetings() {
        return plannedMeetings;
    }

    public void setPlannedMeetings(List<int[]> plannedMeetings) {
        this.plannedMeetings = plannedMeetings;
    }

    
}