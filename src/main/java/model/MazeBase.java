package model;


import Service.MazeService;

public class MazeBase implements MazeBuilder{

   private Maze maze = new Maze();
   private int id = 0;
    @Override
    public void buildRoom(int idRoom) {
        Room room = new Room(idRoom);
        room.setSide(Room.Dirrection.NORTH, new Wall());
        room.setSide(Room.Dirrection.SOUTH, new Wall());
        room.setSide(Room.Dirrection.EAST, new Wall());
        room.setSide(Room.Dirrection.WEST, new Wall());
        maze.addRoom(idRoom, room);
    }

    @Override
    public void setTarget(int idRoom) {
        this.maze.getRoom(idRoom).isTarget(true);
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Room.Dirrection dir) {

        Room r1 = maze.getRoom(roomFrom);
        Room r2 = maze.getRoom(roomTo);
        Door door = new Door(true, r1, r2);
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
        Room r1 = maze.getRoom(roomFrom);
        Room r2 = maze.getRoom(roomTo);
        Door door = new Door(false, key, level, r1, r2);
        r1.setSide(dir, door);
        r2.setSide(contaridir(dir), door);
    }

    @Override
    public void putKeyInRoom(int nroom, Key key) {
        Room room = maze.getRoom(nroom);
        room.setItem(key, "key");
    }

    public void putCoinInRoom(int nroom, Coin coin){
        Room room = maze.getRoom(nroom);
        room.setItem(coin, "coin");
    }

    @Override
    public Maze getMaze() {
        return this.maze;
    }

    @Override
    public void setId(){
        maze.setId(this.id);
        id++;
    }

    @Override
    public void putMazeOnStart(User u) {
        MazeService.startMaze(u, maze);
    }

    @Override
    public void setName(String name) {
        maze.setMazeName(name);
    }
}
