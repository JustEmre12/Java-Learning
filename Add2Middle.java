public class Add2Middle {

    // Inner class to figure out how the Node is situated
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // Method to add to the end of the LL
    public void append(int data) {
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

    // Method to add a node to the middle of the LL
    public void addToMiddle(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        // Finding the size of the list
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Find where the middle position is
        int mid = size / 2;

        // Looking into to the node before the middle
        Node current = head;
        for (int i = 0; i < mid - 1; i++) {
            current = current.next;
        }

        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to print the list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test the list
    public static void main(String[] args) {
        Add2Middle list = new Add2Middle();

        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        System.out.println("Original list:");
        list.printList();

        // Add to the middle of the LL
        list.addToMiddle(25);

        System.out.println("After adding 25 to the middle:");
        list.printList();
    }
}
