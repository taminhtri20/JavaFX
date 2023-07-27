import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.geeksforgeeks.org/javafx-filechooser-class/");

        URLConnection urlConnection = url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }

        br.close();
    }
}