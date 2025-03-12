public class WinFactory implements Factory{

    public Button createButton(){
        return new WinButton();
    }

    public TextBox createTextBox(){
        return new WinTextBox();
    }


}
