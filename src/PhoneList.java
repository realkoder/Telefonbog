import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Stream;

public class PhoneList {

    private Map<String, Contact> phoneList;
    private File phoneBookFile;

    public PhoneList() {
        phoneList = new HashMap<>();
        phoneBookFile = new File("PhoneBook.txt");
    }

    public void addContact(String number, Contact contact) {
        phoneList.put(number, contact);
        savePhoneList();
    }

    public void deleteContact(String number) {
        if (phoneList.containsKey(number)) {
            System.out.println(phoneList.get(number).getFirstname() + " was deleted!");
            phoneList.remove(number);
            savePhoneList();
        }
    }

    public boolean doesFirstnameAppear(String firstname) {
        for (Map.Entry<String, Contact> set : phoneList.entrySet()) {
            if (set.getValue().getFirstname().toLowerCase().equals(firstname.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void printPhoneList() {
        for (Map.Entry<String, Contact> set : getSortedEntryList()) {
            System.out.println(set.getValue() + ", number: " + set.getKey());
        }
    }

    private List<Map.Entry<String, Contact>> getSortedEntryList() {
        Stream<Map.Entry<String, Contact>> sorted = phoneList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue());
        List<Map.Entry<String, Contact>> sortedList = sorted.toList();

        return sortedList;
    }

    public void printPhoneListOnlyNames() {
        for (Map.Entry<String, Contact> set : getSortedEntryList()) {
            System.out.println(set.getValue().getFirstname() + " " + set.getValue().getLastName());
        }
    }

    public void printSpecificNames(String name) {
        boolean firstNameFound = false;
        for (Map.Entry<String, Contact> set : phoneList.entrySet()) {
            if (set.getValue().getFirstname().toLowerCase().equals(name.toLowerCase())) {
                System.out.println(set.getValue() + ", number: " + set.getKey());
                firstNameFound = true;
                break;
            }
        }
        if (!firstNameFound) {
            System.out.println("None in phonebook with that name!");
        }
    }

    private void savePhoneList() {
        try {
            PrintStream printStream = new PrintStream(phoneBookFile);
            for (Map.Entry<String, Contact> set : phoneList.entrySet()) {
                printStream.println(set.getKey() + ";" + set.getValue().getFirstname() +
                        ";" + set.getValue().getLastName());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadPhoneList() {
        try {
            Scanner fileReader = new Scanner(phoneBookFile);
            while (fileReader.hasNextLine()) {
                String tokens[] = fileReader.nextLine().split(";");
                phoneList.put(tokens[0], new Contact(tokens[1], tokens[2]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
