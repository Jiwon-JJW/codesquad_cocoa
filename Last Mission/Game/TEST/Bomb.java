import java.util.Random;

public class Bomb{
    Random random = new Random();

    int x= 0;
    int y= 0;


    public void initBomb() {
        while (true) {
            x= random.nextInt(11);
            y= random.nextInt(11);

            if (x != 5 && y != 5) {
                break;
            }

        }

    }


}
