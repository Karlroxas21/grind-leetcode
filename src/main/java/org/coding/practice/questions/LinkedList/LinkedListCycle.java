package org.coding.practice.questions.LinkedList;

import org.coding.practice.questions.ListNode;

/**
 * 141. Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycle {
    /**
     * EL5
     * <p>
     * Used Floyd's Cycle-Finding Algorithm, also known as the "Tortoise and Hare" algorithm.
     * <p>
     * <p>
     * Imagine you are running a race on a track.
     * <p>
     * Runners: We'll use two runners: a slow runner (the Tortoise) and a fast runner (the Hare).
     * <p>
     * The Race: Both runners start at the beginning of the linked list (the head).
     * <p>
     * Speed:
     * <p>
     * The Tortoise takes one step forward at a time.
     * <p>
     * The Hare takes two steps forward at a time.
     * <p>
     * The Track:
     * <p>
     * No Cycle (Straight Track): If the track is straight (a normal linked list), the fast runner will eventually reach the end of the track (the list's end, or null), and the race stops. Result: No cycle.
     * <p>
     * Cycle (Looping Track): If the track has a loop (a cycle), the fast runner is always catching up to the slower one. Since the fast runner is moving two steps for every one step of the slow runner, the fast runner must eventually lap and meet the slow runner somewhere inside the loop. Result: There is a cycle.
     * <p>
     * So, we just need to keep track of the two runners. If they ever point to the same node, there's a loop! If the fast runner ever falls off the end of the list, there's no loop.
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
