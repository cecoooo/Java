import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1;
    protected String username;
    protected String password;
    public abstract String getUserType();
}
