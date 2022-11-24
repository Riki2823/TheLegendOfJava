package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private boolean isTarget = false;
    int id;

    public Room(int idRoom) {
        this.id = idRoom;
    }

    public enum Dirrection{
        NORTH,
        SOUTH,
        WEST,
        EAST
    }
    private Map<Dirrection, RoomSide> sizes = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();



    public void isTarget(boolean isTarget){
        this.isTarget = isTarget;
    }
    public boolean getTarget(){
        return this.isTarget;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Dirrection, RoomSide> getSides() {
        return sizes;
    }

    public void setSizes(Map<Dirrection, RoomSide> sizes) {
        this.sizes = sizes;
    }
    public void setSide(Dirrection dir, RoomSide side){
        this.sizes.put(dir,side);
    }
    public Map<String, Item> getItems() {
        return items;
    }
    public void setItems(Map<String, Item> items) {
        this.items = items;
    }
    public void setItem (Item item, String itemS){
        this.items.put(itemS,item);
    }
}
