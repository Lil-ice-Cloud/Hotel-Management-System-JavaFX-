package com.devstack.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {

    public AnchorPane context;


    public void openLoginForm(ActionEvent ignoredEvent) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        URL resource = getClass().getResource("/com/devstack/view/LoginForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        setUi("LoginForm");
    }



    public void openRegisterForm(ActionEvent event) throws IOException {
        setUi("RegisterForm");
    }
    private void setUi(String ui)  throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        URL resource = getClass().getResource("/com/devstack/view/"+ui+".fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
}


