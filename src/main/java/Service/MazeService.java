package Service;

import DAO.MazeDao;
import model.Maze;
import model.Room;

public class MazeService {
    public static Room getRoom(Maze inUseMaze, int actualRoomid) {
        return MazeDao.getRoom( inUseMaze,actualRoomid);
    }
}
