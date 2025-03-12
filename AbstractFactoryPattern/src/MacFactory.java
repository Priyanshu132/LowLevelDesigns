public class MacFactory implements Factory{

    public Button createButton(){
        return new MacButton();
    }

    public TextBox createTextBox(){
        return new MacTextBox();
    }
}
