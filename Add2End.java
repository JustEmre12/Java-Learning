class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Add2End {
    private Node head;

    // Method to add a node to the end of the list
    public void addToEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // This prints the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Testing
    public static void main(String[] args) {
        Add2End list = new Add2End();

        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        list.addToEnd(40);

        System.out.print("Linked List: ");
        list.printList();  // The output will be 10 -> 20 -> 30 -> 40
    }
}
