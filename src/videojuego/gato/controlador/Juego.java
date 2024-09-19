package videojuego.gato.controlador;

import java.util.Scanner;
import videojuego.gato.modelo.Jugador;
import videojuego.gato.modelo.Tablero;
import videojuego.gato.vista.Ventana;

public class Juego {
    private static final Jugador jugadorX = new Jugador('X');
    private static final Jugador jugadorO = new Jugador('O');
    public static final Scanner sc = new Scanner(System.in);
    
    private static Tablero tablero = new Tablero();
    private static boolean jugar;
    private static char opcion;
    private static int turno;
    
    public Juego() { }
    
    public static void abrir(){
        do{
            Ventana.mostrarMenuPrincipal();
            opcion = sc.next().charAt(0);
            switch(opcion){
                case '1':
                    jugadorVScomputadora();
                    break;
                case '2':
                    jugadorVSjugador();
                    break;
                case '3':
                    System.out.println("Vuelve pronto :D");
                    jugar = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while(jugar);
    }
    
    private static void jugadorVSjugador(){
        turno = 0;
        jugar = true;
        tablero.rellenar();
        
        do{
            Ventana.mostrarInterfaz(jugadorX, jugadorO, tablero, turno);
            System.out.print("\nEscoge tu casilla: ");
            opcion = sc.next().charAt(0);
            
            switch(opcion){
                case '1': case '2': case '3':
                case '4': case '5': case '6':
                case '7': case '8': case '9':
                    if(turno%2 == 0){
                        turnoJugador(jugadorX, opcion);
                    }else{
                        turnoJugador(jugadorO, opcion);
                    }
                    turno++;
                    break;
                default:
                    System.out.println("\nOpcion no valida");
                    break;
            }
        }while(jugar);
    }
    
    private static void turnoJugador(Jugador jugador, char opcion){
        tablero.colocarFicha(jugador.getFicha(), opcion);
        if(tablero.comprobrarGanador(jugador.getFicha())){
            Ventana.mostrarGanador(jugador);
            jugador.aumentarPuntaje();
            System.out.print("Desea jugar otra partida? \t(S)Si\t(N)No");
            System.out.print("\nOpcion: ");
            opcion = sc.next().charAt(0);
            switch(opcion){
                case 's':
                case 'S':
                    jugar = true;
                    turno = 0;
                    tablero.rellenar();
                    break;
                case 'n':
                case 'N':
                    jugar = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }else if(turno == 8){
            System.out.println("Empate");
        }
    }
    
    private static void jugadorVScomputadora(){
        Jugador computadora = new Jugador();
        jugar = true;
        tablero.rellenar();
        
        do{
            Ventana.mostrarEscogerFicha();
            opcion = sc.next().charAt(0);
            switch(opcion){
                case 'x':
                case 'X':
                    computadora.setFicha('O');
                    do{
                        turno = 0;
                        Ventana.mostrarInterfaz(jugadorX, computadora, tablero, turno);
                    }while(/*jugar*/false);
                    break;
                case 'o':
                case 'O':
                    computadora.setFicha('X');
                    do{
                        turno = 0;
                        Ventana.mostrarInterfaz(computadora, jugadorO, tablero, turno);
                    }while(/*jugar*/false);
                    break;
                default:
                    System.out.println("\nOpcion no valida");
                    break;
            }
        }while(/*jugar*/false);
    }
}