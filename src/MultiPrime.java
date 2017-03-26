import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.util.Random;

/**
 * Created by stfcr on 3/26/2017.
 */
public class MultiPrime {
    private BigInteger n=new BigInteger("0");
    private BigInteger p=new BigInteger("0");
    private BigInteger q=new BigInteger("0");
    private BigInteger r=new BigInteger("0");
    private BigInteger e=new BigInteger("41");
    private BigInteger d=new BigInteger("0");
    private BigInteger phi=new BigInteger("0");
    public static final String ALGORITHM = "RSA";
    private RSAPublicKey blindingKey = null;
    public MultiPrime(){
        Random rand=new Random();
        p=BigInteger.probablePrime(512,rand);
        q=BigInteger.probablePrime(512,rand);
        r=BigInteger.probablePrime(512,rand);
        n=p.multiply(q.multiply(r));
        BigInteger pMinus1=p.subtract(new BigInteger("1"));
        BigInteger qMinus1=q.subtract(new BigInteger("1"));
        BigInteger rMinus1=r.subtract(new BigInteger("1"));
        phi=pMinus1.multiply(qMinus1.multiply(rMinus1));
        d=e.modInverse(phi);
    }

    public void doEncryption(){
        System.out.println(n);
        System.out.println(p);
        System.out.println(q);
        System.out.println(r);
        System.out.println(e);
        System.out.println(d);
    }


}
