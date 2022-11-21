package model;



public class MazeBase implements MazeBuilder{

   private Maze maze = new Maze();
    @Override
    public void buildRoom(int idRoom) {
        Room room = new Room(idRoom);
        room.setSide(Room.Dirrection.NORTH, new Wall());
        room.setSide(Room.Dirrection.SOUTH, new Wall());
        room.setSide(Room.Dirrection.EAST, new Wall());
        room.setSide(Room.Dirrection.WEST, new Wall());
        maze.addRoom(idRoom, room);
        System.out.println(room.getId());
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
        r1.setSide(dir, door);
        r2.setSide(contaridir(dir), door);
    }

    private Room.Dirrection contaridir(Room.Dirrection dir) {
        switch (dir){
            case NORTH:
                return Room.Dirrection.SOUTH;
            case SOUTH:
                return Room.Dirrection.NORTH;
            case EAST:
                return Room.Dirrection.WEST;
            case WEST:
                return Room.Dirrection.EAST;
            default:
                return null;
        }

    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Room.Dirrection dir, Key key, int level) {
        Door door = new Door(false, key, level);
        Room r1 = maze.getRoom(roomFrom);
        Room r2 = maze.getRoom(roomTo);
        r1.setSide(dir, door);
        r2.setSide(contaridir(dir), door);
    }

    @Override
    public void putKeyInRoom(int nroom, Key key) {
        Room room = maze.getRoom(nroom);
        room.setItem(key);
    }

    public void putCoinInRoom(int nroom, Coin coin){
        Room room = maze.getRoom(nroom);
        room.setItem(coin);
    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }
}
