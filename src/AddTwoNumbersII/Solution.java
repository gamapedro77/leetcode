package AddTwoNumbersII;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }

    //The problem suggests trying to do this without reversing the lists which is less efficient
    public static ListNode sumTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> firstList = new Stack<>();
        Stack<Integer> secondList = new Stack<>();
        int totalSize = 0;
        while(l1 != null || l2 != null) {
            totalSize++;
            if(l1 != null) {
                firstList.push(l1.val);    
            } if(l2 != null) {
                secondList.push(l2.val);
            }
    
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode listNode = new ListNode(0);
        Integer carry = 0;

        while(totalSize > 0 || carry > 0) {
            totalSize--;
            Integer first = firstList.isEmpty() ? 0 : firstList.pop();
            Integer second = secondList.isEmpty() ? 0 : secondList.pop();
            Integer sum = first + second + carry;
            carry = 0;
            if(sum >= 10) {
                carry++;
                sum -= 10;
            } 
            listNode.val = sum;

            ListNode newNode = new ListNode();
            newNode.next = listNode;
            listNode = newNode;

        }

        return listNode.next; 
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

