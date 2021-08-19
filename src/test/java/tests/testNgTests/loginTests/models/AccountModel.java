package tests.testNgTests.loginTests.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class AccountModel {

    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;

    public AccountModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountModel() {
    }


}
