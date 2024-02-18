/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class CanvasCafeteria extends Canvas {

    class cliente {

        private int id;
        private char tipo;
        int leche;
        int cafe;

        public cliente(int id, char tipo, int leche, int cafe) {
            this.id = id;
            this.tipo = tipo;
            this.leche = leche;
            this.cafe = cafe;
        }

        public int getLeche() {
            return leche;
        }

        public int getCafe() {
            return cafe;
        }

        public void setLeche(int leche) {
            this.leche = leche;
        }

        public void setCafe(int cafe) {
            this.cafe = cafe;
        }

        public int getId() {
            return id;
        }

        public char getTipo() {
            return tipo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setTipo(char tipo) {
            this.tipo = tipo;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final cliente c = (cliente) obj;
            if (c.getId() == this.getId()) {
                return true;
            } else {
                return false;
            }
        }

    }

    private ArrayList<cliente> colaleche = new ArrayList();
    private ArrayList<cliente> salaleche = new ArrayList();
    private ArrayList<cliente> colacafe = new ArrayList();
    private ArrayList<cliente> salacafe = new ArrayList();
    private ArrayList<cliente> salon = new ArrayList();
    private ArrayList<cliente> colapapelera = new ArrayList();
    private ArrayList<cliente> papelera = new ArrayList();
    private boolean camareroL = false, camareroC = false;

    Image manchadoimg, cortadoimg, camareroimg, papeleraimg, cafeteraimg, lecheraimg;

    public CanvasCafeteria(int ancho, int alto) throws InterruptedException {

        super.setSize(ancho, alto);
        super.setBackground(Color.white);

        manchadoimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/manchado.png"));
        cortadoimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/cortado.png"));
        camareroimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/camarero.gif"));
        papeleraimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/papelera.png"));
        cafeteraimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/cafetera1.png"));
        lecheraimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("image/lechera.png"));

        MediaTracker dibu = new MediaTracker(this);
        dibu.addImage(manchadoimg, 0);
        dibu.waitForID(0);
        dibu.addImage(cortadoimg, 1);
        dibu.waitForID(1);
        dibu.addImage(camareroimg, 2);
        dibu.waitForID(2);
        dibu.addImage(papeleraimg, 3);
        dibu.waitForID(3);
        dibu.addImage(cafeteraimg, 4);
        dibu.waitForID(4);
        dibu.addImage(lecheraimg, 5);
        dibu.waitForID(5);

    }

    private void inserta(ArrayList<cliente> lista, int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        int pos = lista.indexOf(c);
        if (pos == -1) {
            lista.add(c);
        } else {
            lista.set(pos, c);
        }
        repaint();
    }

    public synchronized void encolaleche(int id, char tipo, int leche, int cafe) {
        inserta(colaleche, id, tipo, leche, cafe);
        repaint();
    }

    public synchronized void fincolaleche(int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        colaleche.remove(c);
        repaint();
    }

    public synchronized void ensalaleche(int id, char tipo, int leche, int cafe) {
        inserta(salaleche, id, tipo, leche, cafe);

        repaint();
    }

    public synchronized void finsalaleche(int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        salaleche.remove(c);
        repaint();
    }

    public synchronized void encolacafe(int id, char tipo, int leche, int cafe) {
        inserta(colacafe, id, tipo, leche, cafe);
        repaint();
    }

    public synchronized void fincolacafe(int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        colacafe.remove(c);
        repaint();
    }

    public synchronized void ensalacafe(int id, char tipo, int leche, int cafe) {
        inserta(salacafe, id, tipo, leche, cafe);
        repaint();
    }

    public synchronized void finsalacafe(int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        salacafe.remove(c);
        repaint();
    }

    public synchronized void ensalon(int id, char tipo, int leche, int cafe) {
        inserta(salon, id, tipo, leche, cafe);
        repaint();
    }

    public synchronized void finsalon(int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        salon.remove(c);
        repaint();
    }

    public synchronized void encolapapelera(int id, char tipo, int leche, int cafe) {
        inserta(colapapelera, id, tipo, leche, cafe);
        repaint();
    }

    public synchronized void fincolapapelera(int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        colapapelera.remove(c);
        repaint();
    }

    public synchronized void enpapelera(int id, char tipo, int leche, int cafe) {
        inserta(papelera, id, tipo, leche, cafe);
        repaint();
    }

    public synchronized void finpapelera(int id, char tipo, int leche, int cafe) {
        cliente c = new cliente(id, tipo, leche, cafe);
        papelera.remove(c);
        repaint();
    }

    public synchronized void camarero(char donde) {
        if (donde == 'L') {
            camareroL = true;
        } else {
            camareroC = true;
        }
        repaint();
    }

    public synchronized void fincamarero() {
        camareroL = false;
        camareroC = false;
        repaint();
    }

    @Override
    public void update(Graphics g) {
        paint(g);

    }

    @Override
    public void paint(Graphics g) {

        //x,y,ancho,alto
        int[] poscolaleche = {460, 150, 340, 100};
        int[] poscolacafe = {460, 350, 340, 100};

        int[] possalaleche = {330, 10, 120, 280};
        int[] possalacafe = {330, 310, 120, 280};

        int[] possalon = {15, 25, 310, 200};

        int[] poscolapapelera = {15, 230, 310, 200};

        int[] pospapelera = {165, 450, 60, 100};

        int anchoicon = 40, altoicon = 80, espacio = 65;

        Image imagen = createImage(getWidth(), getHeight());
        Font f1 = new Font("Arial", Font.BOLD, 15);
        Graphics gbuf = imagen.getGraphics();
        gbuf.setFont(f1);

        setBackground(Color.lightGray);
        //cola leche
        gbuf.setColor(Color.white);
        gbuf.fillRect(poscolaleche[0], poscolaleche[1], poscolaleche[2], poscolaleche[3]);
        for (int i = 0; i < colaleche.size(); i++) {
            if (colaleche.get(i).getTipo() == 'C') {
                gbuf.setColor(Color.red);
                gbuf.drawImage(cortadoimg, poscolaleche[0] + espacio * i, poscolaleche[1] + 14, anchoicon, altoicon, null);
                gbuf.drawString(colaleche.get(i).getId() + "," + colaleche.get(i).getLeche() + "," + colaleche.get(i).getCafe(),
                        poscolaleche[0] + espacio * i, poscolaleche[1] + 14);
            } else {
                gbuf.setColor(Color.blue);
                gbuf.drawImage(manchadoimg, poscolaleche[0] + espacio * i, poscolaleche[1] + 14, anchoicon, altoicon, null);
                gbuf.drawString(colaleche.get(i).getId() + "," + colaleche.get(i).getLeche() + "," + colaleche.get(i).getCafe(),
                        poscolaleche[0] + espacio * i, poscolaleche[1] + 14);
            }

        }

        //colacafe
        gbuf.setColor(Color.white);
        gbuf.fillRect(poscolacafe[0], poscolacafe[1], poscolacafe[2], poscolacafe[3]);
        for (int i = 0; i < colacafe.size(); i++) {
            if (colacafe.get(i).getTipo() == 'C') {
                gbuf.setColor(Color.red);
                gbuf.drawImage(cortadoimg, poscolacafe[0] + espacio * i, poscolacafe[1] + 14, anchoicon, altoicon, null);
                gbuf.drawString(colacafe.get(i).getId() + "," + colacafe.get(i).getLeche() + "," + colacafe.get(i).getCafe(),
                        poscolacafe[0] + espacio * i, poscolacafe[1] + 14);
            } else {
                gbuf.setColor(Color.blue);
                gbuf.drawImage(manchadoimg, poscolacafe[0] + espacio * i, poscolacafe[1] + 14, anchoicon, altoicon, null);
                gbuf.drawString(colacafe.get(i).getId() + "," + colacafe.get(i).getLeche() + "," + colacafe.get(i).getCafe(),
                        poscolacafe[0] + espacio * i, poscolacafe[1] + 14);
            }

        }

        //sala leche
        gbuf.setColor(Color.white);
        gbuf.fillRect(possalaleche[0], possalaleche[1], possalaleche[2], possalaleche[3]);
        gbuf.drawImage(lecheraimg, possalaleche[0], possalaleche[1], anchoicon, altoicon, null);
        gbuf.setColor(Color.red);
        for (int i = 0; i < salaleche.size(); i++) {
            if (salaleche.get(i).getTipo() == 'C') {
                gbuf.setColor(Color.red);

                gbuf.drawImage(cortadoimg, possalaleche[0] + espacio, possalaleche[1] + 12 + (altoicon + 12) * i, anchoicon, altoicon, null);
                gbuf.drawString(salaleche.get(i).getId() + "," + salaleche.get(i).getLeche() + "," + salaleche.get(i).getCafe(),
                        possalaleche[0] + espacio, possalaleche[1] + 12 + (altoicon + 12) * i);
            } else {
                gbuf.setColor(Color.blue);

                gbuf.drawImage(manchadoimg, possalaleche[0] + espacio, possalaleche[1] + 12 + (altoicon + 12) * i, anchoicon, altoicon, null);
                gbuf.drawString(salaleche.get(i).getId() + "," + salaleche.get(i).getLeche() + "," + salaleche.get(i).getCafe(),
                        possalaleche[0] + espacio, possalaleche[1] + 12 + (altoicon + 12) * i);
            }

        }
        //salacafe
        gbuf.setColor(Color.white);
        gbuf.fillRect(possalacafe[0], possalacafe[1], possalacafe[2], possalacafe[3]);
        gbuf.drawImage(cafeteraimg, possalacafe[0] , possalacafe[1], anchoicon, altoicon, null);
        gbuf.setColor(Color.red);
        for (int i = 0; i < salacafe.size(); i++) {
            if (salacafe.get(i).getTipo() == 'C') {
                gbuf.setColor(Color.red);

                gbuf.drawImage(cortadoimg, possalacafe[0] + espacio, possalacafe[1] + 12 + (altoicon + 12) * i, anchoicon, altoicon, null);
                gbuf.drawString(salacafe.get(i).getId() + "," + salacafe.get(i).getLeche() + "," + salacafe.get(i).getCafe(),
                        possalacafe[0] + espacio, possalacafe[1] + 12 + (altoicon + 12) * i);
            } else {
                gbuf.setColor(Color.blue);

                gbuf.drawImage(manchadoimg, possalacafe[0] + espacio, possalacafe[1] + 12 + (altoicon + 12) * i, anchoicon, altoicon, null);
                gbuf.drawString(salacafe.get(i).getId() + "," + salacafe.get(i).getLeche() + "," + salacafe.get(i).getCafe(),
                        possalacafe[0] + espacio, possalacafe[1] + 12 + (altoicon + 12) * i);
            }

        }

        //salon
        gbuf.setColor(Color.white);
        gbuf.fillRect(possalon[0], possalon[1], possalon[2], possalon[3]);
        int fila = 0, col = 0;
        for (int i = 0; i < salon.size() && fila < 2; i++) {
            if (salon.get(i).getTipo() == 'C') {
                gbuf.setColor(Color.red);
                gbuf.drawImage(cortadoimg, possalon[0] + espacio * col, possalon[1] + 12 + fila * (altoicon + 12), anchoicon, altoicon, null);
                gbuf.drawString(salon.get(i).getId() + "-" + salon.get(i).getLeche() + "-" + salon.get(i).getCafe(),
                        possalon[0] + espacio * col, possalon[1] + 12 + fila * (altoicon + 12));
            } else {
                gbuf.setColor(Color.blue);
                gbuf.drawString(salon.get(i).getId() + "-" + salon.get(i).getLeche() + "-" + salon.get(i).getCafe(),
                        possalon[0] + espacio * col, possalon[1] + 12 + fila * (altoicon + 12));
                gbuf.drawImage(manchadoimg, possalon[0] + espacio * col, possalon[1] + 12 + fila * (altoicon + 12), anchoicon, altoicon, null);
            }

            col++;
            if (i % 5 == 4) {
                fila++;
                col = 0;
            }
        }

        //colapapelera
        gbuf.setColor(Color.white);
        gbuf.fillRect(poscolapapelera[0], poscolapapelera[1], poscolapapelera[2], poscolapapelera[3]);
        fila = 0;
        col = 0;
        for (int i = 0; i < colapapelera.size() && fila < 2; i++) {
            if (colapapelera.get(i).getTipo() == 'C') {
                gbuf.setColor(Color.red);
                gbuf.drawImage(cortadoimg, poscolapapelera[0] + espacio * col, poscolapapelera[1] + 12 + fila * (altoicon + 12), anchoicon, altoicon, null);
                gbuf.drawString(colapapelera.get(i).getId() + "-" + colapapelera.get(i).getLeche() + "-" + colapapelera.get(i).getCafe(),
                        poscolapapelera[0] + espacio * col, poscolapapelera[1] + 12 + fila * (altoicon + 12));
            } else {
                gbuf.setColor(Color.blue);
                gbuf.drawImage(manchadoimg, poscolapapelera[0] + espacio * col, poscolapapelera[1] + 12 + fila * (altoicon + 12), anchoicon, altoicon, null);
                gbuf.drawString(colapapelera.get(i).getId() + "-" + colapapelera.get(i).getLeche() + "-" + colapapelera.get(i).getCafe(),
                        poscolapapelera[0] + espacio * col, poscolapapelera[1] + 12 + fila * (altoicon + 12));
            }

            col++;
            if (i % 5 == 4) {
                fila++;
                col = 0;
            }
        }

        //PAPELERA
        gbuf.setColor(Color.white);
        gbuf.fillRect(pospapelera[0], pospapelera[1], pospapelera[2], pospapelera[3]);
        for (int i = 0; i < papelera.size(); i++) {

            if (papelera.get(i).getTipo() == 'C') {
                gbuf.setColor(Color.red);
                gbuf.drawImage(cortadoimg, pospapelera[0] , pospapelera[1] + 12, anchoicon, altoicon, null);
                gbuf.drawString(papelera.get(i).getId() + "-" + papelera.get(i).getLeche() + "-" + papelera.get(i).getCafe(),
                        pospapelera[0] , pospapelera[1] + 12);
            } else {
                gbuf.setColor(Color.blue);
                gbuf.drawImage(manchadoimg, pospapelera[0] , pospapelera[1] + 12, anchoicon, altoicon, null);
                gbuf.drawString(papelera.get(i).getId() + "-" + papelera.get(i).getLeche() + "-" + papelera.get(i).getCafe(),
                        pospapelera[0] , pospapelera[1] + 12);
            }
        }
        gbuf.drawImage(papeleraimg, pospapelera[0] + 20, pospapelera[1] + 30, anchoicon * 3, altoicon, null);

        if (camareroL) {
            gbuf.drawImage(camareroimg, 470, 50, anchoicon, altoicon, null);
        }
        if (camareroC) {
            gbuf.drawImage(camareroimg, 470, 460, anchoicon, altoicon, null);
        }

        g.drawImage(imagen, 0, 0, this);

    }

}
