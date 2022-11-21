package model;

public interface MazeBuilder {
    void buildRoom(int idRoom);
    void setTarget(int idRoom);
    void buildDoor(int roomFrom, int roomTo, Room.Dirrection dir);
    void buildDoor(int roomFrom, int roomTo, Room.Dirrection dir, Key key, int level);
    void putKeyInRoom(int nroom, Key key);
    public void putCoinInRoom(int nroom, Coin coin);
    Maze getMaze();
}
