package controllers;

import Service.DoorService;
import Service.MazeService;
import Service.TextService;
import Service.UserService;
import Utils.SelectMaze;
import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/nav")
public class dirController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int userId = (int) session.getAttribute("userId");
        User u = UserService.getUser(userId);

        Maze inUseMaze = MazeService.getMazeInGame(u);
        Room actualRoom = UserService.getActualRoom(u);

        String dirS = req.getParameter("dir");
        Room.Dirrection dir = selectDirrection(dirS);

        RoomSide rs = actualRoom.getSides().get(dir);
        String side = rs.toString();
        String mapName = MazeService.getName(inUseMaze);

        req.setAttribute("keyName", UserService.getKeyName(u));
        req.setAttribute("mapId", mapName);
        req.setAttribute("coinsU", UserService.getnCoins(u));
        req.setAttribute("actualRoom", actualRoom.getId());

        if (side.equals("\"Wall\"")){
            req.setAttribute("messageWall", "No puedes atravesar una pared!!!!");
        }else if (side.equals("\"Door\"")){
            Door door = (Door) rs;
            Room r = DoorService.getOpositeRoom(actualRoom, door);
            actualRoom = r;
            req.setAttribute("actualRoom", actualRoom.getId());
            u.setActualRoom(actualRoom);

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
