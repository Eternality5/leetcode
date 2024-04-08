package question2;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode lNext = l3;
        ListNode lNext2;
        int l1val, l2val;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            l1val = l1 != null ? l1.val : 0;
            l2val = l2 != null ? l2.val : 0;

            lNext.val = l1val + l2val + carry;
            carry = lNext.val >= 10 ? 1 : 0;
            lNext.val %= 10;

            // increment linked lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            // if (l1 != null || l2 != null || carry != 0) {
                lNext2 = new ListNode();
                lNext.next = lNext2;
                lNext = lNext2;
            // }
        }
        return l3;
    }
}
