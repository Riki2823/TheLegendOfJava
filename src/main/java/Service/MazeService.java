package Service;

import DAO.MazeDao;
import DAO.UserDao;
import model.Maze;
import model.Room;
import model.User;

import java.util.Map;

public class MazeService {
    public static Room getRoom(Maze inUseMaze, int actualRoomid) {
        return MazeDao.getRoom( inUseMaze,actualRoomid);
    }

    public static Maze getMazeInGame(User u){
        return MazeDao.getMazeInGame(u);
    }

    public static void startMaze(User u, Maze mazeInGame){
        MazeDao.startMaze(u, mazeInGame);
    }
}
