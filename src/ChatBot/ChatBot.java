package ChatBot;

public class ChatBot {
    String botName;
    int yearOfCreation;

    public ChatBot (String botName, int yearOfCreation){
        this.botName = botName;
        this.yearOfCreation = yearOfCreation;
    }
    public void sayHi(){
        System.out.printf("Hello! My name is %s\n", this.botName);
        System.out.printf("I was created in %d", this.yearOfCreation);
    }
}
