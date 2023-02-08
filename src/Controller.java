public class Controller {
    private GenericMenu myMenu = new GenericMenu("MY PHONEBOOK", "Write number for actionjackson",
            new String[]{"1: add new contact", "2: see my contacts", "4: Print all names in phonebook",
                    "5: Delete a contact", "9: Quit"});
    private UI ui = new UI();
    PhoneList phoneList = new PhoneList();

    public void startMenuLoop() {
        int choice = 0;
        phoneList.loadPhoneList();
        while (choice != 9) {
            myMenu.printMenu();
            switch (ui.readInt()) {
                case 1 -> addContact();
                case 2 -> phoneList.printPhoneList();
                case 3 -> searchForFirstName();
                case 4 -> printOnlyNames();
                case 5 -> deleteContact();
                case 9 -> {
                    System.out.println("TERMINATION!");
                    choice = 9;
                }
            }
        }
    }

    private void addContact() {
        phoneList.addContact(ui.readNumber(), new Contact(ui.readFirstName(), ui.readLastname()));
    }

    private void searchForFirstName() {
        phoneList.printSpecificNames(ui.readFirstName());
    }

    private void printOnlyNames() {
        phoneList.printPhoneListOnlyNames();
    }
    private void deleteContact() {
        String firstName = ui.readFirstName();
        phoneList.printSpecificNames(firstName);
        if (phoneList.doesFirstnameAppear(firstName)) {
            System.out.println("Please write the number of the contact you want to delete");
            String number = ui.readString();
            phoneList.deleteContact(number);
        } else {
            System.out.println("NONONONO");
        }

    }
}
