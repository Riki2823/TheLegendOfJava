package Utils;

import model.*;

import java.util.stream.IntStream;

public class SelectMaze {

    public static Maze createMaze(int maze){
        switch (maze){
            case 1:
                return Maze1();
            case 2:
                Maze2();
            default:
                return null;
        }

    }

    private static Maze Maze2() {
        return null;
    }

    public static Maze Maze1(){
        MazeBuilder maze = new MazeBase();
        IntStream.range(1,5).forEach(maze::buildRoom);

        Key lvl1 = new Key(0, 1, 0);
        Key lvl2 = new Key(1,2, 2);
        maze.buildDoor(1, 2, Room.Dirrection.SOUTH);
        maze.buildDoor(1, 4, Room.Dirrection.EAST, lvl2, 2);
        maze.buildDoor(2,3, Room.Dirrection.EAST, lvl1, 1);

        maze.putKeyInRoom(2, lvl1);
        maze.putKeyInRoom(3,lvl2);

        maze.putCoinInRoom(1, new Coin());
        maze.putCoinInRoom(3, new Coin());

        maze.setTarget(4);

        return maze.getMaze();
    }



}
