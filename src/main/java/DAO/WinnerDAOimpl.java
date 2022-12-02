package DAO;

import Service.MazeService;
import Service.UserService;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DAO.ConectionDatabase.getConnection;

public class WinnerDAOimpl implements WinnerDAO{
    @Override
    public void newWinner(User user) throws SQLException {
        Connection connection = getConnection();
        String insert = "INSERT INTO `winner` (`name`, `map_name`, `elapsed_time`) VALUES(?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(insert);
            statement.setString(1, UserService.getName(user));
            statement.setString(2, MazeService.getName(MazeService.getMazeInGame(user)));
            statement.setString(3, "0");
            statement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> listOfWinners() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        List<User> winners = new ArrayList<>();
        String query = "SELECT * FROM `winner` ORDER BY elapsed_time ASC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            //-------------------------

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                User aux = new User(id);
                aux.setName(resultSet.getString("name"));
                aux.setMapUsed(resultSet.getString("map_name"));
                aux.setElapsTime(resultSet.getString("elapsed_time"));
                winners.add(aux);
            }
            return winners;
        }catch (SQLException | InstantiationException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }
}
