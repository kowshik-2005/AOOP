import java.util.ArrayDeque;

public class BrowsingHistory {
    private ArrayDeque<String> history;
    private String currentPage;

    public BrowsingHistory() {
        history = new ArrayDeque<>();
    }

    public void visitPage(String page) {
        if (currentPage != null) {
            history.push(currentPage); // Save the current page before visiting a new one
        }
        currentPage = page;
        System.out.println("Visited: " + currentPage);
    }

    public void goBack() {
        if (!history.isEmpty()) {
            currentPage = history.pop(); // Go back to the previous page
            System.out.println("Going back to: " + currentPage);
        } else {
            System.out.println("No pages in history to go back to.");
        }
    }

    public void displayCurrentPage() {
        System.out.println("Current Page: " + currentPage);
    }

    public static void main(String[] args) {
        BrowsingHistory browser = new BrowsingHistory();
        browser.visitPage("Homepage");
        browser.visitPage("About Us");
        browser.displayCurrentPage();
        browser.goBack();
        browser.displayCurrentPage();
    }
}
