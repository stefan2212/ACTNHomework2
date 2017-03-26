import java.math.BigInteger;
import java.util.Random;

/**
 * Created by stfcr on 3/26/2017.
 */
public class MultiPrimeTest {
    public MultiPrimeTest(){
        Input input=new Input("input.txt");
        BigInteger text=BigInteger.probablePrime(1024,new Random());
        MultiPrime enc=new MultiPrime();
        BigInteger cipher=enc.doEncryption(text);
        long startTimeV1=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            BigInteger plainText = enc.doDecryption(cipher);
        }
        long endTimeV1=System.currentTimeMillis();
        long time1=Math.abs(startTimeV1-endTimeV1);

        long starTimeV2=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            BigInteger plainText2 = enc.doDecryptCRT(cipher);
        }
        long endTimeV2=System.currentTimeMillis();
        long time2=Math.abs(starTimeV2-endTimeV2);
        System.out.println((double)time1/time2);

    }
}
