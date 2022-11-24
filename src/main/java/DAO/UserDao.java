package DAO;

import model.Coin;
import model.Item;
import model.Room;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDao {
    private static List<User> users = new ArrayList<>();


    public static void addUser(User user) {
        users.add(user);
    }

    public static User getUser(int id) {
        User u = null;
        for (User user : users){
            if (user.getId() == id){
                u = user;
            }
        }
        return u;
    }

    public static Room getActualRoom(User u) {
        return u.getActualRoom();
    }

    public static void setActualRoom(User u, Room actualRoom) {
        u.setActualRoom(actualRoom);
    }

    public static void addCoin(User u) {
        Item coin = new Coin();
        u.addItem("coin", coin);
    }

    public static Map<String, Item> getItems(User u) {
        return u.getItems();
    }
}
