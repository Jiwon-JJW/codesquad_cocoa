import java.time.LocalTime;
import java.util.Calendar;

public class Time extends Thread {

    public void run() {
        ClockSetting clockSetting = new ClockSetting();
        Calendar c = Calendar.getInstance();

        try {
            while (!Thread.currentThread().isInterrupted()) {

                clockSetting.InitClock();
                System.out.println("==============");
                double second = Double.parseDouble(String.valueOf(LocalTime.now()).split(":")[2]);

                Thread.sleep(60000 - (int)(second*1000));
                }
            } catch (InterruptedException e) {
        }
        finally {
            Main.returnMenu();
        }
    }
}
