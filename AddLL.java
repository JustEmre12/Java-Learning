class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class AddLL {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // Placeholder
        ListNode current = dummyHead;
        int carry = 0;

        // Going through both lists
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0; // If this is null then we get value of 0
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;

            carry = sum / 10; // Update carry
            current.next = new ListNode(sum % 10); // Creating a new node with digit
            current = current.next;

            // Moved to the next nodes
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Handle leftover carry
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    // Helper method to print linked list for the output
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // This is testing the method
    public static void main(String[] args) {
        // First number is 342
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Second number is 465
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.print("List 1: ");
        printList(l1);
        System.out.print("List 2: ");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.print("Sum: ");
        printList(result);
    }
}
