package exceptions;

public class CustomIllegalArgumentException extends RuntimeException {
    public CustomIllegalArgumentException() {
        this("잘못된 인자입니다.");
    }
    
    public CustomIllegalArgumentException(String message) {
        super(message);
    }
}
