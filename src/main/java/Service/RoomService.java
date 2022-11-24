package Service;

import model.Item;
import model.Room;

import java.util.Map;

public class RoomService {
    public static void deleteCoin(Room actualRoom){
        Map<String, Item> items = actualRoom.getItems();
        items.remove("coin");
    }
}
