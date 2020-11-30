public class Map{


    public String[][] mapSize = new String[11][11];

    public void initMap(User u, Monster m, Bomb b){
        for(int i =0; i< mapSize.length; i++){
            for(int j = 0; j< mapSize[0].length; j++){
                mapSize[i][j] = " . ";
            }
        }

        int userX = u.x;
        int userY = u.y;
        int monX = m.x;
        int monY = m.y;
        int bombX = b.x;
        int bombY = b.y;

        mapSize[userX][userY] = " @ ";
        mapSize[monX][monY] = " $ ";
        mapSize[bombX][bombY] = " ! ";
    }

    public void addBomb(Bomb b){
        int bombX = b.x;
        int bombY = b.y;
        mapSize[bombX][bombY] = " ! ";
    }

    public void printMap(){
        for(int i = 0; i< mapSize.length;i++){
            for(int j= 0; j < mapSize[0].length;j++){
                System.out.print(mapSize[i][j]);
            }
            System.out.println();
        }
    }


}
