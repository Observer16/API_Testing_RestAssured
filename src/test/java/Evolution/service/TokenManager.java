package Evolution.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TokenManager {
    public static String readTokenFromFile() {
        String authToken = null;
        try {
            FileReader fileReader = new FileReader("src/test/java/Evolution/service/authToken.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            authToken = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authToken;
    }
}
