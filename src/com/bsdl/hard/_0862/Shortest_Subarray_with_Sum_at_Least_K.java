package com.bsdl.hard._0862;

class Shortest_Subarray_with_Sum_at_Least_K {
    public int shortestSubarray(int[] A, int K) {
        int shortest = Integer.MAX_VALUE;
        int[] sums = new int[A.length];
        sums[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            sums[i] = sums[i - 1] + A[i];
        }
        for(int i = 0; i < A.length; i++) {
            int tmpI = i;
            for(int j = A.length - 1; j > tmpI;) {
                int mid = tmpI + (j - tmpI) / 2;
                int sum = sums[mid] - sums[i] + A[i];
                // int lastSum = sums[mid - 1] - sums[i] + A[i];
                if(sum >= K) {
                    j = mid;
                }else {
                    tmpI = mid + 1;
                }                
            }
            if (sums[tmpI] - sums[i] + A[i] >= K) {
                shortest = Math.min(shortest, tmpI - i + 1);
            }
        }
        if(shortest == Integer.MAX_VALUE) {
            shortest = -1;
        }
        return shortest;
    }

    public static void main(String[] args) {
        Shortest_Subarray_with_Sum_at_Least_K s = new Shortest_Subarray_with_Sum_at_Least_K();
        System.out.println(s.shortestSubarray(new int[]{44,-25,75,-50,-38,-42,-32,-6,-40,-47}, 19)); 
    }
}