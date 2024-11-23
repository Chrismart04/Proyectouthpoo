import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
public class Animal {
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int vida;
    private int puntos;
    private Image img;
    private ImageIcon icono;
    private int picaduras = 0;
    
    private int avanceX;
    private int avanceY;
    private String tipo;
    private boolean puedeTrepar;

    private int teclaArriba;
    private int teclaAbajo;
    private int teclaIzquierda;
    private int teclaDerecha;

    public Animal(int x, int y, String imagen, int teclaArriba, int teclaAbajo, int teclaIzquierda, int teclaDerecha, String tipo) {
        this.x = x;
        this.y = y;
        this.icono = new ImageIcon(imagen);
        this.img = this.icono.getImage();
        this.ancho = this.icono.getIconWidth();
        this.alto = this.icono.getIconHeight();
        this.vida = 3;
        this.puntos = 0;
        this.tipo = tipo;
        this.puedeTrepar = tipo.equals("mono");
        
        this.teclaArriba = teclaArriba;
        this.teclaAbajo = teclaAbajo;
        this.teclaIzquierda = teclaIzquierda;
        this.teclaDerecha = teclaDerecha;
    }

    public void mover() {
        this.x += avanceX;
        this.y += avanceY;
        
        if(this.x >= 1050) {
            this.x = 1050;
        }
        if(this.x <= 30) {
            this.x = 30;
        }
        
        if(puedeTrepar) {
            if(this.y >= 500) {
                this.y = 500;
            }
            if(this.y <= 30) {
                this.y = 30;
            }
        }
    }

    public void keyPressed(KeyEvent ev) {
        int tecla = ev.getKeyCode();
        
        if(tecla == teclaDerecha && this.x <= 1050) {
            this.avanceX = 5;
        }
        if(tecla == teclaIzquierda && this.x >= 30) {
            this.avanceX = -5;
        }
        
        if(puedeTrepar) {
            if(tecla == teclaArriba && this.y >= 30) {
                this.avanceY = -5;
            }
            if(tecla == teclaAbajo && this.y <= 500) {
                this.avanceY = 5;
            }
        }
    }

    public void keyReleased(KeyEvent ev) {
        int tecla = ev.getKeyCode();
        if(tecla == teclaDerecha) {
            this.avanceX = 0;
        }
        if(tecla == teclaIzquierda) {
            this.avanceX = 0;
        }
        if(puedeTrepar) {
            if(tecla == teclaArriba) {
                this.avanceY = 0;
            }
            if(tecla == teclaAbajo) {
                this.avanceY = 0;
            }
        }
    }

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

    public void dibujar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, this.x, this.y, null);
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.ancho, this.alto);
    }

    public void serPicado() {
        this.picaduras++;
        this.puntos -= 100;

        if (this.picaduras >= 1) {
            perderVida();
            this.picaduras = 0;
        }
    }

    public void perderVida() {
        this.vida--;
        if (this.vida <= 0) {
            System.out.println("El animal ha muerto.");
        }
    }

    public void comerUva() {
        this.puntos += 300;
    }

    public void comerManzana() {
        this.puntos += 500;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public int getVida() {
        return this.vida;
    }

    public int getTeclaArriba() {
        return this.teclaArriba;
    }

    public int getTeclaAbajo() {
        return this.teclaAbajo;
    }

    public int getTeclaIzquierda() {
        return this.teclaIzquierda;
    }

    public int getTeclaDerecha() {
        return this.teclaDerecha;
    }
}