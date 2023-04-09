class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lt = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            lt.put(nums[i], i);
        }

        int index = 0;
        for(int n: nums) {
            if (lt.containsKey(target - n) && lt.get(target - n) != index) {
                return new int[] {index, lt.get(target - n)};
            }
            index += 1;
        }
        return new int[2];
    }
}
