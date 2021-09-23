package code;

import util.ProcessInputString;

import java.util.Arrays;
import java.util.LinkedList;

public class P0735 {
    public static void main(String[] args) {
        P0735 main = new P0735();
        int[] vector = ProcessInputString.processVector("[5,10,-5]");
        System.out.println(Arrays.toString(main.asteroidCollision(vector)));
    }
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> plane = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                int weight = Math.abs(asteroids[i]);
                while (!plane.isEmpty()) {
                    int index = plane.pollLast();
                    if (weight < asteroids[index]) {
                        asteroids[i] = 0;
                        plane.add(index);
                        break;
                    } else if (weight > asteroids[index]){
                        asteroids[index] = 0;
                    } else {
                        asteroids[i] = asteroids[index] = 0;
                        break;
                    }
                }
            } else if (asteroids[i] > 0){
                plane.add(i);
            }
        }
        int sums = 0;
        for (int asteroid : asteroids) {
            if (asteroid == 0) {
                sums++;
            }
        }
        int[] answer = new int[asteroids.length-sums];
        int index = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                answer[index++] = asteroid;
            }
        }
        return answer;
    }
}
