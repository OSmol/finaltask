package by.javatr.lemesheuski.library.view;

import by.javatr.lemesheuski.library.сontroller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner in = new Scanner(System.in);
        String type="";
        String request;
        String response = null;
        while (true){
            System.out.println("Input command");
            request = type + in.nextLine();
            System.out.println("Input parameters. To end the input enter \"end\"");
            while(true){
                String input = in.nextLine();
                if(input.equals("end")){
                    break;
                }
                request += "&"+input;
            }
            response = controller.executeTask(request);
            if(response.equals("exit"))
                break;
            String[] responseList=response.split("&");
            type=responseList[0];
            String message = responseList[1];
            System.out.println(message);
        }
    }
}
