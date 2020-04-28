package system.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SystemTest {

    @Test
    public  void test(){
        String getProperty1 = System.getProperty("os.version");
        String getProperty2 = System.getProperty("os.name");

        System.out.println(getProperty1 + " && " + getProperty2);


        int a = 7;
        int b = 3;
        BigInteger bi = new BigInteger(String.valueOf((int) Math.pow(a, b)));
        BigDecimal bd = new BigDecimal("1231232.1231");
        BigDecimal bd2 = new BigDecimal("13");
        System.out.println(bi); // 823543
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));

    }

}
