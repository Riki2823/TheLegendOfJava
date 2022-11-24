package Service;

import model.Door;
import model.Room;

public class DoorService {

    public static Room getOpositeRoom(Room actualRoom, Door door) {
        if (door.getRoom1() == actualRoom){
            return door.getRoom2();
        }
        return door.getRoom1();
    }
}
