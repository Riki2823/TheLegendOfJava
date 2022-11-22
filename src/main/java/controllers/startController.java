package controllers;

import Service.MazeService;
import Service.TextService;
import Service.UserService;
import Utils.SelectMaze;
import model.Maze;
import model.MazeBase;
import model.Room;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class startController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/wellcome.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u  = UserService.addUser();

        //Map hace referencia a Maze
        int mapId = Integer.parseInt(req.getParameter("mapId"));
        session.setAttribute("mapId", mapId);
        req.setAttribute("mapId", mapId);

        Maze inUseMaze = SelectMaze.createMaze(mapId);
        int actualRoomid = 1;
        Room actualRoom = MazeService.getRoom( inUseMaze, actualRoomid);
        UserService.setActualRoom(u,actualRoom);

        String roomJSONString = TextService.getJsonInfo(inUseMaze, actualRoomid);
        roomJSONString = roomJSONString.toLowerCase();
        req.setAttribute("room", roomJSONString);

        System.out.println(roomJSONString);

        session.setAttribute("User", u.getId());
        RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(req, resp);
    }
}
