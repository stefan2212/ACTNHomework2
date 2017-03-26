import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
	    Input input=new Input("input.txt");
	    BigInteger text=new BigInteger(input.readText());
	    MultiPrime enc=new MultiPrime();
	    BigInteger cipher=enc.doEncryption(text);
	    BigInteger plainText=enc.doDecryption(cipher);
	    System.out.println(plainText);

    }
}
