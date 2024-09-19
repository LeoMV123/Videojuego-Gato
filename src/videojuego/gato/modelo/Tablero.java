package videojuego.gato.modelo;

public class Tablero {
    private char [][] tablero = new char [3][3];

    public Tablero() { }
    
    public void rellenar(){
        int valorASCII = '1';
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tablero[i][j] = (char)valorASCII++;
            }
        }
    }
    
    public void imprimir(){
        System.out.println();
        for(int i = 0; i < 3; i++){
            System.out.print("\t");
            for(int j = 0; j < 3; j++){
                if(j < 2){
                    System.out.print(" " + tablero[i][j] + " |");
                }else{
                    System.out.print(" " + tablero[i][j]);
                }
            }
            if(i < 2){
                System.out.println("\n\t-----------");
            }
        }
        System.out.println("\n");
    }
    
    public void colocarFicha(char ficha, char posicion){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(posicion == tablero[i][j]){
                    tablero[i][j] = ficha;
                }
            }
        }
    }
    
    public boolean comprobrarGanador(char ficha){
        //Comprobrar filas
        for(int i = 0; i < 3; i++){
            if(tablero[i][0] == ficha && tablero[i][1] == ficha && tablero[i][2] == ficha){
                return true;
            }
        }
        
        //Comprobrar columnas
        for(int j = 0; j < 3; j++){
            if(tablero[0][j] == ficha && tablero[1][j] == ficha && tablero[2][j] == ficha){
                return true;
            }
        }
        
        //Comprobrar diagonal derecha
        if(tablero[0][0] == ficha && tablero[1][1] == ficha && tablero[2][2] == ficha){
            return true;
        }
        
        //Comprobrar diagonal izquierda
        if(tablero[0][2] == ficha && tablero[1][1] == ficha && tablero[2][0] == ficha){
            return true;
        }
        
        return false;
    }
}