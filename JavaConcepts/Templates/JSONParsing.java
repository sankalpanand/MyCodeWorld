package JavaConcepts.Templates;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class JSONParsing {

	// JSON Simple 1.1.1
	public static void main(String[] args) throws IOException
	{
		URL url = new URL("http://mysafeinfo.com/api/data?list=englishmonarchs&format=json");
		// URL url = new URL("http://freegeoip.net/json/");

		// Connect to the URL using java's native library
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		request.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); //from gson
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element

		// This will throw error if JSON is in [{}, {}] format
		// JsonObject rootobj = root.getAsJsonObject();
		// String zipcode = rootobj.get("zip_code").getAsString();

		for (int i = 0; i < ((JsonArray) root).size(); i++) {
			JsonElement jsonElement = ((JsonArray) root).get(i);
			// System.out.println(jsonElement);
			String name = ((JsonObject) jsonElement).get("nm").getAsString();
			System.out.println(name);
		}
	}

}
