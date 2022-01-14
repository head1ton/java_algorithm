package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@SpringBootTest
public class PhoneBookTest {

    @Test
    public void phoneBook() {
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean answer = true;

        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[i].startsWith(phone_book[j])) {
                    answer = false;
                    break;
                }
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
            }
        }
        System.out.println("answer = " + answer);

    }

    @Test
    public void phoneBook1() {
        String[] phone_book = {"123","456","789"};

        boolean answer = true;

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hm.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void phoneBook2() {
        String[] phone_book = {"12","123","1235","567","88"};

        boolean answer = true;

        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String str : set) {
            for (int i = 1; i < str.length(); i++) {
                if (set.contains(str.substring(0, i))) {
                    answer = false;
                }
            }
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void phoneBook3() {
        String[] phone_book = {"12", "234", "1245", "567", "5679", "88"};
//        String[] phone_book = {"123","456","789"};
        boolean answer = true;

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            hm.put(phone_book[i], i);
        }

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (hm.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}
