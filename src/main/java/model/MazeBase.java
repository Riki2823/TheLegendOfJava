package model;

import java.util.HashMap;
import java.util.Map;

public class MazeBase implements MazeBuilder{

    Maze maze = new Maze();
    @Override
    public void buildRoom(int idRoom) {
        Room room = new Room();
        room.setId(idRoom);
        Map<Room.Dirrection, RoomSide> sizes = new HashMap<>();
        room.setSizes(sizes);
        maze.addRoom(idRoom, room);
    }

    @Override
    public void setTarget(int idRoom) {
        this.maze.getRoom(idRoom).isTarget(true);
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Room.Dirrection dir) {
        Door door = new Door(true);
        Room r1 = maze.getRoom(roomFrom);
        Room r2 = maze.getRoom(roomTo);
        Map<Room.Dirrection, RoomSide> sizes = r1.getSizes();
        sizes.put(dir, door);

    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Room.Dirrection dir, Key key, int level) {
        Door door = new Door(false, key, level);
    }

    @Override
    public void putKeyInRoom(int nroom, Key key) {

    }

    @Override
    public Maze getMaze() {
        return null;
    }
}
