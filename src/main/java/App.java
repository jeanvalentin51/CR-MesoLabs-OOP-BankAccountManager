import user.UserProfile;
import user.UserWarehouse;

import java.util.Scanner;

public class App {

    private Scanner input = new Scanner(System.in);
    private void output(String msg) { System.out.println(msg); };
    private int currentPIN;
    private UserWarehouse client = new UserWarehouse();
    private UserProfile currentUser;

    public void App(){
        output(welcome);
        mainMenu();

    }





    // MENUS

    public void mainMenu(){
        output(mainMenu);
        switch ( input.nextInt() ){
            case 1 :
                output("Logging in...");
                logginMenu();
                break;
            case 2 :
                output("Let's get you set up");
                newUserMenu();
                break;
            case 3 :
                output("Thank you for banking with us");
                break;
            default:
                output("Please try again");
                mainMenu();
                break;
        }
    }

    public void logginMenu(){
        if( authenticateUser() ){
            currentUser = client.getUserProfile(currentPIN);
        }
    }

    public void newUserMenu(){
        if ( !authenticateUser() ){ output("User Already Exists"); newUserMenu();}
        else{
            output("Enter your first name");
            String firstName = input.nextLine();
            output ("Enter your last name");
            String lastName = input.nextLine();
            currentUser = new UserProfile(currentPIN, firstName, lastName);
            client.addUserProfile(currentUser);
        }
    }

    public boolean authenticateUser(){
        output("Enter your PIN");
        currentPIN = input.nextInt();

        return client.getUserProfile(currentPIN) != null;
   }




    //STRINGS

    String welcome = "Thank You For Banking With 5ive";

    String mainMenu = "What would you like to do?\n" +
            "1 - Log in\n" +
            "2 - Create Account\n" +
            "3 - Exit";

}
