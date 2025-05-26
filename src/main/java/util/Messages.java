package util;

public class Messages {
    public static void sendMessage(String message) {
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
        System.out.println(message);
    }

    public static void sendMessage(String message, String message1) {
        for (int i = 0; i < 50; i++) {
            System.out.println(" ");
        }
        System.out.println(message);
        System.out.println(message1);
    }
}
