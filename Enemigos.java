import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemigos { 
    protected int x;
    protected int y;
    protected int ancho;
    protected int alto;
    protected int visible;
    protected Image img;
    protected ImageIcon icono;
    protected Rectangle rect;
    protected String imag;
    protected String tipo;
    protected int velocidad;
    protected int puntosDeDano;

    // Constructor
    public Enemigos(int x, int y, String tipo, String imag) {  
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.imag = imag;
        this.icono = new ImageIcon(imag);
        this.img = icono.getImage(); 
        this.visible = 1;
        this.ancho = icono.getIconWidth(); 
        this.alto = icono.getIconHeight(); 

        if (tipo.equals("arania")) {
            this.velocidad = 2;
            this.puntosDeDano = 100;
        } else if (tipo.equals("avispa")) {
            this.velocidad = 2;
            this.puntosDeDano = 50;
        }
    }

    // Getters y Setters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getAncho() {
        return this.ancho;
    }

    public int getAlto() {
        return this.alto;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setPuntosDeDano(int puntosDeDano) {
        this.puntosDeDano = puntosDeDano;
    }

    public void setImag(String imag) {
        this.imag = imag;
        this.icono = new ImageIcon(imag);
        this.img = this.icono.getImage();
    }

    
    public void mover() {
        if (this.tipo.equals("arania")) {
            this.y += velocidad;  
        } else if (this.tipo.equals("avispa")) {
            this.x += velocidad;  
        }
    }

   
    public boolean detectarColision(Rectangle r) {
        this.rect = new Rectangle(this.x, this.y, this.ancho, this.alto);
        return this.rect.intersects(r); 
    }

   
    public void atacar(Animal animal) {
        if (detectarColision(animal.getRectangle())) {
            animal.serPicado();
            if (this.tipo.equals("arania")) {
                animal.perderVida();  
            }
        }
    }

    
    public void dibujar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.visible == 1) {
            g2d.drawImage(this.img, this.x, this.y, null); 
        }
    }

    
    public int getVisible() {
        return this.visible;
    }

    
    public void serPicado(int puntosDeDano) {
        this.puntosDeDano += puntosDeDano;
    }

    public boolean fueraDePantalla(int screenWidth, int screenHeight) {
        return this.x < 0 || this.x > screenWidth || this.y < 0 || this.y > screenHeight;
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.ancho, this.alto);
    }
}