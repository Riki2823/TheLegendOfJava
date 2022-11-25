package DAO;

import Service.MazeService;
import model.Maze;
import model.Room;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class MazeDao {

    static Map<User, Maze> mazesInGame = new HashMap<>();
    public static Room getRoom(Maze inUseMaze, int actualRoomid) {
        return inUseMaze.getRoom(actualRoomid);
    }

    public static void startMaze(User u, Maze mazeInGame) {

        mazesInGame.put(u, mazeInGame );
    }

    public static Maze getMazeInGame(User u) {
        return mazesInGame.get(u);
    }
}
