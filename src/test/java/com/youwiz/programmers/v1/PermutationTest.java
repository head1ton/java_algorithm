package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
public class PermutationTest {

    @Test
    public void permutation0() {
        String numbers = "17";
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        System.out.println("answer = " + count);
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if (!prefix.equals("")) {
            set.add(Integer.valueOf(prefix));
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
        }
    }

    @Test
    public void permutation1() {
        String numbers = "011";
        int answer = 0;


        System.out.println("answer = " + answer);
    }
}
