import java.util.Random;

public class Bomb extends moveUnit{
    Random random = new Random();

    public void initBomb(){
        while (true) {
            setBombx(random.nextInt(11));
            setBomby(random.nextInt(11));
            if (super.Bombx != 5 && super.Bomby != 5) {
                if (super.Monsterx != super.Bombx && super.Monstery != super.Bomby){
                    break;
                }
            }
        }
    }

}
