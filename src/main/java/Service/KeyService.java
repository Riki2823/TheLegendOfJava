package Service;

import DAO.KeyDao;
import model.Item;
import model.Key;

public class KeyService {

    public static int getKeyPrice(Key key) {
        return KeyDao.getKeyPrice(key);
    }

    public static int getKeyLvl(Key key){
        return KeyDao.getKeyLvl(key);
    }

    public static String getKeyName(Item key) {
        return key.getName();
    }
}
