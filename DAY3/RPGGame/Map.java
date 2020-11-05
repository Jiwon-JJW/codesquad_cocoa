public class Map extends Unit {
    public String FieldSize[][] = new String[11][11];

    public void initField(Character c, Monster m, Bomb b) {
        for (int x = 0; x < FieldSize.length; x++) {
            for (int y = 0; y < FieldSize[0].length; y++) {
                FieldSize[x][y] = ".";
            }
            FieldSize[c.x][c.y] = "@";
            FieldSize[m.x][m.y] = "$";
            FieldSize[b.x][b.y] = "!";
        }
    }


    public void PrintField() {
        for (int x = 0; x < FieldSize.length; x++) {
            for (int y = 0; y < FieldSize[0].length; y++) {
                System.out.print(FieldSize[x][y]);
            }
            System.out.println();
        }
    }
}