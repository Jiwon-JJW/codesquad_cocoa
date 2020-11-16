import java.util.Calendar;

public class Clock {
    public static void main(String[] args) {
        ClockSetting clockSetting = new ClockSetting();
        Calendar today = Calendar.getInstance();

        int hour = today.get(Calendar.HOUR_OF_DAY);
        int minute = today.get(Calendar.MINUTE);

        clockSetting.InitClock(hour,minute);

    }
}