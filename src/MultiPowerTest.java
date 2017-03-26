import java.math.BigInteger;
import java.util.Random;

/**
 * Created by stfcr on 3/26/2017.
 */
public class MultiPowerTest {
    public MultiPowerTest(){
        BigInteger text=BigInteger.probablePrime(256,new Random());
        MultiPower power=new MultiPower();
        BigInteger cipher=power.doEncryption(text);
        long startTimeV1=System.currentTimeMillis();
        for(int i=0;i<200;i++) {
            BigInteger plainText = power.doDecryption(cipher);
        }
        long endTimeV1=System.currentTimeMillis();
        long time1=Math.abs(startTimeV1-endTimeV1);

        long starTimeV2=System.currentTimeMillis();
        for(int i=0;i<200;i++) {
            BigInteger plainTexxt2 = power.doDecryptionFaster(cipher);
        }
        long endTimeV2=System.currentTimeMillis();
        long time2=Math.abs(starTimeV2-endTimeV2);
        System.out.println((double)time1/time2);
    }
}
