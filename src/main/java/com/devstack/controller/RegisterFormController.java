package com.devstack.controller;

import com.devstack.util.PasswordManeger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class RegisterFormController {
    public TextField txtContact;
    public TextField txtEmail;
    public TextField txtName;
    public PasswordField txtPassword;


      public void registerOnAction(ActionEvent event) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://Localhost:3306/hotel_api", "root", "Lil*peep8320");
            String sql ="INSERT INTO user VALUES(?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, UUID.randomUUID().toString());
            stm.setString(2, txtName.getText());
            stm.setString(3, txtEmail.getText());
            stm.setString(4, PasswordManeger.hash(txtPassword.getText()));
            boolean isSaved = stm.executeUpdate()>0;
            if(isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Saved..").show();
            }
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
}

