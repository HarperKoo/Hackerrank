package com.harper.daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by harperkoo on 12/22/16.
 */
public class euler169 {
    // Memoization
    private Map<List<BigInteger>,BigInteger> ways = new HashMap<>();

    private BigInteger countWays(BigInteger number, int exponent, int repetitions) {
        List<BigInteger> key = Arrays.asList(number, BigInteger.valueOf(exponent), BigInteger.valueOf(repetitions));
        if (ways.containsKey(key))
            return ways.get(key);

        BigInteger result;
        if (exponent < 0)
            result = number.equals(BigInteger.ZERO) ? BigInteger.ONE : BigInteger.ZERO;
        else {
            result = countWays(number, exponent - 1, 2);
            BigInteger pow = BigInteger.ONE.shiftLeft(exponent);
            BigInteger upper = pow.multiply(BigInteger.valueOf(repetitions + 2));
            if (repetitions > 0 && pow.compareTo(number) <= 0 && number.compareTo(upper) < 0)
                result = result.add(countWays(number.subtract(pow), exponent, repetitions - 1));
        }
        ways.put(key, result);
        return result;
    }
    public static void main(String[] args) {
        BufferedReader br = null;
        euler169 s = new euler169();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            BigInteger N = BigInteger.valueOf(n);
            System.out.println(s.countWays(N, N.bitLength() - 1, 2).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
