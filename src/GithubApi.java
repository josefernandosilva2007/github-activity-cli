import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GithubApi {
    public static void main(String[] args) {
        String username = args[0];
        String buildUri = String.format("https://api.github.com/users/%s/events", username);

        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(buildUri))
                .header("Accept", "application/json")
                .GET()
                .build();

        try{
            HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());


            System.out.println("Status: " +  response.statusCode());
            System.out.println("Body: " +  response.body());
        }catch(IOException | InterruptedException e){
            e.printStackTrace();
        }


        }
    }
