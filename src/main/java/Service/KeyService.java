package Service;

import DAO.KeyDao;
import model.Key;

public class KeyService {

    public static int getKeyPrice(Key key) {
        return KeyDao.getKeyPrice(key);
    }

    public static int getKeyLvl(Key key){
        return KeyDao.getKeyLvl(key);
    }
}
