class BookCatalog {
    public void checkStock() {
        System.out.println("Checking book stock...");
    }
}

class PatronValidator {
    public void validatePatron() {
        System.out.println("Validating patron credentials...");
    }
}

class CheckoutService {
    public void processCheckout() {
        System.out.println("Processing book checkout...");
    }
}

class LibraryServiceFacade {
    private BookCatalog bookCatalog;
    private PatronValidator patronValidator;
    private CheckoutService checkoutService;

    public LibraryServiceFacade() {
        this.bookCatalog = new BookCatalog();
        this.patronValidator = new PatronValidator();
        this.checkoutService = new CheckoutService();
    }

    public void checkoutBook() {
        patronValidator.validatePatron();
        bookCatalog.checkStock();
        checkoutService.processCheckout();
    }
}

public class Library {
    public static void main(String[] args) {
        LibraryServiceFacade libraryFacade = new LibraryServiceFacade();
        libraryFacade.checkoutBook();
    }
}
