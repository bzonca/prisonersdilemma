import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.collections.FXCollections;
import sun.security.x509.CertAttrSet;

public class GameManager extends Application{
    
    
    
    private boolean isProgramActive;

    public static void main(String[] args) {
        launch(args);
    }
    
    private void runProgramLoop(){
        isProgramActive = true;
        Scanner kb = new Scanner(System.in);  // Create a Scanner object
        while (isProgramActive){

            System.out.print("Number of turns : ");
            int numTurns = kb.nextInt();  // Read user input

            //Create player1 as a user. Let it use the scanner used previously.
            //Player player1 = new User(kb);
            Player player1 = new RandomPlayer();
            //Create player2 Always false
            //Player player2 = new AlwaysSame(false);
            Player player2 = new AlwaysSame(false);

            //Create game with parameters
            startGame(player1, player2, numTurns);

            isProgramActive = false;
        }
    }

    private void startGame(Player playerA, Player playerB, int turns){
        //Create game and start it
        Game game = new Game(playerA, playerB, turns);
        game.begin();
    }
    
    private void initializeGameFromGUI(String playerAChoice, String playerBChoice, int turns){
        
        System.out.println("-Player a " + playerAChoice);
        System.out.println("-Player b " + playerBChoice);
        System.out.println("-Turns " + turns);
        
        Player player1 = getPlayerFromTextChoice(playerAChoice);
        Player player2 = getPlayerFromTextChoice(playerBChoice);
        
        //Create game with parameters
        startGame(player1, player2, turns);
    }
    
    private Player getPlayerFromTextChoice(String str){
        
        switch(str) {
            case "Random" : return new RandomPlayer();
                
            case "Always Cooperate": return new AlwaysSame(true);
                
            case "Always Defect" : return new AlwaysSame(false);
                
            case "Tit for Tat" : return new TitForTat();
            
            case "User" : return new User(new Scanner(System.in));
              
            case "Neural Net" : return new NeuralNet();
             
            default : System.out.println("Error : Unknown choice");
                return null;
        }
    }

    public static void displayEndScreenPopup(String winnerText, String scoreText){
        Stage popup = new Stage();
        popup.setTitle("Game complete");
        GridPane root = new GridPane();
        
        Label winnerLabel = new Label(winnerText);
        winnerLabel.setFont(new Font("Arial", 20));
        winnerLabel.setStyle("-fx-font-weight: bold");
        winnerLabel.setPadding(new Insets(15.0, 10.0, 0.0, 10.0));
        
        Label scoreLabel = new Label(scoreText);
        scoreLabel.setPadding(new Insets(15.0, 10.0, 0.0, 10.0));
        scoreLabel.setFont(new Font("Arial", 16));
        scoreLabel.setLineSpacing(4.0);
        
        root.add(winnerLabel, 0,0);
        root.add(scoreLabel,0,1);

        popup.setScene(new Scene(root, 400, 300));
        popup.show();
    }

    //TODO : Have this popup handle all user related input
    public static void displayUserInputStage(){
//        Stage popup = new Stage();
//        popup.setTitle("Game complete");
//        GridPane root = new GridPane();
//
//        Label winnerLabel = new Label(winnerText);
//        winnerLabel.setFont(new Font("Arial", 20));
//        winnerLabel.setStyle("-fx-font-weight: bold");
//        winnerLabel.setPadding(new Insets(15.0, 10.0, 0.0, 10.0));
//
//        Label scoreLabel = new Label(scoreText);
//        scoreLabel.setPadding(new Insets(15.0, 10.0, 0.0, 10.0));
//        scoreLabel.setFont(new Font("Arial", 16));
//        scoreLabel.setLineSpacing(4.0);
//
//        root.add(winnerLabel, 0,0);
//        root.add(scoreLabel,0,1);
//
//        popup.setScene(new Scene(root, 400, 300));
//        popup.show();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Prisoner's Dilemma");
        BorderPane root = new BorderPane();
        

        GridPane gpTop = new GridPane();
        gpTop.setPadding(new Insets(10.0, 20.0, 20.0, 20.0));
        
        Label title = new Label("Choose two strategies using the dropdowns");
        title.setFont(new Font("Arial", 30));

        Label numTurns = new Label("Number of turn iterations");
        numTurns.setFont(new Font("Arial", 16));
        numTurns.setPadding(new Insets(0.0, 20.0, 0.0, 20.0));

        NumberTextField turnInput = new NumberTextField();
        turnInput.replaceSelection("0");
        turnInput.maxWidth(30.0);
        

        gpTop.add(title, 0, 0, 3, 1);
        gpTop.add(numTurns, 0, 1);
        gpTop.add(turnInput, 1, 1);
        
        root.setTop(gpTop);


        Button btnExit = new Button();
        btnExit.setText("Exit");
        btnExit.setPadding(new Insets(30.0));
        btnExit.setOnAction(e -> System.exit(0));

        Button btnBegin = new Button();
        btnBegin.setText("Begin");
        btnBegin.setPadding(new Insets(30.0));
        


        HBox hbox = new HBox();
        hbox.setMaxWidth(200.0);


        hbox.getChildren().addAll(btnExit, btnBegin);
        root.setBottom(hbox);

        GridPane.setHalignment(hbox, HPos.CENTER);


        GridPane gridpane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);

        gridpane.getColumnConstraints().addAll(column1, column2); // each get 50% of width
        gridpane.setPadding(new Insets(100.0, 20.0, 20.0, 20.0));


        Label playerALabel = new Label("Player 1");
        playerALabel.setFont(new Font("Arial", 24));
        playerALabel.setPadding(new Insets(10.0, 0.0, 10.0, 0.0));
        GridPane.setHalignment(playerALabel, HPos.CENTER);

        Label playerBLabel = new Label("Player 2");
        playerBLabel.setFont(new Font("Arial", 24));
        playerBLabel.setPadding(new Insets(10.0, 0.0, 10.0, 0.0));
        GridPane.setHalignment(playerBLabel, HPos.CENTER);

        ObservableList strategies = FXCollections.observableArrayList(
                "Random",
                "Always Cooperate",
                "Always Defect",
                "Tit for Tat",
                new Separator(),
                "User", "Neural Net");

        ChoiceBox playerAChoiceBox = new ChoiceBox();
        playerAChoiceBox.setItems(strategies);
        playerAChoiceBox.setValue("Random");
        GridPane.setHalignment(playerAChoiceBox, HPos.CENTER);

        ChoiceBox playerBChoiceBox = new ChoiceBox();
        playerBChoiceBox.setItems(strategies);
        playerBChoiceBox.setValue("Random");
        GridPane.setHalignment(playerBChoiceBox, HPos.CENTER);

        gridpane.add(playerALabel, 0, 0); // column=1 row=0
        gridpane.add(playerBLabel, 1, 0);  // column=2 row=0
        gridpane.add(playerAChoiceBox, 0, 1);
        gridpane.add(playerBChoiceBox, 1, 1);
        
        root.setCenter(gridpane);
        BorderPane.setAlignment(gridpane, Pos.CENTER);
        BorderPane.setAlignment(title, Pos.TOP_CENTER);

        btnBegin.setOnAction(e -> {
            GameManager gm = new GameManager();
            gm.initializeGameFromGUI(playerAChoiceBox.getValue().toString(), 
                    playerBChoiceBox.getValue().toString(), 
                    turnInput.getInt());

        });

        primaryStage.setScene(new Scene(root, 640, 640));
        primaryStage.show();

    }

    public class NumberTextField extends TextField
    {

        @Override
        public void replaceText(int start, int end, String text)
        {
            if (validate(text))
            {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String text)
        {
            if (validate(text))
            {
                super.replaceSelection(text);
            }
        }

        private boolean validate(String text)
        {
            return text.matches("[0-9]*");
        }
        
        public int getInt(){
            return Integer.parseInt(getText());
        }
    }
}