package DAO;

import model.Key;

public class KeyDao {

    public static int getKeyPrice(Key key) {
        return  key.getPrice();
    }
}
