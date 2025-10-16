class TheNode {
    int data;
    TheNode next;

    TheNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Main class for sorting
public class SortLL {
    private TheNode head;

    // Add a node at the end of the LL
    public void add(int data) {
        TheNode newNode = new TheNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        TheNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Sort the LL using merge sort
    public void sort() {
        head = mergeSort(head);
    }

    // Merge Sort Helper
    private TheNode mergeSort(TheNode h) {
        if (h == null || h.next == null) return h;

        // Get the middle
        TheNode middle = getMiddle(h);
        TheNode nextOfMiddle = middle.next;
        middle.next = null; // Split the list into two halves

        TheNode left = mergeSort(h);
        TheNode right = mergeSort(nextOfMiddle);

        return sortedMerge(left, right);
    }

    // Merging the sorted lists
    private TheNode sortedMerge(TheNode a, TheNode b) {
        if (a == null) return b;
        if (b == null) return a;

        TheNode result;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    // This is a Utility that helps get to the middle of the list
    private TheNode getMiddle(TheNode h) {
        if (h == null) return h;

        TheNode slow = h, fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Print the LL
    public void printList() {
        TheNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Test the SortLL class
    public static void main(String[] args) {
        SortLL list = new SortLL();
        list.add(50);
        list.add(20);
        list.add(40);
        list.add(10);
        list.add(30);

        System.out.print("Original List: ");
        list.printList();

        list.sort();

        System.out.print("Sorted List: ");
        list.printList();
    }
}
