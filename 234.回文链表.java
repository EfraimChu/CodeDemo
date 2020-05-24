class Solution {

    public boolean isPalindrome(ListNode head) {
        // 1. 快慢指针找到中点
        // 2. 反转中点后面的数据
        ListNode middle = findMiddle(head);
        ListNode newList = swapList(middle);

        boolean result = true;
        ListNode newNode = newList;
        while(head!=null && newNode!=null){
            if(head.val != newNode.val){
                return false;
            }
            head = head.next;
            newNode = newNode.next;
        }
        return result;
    }

    public ListNode swapList(ListNode node){
        ListNode pre = null ;
        ListNode current = node;
        while(current!=null){
            ListNode nextTemp = current.next;
            current.next = pre;
            pre = current;
            current = nextTemp;
        }
        return pre;
    }
    public ListNode findMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next!=null && fast.next.next !=null){
           slow = slow.next; 
           fast = fast.next.next;
        }
        return slow;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
