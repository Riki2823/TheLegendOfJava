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

    public static int getLvl(Door door) {
        return door.getLevel();
    }

    public static void setOpenStatus(Door door, boolean b) {
        door.setOpen(b);
    }
}
