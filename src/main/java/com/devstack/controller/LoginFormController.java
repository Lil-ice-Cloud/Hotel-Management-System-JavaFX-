package com.devstack.controller;

import com.devstack.util.PasswordManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.UUID;

public class LoginFormController {
    @FXML
    private PasswordField textPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    void loginOnAction(ActionEvent event) {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://Localhost:3306/hotel_api", "root", "Lil*peep8320");
        String sql = "SELECT * FROM user WHERE email=?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setObject(1, txtEmail.getText());

        ResultSet rs = stm.executeQuery();
        if (rs.next()){
            boolean password = PasswordManeger.checkPassword(textPassword.getText(), rs.getString("password"));
            if (password){
                new Alert(Alert.AlertType.INFORMATION,"Login Successful!").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Wrong Password!").show();
            }
        }else{
            new Alert(Alert.AlertType.ERROR,"User Not Found").show();
        }
    }catch(ClassNotFoundException | SQLException ex){
        ex.printStackTrace();
        }
    }
}

