import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by stfcr on 3/26/2017.
 */
public class Input {
    private String filename;

    public Input(String filename) {
        this.filename = filename;
    }

    public String readText() {
        BufferedReader br = null;
        String text = "";
        try {
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                text += line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return text;
        }
    }
}
