class Thenode {
    int data;
    Thenode next;

    Thenode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeLL {

    // Merges two sorted LL together and returns the head of the new list
    public static Thenode mergeSortedLists(Thenode l1, Thenode l2) {
        Thenode dummy = new Thenode(0);  // Dummy node to start the merged list
        Thenode current = dummy;

        // Moving through both lists and merging in a sorted order
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) current.next = l1;
        if (l2 != null) current.next = l2;

        return dummy.next;
    }

    // Helper method to print a list
    public static void printList(Thenode head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    // Helper method to build a LL from the array
    public static Thenode buildList(int[] values) {
        Thenode head = null;
        Thenode tail = null;
        for (int val : values) {
            Thenode newNode = new Thenode(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    // Test code
    public static void main(String[] args) {
        // Create two LL
        Thenode list1 = buildList(new int[]{1, 3, 5, 7});
        Thenode list2 = buildList(new int[]{2, 4, 6, 8, 10});

        System.out.print("List 1: ");
        printList(list1);

        System.out.print("List 2: ");
        printList(list2);

        // Merge them
        Thenode merged = mergeSortedLists(list1, list2);

        System.out.print("Merged List: ");
        printList(merged);
    }
}
