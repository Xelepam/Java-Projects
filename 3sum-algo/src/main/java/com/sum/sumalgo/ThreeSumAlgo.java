// Work problem
/* Determine office hour options for a location. The office hours are determined from a set of constraints
   which change every month. Maximum hours open per day (maxHoursOpenPerDay), days available per week (daysAvailablePerWeek),
   hours to work per week (hoursToWorkPerWeek).
   Ex. 4 hours max per day, 3 days a week, 10 hours per week. -> maxHoursOpenPerDay = 4; daysAvailablePerWeek = 3; hoursToWorkPerWeek = 10
   Result: [(4,4,2), (4,2,4), (2,4,4), (4,3,3), (3,4,3), (3,3,4)] -> [ ("3 days that don't go over 4 hours which sum up to 10"), (...), ... ]
   */

// 3 Sum Combinatorial Algorithm
/* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives
   the sum of zero.
   */

/* Note: Elements in a triplet (a,b,c) must be in non-descending order, i.e. a <= b <= c. (Will have to sort)
   The solution set must not contain duplicate triplets.
   */

/*
 n = 3
 S = [ n1, n2, n3 ]
 a <= b <= c
 a + b + c = 0
 */

/*
 n = 3
 S = [ maxHoursOpenPerDay, daysAvailablePerWeek, hoursToWorkPerWeek ]
 */

package com.sum.sumalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSumAlgo {
    // Solve using two pointers. Time complexity is O(n^2).
    // To avoid duplicate, we can take advantage of sorted arrays, i.e. move pointers by > 1 to use same element only once.

    public static void main(String args[]) {
        int maxHoursOpenPerDay = 4;
        int daysAvailablePerWeek = 3;
        int hoursToWorkPerWeek = 10;
        int[] nums = new int[]{maxHoursOpenPerDay, daysAvailablePerWeek, hoursToWorkPerWeek};
//
//        ThreeSumAlgo sum = new ThreeSumAlgo();
//        List<List<Integer>> test = sum.threeSum(nums, hoursToWorkPerWeek);
//
//        System.out.println(test.size());
        TwoSum sum = new TwoSum();
        int[] test = sum.twoSum(nums, hoursToWorkPerWeek);
        System.out.println(test.);
    }

    public List<List<Integer>> threeSum(int[] nums, int hoursToWorkPerWeek) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 3)
            return result;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == hoursToWorkPerWeek) {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        result.add(l);

                        j++;
                        k++;

                        // Handle duplicate here
                        while (j < k && nums[j] == nums[j - 1])
                            j++;
                        while (j < k && nums[k] == nums[k + 1])
                            k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return result;
    }
}

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2)
            return new int[]{0,0};

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target-nums[i], i);
            }
        }

        return new int[]{0,0};
    }
}
