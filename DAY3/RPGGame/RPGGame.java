import java.util.*;

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map map = new Map();
        Character character = new Character();
        Bomb bomb = new Bomb();
        Monster monster = new Monster();

        character.initCharacter();
        bomb.initBomb();
        monster.initMonster();

        map.initField(character,monster,bomb);
        map.DefaultField();

        System.out.println("WASD로 이동키를 입력해주세요.");
        System.out.print("> ");

        String characterMove = scanner.nextLine();

        while (true) {
            if (characterMove.equalsIgnoreCase("W")) {
                character.CharacterUp();
                return;
            }
            if (characterMove.equalsIgnoreCase("S")) {
                character.CharacterDown();
                return;
            }
            if (characterMove.equalsIgnoreCase("A")) {
                character.CharacterLeft();
                return;
            }
            if (characterMove.equalsIgnoreCase("D")) {
                character.CharacterRight();
                return;
            }
        }

    }

}





