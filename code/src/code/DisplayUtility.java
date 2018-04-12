package code;

import java.util.Scanner;

public class DisplayUtility {
    Scanner input = new Scanner(System.in);

    public void showToScreen(String message) {
        System.out.println(message);
    }

    public String getFromScreen() {
        return input.nextLine();
    }
}