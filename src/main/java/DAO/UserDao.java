package DAO;

import model.*;

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

    public static int getnCoins(User u) {
        return u.getCoins();
    }

    public static void buy(int keyPrice, User u) {
        int coins = u.getCoins() - keyPrice;
        u.setCointCounter(coins);

    }

    public static void addKey(Key key, User u) {
        u.addItem("key", key);
    }

    public static String getName(User user) {
        return user.getName();
    }

    public static void removeUser(int userId) {
        int index = -1;
        for (User u: users){
            if (u.getId() == userId){
                index = users.indexOf(u);
            }
        }
        if (index != -1){
            users.remove(index);
        }

        System.out.println(users);
    }
}
