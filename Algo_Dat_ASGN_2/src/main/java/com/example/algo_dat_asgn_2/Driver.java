package com.example.algo_dat_asgn_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Driver extends Application {

    //serialization file for the list of bs
    private static final String FILENAME = "doublyLinkedList.bin";

    //ref to linked list
    public static DoublyLinkedList<Integer> list;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Drinks Information System");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    //this is to load the serialiazed files
    @Override
    public void stop() throws Exception{
        if (list != null) {
            list.saveListToBinaryFile(FILENAME);
            System.out.println("list saved to file at exit");
        }
        super.stop();
    }



    public static void main(String[] args) {
        list = DoublyLinkedList.loadListFromBinaryFile(FILENAME);
        if (list == null) {
            System.out.println("Data failed to load or not found creating new file");
            list = new DoublyLinkedList<>();
        } else {
            System.out.println("Data loaded successfully");
        }

        //Dunno what this code part is chat gpt gave it as a fix for coding on mac cause it would run otherwise - CONOR
        System.setProperty("javafx.macos.addNestedMenuItems", "true");
        launch(args);
    }
}
