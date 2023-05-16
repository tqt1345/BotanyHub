package User;

import java.io.Serializable;

public class Customer implements User, Serializable {

    private final CustomerInformation customerInformation;

    public Customer (String username, String password){
        this.customerInformation = new CustomerInformation(username, password);
    }

    @Override
    public void setUsername(String username) {
        this.customerInformation.setUsername(username);
    }

    @Override
    public void setPassword(String password) {
        this.customerInformation.setPassword(password);
    }

    @Override
    public String getUsername() {
        return this.customerInformation.getUsername();
    }

    @Override
    public String getPassword() {
        return this.customerInformation.getPassword();
    }

    @Override
    public String toString() {
        return "Username: " + this.customerInformation.getUsername() + "\n" +
                "Password: " + this.customerInformation.getPassword() + "\n";
    }
}
