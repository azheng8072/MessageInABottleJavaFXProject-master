package sample;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    Scene scene1, scene2, scene3, scene4;

//add the police song message in a bottle or one of the instrumentals or both
    @Override
    public void start(Stage primaryStage)throws Exception {
        primaryStage.setTitle("SceneTest");
//        String fileName = "C:\\Users\\BT_1N3_27\\IdeaProjects\\MessageInABottleJavaFXProject-master\\MessageInABottleJavaFXProject-master\\src\\sample\\Bottle.csv";
//        File file = new File(fileName); //read about file
//        try {
//            Scanner inputStream = new Scanner(file);
//            inputStream.next(); //ignores 1st line
//            while (inputStream.hasNext()){
//                String data = inputStream.next();  //gets whole line
//                String[] values = data.split(",");
//                double Va = Double.parseDouble(values[2]); //replace variable with name of what the values means. replace x with the order place the value is in
//                System.out.println(Va);
//            }
//            inputStream.close();
//        }catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }



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

    public static class CSVReaderInJava {

        public static void main(String... args) {
            List<Book> books = readBooksFromCSV("books.txt");

            // let's print all the person read from CSV file
            for (Book b : books) {
                System.out.println(b);
            }
        }

        private static List<Book> readBooksFromCSV(String fileName) {
            List<Book> books = new ArrayList<>();
            Path pathToFile = Paths.get(fileName);

            // create an instance of BufferedReader
            // using try with resource, Java 7 feature to close resources
            try (BufferedReader br = Files.newBufferedReader(pathToFile,
                    StandardCharsets.US_ASCII)) {

                // read the first line from the text file
                String line = br.readLine();

                // loop until all lines are read
                while (line != null) {

                    // use string.split to load a string array with the values from
                    // each line of
                    // the file, using a comma as the delimiter
                    String[] attributes = line.split(",");

                    Book book = createBook(attributes);

                    // adding book into ArrayList
                    books.add(book);

                    // read next line before looping
                    // if end of file reached, line would be null
                    line = br.readLine();
                }

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            return books;
        }

        private static Book createBook(String[] metadata) {
            String name = metadata[0];
            int price = Integer.parseInt(metadata[1]);
            String author = metadata[2];

            // create and return book of this metadata
            return new Book(name, price, author);
        }

    }

    static class Book {
        private String name;
        private int price;
        private String author;

        public Book(String name, int price, String author) {
            this.name = name;
            this.price = price;
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book [name=" + name + ", price=" + price + ", author=" + author
                    + "]";
        }

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
