package model;

public class Door implements RoomSide{
    private boolean isOpen;
    private Key key;
    private int level;

    public Door(boolean isOpen, Key key, int level, Room room1, Room room2) {
        this.isOpen = isOpen;
        this.key = key;
        this.level = level;
    }

    public Door(boolean isOpen, Room room1, Room room2){
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "\"Door\"";
    }
}
