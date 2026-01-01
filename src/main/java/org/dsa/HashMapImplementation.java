package org.dsa;

import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class HashMapImplementation {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    int[] nums = {1, 2, 2, 4, 5, 1, 2, 3, 4, 4, 129, 4};

    int maxFreq = Integer.MIN_VALUE;
    int minFreq = Integer.MAX_VALUE;

    int maxKey;
    int minKey ;

    public void freqFinder() {
            for(int num: nums) {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);

            }
            for(int i : hashMap.keySet()) {
                System.out.println("Key: " + i + " value: " + hashMap.get(i));
            }

            for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                int value = entry.getValue();
                int key = entry.getKey();

                if (value > maxFreq) {
                    maxFreq = value;
                    maxKey = key;
                }

                if (value < minFreq) {
                    minFreq = value;
                    minKey = key;
                }
            }
        System.out.println("Highest Frequency: Key = " + maxKey + ", Value = " + maxFreq);
        System.out.println("Lowest Frequency: Key = " + minKey + ", Value = " + minFreq);

    }

//    public int getHighestFreq() {
//        hashMap.
//    }
}
