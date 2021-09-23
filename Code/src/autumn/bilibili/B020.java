package autumn.bilibili;

import java.util.Arrays;
import java.util.Scanner;

public class B020 {
    public static void main(String[] args) {
        Scanner java = new Scanner(System.in);
        int days = java.nextInt();
        int num;
        Mission[] missions = new Mission[days];
        for (int i = 0; i < days; i++) {
            num = java.nextInt();
            missions[i] = new Mission(num);
        }
        for (int i = 0; i < days; i++) {
            missions[i].type = java.nextInt();
        }
        Arrays.sort(missions, (first, second) -> {
            if (first.type < second.type) {
                return 1;
            } else if (first.type == second.type) {
                return Integer.compare(second.num, first.num);
            } else {
                return -1;
            }
        });
        int[] type = new int[] {0, 100, 45, 5};
        int[] maxType = new int[] {0, 0, 0, 0};
        int typeIndex = 3;
        for (int i = 0; i < days; i++) {
            if (typeIndex == missions[i].type) {
                maxType[typeIndex--] = i;
            }
        }
        int day = 0;
        for (int i = 0; i < days; i++) {
            if (missions[i].type >= typeIndex) {
                if (i+1 < days && missions[i+1].type == typeIndex) {
                    maxType[typeIndex] = i + 1;
                } else {
                    maxType[typeIndex] = -1;
                }
                day++;
                num = missions[i].num;
                while (num > 0) {
                    if (missions[i].num <= type[typeIndex]) {
                        type[typeIndex] -= num;
                        num = 0;
                    } else {
                        num -= type[typeIndex];
                        type[typeIndex--] = 0;
                    }
                    if (typeIndex == 0) {
                        System.out.println(day);
                        return;
                    }
                }
            }
            if (typeIndex == 2) {
                if (maxType[3] != -1 && missions[maxType[3]].num >= missions[maxType[2]].num) {
                    typeIndex++;
                }
            }
        }
    }
    private static class Mission {
        private final int num;
        private int type;
        private Mission(int num) {
            this.num = num;
        }

        @Override
        public String toString() {
            return "Mission{" +
                    "num=" + num +
                    ", type=" + type +
                    '}';
        }
    }
    private static class Activity {
        private final int[] missions;
        private Activity() {
            missions = new int[4];
            missions[0] = 0;
            missions[1] = 100;
            missions[2] = 45;
            missions[3] = 5;
        }
        private boolean choose(Mission mission) {
            int num = mission.num;
            int type = mission.type;
            while (num > 0 && missions[type] > 0) {
                if (missions[type] >= mission.num) {
                    missions[type] -= mission.num;
                    num = 0;
                } else {
                    num -= missions[type];
                    missions[type--] = 0;
                }
            }
            return missions[1] == 0 && missions[2] == 0 && missions[3] == 0;
        }
    }
}
