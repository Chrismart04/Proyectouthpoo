import javax.swing.JFrame;

public class Principal extends JFrame {
    Escenario esc = new Escenario();

    public Principal() {
        this.add(this.esc);
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
         new Principal();
    }
}