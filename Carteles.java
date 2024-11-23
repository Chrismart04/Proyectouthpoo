import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Carteles {
    private int x;
    private int y;
    private ImageIcon imagen;

    public Carteles(int x, int y, String rutaImagen) {
        this.x = x;
        this.y = y;
        this.imagen = new ImageIcon(rutaImagen);
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen.getImage(), x, y, null);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
