package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.PriorityQueue;

@SpringBootTest
public class DiskControllerTest {

    @Test
    public void diskcontroll() {
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs = {{0, 5}, {1, 12}, {2, 8}};
        // 시작 시간 빠른 순 정렬
        Arrays.sort(jobs, (x, y) -> (x[0] - y[0]));
        // 실행 시간 적은 순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
        // 시간, 인덱스, 답 초기화
        int time = 0, idx = 0, answer = 0;
        // 인덱스가 범위내에 있거나, pq가 비어있지 않다면 while 진행
        while (idx < jobs.length || !pq.isEmpty()) {
            // 인덱스가 범위 내에 있고, 시작시간이 시간 이내라면 pq에 넣기
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx++]);
            }
            // pq 가 비어있다면 (시간 이내에 시작하는 task가 없다면)
            if (pq.isEmpty()) {
                time = jobs[idx][0];
                continue;
            }
            // pq가 비어있지 않다면
            // 시간에 pq에 들어간 작은 수행 시간을 더함
            int[] job = pq.poll();
            time += job[1];
            // 종료 시간 - 시작시간
            answer += time - job[0];
        }
        // 평균시간이므로 job의 길이로 나눠줌
        System.out.println("answer = " + answer / jobs.length);
    }
}
