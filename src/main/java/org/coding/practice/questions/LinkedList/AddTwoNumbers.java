package org.coding.practice.questions.LinkedList;

import org.coding.practice.questions.ListNode;

/**
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * -----
 *
 * Approach
 *
 * This question is very simple. All we have to do is just to calculate node values from l1 and l2. Let's think about this case.
 *
 * Input: l1 = [2,4,3], l2 = [5,6]
 *
 * In the case, output should be
 *
 * [2,4,3]
 * [5,6]
 * -------
 * [7,0,4]
 *
 * We will implement simple algorithm and create a new LinkedList.
 *
 * First of all, we create dummy node with value 0(you can put any number instead of 0).
 *
 * 0 → None
 * d
 * r
 *
 * d is dummy pointer
 * r is result pointer
 *
 * We copy dummy pointer and create result pointer. I'll explain why we need result pointer later.
 *
 * Basically, we calculate addition with values from l1 and l2 at the same index. Let's begin.
 *
 * [2,4,3]
 * [5,6]
 *  ↑
 *
 * 2 + 5 = 7
 *
 * We got 7 as a total, so we create a new node with 7 and then connect it with node 0.
 *
 * 0 → 7 → None
 * r   d
 *
 * We move dummy pointer to the next node(= 7) so that we can connect the next new node easily after 7.
 *
 * Let's calculate addition with the next values.
 *
 * [2,4,3]
 * [5,6]
 *    ↑
 *
 * 4 + 6 = 10
 *
 * We got 10. In that case, we want to put 0 for current digit. How can we put 0?
 *
 * ⭐️ Points
 *
 * Simply, we use remainder divided by 10.
 *
 * total % 10
 *
 * For example,
 *
 * 10 % 10 = 0
 * 15 % 10 = 5
 * 7 % 10 = 7
 *
 * You can use it when total is one digit. For example, previous digit 2 + 5 = 7
 *
 * We have one more important thing. We have carry for a next digit, because total of current digit is 10. How can we calculate the carry?
 *
 * ⭐️ Points
 *
 * Just divide total by 10, but this time we use // in Python.
 *
 * total // 10
 *
 * For example,
 *
 * 8 // 10 = 0
 * 18 // 10 = 1
 *
 * Now, we can get 0 for the current digit and carry 1 for the next digit, so we create a new node with 0 and then connect it with node 7 and move dummy pointer to node 0
 *
 * 0 → 7 → 0 → None
 * r       d
 *
 * carry = 1
 *
 * Next
 *
 * [2,4,3]
 * [5,6]
 *      ↑
 *
 * 3 + 0 + 1 = 4
 *
 * 0 comes after 6 in the second list
 * 1 is carry
 *
 * Now, we can get 4 for the current digit and carry 0 for the next digit, so we create a new node with 4 and then connect it with node 0 and move dummy pointer to node 4
 *
 * 0 → 7 → 0 → 4 → None
 * r           d
 *
 * carry = 0
 *
 * We finish iteration. Problem here is that dummy pointer is at node 4 but we want to return 7 → 0 → 4, how can we return the whole new list?
 *
 * ⭐️ Points
 *
 * Luckily, we have result pointer that is pointing to the first node 0. That is a reason why we copy dummy pointer and create result pointer at first.
 *
 * We should return r.next(= node 7).
 *
 * return 7 → 0 → 4
 *
 * Let me add one more explanation. This is about conditions to continue calculating addition. To understand it, let's add 7 to the second list after 6.
 *
 *  0,0,1,1 (= carry)
 * [2,4,3]
 * [5,6,7]
 * --------
 * [7,0,1,1]
 *
 * In this case, 1 + 3 + 7 creates carry, so we should add node 1 at last. From this example, we have 3 conditions to continue calculating.
 *
 * ⭐️ Points
 *
 * If list 1 has a value(= not null) or list 2 has a value(= not null) or we have a carry, then we continue to calculate addtion.
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode result = dummy;

        int carry = 0;
        int total = 0;

        while (l1 != null || l2 != null || carry !=0) {
            total = carry;

            if (l1 != null) {
                total += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                total += l2.data;
                l2 = l2.next;
            }

            // we get carry or  if single digit just get the single digit.
            int number = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(number);
            dummy = dummy.next;
        }

        return result.next;
    }
}
