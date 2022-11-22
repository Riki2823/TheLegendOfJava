package controllers;

import Utils.SelectMaze;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/dir")
public class dirController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int mapId = (Integer) session.getAttribute("mapId");
        Maze inUseMaze = SelectMaze.createMaze(mapId);
        int actualRoomId = (Integer) session.getAttribute("actualRoom");
        Room actualRoom = inUseMaze.getRoom(actualRoomId);

        String dirS = req.getParameter("dir");
        Room.Dirrection dir = selectDirrection(dirS);

        RoomSide rs = actualRoom.getSides().get(dir);
        String side = rs.toString();
        if (side.equals("Wall")){
            req.setAttribute("messageWall", "No puedes atravesar una pared!!!!");
        }else if (side.equals("Door")){

        }
    }

    private Room.Dirrection selectDirrection(String dir) {
        switch (dir){
            case "w":
                return Room.Dirrection.WEST;
            case "e":
                return Room.Dirrection.EAST;
            default:
                return null;
        }
    }
}
