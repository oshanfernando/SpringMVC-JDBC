package com.spring.DAO;

import com.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDAOImpl implements UserDAO {


    @Autowired
    DataSource dataSource;



    @Override
    public String verifyUser(String email, String password) {

        try {
            String SQL = "SELECT name FROM USER" +
                    " WHERE email = ? AND password = ?";

            return new JdbcTemplate(dataSource).queryForObject(SQL,new Object[]{email,password},String.class);

        }
        catch (Exception e){

            return "";
        }
    }

    @Override
    public int createAccount(User user) {

        String SQL =  "INSERT INTO user (name,address,age,email,password) values "
                + "(?,?,?,?,?)";
        try{
            int status = new JdbcTemplate(dataSource).update(SQL,new Object[]{user.getName(),user.getAddress(),user.getAge(),user.getEmail(),user.getPassword()}, Integer.class);

            if(status ==1){
                return 1;
            }
            else {
                return 0;
            }
        }
        catch (Exception e){
            return 0;
        }

    }
}
