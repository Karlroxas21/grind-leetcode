package org.example;


import org.coding.practice.questions.*;
import org.coding.practice.questions.BinarySearchTree.ConvertSortedArraytoBinarySearchTree;
import org.dsa.HashMapImplementation;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    }


    /* Input: nums = [2,7,11,15], target = 9
    *  Output: [0,1]
    *
    * Input: nums = [3,2,4], target = 6
    * Output: [1,2]
    *
    * Input: nums = [3,3], target = 6
    * Output: [0,1]
    */
    public static int[] twoSum(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    /*
     * Example 1:
     *
     * Input: s = "abacbc"
     * Output: true
     * Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
     *
     * Example 2:
     *
     * Input: s = "aaabb"
     * Output: false
     * Explanation: The characters that appear in s are 'a' and 'b'.
     * 'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
     */
    public static boolean areOccurencesEqual(String s) {
        if (s.length() <= 1) return true;

        Map<Character, Integer> frequencyMap = new HashMap<>();
        for(char c : s.toCharArray()){
            System.out.println("Adding in frequency map: " + frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1) + ". " + "Current character: " + c);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0));
        }

        System.out.println("frequencyMap Values: " + frequencyMap);

        Set<Integer> counts = new HashSet<>(frequencyMap.values());
        System.out.println("-----");
        System.out.println("Counts size: " + counts.size());
        System.out.println("Counts " +  counts
        );

        return counts.size() <= 1;
    }
}