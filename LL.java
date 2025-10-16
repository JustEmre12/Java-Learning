class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Main Linked List class
public class LL {
    private node head;

    // Adding a node to the end of the LL
    public void addLast(int data) {
        node newNode = new node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Adding a node to the beginning of the LL
    public void addFirst(int data) {
        node newNode = new node(data);
        newNode.next = head;
        head = newNode;
    }

    // Removing a node by its value
    public void remove(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Printing the list
    public void printList() {
        node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Testing
    public static void main(String[] args) {
        LL myList = new LL();

        myList.addLast(10);
        myList.addLast(20);
        myList.addFirst(5);
        myList.addLast(30);

        System.out.print("Initial List: ");
        myList.printList();

        myList.remove(20);
        System.out.print("After removing 20: ");
        myList.printList();

        myList.remove(5);
        System.out.print("After removing 5 (head): ");
        myList.printList();
    }
}
