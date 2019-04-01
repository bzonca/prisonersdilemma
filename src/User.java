import java.util.Scanner;

public class User extends Player {

    private Scanner kb;

    public User(Scanner kb){
        this.kb = kb;
    }

    public boolean makeDecision() {
        System.out.println("Type 'C' to cooperate, 'D' to defect, 'Q' to quit...");
        String userInput = kb.next();  // Read user input

        boolean userDecision = false;

        try {
            if(userInput.equalsIgnoreCase("C")){
                System.out.println("Chose to cooperate");
                userDecision = true;
            }else if(userInput.equalsIgnoreCase("D")){
                System.out.println("Chose to defect");
                userDecision = false;
            }else if (userInput.equalsIgnoreCase("Q")){
                System.out.println("Quitting...");
                System.exit(0);
            }else{
                System.out.println("String input, but invalid choice");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return userDecision;
    }

    public String toString() {
        return "User (keyboard)";
    }
}
