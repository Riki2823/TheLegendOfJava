package controllers;


import Service.UserService;
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
import java.time.Duration;
import java.time.Instant;

@WebServlet("/endform")
public class winnerFormController extends HttpServlet {
    UserService us = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/winnerForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = UserService.getUser((int) session.getAttribute("userId"));
        String elapseTime = setElapseTime(session);
        UserService.setElapseTime(elapseTime, u);
        String userName = req.getParameter("name");
        u.setName(userName);

        try {
            us.insertMysql(u);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/winners");
    }

    private String setElapseTime(HttpSession session) {
        Instant startTime = (Instant) session.getAttribute("startTime");
        Instant endTime =  (Instant)  session.getAttribute("playerEndTime");

        Duration elap = Duration.between(startTime, endTime);

        long seconds = elap.toSeconds();
        System.out.println(seconds);

        int minutes = 0;
        int hours = 0;

        if (seconds >= 60) {
            while (seconds >= 60) {
                minutes += 1;
                seconds-= 60;
                if (minutes >= 60) {
                    hours += 1;
                    minutes -= 60;
                }
            }
        }


        String h = "";
        String m = "";
        String s = "";

        if (hours < 10){
            h = "0" + hours;
        }else {
            h = String.valueOf(hours);
        }

        if (minutes < 10){
            m = "0" + minutes;
        }else {
            m = String.valueOf(minutes);
        }

        if (seconds < 10){
            s = "0" + seconds;
        }else {
            s = String.valueOf(seconds);
        }

        return h + ":" + m + ":" + s;
    }
}
