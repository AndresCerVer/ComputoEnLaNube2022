/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Andrés Cervantes Verástegui
 */
public class ProgramaEjemplo {
    public static void main(String[] args) {
        // DECLARACION DE VARIABLES
    int opcion,totalOpciones;
    int[] v1 = new int [20];
    String[] v2 = {"Tokio", "Río", "Lisboa", "Moscú", "Berlín", "Profesor", "Nairobi", "Denver", 
                    "Manila", "Estocolmo", "Helsinki", "Oslo", "Bogotá", "Palermo", "Marsella"};
    
    // VARIABLE String  DONDE SE VAN AGREGANDO LAS OPCIONES DEL MENU
    String menu = "                     MENU DE OPCIONES \n";
            menu += "1.  Ordenar ascendente por QUICKSORT \n";
            menu += "2.  Ordenar A..Z usando QUICKSORT \n";
            menu += "3.  Ordenar Z..A usando QUICKSORT \n";
            menu += "4.  Salir \n";
    totalOpciones = 4;

  // CICLO ITERATIVO QUE PRESENTA EL MENU DE OPCIONES HASTA QUE EL USUARIO SELECCIONE LA OPCION 5
    do {
        opcion = Integer.parseInt (JOptionPane.showInputDialog (menu));  // SE CAPTURA DEL TECLADO UN ENTERO (NUMERO DE LA OPCION)
        switch (opcion){
           case 1:
               vectorAleatorios(v1);
               JOptionPane.showMessageDialog(null, "Vector Generado\n"+ Arrays.toString(v1));
               quicksortAscendente(v1, 0, (v1.length-1));
               JOptionPane.showMessageDialog(null, "Vector Ordenado Asc\n"+ Arrays.toString(v1));
               break; 
           case 2:
               JOptionPane.showMessageDialog(null, "Vector Desordenado\n"+ Arrays.toString(v2));
               quicksortAZ(v2, 0, (v2.length-1));
               JOptionPane.showMessageDialog(null, "Vector Ordenado \n"+ Arrays.toString(v2));
               break;
           case 3:
               JOptionPane.showMessageDialog(null, "Vector Desordenado\n"+ Arrays.toString(v2));
               quicksortZA(v2, 0, (v2.length-1));
               JOptionPane.showMessageDialog(null, "Vector Ordenado \n"+ Arrays.toString(v2));
               break;
           case 4:
               break;    
           default:
               JOptionPane.showMessageDialog (null, "Opción no válida");
               break;
        }  //  FIN DEL SWITCH

    } while (opcion != totalOpciones);   // FIN DEL DO..WHILE
  }  // FIN DEL METODO main
    
    public static void vectorAleatorios(int[] v){
        int i;
        for(i=0; i<v.length; i++)
            v[i] = (int)(Math.random()*101)-50;
    }
    
    public static void quicksortAscendente (int a[], int inicio, int fin) {
        int x = a[inicio];      
        int izq = inicio;        
        int der = fin;           
        int aux;        
        while (izq < der){
            while (a[izq] <= x && izq < der)
                izq++;
            while  (a[der] > x)
                der--;
            if (izq < der){
                aux = a[izq];                  
                a[izq] = a[der];
                a[der] = aux;
            }
        }        
        a[inicio] = a[der];
        a[der] = x;        
        if (inicio < der -1)
            quicksortAscendente (a, inicio, der-1);        
        if (der+1 < fin)	
            quicksortAscendente (a, der+1, fin); 
    }
    
    public static void quicksortAZ (String a[], int inicio, int fin) {
        String x = a[inicio];      
        int izq = inicio;        
        int der = fin;           
        String aux;        
        while (izq < der){
            while (a[izq].compareToIgnoreCase(x) <= 0 && izq < der)    
                izq++; 
            while  (a[der].compareToIgnoreCase(x) > 0)
                der--;
            if (izq < der){
                aux = a[izq];                  
                a[izq] = a[der];
                a[der] = aux;
            }
        }        
        a[inicio] = a[der];
        a[der] = x;
        if (inicio < der -1)
            quicksortAZ (a, inicio, der-1);        
        if (der+1 < fin)	
            quicksortAZ (a, der+1, fin); 
    }    
    public static void quicksortZA (String a[], int inicio, int fin) {
        String x = a[inicio];      
        int izq = inicio;        
        int der = fin;           
        String aux;
        while (izq < der){
            while (a[izq].compareToIgnoreCase(x) >= 0 && izq < der)    
                izq++; 
            while  (a[der].compareToIgnoreCase(x) < 0)
                der--;
            if (izq < der){
                aux = a[izq];                  
                a[izq] = a[der];
                a[der] = aux;
            }
        }       
        a[inicio] = a[der];
        a[der] = x;
        if (inicio < der -1)
            quicksortZA (a, inicio, der-1);
        if (der+1 < fin)	
            quicksortZA (a, der+1, fin); 
    }
}
