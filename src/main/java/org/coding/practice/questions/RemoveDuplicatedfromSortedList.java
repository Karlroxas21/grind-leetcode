package org.coding.practice.questions;

/**
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * Input: head = [1,1,2]
 * Output: [1,2]
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 */


public class RemoveDuplicatedfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while(current != null && current.next != null) {
            // Delete duplicate and iterates if there are many duplicates na magkakasunod
            if (current.data == current.next.data) {
                current.next = current.next.next;
            }else {
                //remove duplicates
                current = current.next;
            }
        }
        return head;
    }
}
