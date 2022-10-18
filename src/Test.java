import ChatBot.ChatBot;

public class Test {
    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot("Elena", 2022);
        chatBot.sayHi();
        chatBot.askName();
    }
}
