import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameManager extends Application{

    private boolean isProgramActive;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        //TODO : Port all interaction to javafx
        //GameManager gm = new GameManager();
        //gm.runProgramLoop();
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
}