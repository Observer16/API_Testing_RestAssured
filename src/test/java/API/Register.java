package API;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Register {
    private String email;
    private String password;

    public Register() {
        // Пустой конструктор по умолчанию
    }

    public Register(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }
}
