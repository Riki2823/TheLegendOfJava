package model;


import java.util.List;
import java.util.Map;

public class Room {
    int id;
    public enum Dirrection{
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    private Map<Dirrection, RoomSide> sizes;

    private List<Item> items;
}
