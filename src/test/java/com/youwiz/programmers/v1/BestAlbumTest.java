package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
public class BestAlbumTest {

    @Test
    public void bestAlbum() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
//        int[] answer = {};

        HashMap<String, Object> genresMap = new HashMap<>();    // < 장르, 곡 정보>
        HashMap<String, Integer> playMap = new HashMap<>();         // <장르, 총 장르 재생수>
        ArrayList<Integer> resultAL = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            HashMap<Integer, Integer> infoMap;  // 곡 정보 : <곡 고유번호, 재생횟수>

            if (genresMap.containsKey(key)) {
                infoMap = (HashMap<Integer, Integer>) genresMap.get(key);
            } else {
                infoMap = new HashMap<Integer, Integer>();
            }

            infoMap.put(i, plays[i]);
            genresMap.put(key, infoMap);        //  (장르, (곡 고유번호, 재생횟수))

            if (playMap.containsKey(key)) {
                playMap.put(key, playMap.get(key) + plays[i]);
            } else {
                playMap.put(key, plays[i]);
            }
        }

        int mCnt = 0;
        Iterator it = sortByValue(playMap).iterator();

        while (it.hasNext()) {
            String key = (String) it.next();
            Iterator indexIt = sortByValue((HashMap<Integer, Integer>) genresMap.get(key)).iterator();
            int playsCnt = 0;

            while (indexIt.hasNext()) {
                resultAL.add((int)indexIt.next());
                mCnt++;
                playsCnt++;
                if (playsCnt > 1) break;
            }
        }

        int[] answer = new int[resultAL.size()];

        for (int i = 0; i < resultAL.size(); i++) {
            answer[i] = resultAL.get(i).intValue();
        }

        System.out.println("answer = " + answer);
    }

    private ArrayList sortByValue(final Map map) {
        ArrayList<Object> keyList = new ArrayList<>();
        keyList.addAll(map.keySet());

        Collections.sort(keyList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });
        return keyList;
    }
}
