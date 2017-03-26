import java.math.BigInteger;
import java.util.Random;

/**
 * Created by stfcr on 3/26/2017.
 */
public class MultiPrime {
    private BigInteger n=new BigInteger("0");
    private BigInteger p=new BigInteger("0");
    private BigInteger q=new BigInteger("0");
    private BigInteger r=new BigInteger("0");
    public static final String ALGORITHM = "RSA";
    public MultiPrime(){
        Random rand=new Random();
        p=BigInteger.probablePrime(512,rand);
        q=BigInteger.probablePrime(512,rand);
        r=BigInteger.probablePrime(512,rand);
        n=p.multiply(q.multiply(r));
    }

    public void doEncryption(){
        System.out.println(n);
        System.out.println(p);
        System.out.println(q);
        System.out.println(r);
    }
}
