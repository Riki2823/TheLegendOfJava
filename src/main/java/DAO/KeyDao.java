package DAO;

import model.Key;

public class KeyDao {

    public static int getKeyPrice(Key key) {
        return  key.getPrice();
    }

    public static int getKeyLvl(Key key){
        return key.getKeyLevel();
    }
}
