package exceptions;


public class InvalidQuantityException extends Exception {
    public InvalidQuantityException(int invalidQuantity) {
        super("Expected quantity to be between 1 and 100 but got " + invalidQuantity + ".");
    }

}