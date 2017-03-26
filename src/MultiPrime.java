import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.util.Random;

/**
 * Created by stfcr on 3/26/2017.
 */
public class MultiPrime {
    private BigInteger n = new BigInteger("0");
    private BigInteger p = new BigInteger("0");
    private BigInteger q = new BigInteger("0");
    private BigInteger r = new BigInteger("0");
    private BigInteger e = new BigInteger("41");
    private BigInteger d = new BigInteger("0");
    private BigInteger phi = new BigInteger("0");
    public static final String ALGORITHM = "RSA";
    private RSAPublicKey blindingKey = null;

    public MultiPrime() {
        Random rand = new Random();
        p = BigInteger.probablePrime(512, rand);
        q = BigInteger.probablePrime(512, rand);
        r = BigInteger.probablePrime(512, rand);
        n = p.multiply(q.multiply(r));
        BigInteger pMinus1 = p.subtract(new BigInteger("1"));
        BigInteger qMinus1 = q.subtract(new BigInteger("1"));
        BigInteger rMinus1 = r.subtract(new BigInteger("1"));
        phi = pMinus1.multiply(qMinus1.multiply(rMinus1));
        d = e.modInverse(phi);
    }

    public BigInteger doEncryption(BigInteger text) {
        return text.modPow(e, n);
    }

    public BigInteger doDecryption(BigInteger cipher) {
        return cipher.modPow(d, n);
    }

    public BigInteger doDecryptCRT(BigInteger cipher){
        BigInteger pMinus1 = p.subtract(new BigInteger("1"));
        BigInteger qMinus1 = q.subtract(new BigInteger("1"));
        BigInteger rMinus1 = r.subtract(new BigInteger("1"));
        BigInteger dP=d.mod(pMinus1);
        BigInteger dQ=d.mod(qMinus1);
        BigInteger dR=d.mod(rMinus1);
        BigInteger m1=cipher.modPow(dP,p);
        BigInteger m2=cipher.modPow(dQ,q);
        BigInteger m3=cipher.modPow(dR,r);
        BigInteger rInv=r.modInverse(q);
        BigInteger h=rInv.multiply((m2.subtract(m3))).mod(q);
        m2=m2.add(h.multiply(q));
        BigInteger qInv=q.modInverse(p);
        h=qInv.multiply((m1.subtract(m2))).mod(p);
        BigInteger m=m2.add(h.multiply(q));
        return m;
    }

}
