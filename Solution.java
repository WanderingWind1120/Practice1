package org.example;

public class Solution {
    public int solution(int[] height) {

        int[] lessthanleft = new int[height.length];
        int[] lessthanright = new int[height.length];
        lessthanleft[0] = 0;
        lessthanright[height.length - 1] = height.length - 1;

        for (int i = 1; i <= height.length - 1; i++) {
            int p = i;
            while (p - 1 >= 0 && height[p - 1] > height[i]) {
                p--;
            }
            lessthanleft[i] = p;
        }
        for (int i = height.length - 2; i >= 0; i--) {
            int p = i;
            while (p + 1 <= height.length - 1 && height[p + 1] > height[i]) {
                p++;
            }
            lessthanright[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i <= height.length - 1; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessthanright[i] - lessthanleft[i] + 1));
        }

        return maxArea;

    }
}
