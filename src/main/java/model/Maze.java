package model;

import java.util.HashMap;
import java.util.Map;

public class Maze {
    private Map<Integer, Room> rooms = new HashMap<>();
    private int id;
    private String mazeName;
    public void addRoom(int nroom, Room room) {
        this.rooms.put(nroom, room);
    }

    public Room getRoom(int nroom) {
        return this.rooms.get(nroom);
    }

    public Map<Integer, Room> getRooms (){
        return this.rooms;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
            return this.id;
    }

    public void setMazeName(String mazeName) {
        this.mazeName = mazeName;
    }

    public String getName() {
        return mazeName;
    }
}
