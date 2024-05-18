package scheduler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class CalendarTest {
    @Test
    public void testSameStartAndEndTime() {
        Calendar calendar = new Calendar("09:00", "09:00", Arrays.asList(new String[][]{{"09:00", "10:00"}}));
        List<int[]> freeSlots = calendar.findFreeSlots(30);
        assertTrue(freeSlots.isEmpty());
    }


    @Test
    public void testDurationLongerThanAvailableTime() {
        Calendar calendar = new Calendar("09:00", "10:00", Arrays.asList(new String[][]{{"09:00", "09:30"}}));
        List<int[]> freeSlots = calendar.findFreeSlots(60);
        assertTrue(freeSlots.isEmpty());
    }

    @Test
    public void testOverlappingMeetings() {
        Calendar calendar = new Calendar("09:00", "11:00", Arrays.asList(new String[][]{{"09:00", "10:00"}, {"09:30", "10:30"}}));
        List<int[]> freeSlots = calendar.findFreeSlots(30);
        assertEquals(1, freeSlots.size());
        assertArrayEquals(new int[]{630, 660}, freeSlots.get(0));
    }

     @Test
    public void testMeetingsOutsideStartAndEndTime() {
        Calendar calendar = new Calendar("09:00", "10:00", Arrays.asList(new String[][]{{"08:00", "09:00"}, {"10:00", "11:00"}}));
        List<int[]> freeSlots = calendar.findFreeSlots(30);
        assertArrayEquals(new int[]{540, 600}, freeSlots.get(0));
    }
}