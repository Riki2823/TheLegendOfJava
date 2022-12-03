package controllers;

import Service.*;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/open")
public class openDoorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = UserService.getUser((int) session.getAttribute("userId"));

        Maze inUseMaze = MazeService.getMazeInGame(u);

        Room actualRoom = UserService.getActualRoom(u);

        String mapName = MazeService.getName(inUseMaze);


        req.setAttribute("keyName", UserService.getKeyName(u));
        req.setAttribute("mapId", mapName);
        req.setAttribute("coinsU", UserService.getnCoins(u));
        req.setAttribute("actualRoom", actualRoom.getId());

        String dirS = req.getParameter("dir");
        Room.Dirrection dir = selectDirrection(dirS);

        Door door = (Door) actualRoom.getSides().get(dir);

        boolean hadKey = false;
        Key key = null;
        for (Map.Entry<String, Item> items : u.getItems().entrySet()){
            if(items.getKey().equals("key")){
                hadKey = true;
                key = (Key) items.getValue();
            }
        }

        if (hadKey){
            if (KeyService.getKeyLvl(key) == DoorService.getLvl(door)){
                actualRoom = DoorService.getOpositeRoom(actualRoom, door);
                DoorService.setOpenStatus(door, true);
                u.setActualRoom(actualRoom);
                req.setAttribute("actualRoom", actualRoom.getId());
                req.setAttribute("messageWall", "Has conseguido abrir la puerta!!");
                if (RoomService.isTarget(actualRoom)){
                        req.setAttribute("winner", true);
                }
            }else {
                req.setAttribute("messageWall", "La llaves que posees no son del nivel necesario");
                System.out.println("No1");
            }
        }else {
            req.setAttribute("messageWall", "De momento no dispones de llaves para abrir puertas");
            System.out.println("No2");
        }

        //!!!!!!!!!IMPORTANTE IMPLEMENTAR DAO!!!!!!!!!!!!!!!!1
        int actualRoomid = actualRoom.getId();
        String roomJSONString = TextService.getJsonInfo(inUseMaze, actualRoomid, u);
        roomJSONString = roomJSONString.toLowerCase();
        req.setAttribute("room", roomJSONString);

        RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }
    private Room.Dirrection selectDirrection(String dir) {
        switch (dir){
            case "w":
                return Room.Dirrection.WEST;
            case "e":
                return Room.Dirrection.EAST;
            case "n":
                return Room.Dirrection.NORTH;
            case "s":
                return Room.Dirrection.SOUTH;
            default:
                return null;
        }
    }
}
