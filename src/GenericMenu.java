public class GenericMenu {
    private String header;
    private String leadText;
    private String[] mainText;

    public GenericMenu(String header, String leadText, String[] mainText) {
        this.header = header;
        this.leadText = leadText;
        this.mainText = mainText;
    }

    public void printMenu(){
        System.out.println(header);
        System.out.println(leadText);
        for (String string : mainText) {
            System.out.println(string);
        }
    }
}
