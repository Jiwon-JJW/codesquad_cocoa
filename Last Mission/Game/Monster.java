import java.util.Random;

public class Monster {
    Random random = new Random();
    Bomb b = new Bomb();

    int x= 0;
    int y= 0;

    public void initMonster() {
        while (true) {
            x=random.nextInt(10);
            y=random.nextInt(10);

            if (x != 5 && y != 5) {
                break;
            }

        }
    }
}
