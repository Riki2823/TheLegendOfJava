package Service;
import DAO.UserDao;
import DAO.WinnerDAO;
import DAO.WinnerDAOimpl;
import model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserService {
    private static WinnerDAO winnerDAO = new WinnerDAOimpl();

    private static int id = 0;
    public static User addUser(){
        User user = new User(id);
        UserDao.addUser(user);
        id++;
        return user;
    }

    public static User getUser(int id){
        return UserDao.getUser(id);
    }

    public static Room getActualRoom(User u){
        return UserDao.getActualRoom(u);
    }

    public static void setActualRoom(User u, Room actualRoom) {
        UserDao.setActualRoom(u, actualRoom);
    }

    public static void addCoin(User u) {
        UserDao.addCoin(u);
    }

    public static Map<String, Item> getItems(User u){
            return UserDao.getItems(u);
    }

    public static int getnCoins(User u) {
        return UserDao.getnCoins(u);
    }

    public static void buying(int keyPrice, User u) {
        UserDao.buy(keyPrice, u);
    }

    public static void addKey(Key key, User u) {
        UserDao.addKey(key, u);
    }

    public static String getName(User user) {
        return UserDao.getName(user);
    }

    public static void removeUser(int userId) {
        UserDao.removeUser(userId);
    }

    public static List<User> getWinners() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return winnerDAO.listOfWinners();
    }

    public static void deleteItems(User u) {
        UserDao.deleteItems(u);
    }

    public void insertMysql(User u) throws SQLException {
        winnerDAO.newWinner(u);
    }
}
