package controllers;

import Service.MazeService;
import Service.UserService;
import model.Maze;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/winners")
public class winnerTabController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = UserService.getUser((int) session.getAttribute("userId"));
        MazeService.removeMaze(u);
        UserService.removeUser(u.getId());
        session.removeAttribute("userId");
        session.removeAttribute("mapId");
        session.removeAttribute("startTime");


        List<User> winners = null;
        try {
            winners = UserService.getWinners();
        }catch (SQLException | IllegalAccessException |InstantiationException|ClassNotFoundException e){
            throw new RuntimeException(e);
        }

        req.setAttribute("winners", winners);

        RequestDispatcher dispatcher =  req.getRequestDispatcher("/WEB-INF/jsp/winnerTab.jsp");
        dispatcher.forward(req, resp);
    }
}
