import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ashutosh on 26-09-2016.
 */

@SpringBootApplication

public class App {

    public static void main(String[] args) {

        final String apiKey = "AIzaSyBcKII4bmIodWmM2MRDei4R3-QQ3QRTKiw";

        try {

            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + apiKey);

            conn.setDoOutput(true);

            String input = "{\"to\" : \"/topics/news\", \"data\" : {\"image\" : \"http://52.24.133.119:8009/image/NP0L4XZI.png\" , \"AnotherActivity\" : \"True\"," +
                    " \"title\" : \"Firebase Push Message Using API\", \"message\" : \"Firebase Push Message Using API Firebase Push Message Using API Firebase Push Message Using API\"}}";

            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + input);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
