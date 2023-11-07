package sections_8_16.exceptions;

public class EntityException extends Exception {
    private static final long serialVersionUID = 1L;
     
    public EntityException(String msg){
        super(msg);
    }
}
