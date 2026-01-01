package org.coding.practice.questions.Arrays;

/**
 * 605. Can Place Flowers
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if
 * n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 *
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++) {
           if (flowerbed[i] == 0) {
               // Return true if its first index or the left of the index is 0
               boolean isLeftEmpty = (i == 0) || (flowerbed[i-1] == 0);
               // Return true if its last index or the right of the index is 0
               boolean isRightEmpty = (i == flowerbed.length - 1) || (flowerbed[i+1] == 0);

               // If right and left is empty, plant that fkn flower
               if (isLeftEmpty && isRightEmpty) {
                   flowerbed[i] = 1;
                   count += 1;

                   // Optimization, skip the next plot because the current one now has plant and
                   // the next can not be used.
                   i += 1;
               }
           }
        }
        if (count >= n) {
            return true;
        }
        return false;
    }
}
