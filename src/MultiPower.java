import java.math.BigInteger;
import java.util.Random;

/**
 * Created by stfcr on 3/26/2017.
 */
public class MultiPower {
    private BigInteger n = new BigInteger("0");
    private BigInteger p = new BigInteger("0");
    private BigInteger pPatrat=new BigInteger("0");
    private BigInteger q = new BigInteger("0");
    private BigInteger e= new BigInteger("41");
    private BigInteger d=new BigInteger("0");
    private BigInteger phi=new BigInteger("0");
    public MultiPower(){
        Random rand = new Random();
        p = BigInteger.probablePrime(512, rand);
        q = BigInteger.probablePrime(512, rand);
        pPatrat=p.multiply(p);
        n=pPatrat.multiply(q);
        BigInteger pPatratMinusP=pPatrat.subtract(p);
        BigInteger qMinus1 = q.subtract(new BigInteger("1"));
        phi=pPatratMinusP.multiply(qMinus1);
        d=e.modInverse(phi);
    }

    public BigInteger doEncryption(BigInteger text) {
        return text.modPow(e, n);
    }

    public BigInteger doDecryption(BigInteger cipher) {
        return cipher.modPow(d, n);
    }

    public BigInteger doDecryptionFaster(BigInteger cipher){
        BigInteger qMinus1=q.subtract(new BigInteger("1"));
        BigInteger yp2=cipher.mod(pPatrat);
        BigInteger pMinus1=p.subtract(new BigInteger("1"));
        BigInteger x0=(cipher.mod(p)).modPow(d.mod(pMinus1),p);
        BigInteger E=yp2.subtract(x0.modPow(e,pPatrat)).mod(pPatrat);
        BigInteger eMinus1=e.subtract(new BigInteger("1"));
        BigInteger paranteza=(e.multiply(x0.modPow(eMinus1,p)));
        BigInteger x1=((E.divide(p)).multiply((paranteza.modInverse(p)))).mod(p);
        BigInteger xp2=x0.add((p.multiply(x1)));
        BigInteger xq=(cipher.mod(q)).modPow(d.mod(qMinus1),q);
        BigInteger paranteza1=xq.subtract(xp2);
        BigInteger m=xp2.add(paranteza1.multiply(pPatrat.modInverse(q))).mod(q);
        return m;
    }
}
