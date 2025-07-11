import com.util.ConfigReader;

public class Main {
	static ConfigReader config = new ConfigReader();
	public static void main(String[] args) {
		
		System.out.println(ConfigReader.get("url"));
	}

}
