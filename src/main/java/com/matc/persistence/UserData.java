package com.matc.persistence;

import com.matc.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());


    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    //TODO add a method or methods to return a single user based on search criteria
    public User getSearch(String search){

        logger.info("you searched for " + search);
        User employee = null;
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM users where last_name=";
        sql = sql + "'" + search + "'";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            employee = createUserFromResults(results);

            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }

        return employee;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        // TODO map the remaining fields
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        return user;
    }

}
