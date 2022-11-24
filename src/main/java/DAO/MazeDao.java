package DAO;

import model.Maze;
import model.Room;

public class MazeDao {
    public static Room getRoom(Maze inUseMaze, int actualRoomid) {
        return inUseMaze.getRoom(actualRoomid);
    }
}
