import java.util.UUID;

public class User {
    private final String id;
    private final String email;
    private final String name;
    private String password;

    public User(int id, String email, String name, String password) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
