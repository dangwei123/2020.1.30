/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        int len=getLen(head);
        while(len-n!=0){
            cur=cur.next;
            n++;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }
    private int getLen(ListNode head){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        ListNode pre=dummy;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(cur.next!=null){
                cur.next=cur.next.next;

                curNext.next=pre.next;
                pre.next=curNext;
            }
           
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        int len=getLen(head);
        k%=len;
        if(k==0){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(k-1!=0){
            fast=fast.next;
            k--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode cur=head;
        while(cur.next!=slow){
            cur=cur.next;
        }
        cur.next=null;
        fast.next=head;
        return slow;
    }
    private int getLen(ListNode head){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=pre.next;
        while(cur!=null){
            if(cur.next!=null&&cur.val==cur.next.val){
                while(cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
                pre.next=cur;
            }else{
                pre=cur;
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead=new ListNode(-1);
        ListNode afterHead=new ListNode(-1);
        ListNode beforecur=beforeHead;
        ListNode aftercur=afterHead;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x){
                beforecur.next=cur;
                beforecur=beforecur.next;
                cur=cur.next;
            }else{
                aftercur.next=cur;
                aftercur=aftercur.next;
                cur=cur.next;
            }
        }
        if(beforeHead.next!=null){
            beforecur.next=afterHead.next;
            aftercur.next=null;
            return beforeHead.next;
        }
        return afterHead.next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        int count=n-m;
        while(m-1!=0){
            pre=pre.next;
            m--;
        }
        ListNode cur=pre.next;
        while(count!=0){
            ListNode curNext=cur.next;
            if(cur.next!=null){
                cur.next=cur.next.next;

                curNext.next=pre.next;
                pre.next=curNext;
            }
            count--;
        }
        return dummy.next;
    }
}

