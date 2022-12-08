package com.application;

/**
 *
 * @author Mariusz Kamiński
 */

import javafx.scene.control.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Board boardLogic = new Board();
        BorderPane layout = new BorderPane();
        //Top infor text
        Label infoText = new Label("Turn: X");
        infoText.setFont(Font.font("Monospaced", 20));
        layout.setTop(infoText);
        
        //Border Game
        GridPane boardView = new GridPane();
        Button[][] buttons = new Button[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button(" ");
                buttons[i][j] = button;
                button.setFont(Font.font("Monospaced", 40));
                boardView.add(button, i, j);
                int x = i;
                int y = j;
                button.setOnAction(event -> {
                    if (boardLogic.getCell(x, y) == Character.MIN_VALUE && !boardLogic.Win()) {
                        if(boardLogic.Turn()) {
                            button.setText("X");
                            boardLogic.setX(x, y);
                            infoText.setText("Turn: O");

                        } else {
                            button.setText("O");
                            boardLogic.setO(x, y);
                            infoText.setText("Turn: X");
                        }
                    }
                    if (boardLogic.Win()) {
                        infoText.setText("The end!");
                    }
                        
                });
                    
                    
            }
        }
                
        //Setting board in the center of layout, below infoText
        layout.setCenter(boardView);
        //Scene with layout
        Scene scene = new Scene(layout);
        
        //Stage
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
