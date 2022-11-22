package Service;
import DAO.UserDao;
import model.Room;
import model.User;

public class UserService {

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
}
