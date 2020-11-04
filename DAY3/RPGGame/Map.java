public class Map {

    public String FieldSize[][] = new String[11][11];

    public void DefaultField() {
        for (int x = 0; x < FieldSize.length; x++) {
            for (int y = 0; y < FieldSize[0].length; y++) {
                FieldSize[x][y] = ".";
                System.out.print(FieldSize[x][y]);
            }
            System.out.println();
        }
    }

    public void initField(Character c,Monster m,Bomb b){
        int c_x = c.getCharacterx();
        int c_y = c.getCharactery();
        int m_x = m.getCharacterx();
        int m_y = m.getCharactery();
        int b_x = b.getCharacterx();
        int b_y = b.getCharactery();

        this.FieldSize[c_y][c_x] = "@";
        this.FieldSize[m_y][m_x] = "$";
        this.FieldSize[b_y][b_x] = ".";

    }

}