package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PlayerTest {

    @Test
    public void playerTest() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();

        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        System.out.println("answer = " + answer);

    }

    @Test
    public void playerTest1() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i])) break;
        }

        System.out.println("participant = " + participant[i]);
    }

    @Test
    public void playerTest2() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();

        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void playerTest3() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i])) break;
        }

        System.out.println("participant = " + participant[i]);
    }
}
