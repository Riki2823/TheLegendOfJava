package Utils;

import model.*;

import java.util.stream.IntStream;

public class SelectMaze {

    public static Maze createMaze(int maze, User u){
        switch (maze){
            case 1:
                return Maze1(u);
            case 2:
                return Maze2(u);
            default:
                return null;
        }

    }

    private static Maze Maze2(User u) {
        MazeBuilder maze = new MazeBase();
        maze.setId();
        IntStream.range(1,9).forEach(maze::buildRoom);

        Key lvl1 = new Key(0, 1, 1);
        Key lvl2 = new Key(1, 2, 2);
        Key lvl3 = new Key(2, 3, 3);
        Key lvl4 = new Key(3, 4, 0);

        maze.buildDoor(1, 2, Room.Dirrection.WEST, lvl1, 1);
        maze.buildDoor(1, 3, Room.Dirrection.EAST);
        maze.buildDoor(1, 6, Room.Dirrection.SOUTH);

        maze.buildDoor(3, 4, Room.Dirrection.EAST, lvl2, 2);

        maze.buildDoor(4, 5, Room.Dirrection.NORTH);

        maze.buildDoor(6, 7, Room.Dirrection.EAST, lvl3, 3);
        maze.buildDoor(6,8, Room.Dirrection.SOUTH, lvl4, 4);

        maze.putKeyInRoom(1, lvl1);
        maze.putKeyInRoom(2, lvl2);
        maze.putKeyInRoom(5, lvl3);
        maze.putKeyInRoom(7, lvl4);

        maze.putCoinInRoom(1, new Coin());
        maze.putCoinInRoom(2, new Coin());
        maze.putCoinInRoom(3, new Coin());
        maze.putCoinInRoom(4, new Coin());
        maze.putCoinInRoom(5, new Coin());
        maze.putCoinInRoom(6, new Coin());

        maze.setName("La cueva de los keese");
        maze.setTarget(8);
        maze.putMazeOnStart(u);
        return maze.getMaze();


    }

    public static Maze Maze1(User u){
        MazeBuilder maze = new MazeBase();

        maze.setId();
        IntStream.range(1,5).forEach(maze::buildRoom);

        Key lvl1 = new Key(0, 1, 1);
        Key lvl2 = new Key(1,2, 2);
        maze.buildDoor(1, 2, Room.Dirrection.SOUTH);
        maze.buildDoor(1, 4, Room.Dirrection.EAST, lvl2, 2);
        maze.buildDoor(2,3, Room.Dirrection.EAST, lvl1, 1);


        maze.putKeyInRoom(2, lvl1);
        maze.putKeyInRoom(3,lvl2);
        maze.setName("Tutorial");
        maze.putCoinInRoom(1, new Coin());
        maze.putCoinInRoom(3, new Coin());
        maze.putCoinInRoom(2, new Coin());


        maze.setTarget(4);
        maze.putMazeOnStart(u);
        return maze.getMaze();
    }



}
