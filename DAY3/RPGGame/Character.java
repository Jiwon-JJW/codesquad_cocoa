public class Character extends moveUnit {

    public void initCharacter() {
        setCharacterx(5);
        setCharactery(5);
    }

    public void CharacterUp() {
        if (super.Charactery - 1 < 0) {
            System.out.println("위로는 더이상 갈 수 없습니다.");
            return;
        }
        super.Charactery--;
    }

    public void CharacterDown() {
        if (super.Charactery + 1 >= 11) {
            System.out.println("아래로는 더이상 갈 수 없습니다.");
            return;
        }
        super.Charactery++;
    }

    public void CharacterLeft() {
        if (super.Characterx - 1 < 0) {
            System.out.println("왼쪽으로는 더이상 갈 수 없습니다.");
            return;
        }
        super.Characterx--;
    }

    public void CharacterRight() {
        if (super.Characterx + 1 >= 11) {
            System.out.println("오른쪽으로는 더이상 갈 수 없습니다.");
            return;
        }
        super.Characterx++;
    }
}
