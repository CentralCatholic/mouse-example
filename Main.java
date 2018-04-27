import javax.swing.*;
class Main {
    public static void main(String[] args) {
        JFrame page = new MouseExample();
        page.setExtendedState(JFrame.MAXIMIZED_BOTH);
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setVisible(true); 
    }
}
