import java.util.Random;

public class Bomb{
    Random random = new Random();

    int x= 0;
    int y= 0;

    public void initBomb(Monster m) {
        while (true) {
            x= random.nextInt(10);
            y= random.nextInt(10);

            if (x != 5 && y != 5) {
                if(x != m.x && y!= m.y){

                }
                break;
            }
        }

    }


}
