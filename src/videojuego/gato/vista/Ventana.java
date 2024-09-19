package videojuego.gato.vista;

import videojuego.gato.modelo.Jugador;
import videojuego.gato.modelo.Tablero;

public class Ventana {
    public Ventana (){ }
    
    public static void mostrarMenuPrincipal(){
        System.out.println("\tMenu principal\n");
        System.out.println("1. Jugador VS Computadora");
        System.out.println("2. Jugador VS Jugador");
        System.out.println("3. Salir");
        System.out.print("\nEscoge una opcion: ");
    }
    
    public static void mostrarEscogerFicha(){
        System.out.println("\nPreciona X para dicha ficha");
        System.out.println("Preciona O para dicha ficha");
        System.out.print("\nEscoge tu ficha: ");
    }
    
    public static void mostrarInterfaz(Jugador jugadorX, Jugador jugadorO, Tablero tablero, int turno){
        System.out.println("\n\tTurno " + (turno + 1));
        System.out.println("\nJugador X \t\tJugador O");
        System.out.println("Puntaje: "+ jugadorX.getPuntaje() +" \t\tPuntaje: " + jugadorO.getPuntaje());
        tablero.imprimir();
    }
    
    public static void mostrarGanador(Jugador jugador){
        System.out.println("\nGanador jugador " + jugador.getFicha());
    }
}
