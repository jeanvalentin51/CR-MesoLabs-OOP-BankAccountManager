import java.util.Scanner;

public class App {

    private Scanner input = new Scanner(System.in);
    private void output(String msg) { System.out.println(msg); };
    private String onScreenMsg;
    private Object choice;

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
                //logginMenu();
                break;
            case 2 :
                output("Let's get you set up");
                //newUserMenu();
                break;
            case 3 :
                output("Thank you for banking with us");
                break;
            default:
                output("Please try again");
                break;

        }
    }



    //STRINGS
    String welcome = "Thank You For Banking With 5ive";
    String mainMenu = "What would you like to do?\n" +
            "1 - Log in\n" +
            "2 - Create Account\n" +
            "3 - Exit";

}
