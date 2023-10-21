package ChatBot;

public class ChatBot {
    public static void main(String[] args) {

        String botName = "Hyron Stick";
        int currentYear = java.time.Year.now().getValue();


        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + currentYear + ".");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, remind me your name.");
        String yourName = scanner.nextLine();

        System.out.println("What a great name you have, " + yourName + "!");

    }
}
