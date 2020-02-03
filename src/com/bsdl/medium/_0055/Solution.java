package com.bsdl.medium._0055;

public class Solution {

    // backtraking 超时
//    public boolean canJump(int[] nums) {
//        return backTracking(0, nums);
//    }
//    private boolean backTracking(int position, int[] nums) {
//        if(position == nums.length - 1) {
//            return true;
//        }
//        int farthestPosition = Math.min(nums[position] + position, nums.length - 1);
//        for(int nextPosition = position + 1; nextPosition <= farthestPosition; nextPosition++) {
//            if(backTracking(nextPosition, nums)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean canJump(int[] nums) {
//
//    }
}
