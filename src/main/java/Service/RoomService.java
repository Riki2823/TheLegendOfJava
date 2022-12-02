package Service;

import model.Item;
import model.Room;

import java.util.Map;

public class RoomService {
    public static void deleteCoin(Room actualRoom){
        Map<String, Item> items = actualRoom.getItems();
        items.remove("coin");
    }
    public static int numOfCoins(Room r){
        return r.getNumOfCoins();
    }

    public static void removeOneCoin(Room actualRoom) {
        actualRoom.removeOneCoin();
    }

    public static boolean hadKey (Room actualRoom) {
        Map<String, Item> items = actualRoom.getItems();
        for (String key : items.keySet()){
            return key.equals("key");
        }
        return false;
    }

    public static Item getKey(Room actualRoom) {
        return actualRoom.getKey();
    }

    public static void deleteKey(Room actualRoom){
        Map<String, Item> items = actualRoom.getItems();
        items.remove("key");
    }

    public static boolean isTarget(Room actualRoom) {
        return actualRoom.getIsTarget();
    }
}
