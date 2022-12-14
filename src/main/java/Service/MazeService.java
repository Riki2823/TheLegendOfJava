package Service;

import DAO.MazeDao;
import model.Maze;
import model.Room;
import model.User;



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

    public static String getName(Maze mazeInGame) {
        return MazeDao.getName(mazeInGame);

    }

    public static void removeMaze(User u) {
        MazeDao.removeMaze(u);
    }
}
