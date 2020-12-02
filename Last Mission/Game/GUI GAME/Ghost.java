import java.util.Random;

public class Ghost {
    Random random = new Random();
    int x,y;
    int speed;

    Ghost(int x, int y, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void move(){
        x-=speed;
    }


}
