public class Main {
    public static void main(String[] args) {

        Factory macFactory = GUIFactory.createFactory(FactoryType.MAC);
        Button macButton = macFactory.createButton();
        TextBox macTextBox = macFactory.createTextBox();

        System.out.println(macButton.press());
        System.out.println(macTextBox.write("This is Mac "));


        Factory winFactory = GUIFactory.createFactory(FactoryType.WIN);
        Button winButton = winFactory.createButton();
        TextBox winTextBox = winFactory.createTextBox();

        System.out.println(winButton.press());
        System.out.println(winTextBox.write("This is Win "));

        Factory linuxFactory = GUIFactory.createFactory(FactoryType.LINUX);
        Button linuxButton = linuxFactory.createButton();
        TextBox linuxTextBox = linuxFactory.createTextBox();

        System.out.println(linuxButton.press());
        System.out.println(linuxTextBox.write("This is Win "));

    }
}