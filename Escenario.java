import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.Timer;

public class Escenario extends JPanel implements KeyListener {
    Image fondo;
    Enemigos arania1;
    Enemigos arania2;
    Enemigos arania3;
    Enemigos arania4;
    int velocidad = 100;
    Carteles tela1;
    Carteles tela2;
    Carteles tela3;
    Carteles tela4;
    Animal animal1;
    Animal animal2; 
    Animal animal3;
    Animal animal4;   
    public Escenario() {
        ImageIcon icono = new ImageIcon("imagenes/fondo.jpg");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        this.setSize(1200, 700);
        this.setVisible(true);
        this.setFocusable(true);
        this.addKeyListener(this);

        tela1 = new Carteles(100, 50, "imagenes/tela.png");
        tela2 = new Carteles(400, 50, "imagenes/tela.png");
        tela3 = new Carteles(700, 50, "imagenes/tela.png");
        tela4 = new Carteles(1000, 50, "imagenes/tela.png");
        arania1 = new Enemigos(100, 50, "arania", "imagenes/arania.png");
        arania2 = new Enemigos(400, 50, "arania", "imagenes/arania.png");
        arania3 = new Enemigos(700, 50, "arania", "imagenes/arania.png");
        arania4 = new Enemigos(1000, 50, "arania", "imagenes/arania.png");
        animal1 = new Animal(100, 50, "imagenes/animal1.png", KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, "mono");
        animal2 = new Animal(400, 500, "imagenes/animal2.png", KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, "");
        animal3 = new Animal(400, 500, "imagenes/animal3.png", KeyEvent.VK_I, KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_L, "");
        animal4 = new Animal(400, 500, "imagenes/animal4.png", KeyEvent.VK_T, KeyEvent.VK_G, KeyEvent.VK_F, KeyEvent.VK_H, "");
        
        Timer timer = new Timer(30, e -> {
            moverAranias();
            animal1.mover();
            animal2.mover();
            animal3.mover();
            animal4.mover();
            repaint();
        });
        timer.start();
    }

    public void moverAranias() {
        arania1.mover();
        arania2.mover();
        arania3.mover();
        arania4.mover();

        if (arania1.getY() > getHeight())
            arania1.setY(50);
        if (arania2.getY() > getHeight())
            arania2.setY(50);
        if (arania3.getY() > getHeight())
            arania3.setY(50);
        if (arania4.getY() > getHeight())
            arania4.setY(50);

        repaint();
    }
    // Manejo de teclas presionadas
    public void keyPressed(KeyEvent e) {
        animal1.keyPressed(e);
        animal2.keyPressed(e);
        animal3.keyPressed(e);
        animal4.keyPressed(e);
        repaint();
    }
     // Manejo de teclas soltadas
    public void keyReleased(KeyEvent e) {
        animal1.keyReleased(e);
        animal2.keyReleased(e);
        animal3.keyReleased(e);
        animal4.keyReleased(e);
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        // No necesita implementación
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(this.fondo, 0, 0, this);
        tela1.dibujar(g);
        tela2.dibujar(g);
        tela3.dibujar(g);
        tela4.dibujar(g);
        arania1.dibujar(g);
        arania2.dibujar(g);
        arania3.dibujar(g);
        arania4.dibujar(g);
        animal1.dibujar(g);
        animal2.dibujar(g);
        animal3.dibujar(g);
        animal4.dibujar(g);
    }
}