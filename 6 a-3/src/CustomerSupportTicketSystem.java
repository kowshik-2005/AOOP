import java.util.LinkedList;
import java.util.Queue;

public class CustomerSupportTicketSystem {
    private Queue<String> tickets;

    public CustomerSupportTicketSystem() {
        tickets = new LinkedList<>();
    }

    public void addTicket(String ticket) {
        tickets.add(ticket);
    }

    public String processTicket() {
        return tickets.poll(); // Returns and removes the head of the queue
    }

    public void displayPendingTickets() {
        System.out.println("Pending Tickets: " + tickets);
    }

    public static void main(String[] args) {
        CustomerSupportTicketSystem supportSystem = new CustomerSupportTicketSystem();
        supportSystem.addTicket("Issue with login");
        supportSystem.addTicket("Payment not processed");
        supportSystem.displayPendingTickets();
        supportSystem.processTicket();
        supportSystem.displayPendingTickets();
    }
}
