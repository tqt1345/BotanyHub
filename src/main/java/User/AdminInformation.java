package User;

public class AdminInformation extends UserInformation{
    private static final String userType = "Admin";
    public AdminInformation(String username, String password) {
        super(username, password);
    }
}
