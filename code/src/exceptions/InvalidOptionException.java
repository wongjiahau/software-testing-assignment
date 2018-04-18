package exceptions;

public class InvalidOptionException extends Exception {
    public InvalidOptionException(String invalidOption) {
        super("Invalid option. Expected 'a' or 'b' or 'c' but got " + invalidOption);
    }
}