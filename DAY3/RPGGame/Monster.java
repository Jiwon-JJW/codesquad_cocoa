import java.util.*;
public class Monster extends moveUnit {

    Random random = new Random();

    public void initMonster() {
        while (true) {
            super.setMonsterx(random.nextInt(10));
            super.setMonstery(random.nextInt(10));
            if (super.Monsterx != 5 && super.Monstery != 5) {
                if (super.Monsterx != super.Bombx && super.Monstery != super.Bomby){
                    break;
                }
            }
        }
    }

}
