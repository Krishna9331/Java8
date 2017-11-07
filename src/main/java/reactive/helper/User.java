package reactive.helper;

public class User {

    private String name;
    private String email;
    private UserSecurityStatus userSecurityStatus;

    public User(String name, String email, UserSecurityStatus userSecurityStatus) {
        this.name = name;
        this.email = email;
        this.userSecurityStatus = userSecurityStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return userSecurityStatus == user.userSecurityStatus;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userSecurityStatus != null ? userSecurityStatus.hashCode() : 0);
        return result;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserSecurityStatus getUserSecurityStatus() {
        return userSecurityStatus;
    }

    public void setUserSecurityStatus(UserSecurityStatus userSecurityStatus) {
        this.userSecurityStatus = userSecurityStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userSecurityStatus=" + userSecurityStatus +
                '}';
    }
}
