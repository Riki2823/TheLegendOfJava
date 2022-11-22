package DAO;

import model.Maze;
import model.Room;

public class MazeDao {
    public static Room getRoom(Maze inUseMaze, int actualRoomid) {
        return inUseMaze.getRoom(actualRoomid);
    }

    public static Room getOpositeRoom(Maze inUseMaze, Room actualRoom) {
        return inUseMaze.getOpositeRoom(actualRoom);
    }
}
