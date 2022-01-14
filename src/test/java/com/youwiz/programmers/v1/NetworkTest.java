package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NetworkTest {

    @Test
    public void network0() {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = 0;
        boolean[] chk = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!chk[i]) {
                dfs(computers, chk, i);
            }
        }

        System.out.println("answer = " + answer);
    }

    private void dfs(int[][] computers, boolean[] chk, int start) {
        chk[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[start][i] == 1 && !chk[i]) {
                dfs(computers, chk, i);
            }
        }
    }

    @Test
    public void network1() {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int answer = 0;


        System.out.println("answer = " + answer);
    }
}
