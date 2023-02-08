import java.util.Scanner;

public class UI {
    private Scanner scan = new Scanner(System.in);

    public int readInt() {
        System.out.println("Please write a number:");
        do {
            if (scan.hasNextInt()) {
                int number = scan.nextInt();
                scan.nextLine();
                return number;
            } else {
                System.out.println("Must be number mane!");
                System.out.println("Please write a number:");
                scan.nextLine();
            }
        } while (scan.hasNext());
        return 0;
    }

    public String readString() {
        return scan.nextLine();
    }
    public String readFirstName() {
        System.out.print("Write the firstname: ");
        return readString();
    }

    public String readNumber() {
        System.out.print("Write the contacts number: ");
        return readString();
    }

    public String readLastname() {
        System.out.println("Please write new contacts lastName " +
                "(if middle name, then just separate with spaces) xD");
        return readString();
    }
}
