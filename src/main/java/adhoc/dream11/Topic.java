package adhoc.dream11;

public interface Topic {
    public String getMessage() throws InterruptedException;
    void putMessage(String message) throws InterruptedException;
}
