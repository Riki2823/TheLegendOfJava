package model;


import java.util.List;
import java.util.Map;

public class Room {
    private boolean isTarget = false;
    int id;
    public enum Dirrection{
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    private Map<Dirrection, RoomSide> sizes;

    private List<Item> items;

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

    public Map<Dirrection, RoomSide> getSizes() {
        return sizes;
    }

    public void setSizes(Map<Dirrection, RoomSide> sizes) {
        this.sizes = sizes;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
