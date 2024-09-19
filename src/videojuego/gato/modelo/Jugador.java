package videojuego.gato.modelo;

public class Jugador {
    private char ficha = ' ';
    private int puntaje = 0;

    public Jugador(char ficha) {
        this.ficha = ficha;
    }
    
    public Jugador() { }
    
    public void aumentarPuntaje(){
        puntaje++;
    }

    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
