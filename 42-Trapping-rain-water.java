/*
Trap water if height of bars around i is >  height[i]
water[i] = min(tallest to left, tallest to right) - height[i]
tallest to left = build by iterating over heights from l to r, storing max seen so far
tallest to right = build by iterating over heights from r to l, storing max
hei = [0,1,0,2,1,0,1,3,2,1,2,1]
l2r = [0,1,1,2,2,2,2,3,3,3,3,3]
r2l = [3,3,3,3,3,3,3,3,2,2,2,1]
water[i] = [min(0,3) - 0, min(1,3) - 1, min(1,3) - 0,]
*/

class Solution {
    public int trap(int[] height) {
        int[] l2r = new int[height.length];
        int[] r2l = new int[height.length];
        int water = 0;
        for(int i = 0; i < height.length; i++) {
            l2r[i] = i == 0 ? height[0] : Math.max(height[i], l2r[i - 1]); 
        }
        for(int i = height.length - 1; i >= 0; i--) {
            r2l[i] = i == height.length - 1 ? height[i] : Math.max(height[i], r2l[i + 1]);
        }

        for(int i = 0; i < height.length; i++) {
            water += (height[i] > Math.min(l2r[i], r2l[i])) ? 0: Math.min(l2r[i], r2l[i]) - height[i];
        }
        return water;
    }
}
