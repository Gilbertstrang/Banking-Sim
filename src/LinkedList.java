/**
 * Linked list implementation.
 *
 * @author Enes Duman
 * @SchoolID 2023719042
 */

public class LinkedList {
    /**
     * Node implementation.
     *
     */
    static class Node {
        int customer;
        int priority;
        Node next;

    }
    static Node head;

    /**
     * Customer priority hierarchy. From highest to lowest.
     */
    enum Priority {
        PRIO_CARD_THEFT,
        PRIO_CLOSE_ACCOUNT,
        PRIO_OPEN_ACCOUNT,
        PRIO_PAY_BILL,
        PRIO_DEPOSIT,
        PRIO_DRAW,
        MAX_PRIO,
    }

    /**
     * Creates a node with customer ID and priority.
     * If it is the first customer the created node is the head node.
     * Otherwise, iterate through the list until the NEXT node's priority is lower (higher number) and it is not the end node.
     * Then put the newly created node to the current node's next node.
     * @param customer
     * @param priority
     */
   public void addNode(int customer, int priority) {
        Node newNode = new Node();
        newNode.customer = customer;
        newNode.priority = priority;

        if (head == null) {
            head = newNode;
            head.next = null;
        } else {
            Node current = head;
            while (current.next != null && current.next.priority <= newNode.priority) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
   }

    /**
     * Remove the first one in the queue.
     * Since head node is shadow node (no data), skip it.
     */
    public void removeMin() {
       Node current = head.next;
       current = current.next;
    }

    /**
     *  Prints out queue.
     *  Start from the head node, until reaching to NULL, print the node.
     *  Skip the head node as it is the shadow node. (no data)
     */
    public void printQueue() {

        Node current = head;
        current = current.next;
        while (current != null) {

            System.out.println("Priority: " + Priority.values()[current.priority] +
                    ". Customer ID: " + current.customer);

            current = current.next;
        }

        System.out.println("=================================================");

    }

}
