import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyConverter {
    private double exchangeRate;

    public CurrencyConverter(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public static double convert(String source, String target, double amount) {
        String url = String.format("https://api.frankfurter.dev/v1/latest?base=%s&symbols=%s", source, target);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(response.body());
            double rate = json.get("rates").get(target).asDouble();

            return amount * rate;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1; // Return -1 to indicate an error occurred
        }
    }
}
