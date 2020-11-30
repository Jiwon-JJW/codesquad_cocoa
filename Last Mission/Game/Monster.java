import java.util.Random;

public class Monster {
    Random random = new Random();

    int x= 0;
    int y= 0;

    public void initMonster() {
        while (true) {
            x=random.nextInt(11);
            y=random.nextInt(11);

            if (x != 5 && y != 5) {
                break;
            }

        }
    }
}
