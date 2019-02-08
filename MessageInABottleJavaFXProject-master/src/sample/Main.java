package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.server.ExportException;

public class Main extends Application {

    Scene scene1, scene2, scene3, scene4;

//add the police song message in a bottle or one of the instrumentals or both
    @Override
    public void start(Stage primaryStage)throws Exception {
        primaryStage.setTitle("SceneTest");
        String fileName = "Bottle.csv";
        File file = new File(fileName); //read about file
        file.
        try {
            Scanner inputStream = new Scanner(file);
            inputStream.next(); //ignores 1st line
            while (inputStream.hasNext()){
                String data = inputStream.next();  //gets whole line
                String[] values = data.split(",");
                double VaARIABLE = Double.parseDouble(values[x]); //replace variable with name of what the values means. replace x with the order place the value is in
                System.out.println(values[x]);
            }
            inputStream.close();
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }



//Scene 1
        Label label1= new Label("This is the first scene");
        Button button1= new Button("Go to scene 2");
        button1.setOnAction(event -> primaryStage.setScene(scene2));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1= new Scene(layout1, 1200, 800);
        layout1.setId("s1");

//Scene 2
        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to scene 3");
        button2.setOnAction(event -> primaryStage.setScene(scene3));

        //MAINGAMESETUP
        Button bot1= new Button("BOTTLE1");
        Button bot2= new Button("BOTTLE2");
        Button bot3= new Button("BOTTLE3");
        Button bot4= new Button("BOTTLE4");
        Button bot5= new Button("BOTTLE5");
        Button bot6= new Button("BOTTLE6");

        bot1.setId("b1");

        bot2.setId("b2");
        bot3.setId("b3");
        bot4.setId("b4");
        bot5.setId("b5");
        bot6.setId("b6");

        //ENDOFMAINGAMESETUP
        bot1.setLayoutX(400);
        bot1.setLayoutY(400);

        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(label2, button2, bot1, bot2, bot3, bot4, bot5, bot6);

        scene2= new Scene(layout2,1200,800);
        layout2.setId("s2");

//Scene 3
        Label label3 = new Label("This is the third scene");
        Button button3 = new Button("Go to scene 4");
        button3.setOnAction(event -> primaryStage.setScene(scene4));
        VBox layout3 = new VBox(20);
        layout3.getChildren().addAll(label3, button3);
        scene3= new Scene(layout3,1200,800);
        layout3.setId("s3");

        //Scene 4
        Label label4 = new Label("This is the fourth scene");
        Button button4 = new Button("Go to scene 1");
        button4.setOnAction(event -> primaryStage.setScene(scene1));
        VBox layout4 = new VBox(20);
        layout4.getChildren().addAll(label4, button4);
        scene4= new Scene(layout4,1200,800);
        layout4.setId("s4");

        layout1.getStylesheets().add("/sample/bottlestyle.css");
        layout2.getStylesheets().add("/sample/bottlestyle.css");
        layout3.getStylesheets().add("/sample/bottlestyle.css");
        layout4.getStylesheets().add("/sample/bottlestyle.css");

        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }








    //NOTES
    //Label label1= new Label("This is the first scene"); This contains text. It can be text or an image. Here, a text box is placed and defined as label1 with the quote inside displayed.
    //Button button1= new Button("Go to scene 2"); This creates a button, the text inside is what will be on it
    //button1.setOnAction(e -> primaryStage.setScene(scene2)); This sets an action for the button to have. setScene is built in. We have to create new scenes.
    //VBox layout1 = new VBox(20); This reopens the virtual box, but it keeps it at the same size
    //layout1.getChildren().addAll(label1, button1); This function adds the label and button as children of the virtual box
    //scene1= new Scene(layout1, 300, 250); This initializes the first scene. The first scene is the layout with its children and the size is set up.
    //for the stylesheet to work you gotta add it to the layout and set ids for the things you make here
    //whatamidoingnow i should start with the third scene, the main game, and make buttons with images of bottles. The buttons will have to work.
    //plan - first scene title, second instructions, third main game, fourth bottle main game, fifth level results, sixth end game??
    //either way i can just work on the main game, THEN set it permanently to a scene. Scene for now will be scene #2.
    //now how in the world do i do this? first - make the buttons and place them second make them do something.
    //

}