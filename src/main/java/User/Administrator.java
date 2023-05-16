package User;

import java.io.Serializable;

public class Administrator implements User, Serializable {

    private final AdminInformation adminInformation;
    public Administrator (String username, String password){
        this.adminInformation = new AdminInformation(username, password);
    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}

