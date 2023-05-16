package User;

public class CustomerUser implements User{

    private final CustomerInformation customerInformation;

    public CustomerUser (CustomerInformation customerInformation){
        this.customerInformation = customerInformation;
    }

    public CustomerInformation getCustomerInformation() {
        return this.customerInformation;
    }

    @Override
    public void login() {
        // TODO
    }

    @Override
    public void logout() {
        // TODO
    }

    @Override
    public void setCurrentUser() {

    }
}
