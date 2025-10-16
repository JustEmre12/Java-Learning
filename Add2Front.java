class Listnode {
    int val;
    Listnode next;

        Listnode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Add2Front {
    private Listnode head;

    // Constructor
    public Add2Front() {
        head = null;
    }

    // Method to add a node to the front of the list
    public void addToFront(int val) {
        Listnode newNode = new Listnode(val);
        newNode.next = head;  // New node points to the old head
        head = newNode;       // New node becomes the new head
    }

    // This prints the entire list
    public void printList() {
        Listnode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        Add2Front list = new Add2Front();

        list.addToFront(10);
        list.addToFront(20);
        list.addToFront(30);
        list.addToFront(40);

        System.out.print("Linked List: ");
        list.printList();  // Output will be 40 -> 30 -> 20 -> 10
    }
}
