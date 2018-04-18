package code;

import java.util.Scanner;

public class DisplayUtility {
    Scanner input = new Scanner(System.in);

    public void showToScreen(String... messages) {
        for (String str : messages) {
            System.out.println(str);
        }
    }

    public void showToScreen(String message) {
        System.out.println(message);
    }

    public String getFromScreen() {
        String result;
        System.out.print("> ");
        result = input.nextLine();
        System.out.println();
        return result;
    }

    public void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue . . . ");
        input.nextLine();
    }
}