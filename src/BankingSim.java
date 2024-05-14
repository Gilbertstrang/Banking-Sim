/**
 * Banking simulation.
 * Using priority queue in the form of a linked list, queues customers in terms of the importance of their task.
 * First in, first out structure. Newly arrived customers put in the end of the queue.
 * @author Enes Duman
 * @SchoolID 2023719042
 */

class BankingSim {

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
     * Creates the queue as a linked list.
     * Adds a shadow node first, then adds 10 customers.
     * Randomly generates 10 customer ID and priority. Add as nodes, print the queue.
     * @return created queue
     */
    public static LinkedList createList() {
        LinkedList queue = new LinkedList();
        queue.addNode(-1, -1);  //shadow node

        for (int i = 0; i < 10; i++) {
            int customerID = 1000 + (int) (Math.random() * 1001);
            int customerPrio = (int) (Math.random() * 6);
            System.out.println("Customer added. " + "Priority: " + Priority.values()[customerPrio] + " Customer ID: " + customerID);
            queue.addNode(customerID, customerPrio);
            queue.printQueue();
        }
        return queue;
    }

    /**
     * Main function.
     * Creates queue with createList(), waits for half a second and for a 50% chance deletes the highest priority customer.
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

            LinkedList queue = createList();

            Thread.sleep(500);
            int removeChance = (int) (Math.random() * 101);
            if (removeChance > 49) {
                queue.removeMin();
                System.out.println("Removed!");
                queue.printQueue();
            }

        }

    }



