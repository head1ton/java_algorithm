package com.youwiz.programmers.v1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

@SpringBootTest
public class BridgeTest {

    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    @Test
    public void bridge() {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int answer = 0;

        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truck_weights) {
            waitQ.offer(new Truck(t));
        }

        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridge_length) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        System.out.println("answer = " + answer);
    }

    @Test
    public void bridge1() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};
        int answer = 0;

        Stack<Integer> truckStack = new Stack<>();
        HashMap<Integer, Integer> bridgeMap = new HashMap<>();

        for (int i = truck_weights.length - 1; i >= 0; i--) {
            truckStack.push(truck_weights[i]);
        }

        int sum = 0;
        while (true) {
            answer++;
            if (bridgeMap.containsKey(answer))
                bridgeMap.remove(answer);

            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

            if (!truckStack.isEmpty())
                if (sum + truckStack.peek() <= weight)
                    bridgeMap.put(answer + bridge_length, truckStack.pop());

            if (bridgeMap.isEmpty() && truckStack.isEmpty())
                break;
        }
        System.out.println("answer = " + answer);
    }

    @Test
    public void bridge2() {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int j = 0; j < bridge_length; j++) {
            que.offer(0);
        }
        while (!que.isEmpty()) {
            int popped = que.poll();
            sum -= popped;
            if (i < truck_weights.length) {
                if (sum + truck_weights[i] <= weight) {
                    que.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                } else {
                    que.offer(0);
                }
            }
            answer++;
        }

        System.out.println("answer = " + answer);
    }

    @Test
    public void bridge3() {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int j = 0; j < bridge_length; j++) {
            que.offer(0);
        }
        while (!que.isEmpty()) {
            int popped = que.poll();
            sum -= popped;
            if (i < truck_weights.length) {
                if (sum + truck_weights[i] <= weight) {
                    que.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                } else {
                    que.offer(0);
                }
            }
            answer++;
        }

        System.out.println("answer = " + answer);
    }

    @Test
    public void bridge4() {
        int bridge_length = 2;                      // 다리에 올라갈 수 있는 트럭 수
        int weight = 10;                                // 다리가 견딜 수 있는 무게
        int[] truck_weights = {7, 4, 5, 6};     // 트럭별 무게 수
        int answer = 0;                                 // 몇 초 걸리는지
        int sum = 0;                                        // 동시에 올라갈 때의 합산을 위해
        int i = 0;                                              // 트럭 무게 길이만큼 돌리기 위해

        Queue<Integer> que = new LinkedList<>();
        for (int j = 0; j < bridge_length; j++) {   // que 길이만큼 만들어준다.(트럭이 다리에 올라갈 수 있는 만큼 생성)
            que.offer(0);                                   // que 에 기본으로 0을 추가
        }

        while (!que.isEmpty()) {                        // que 에 담겨 있는 것이 없을 때까지 돌자
            int popped = que.poll();                    // que 에서 처음으로 들어간 거 뽑고 popped 에 넣어줌
            sum -= popped;                                  // 다리에 올라가 있는 무게의 합산이라 생각하면 된다.
            if (i < truck_weights.length) {             // 트럭 무게 길이만큼 돌리고
                if (sum + truck_weights[i] <= weight) {     // sum 과 현재 트럭의 무게가 weight 보다 작거나 같다면
                    que.offer(truck_weights[i]);            // que 에 무게의 값을 셋팅
                    sum += truck_weights[i];                        // 다리에 올라갈 수 있는 무게의 합을 계산하기 위해 sum 에 값을 넣어줌.
                    i++;
                } else {                                                        // weight 무게보다 크다면
                    que.offer(0);
                }
            }
            answer++;                                            // 1초씩 올려줌
        }
        System.out.println("answer = " + answer);
    }
}
