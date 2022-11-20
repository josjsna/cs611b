package byog.Core;

import java.util.Random;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class MapGenerator {
    private int WIDTH;
    private int HEIGHT;
    private Random RANDOM;
    private long seed;
    private static final int TIMES=100;
    private static TETile[][] positionOfroom;
    private static TETile[][]world;



    private void fillwithroom(){
        for (int i = 0; i < TIMES; i++) {
            int x=RANDOM.nextInt(WIDTH);
            int y=RANDOM.nextInt(HEIGHT);
            int width=RANDOM.nextInt(WIDTH/10)+2;
            int height=RANDOM.nextInt(HEIGHT);
            if(y+height+1>=HEIGHT||x+WIDTH+1>=WIDTH)
                continue;
            if(isOverlap(x,y,width,height))
                continue;;
                buildRoom(x,y,width,height);


        }
    }
    private void buildRoom(int x,int y,int width,int height){
        for (int i = x; i <x+width+1 ; i++) {
            for (int j = y; j <y+height+1 ; j++) {
                if(i==x || i==x+width+1 || j==y || j==y+height+1){
                    positionOfroom[i][j]=Tileset.WALL;

                    continue;
                }
                world[i][j]=Tileset.GRASS;
                positionOfroom[i][j]=Tileset.GRASS;

            }

        }
    }
    private boolean isOverlap(int x,int y,int width,int height){
        for (int i=x;i<=x+width+1;i++)
            for (int j=y;j<=y+height+1;j++)
                if (positionOfroom[i][j]==Tileset.WALL||positionOfroom[i][j]==Tileset.GRASS)
                    return true;
        return false;
    }
}

