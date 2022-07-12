package node;

import supportmodel.ListNode;

/**
 * 两数想加
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode temp = l1;
        int i = 0;
        while (i < 7) {
            i++;
            temp.val = 9;
            temp.next = new ListNode(9);
            temp = temp.next;
        }
        print(l1);
        ListNode l2 = new ListNode(9);
        temp = l2;
        int j = 0;
        while (j < 4) {
            j++;
            temp.val = 9;
            temp.next = new ListNode(9);
            temp = temp.next;
        }
        print(l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        print(listNode);
        ListNode listNode2 = addTwoNumbers2(l1, l2);
        print(listNode2);
    }

    private static void print(ListNode listNode) {
        System.out.print("[");
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
            if (listNode != null) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode tempNode = node;
        if (l1 == null || l2 == null) {
            return new ListNode(0);
        }
        boolean needAddOn = false;
        int temp;
        int sum;
        while (l1 != null && l2 != null) {
            int add = 0;
            if (needAddOn) {
                add = 1;
            }
            sum = l1.val + l2.val + add;
            needAddOn = false;
            if (sum >= 10) {
                needAddOn = true;
                temp = sum % 10;
            } else {
                temp = sum;
            }
            tempNode.val = temp;
            if (l1.next != null || l2.next != null) {
                tempNode.next = new ListNode(0);
                tempNode = tempNode.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int add = 0;
            if (needAddOn) {
                needAddOn = false;
                add = 1;
            }
            tempNode.val = l1.val + add;
            if (tempNode.val >= 10) {
                tempNode.val = tempNode.val % 10;
                needAddOn = true;
            }
            if (l1.next != null) {
                tempNode.next = new ListNode(0);
                tempNode = tempNode.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            int add = 0;
            if (needAddOn) {
                needAddOn = false;
                add = 1;
            }
            tempNode.val = l2.val + add;
            if (tempNode.val >= 10) {
                tempNode.val = tempNode.val % 10;
                needAddOn = true;
            }
            if (l2.next != null) {
                tempNode.next = new ListNode(0);
                tempNode = tempNode.next;
            }
            l2 = l2.next;
        }

        if (needAddOn) {
            tempNode.next = new ListNode(1);
        }
        return node;
    }

    /**
     * 这个精简版的，还有点东西
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        return root.next;
    }
}
