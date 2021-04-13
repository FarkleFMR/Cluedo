
package proyecto.pkg1;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Pantalla extends javax.swing.JFrame {
    
    static int matriz[][] = {{1,2,3,4,5,6,7},//Matriz de cartas
                             {1,2,3,4,5,6,7,8},
                             {1,2,3,4,5,6},
                             {1,2,3,4,5,6},
                             {1,2,3,4,5,6,7,8,9},
                             {0}};
    //Array de sospechoso
    static String Sospechosos[] = {"El/la mejor amigo(a)","El/la novio(a)","El/la vecino(a)","El mensajero","El extraño","El/la hermanastro(a)","El/la colega de trabajo"};
    static String Armas[] = {"Pistola","Cuchillo","Machete","Pala","Bate","Botella","Tubo","Cuerda"};//Array de armas
    static String Motivos[] = {"Venganza","Celos","Dinero","Accidente","Drogas","Robo"};//Array de motivos
    static String ParteCuerpo[] = {"Cabeza","Pecho","Abdomen","Espalda","Piernas","Brazos"};//Array de partes del cuerpo
    static String Lugares[] = {"Sala","Comedor","Baño","Terraza","Cuarto","Garage","Patio","Balcon","Cocina"};//Array lugares
    int asesino[] = {0,0,0,0,0};//Array del resultado ganador
    int restriccion[][][];//Array de arrays donde estan las parejas restringidas
    int tiempoBack;
    
    public Pantalla() throws InterruptedException {
        initComponents();
        
        Nombres();
    }
    
    public void Empezar() throws InterruptedException{
        // Función que empieza el algoritmo de Fuerza Bruta
        int[][] Matriz = {{1,2,3,4,5,6,7},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6,7,8,9}};
        int[] Secuencia = {Random(6),Random(8),Random(6),Random(6),Random(9)};   
        
        long startTime = System.nanoTime();
        ArrayList<Integer>[] resultado =AuxFuerzaBrutaSug2(Matriz,Secuencia); 
        long endTime = System.nanoTime();
        long tiempo = (endTime-startTime);
        
        resultado =AuxFuerzaBrutaSug(Matriz,Secuencia);
        
        // comprobamos que este todo bien
        
        
        tiempoAl.setText("Tiempo en nanoSegundos Fuerza Bruta: "+(tiempo));
        
        solu1.setText(Sospechosos[Secuencia[0]-1]);
        solu2.setText(Armas[Secuencia[1]-1]);
        solu3.setText(Motivos[Secuencia[2]-1]);
        solu4.setText(ParteCuerpo[Secuencia[3]-1]);
        solu5.setText(Lugares[Secuencia[4]-1]); 
            
    } 
    public int Random(int num1){
        // Funció que devuelve números randoms desde 1 a num1
        return (int)Math.floor(Math.random()*(num1-1+1)+1);
    }
    public void Nombres(){
            // Función que coloca los nombres de los botones
            sos1.setText("Mejor amigo/a");
            sos2.setText("Novio/a");
            sos3.setText("Vecino/a");
            sos4.setText("Mensajero");
            sos7.setText("El extraño");
            sos5.setText("Hermanastro/a");
            sos6.setText("Colega de trabajo");
            
            arm1.setText("Pistola");
            arm2.setText("Cuchillo");
            arm3.setText("Machete");
            arm4.setText("Pala");
            arm5.setText("Bate");
            arm6.setText("Botella");
            arm7.setText("Tubo");
            arm8.setText("Cuerda");
            
            mot1.setText("Vengaza");
            mot2.setText("Celos");
            mot3.setText("Dinero");
            mot4.setText("Accidente");
            mot5.setText("Drogas");
            mot6.setText("Robo");
            
            part1.setText("Cabeza");
            part2.setText("Pecho");
            part3.setText("Abdomen");
            part4.setText("Espalda");
            part5.setText("Piernas");
            part6.setText("Brazos");
            
            lug1.setText("Sala");
            lug2.setText("Comedor");
            lug3.setText("Baño");
            lug4.setText("Terraza");
            lug5.setText("Cuarto");
            lug6.setText("Garage");
            lug7.setText("Patio");
            lug8.setText("Balcón");
            lug9.setText("Cocina");           
            
    }
    public void ColorBot(int aux, int aux2,int color, long tiempo) throws InterruptedException{
        // Función encargada de cambiar el color de los botones    
        // Variables: aux(la columna de la matriz), aux2(es la fila de la columna), color(es el número de color que le pondremos al boton)
        // tiempo (es la cantidad de tiempo que tardara en cambiarse el color del boton)
        Timer timer2 = new Timer(((((int)tiempo/10)*100)), (ActionEvent arg0) -> { 
        Timer timer = new Timer((1000), (ActionEvent arg1) -> {            
        int red = 0;
        int green = 0;
        int black = 0;

        if(color == 3){// verde
            red = 43;
            green = 247;
            black = 34;
        }
        else if(color == 1){// amarillo
            red = 247;
            green = 176;
            black = 34;

        }
        else if(color == 2){// rojo
            red = 244;
            green = 62;
            black = 30;

        }
        else if(color == 4){// azul
            red = 153;
            green = 255;
            black = 255;

        }    
        else if( color == 5){// morado
            red = 163;
            green = 73;
            black = 164;
        }
            if(aux == 0){
                    if (aux2 == 0){
                        sos1.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 1){
                        sos2.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 2){
                        sos3.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 3){
                        sos4.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 4){
                        sos7.setBackground(new java.awt.Color(red, green, black ));
                    }  
                    else if(aux2 == 5){
                        sos5.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 6){
                        sos6.setBackground(new java.awt.Color(red, green, black ));
                    }
            }else if(aux == 1){

                    if (aux2 == 0){
                        arm1.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 1){
                        arm2.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 2){
                        arm3.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 3){
                        arm4.setBackground(new java.awt.Color(red, green, black));
                    }
                    else if(aux2 == 4){
                        arm5.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 5){
                        arm6.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 6){
                        arm7.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 7){
                        arm8.setBackground(new java.awt.Color(red, green, black ));
                    }             
            }else if(aux == 2){

                    if (aux2 == 0){
                        mot1.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 1){
                        mot2.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 2){
                        mot3.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 3){
                        mot4.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 4){
                        mot5.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 5){
                        mot6.setBackground(new java.awt.Color(red, green, black ));
                    }         
            }else if(aux == 3){

                    if (aux2 == 0){
                        part1.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 1){
                        part2.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 2){
                        part3.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 3){
                        part4.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 4){
                        part5.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 5){
                        part6.setBackground(new java.awt.Color(red, green, black ));
                    }         
            }else if(aux == 4){

                    if (aux2 == 0){
                        lug1.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 1){
                        lug2.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 2){
                        lug3.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 3){
                        lug4.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 4){
                        lug5.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 5){
                        lug6.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 6){
                        lug7.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 7){
                        lug8.setBackground(new java.awt.Color(red, green, black ));
                    }  
                    else if(aux2 == 8){
                        lug9.setBackground(new java.awt.Color(red, green, black ));
                    }       
                }     
            }
            ); 
            timer.setRepeats(false); 
            timer.start();
            }
            ); 
            timer2.setRepeats(false); 
            timer2.start();        
    }
    
    public void TodoCel() throws InterruptedException{
        // Función que pone todos los botones en celeste
        int fila = 0;
        int columna = 0;
        
        while (fila != matriz.length){
            while( columna != matriz[fila].length){
                ColorBot(fila,columna,4,1);
                columna++;
            }
            fila++;
            columna = 0;
        }        
    }
    
    // Fuerza Bruta con Interfaz
    
    public ArrayList<Integer>[] AuxFuerzaBrutaSug(int[][] Matriz,int[] Secuencia) throws InterruptedException{
        // Matriz(matriz donde se encuentran nuestra secuencia de enteros), Secuencia(la secuencia correcta de enteros)
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        int[][] aux = {{-3,-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3,-3}};
        // aux lo seteamos para despues usarlo para eliminar cartas
        long tiempo = 10;
        tiempoBack = 0;
        return fuerzaBrutaSug(Matriz,Secuencia,(Matriz.length-1),aux,0,tiempo,auxiliar);
    }   
    public boolean AuxFuerzaBrutaSug2(ArrayList<Integer> resultado,int[] Secuencia,long tiempo,int[][] Matriz) throws InterruptedException{       
        // resultado ( Arraylist donde guardaremos la secuencia encontrada en la matriz)
        // Matriz(matriz donde se encuentran nuestra secuencia de enteros), Secuencia(la secuencia correcta de enteros)
        // tiempo (el tiempo que transcurre entre cada animación de los botones)
        int i = Secuencia.length-1;        
        boolean salida = true;
        while(i != -1){          
            int aux = 0;
            while(aux != Matriz[i].length){
                    if (Matriz[i][aux] == resultado.get((Secuencia.length-1)-i)){
                        break;
                    }
                    aux++;
                }            
            ColorBot(i,aux,1,tiempo);
            if (resultado.get((Secuencia.length-1)-i) != Secuencia[i]){                
                salida = false;
            }else{ 
                ColorBot(i,aux,3,tiempo);
            }

            i -= 1;
            aux++;
        }
        if (salida == true)
            return salida;
        tiempo += 10;        
        i = Secuencia.length-1;       
        while(i != -1){           
            int aux = 0;
            while(aux != Matriz[i].length){
                    if (Matriz[i][aux] == resultado.get((Secuencia.length-1)-i)){
                        break;
                    }
                    aux++;
                }
            ColorBot(i,aux,4,tiempo);
            i -= 1;
            aux++;
        }
        return salida;
    }   
    public ArrayList<Integer>[] fuerzaBrutaSug(int[][] Matriz,int[] Secuencia, int aux,int[][] aux2,int aux3,long tiempo,ArrayList<Integer>...resultado) throws InterruptedException{        
        // aux es el tamaño de nuestra matriz,aux2 es la matriz donde borraremos las cartas,aux3 tamaño de secuencia
        // resultado ( Arraylist donde guardaremos la secuencia encontrada de la matriz)
        // Matriz(matriz donde se encuentran nuestra secuencia de enteros), Secuencia(la secuencia correcta de enteros)
        // tiempo (el tiempo que transcurre entre cada animación de los botones)
        if(Matriz.length-1 == aux){
            int aux4 = aux;
            while (aux4 != -1){
                resultado[0].add(Matriz[aux4][0]);
                aux4--;             
            }
        }        
        
        if (AuxFuerzaBrutaSug2(resultado[0],Secuencia,tiempo,Matriz)){
                return resultado;  
        }
        
        aux3 = Random(resultado[0].size())-1; //elegimos una posición random de nuestra posible respuesta
        int aux9 =Random(Matriz[4-aux3].length)-1;     
        
        while(aux2[4-aux3][aux9] == -2){
            if(Matriz[4-aux3][aux9]== Secuencia[4-aux3]){                  
                    break;
            }
            ColorBot(4-aux3,aux9,2,tiempo+20);
            aux3 = Random(resultado[0].size())-1;
            aux9 =Random(Matriz[4-aux3].length)-1; 
        }   
        
        tiempo += 20; 
        
        aux2[4-aux3][aux9] = -2; 
        resultado[0].set(aux3,Matriz[4-aux3][aux9]); // elegimos aleatoriamente otro resultado no probado
        
        return fuerzaBrutaSug(Matriz,Secuencia,0,aux2,aux3+1,tiempo,resultado);   
    }
   
    // Bactracking con Interfaz

    public void Seleccionar(int matriz[][]){//Selecciona la combinacion a buscar y la ingresa en asesino	
            Random rand = new Random();
            for (int i = 0; i < 5;i++) {
                    int limite = matriz[i].length;//Establece el limite para generar los random
                    int seleccionado = rand.nextInt(limite);//Escoge un indice random de una fila de la matriz
                    asesino[i] = matriz[i][seleccionado];//Ingresa la carta random a asesino
            }
    }
    public void Restricciones(int parejas) throws InterruptedException {//Escoge las parejas restringidas
            Random rand = new Random();
            int newpareja[][][] = new int[parejas][2][2]; //El primer[] es la cantidad de parejas, el segundo[] es para indicar la fila de la matriz y el dato y la tercera es para la fila en la matriz y el dato de la pareja
            for (int i = 0; i < parejas;i++) {
                    int seccion1 = rand.nextInt(5);//Escoge una seccion random osea escoge sospechoso,armas etc
                    int seccion2 = rand.nextInt(5);//Escoge otra seccion random osea escoge sospechoso,armas etc
                    newpareja[i][0][0] = seccion1;//La ingresa en el campo de fila
                    newpareja[i][1][0] = seccion2;//La ingresa en el campo fila de la pareja
                    int rand0 = rand.nextInt(matriz[seccion1].length);
                    int rand1 = rand.nextInt(matriz[seccion2].length);
                    newpareja[i][0][1] = matriz[seccion1][rand0];//Ingresa el dato restringido 1
                    newpareja[i][1][1] = matriz[seccion2][rand1];//Ingresa el dato restringido 2 apartir de ahora estos dos datos no pueden ir juntos
                    ColorBot(seccion1,rand0,5,tiempoBack);
                    ColorBot(seccion2,rand1,5,tiempoBack);

            }
            restriccion = newpareja;//Ingresa los datos en restriccion
    }
    public boolean isSafe(int clasificacion,int select,int sol[]) {//Se asegura que el dato escogido no sea uno que haya sido descartado
            if (matriz[clasificacion][select] == -1)//Si fue descartado return false
                    return false;
            return true;
    }
    public boolean SuggestSol() throws InterruptedException {//Funcion para solucionar el cluedo
            int Sol[] = {0,0,0,0,0,0};//Array donde se guarda la posible solucion
            if (SuggestUtil(0,Sol) == false) {//Si no existe una combinacion correcta			
                    JOptionPane.showMessageDialog(null, " "
                        + "\nNo existe solución");
                    return false;
            }
            printSolucion(Sol);//Imprimir la solucion en caso de que exista una solucion correcta
            return true;
    }
    public void printSolucion(int[] sol) throws InterruptedException {//Imprime la solucion
            tiempoBack += 10;
            for(int i=0; i!=5; i++){
                ColorBot(i,sol[i]-1,3,tiempoBack);
            }
            solu1.setText(Sospechosos[sol[0]-1]);
            solu2.setText(Armas[sol[1]-1]);
            solu3.setText(Motivos[sol[2]-1]);
            solu4.setText(ParteCuerpo[sol[3]-1]);
            solu5.setText(Lugares[sol[4]-1]);            
    }
    public void Eliminar() throws InterruptedException {//Elimina una carta incorrecta de manera aleatoria
            Random rand = new Random();
            int seccion = rand.nextInt(5);//Escoge de que seccion se va a eliminar
            int carta = rand.nextInt(matriz[seccion].length);//Escoge la carta a eliminar
            if (matriz[seccion][carta] != -1) {//Si no es una carta eliminada
                    if(matriz[seccion][carta] != asesino[seccion]) {//Si no es una carta de la solucion
                            matriz[seccion][carta] = -1;//Elimina la carta
                            tiempoBack += 10;
                            ColorBot(seccion,carta,2,tiempoBack);
                    }
            }
    }
    public boolean SuggestUtil(int i,int sol[]) throws InterruptedException {//Algoritmo de bactracking para solucionar el cluedo
            if (i > 5) {//Si tiene un posible resultado
                    Eliminar();//Elimine una incorrecta y luego imprime sugerencia
                    tiempoBack += 10;
                    for(int n=0; n!=5; n++){
                        ColorBot(n,sol[n]-1,1,tiempoBack);
                    }
                    tiempoBack += 20;
                    for(int n=0; n!=5; n++){
                        if(matriz[n][sol[n]-1] == -1)
                            ColorBot(n,sol[n]-1,2,tiempoBack);
                        ColorBot(n,sol[n]-1,4,tiempoBack);
                    }
                    return true;
            }
            for (int j = 0; j < matriz[i].length;j++) {//For para que pase a la siguiente carta en caso de estar en el camino incorrecto
                    if (isSafe(i,j,sol)) {//Si la carta no esta eliminada                               
                            sol[i] = matriz[i][j];//Ingresa el dato a la posible solucion                                
                            if (VerResticcion(sol)) {//Se asegura que el dato ingresado no sea una pareja de restriccion   
                                    return false;
                            }
                            if (SuggestUtil(i+1,sol)) {//Se mueve a probar la siguiente seccion                                                                               
                                    if (Verificar(sol))//Si es la combinacion ganadora
                                            return true;
                                    return false;//Continue las sugerencial
                            }
                            sol[i] = 0;//En caso de no ser ninguna de las anteriores convierta en cero la opcion                               

                    }
            }
            return false;
    }
    public boolean VerResticcion(int[] sol) {//Se asegura que en la posible solucion no haya parejas restringidas
            for (int i = 0; i < restriccion.length;i++) {//Pasa por todas las parejas restringidas
                    //Si existen parejas restringidas en la solucion retorne true
                    if (sol[restriccion[i][0][0]] == restriccion[i][0][1] && sol[restriccion[i][1][0]] == restriccion[i][1][1]) {
                            return true;
                    }
            }
            return false;
    }
    public boolean Verificar(int sol[]) {//Verifica si la posible solucion es la correcta
            if (sol.length < 5)//Se asegura que la posible solucion sea del largo correcto
                    return false;
            for(int i = 0; i < 5;i++) {//Compara la posible solucion con la solucion correcta
                    if(sol[i] != asesino[i]){
                            return false;
                    }
            }
            return true;
    }
    
    
    // Fuerza Bruta sin Interfaz
    
    public ArrayList<Integer>[] AuxFuerzaBrutaSug2(int[][] Matriz,int[] Secuencia) throws InterruptedException{
        // Matriz(matriz donde se encuentran nuestra secuencia de enteros), Secuencia(la secuencia correcta de enteros)
        // Esta función se encarga de crear variables que nos ayudaran para encontrar la secuencia dentro de la matriz
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        int[][] aux = {{-3,-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3,-3}};
        return fuerzaBrutaSug2(Matriz,Secuencia,(Matriz.length-1),aux,0,auxiliar);
    }   
    public boolean AuxFuerzaBrutaSug22(ArrayList<Integer> resultado,int[] Secuencia,int[][] Matriz) throws InterruptedException{  
        // resultado ( Arraylist donde guardaremos la secuencia encontrada de la matriz)
        // Matriz(matriz donde se encuentran nuestra secuencia de enteros), Secuencia(la secuencia correcta de enteros)
        // Esta función se encarga de fijarse si resultado es igual a la Secuencia si es igual devuelve true, si no false.
        int largoSec = Secuencia.length-1;
        int largoSecAux = largoSec;
        while(largoSec != -1){            
            //Comparamos nuestro ArrayList con la Secuencia si tiene un elemento diferente retorna false
            if (resultado.get((largoSecAux)-largoSec) != Secuencia[largoSec]){
                return false;
            }
            largoSec -= 1;
        }        
        return true;
    }   
    public ArrayList<Integer>[] fuerzaBrutaSug2(int[][] Matriz,int[] Secuencia, int aux,int[][] aux2,int aux3,ArrayList<Integer>...resultado) throws InterruptedException{        
        // aux es el tamaño de nuestra matriz,aux2 es la matriz donde "eliminaremos" las cartas,aux 3 tamaño de secuencia
        // resultado ( Arraylist donde guardaremos la secuencia encontrada de la matriz)
        // Matriz(matriz donde se encuentran nuestra secuencia de enteros), Secuencia(la secuencia correcta de enteros)
        
        //Esta función se encarga de encontrar la Secuencia dentro de Matriz
        
        // Como primera opción probamos toda la primer linea
        if(Matriz.length-1 == aux){
            int aux4 = aux;
            while (aux4 != -1){
                resultado[0].add(Matriz[aux4][0]);
                aux4--;             
            }
        }      
        // Nos fijamos si el resultado es igual a la Secuencia
        if (AuxFuerzaBrutaSug22(resultado[0],Secuencia,Matriz)){
                return resultado;  
        }        
        aux3 = Random(resultado[0].size())-1; //elegimos una fila random de nuestra posible respuesta
        int aux9 =Random(Matriz[4-aux3].length)-1;// elegimos una columna random de la fila random      
        
        while(aux2[4-aux3][aux9] == -2){// Si esa posición tiene un -2(significa que ya se probo y se descarto) la cambiamos
            if(Matriz[4-aux3][aux9]== Secuencia[4-aux3]){ // si la posición random es una respuesta de la secuencia salimos                 
                    break;
            }
            aux3 = Random(resultado[0].size())-1;
            aux9 =Random(Matriz[4-aux3].length)-1; 
        }          
        aux2[4-aux3][aux9] = -2; 
        resultado[0].set(aux3,Matriz[4-aux3][aux9]); // elegimos aleatoriamente otro elemento y lo metemos en resultado
        
        return fuerzaBrutaSug2(Matriz,Secuencia,0,aux2,aux3+1,resultado);   
    }
   
    // Bactracking sin Interfaz



    public boolean isSafe2(int clasificacion,int select,int sol[]) {//Se asegura que el dato escogido no sea uno que haya sido descartado
            if (matriz[clasificacion][select] == -1)//Si fue descartado return false
                    return false;
            return true;
    }
    public boolean SuggestSol2() throws InterruptedException {//Funcion para solucionar el cluedo
            int Sol[] = {0,0,0,0,0,0};//Array donde se guarda la posible solucion
            if (SuggestUtil2(0,Sol) == false) {//Si no existe una combinacion correcta			
                    return false;
            }
            return true;
    }    
    public void Eliminar2() throws InterruptedException {//Elimina una carta incorrecta de manera aleatoria
            Random rand = new Random();
            int seccion = rand.nextInt(5);//Escoge de que seccion se va a eliminar
            int carta = rand.nextInt(matriz[seccion].length);//Escoge la carta a eliminar
            if (matriz[seccion][carta] != -1) {//Si no es una carta eliminada
                    if(matriz[seccion][carta] != asesino[seccion]) {//Si no es una carta de la solucion
                            matriz[seccion][carta] = -1;//Elimina la carta                            
                    }
            }
    }
    public boolean SuggestUtil2(int i,int sol[]) throws InterruptedException {//Algoritmo de bactracking para solucionar el cluedo
            if (i > 5) {//Si tiene un posible resultado
                    Eliminar2();//Elimine una incorrecta y luego imprime sugerencia
                    return true;
            }
            for (int j = 0; j < matriz[i].length;j++) {//For para que pase a la siguiente carta en caso de estar en el camino incorrecto
                    if (isSafe2(i,j,sol)) {//Si la carta no esta eliminada                               
                            sol[i] = matriz[i][j];//Ingresa el dato a la posible solucion                                
                            if (VerResticcion2(sol)) {//Se asegura que el dato ingresado no sea una pareja de restriccion   
                                    return false;
                            }
                            if (SuggestUtil2(i+1,sol)) {//Se mueve a probar la siguiente seccion                                                                               
                                    if (Verificar2(sol))//Si es la combinacion ganadora
                                            return true;
                                    return false;//Continue las sugerencial
                            }
                            sol[i] = 0;//En caso de no ser ninguna de las anteriores convierta en cero la opcion                               

                    }
            }
            return false;
    }
    public boolean VerResticcion2(int[] sol) {//Se asegura que en la posible solucion no haya parejas restringidas
            for (int i = 0; i < restriccion.length;i++) {//Pasa por todas las parejas restringidas
                    //Si existen parejas restringidas en la solucion retorne true
                    if (sol[restriccion[i][0][0]] == restriccion[i][0][1] && sol[restriccion[i][1][0]] == restriccion[i][1][1]) {
                            return true;
                    }
            }
            return false;
    }
    public boolean Verificar2(int sol[]) {//Verifica si la posible solucion es la correcta
            if (sol.length < 5)//Se asegura que la posible solucion sea del largo correcto
                    return false;
            for(int i = 0; i < 5;i++) {//Compara la posible solucion con la solucion correcta
                    if(sol[i] != asesino[i]){
                            return false;
                    }
            }
            return true;
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sos1 = new javax.swing.JButton();
        sos2 = new javax.swing.JButton();
        sos3 = new javax.swing.JButton();
        sos4 = new javax.swing.JButton();
        sos5 = new javax.swing.JButton();
        sos6 = new javax.swing.JButton();
        arm1 = new javax.swing.JButton();
        arm8 = new javax.swing.JButton();
        arm7 = new javax.swing.JButton();
        arm6 = new javax.swing.JButton();
        arm5 = new javax.swing.JButton();
        arm4 = new javax.swing.JButton();
        arm3 = new javax.swing.JButton();
        arm2 = new javax.swing.JButton();
        mot1 = new javax.swing.JButton();
        mot6 = new javax.swing.JButton();
        mot5 = new javax.swing.JButton();
        mot4 = new javax.swing.JButton();
        mot3 = new javax.swing.JButton();
        mot2 = new javax.swing.JButton();
        part1 = new javax.swing.JButton();
        part6 = new javax.swing.JButton();
        part5 = new javax.swing.JButton();
        part4 = new javax.swing.JButton();
        part3 = new javax.swing.JButton();
        part2 = new javax.swing.JButton();
        lug1 = new javax.swing.JButton();
        lug8 = new javax.swing.JButton();
        lug7 = new javax.swing.JButton();
        lug6 = new javax.swing.JButton();
        lug5 = new javax.swing.JButton();
        lug4 = new javax.swing.JButton();
        lug3 = new javax.swing.JButton();
        lug2 = new javax.swing.JButton();
        lug9 = new javax.swing.JButton();
        actFB = new javax.swing.JButton();
        actBT = new javax.swing.JButton();
        tiempoAl = new javax.swing.JLabel();
        numRes = new javax.swing.JTextField();
        canPar = new javax.swing.JLabel();
        probBT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        solu1 = new javax.swing.JButton();
        solu2 = new javax.swing.JButton();
        solu3 = new javax.swing.JButton();
        solu4 = new javax.swing.JButton();
        solu5 = new javax.swing.JButton();
        sos7 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Fuerza Bruta");

        sos1.setBackground(new java.awt.Color(153, 255, 255));
        sos1.setText("jButton1");
        sos1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sos1ActionPerformed(evt);
            }
        });

        sos2.setBackground(new java.awt.Color(153, 255, 255));
        sos2.setText("jButton1");
        sos2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sos2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sos3.setBackground(new java.awt.Color(153, 255, 255));
        sos3.setText("jButton1");
        sos3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sos3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sos4.setBackground(new java.awt.Color(153, 255, 255));
        sos4.setText("jButton1");
        sos4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sos4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sos5.setBackground(new java.awt.Color(153, 255, 255));
        sos5.setText("jButton1");
        sos5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sos5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        sos6.setBackground(new java.awt.Color(153, 255, 255));
        sos6.setText("jButton1");
        sos6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sos6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        arm1.setBackground(new java.awt.Color(153, 255, 255));
        arm1.setText("jButton1");
        arm1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        arm8.setBackground(new java.awt.Color(153, 255, 255));
        arm8.setText("jButton1");
        arm8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        arm7.setBackground(new java.awt.Color(153, 255, 255));
        arm7.setText("jButton1");
        arm7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        arm6.setBackground(new java.awt.Color(153, 255, 255));
        arm6.setText("jButton1");
        arm6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        arm5.setBackground(new java.awt.Color(153, 255, 255));
        arm5.setText("jButton1");
        arm5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        arm4.setBackground(new java.awt.Color(153, 255, 255));
        arm4.setText("jButton1");
        arm4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        arm3.setBackground(new java.awt.Color(153, 255, 255));
        arm3.setText("jButton1");
        arm3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        arm2.setBackground(new java.awt.Color(153, 255, 255));
        arm2.setText("jButton1");
        arm2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        arm2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        mot1.setBackground(new java.awt.Color(153, 255, 255));
        mot1.setText("jButton1");
        mot1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mot1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        mot6.setBackground(new java.awt.Color(153, 255, 255));
        mot6.setText("jButton1");
        mot6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mot6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        mot5.setBackground(new java.awt.Color(153, 255, 255));
        mot5.setText("jButton1");
        mot5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mot5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        mot4.setBackground(new java.awt.Color(153, 255, 255));
        mot4.setText("jButton1");
        mot4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mot4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        mot3.setBackground(new java.awt.Color(153, 255, 255));
        mot3.setText("jButton1");
        mot3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mot3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        mot2.setBackground(new java.awt.Color(153, 255, 255));
        mot2.setText("jButton1");
        mot2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mot2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        part1.setBackground(new java.awt.Color(153, 255, 255));
        part1.setText("jButton1");
        part1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        part1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        part6.setBackground(new java.awt.Color(153, 255, 255));
        part6.setText("jButton1");
        part6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        part6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        part5.setBackground(new java.awt.Color(153, 255, 255));
        part5.setText("jButton1");
        part5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        part5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        part4.setBackground(new java.awt.Color(153, 255, 255));
        part4.setText("jButton1");
        part4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        part4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        part3.setBackground(new java.awt.Color(153, 255, 255));
        part3.setText("jButton1");
        part3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        part3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        part2.setBackground(new java.awt.Color(153, 255, 255));
        part2.setText("jButton1");
        part2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        part2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug1.setBackground(new java.awt.Color(153, 255, 255));
        lug1.setText("jButton1");
        lug1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug8.setBackground(new java.awt.Color(153, 255, 255));
        lug8.setText("jButton1");
        lug8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug7.setBackground(new java.awt.Color(153, 255, 255));
        lug7.setText("jButton1");
        lug7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug6.setBackground(new java.awt.Color(153, 255, 255));
        lug6.setText("jButton1");
        lug6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug6.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug5.setBackground(new java.awt.Color(153, 255, 255));
        lug5.setText("jButton1");
        lug5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug4.setBackground(new java.awt.Color(153, 255, 255));
        lug4.setText("jButton1");
        lug4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug3.setBackground(new java.awt.Color(153, 255, 255));
        lug3.setText("jButton1");
        lug3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug2.setBackground(new java.awt.Color(153, 255, 255));
        lug2.setText("jButton1");
        lug2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lug9.setBackground(new java.awt.Color(153, 255, 255));
        lug9.setText("jButton1");
        lug9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lug9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        actFB.setText("Fuerza Bruta");
        actFB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actFBActionPerformed(evt);
            }
        });

        actBT.setText("Backtracking");
        actBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actBTActionPerformed(evt);
            }
        });

        tiempoAl.setBackground(new java.awt.Color(51, 255, 255));
        tiempoAl.setText("Tiempo en nanoSegundos:");
        tiempoAl.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.cyan, java.awt.Color.blue));

        numRes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numRes.setBorder(new javax.swing.border.MatteBorder(null));

        canPar.setText("Cantidad de parejas restringidas:");

        probBT.setText("Probar");
        probBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                probBTActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Solución:");
        jLabel2.setToolTipText("");

        solu1.setBackground(new java.awt.Color(0, 204, 0));
        solu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        solu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        solu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solu1ActionPerformed(evt);
            }
        });

        solu2.setBackground(new java.awt.Color(0, 204, 0));
        solu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        solu2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        solu3.setBackground(new java.awt.Color(0, 204, 0));
        solu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        solu3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        solu4.setBackground(new java.awt.Color(0, 204, 0));
        solu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        solu4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        solu5.setBackground(new java.awt.Color(0, 204, 0));
        solu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        solu5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        sos7.setBackground(new java.awt.Color(153, 255, 255));
        sos7.setText("jButton1");
        sos7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        sos7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(366, 366, 366))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sos2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sos1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sos3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sos4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sos5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sos6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sos7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(actBT)
                                            .addComponent(actFB))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(arm2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(arm1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(arm3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(arm4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(arm5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(arm6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(arm7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(arm8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(mot2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(mot1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(mot3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(mot4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(mot5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(mot6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(numRes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(91, 91, 91)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tiempoAl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(part2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(part1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(part3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(part4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(part5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(part6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lug2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lug9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(canPar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(solu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(0, 0, 0)
                                    .addComponent(solu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(9, 9, 9)
                                    .addComponent(solu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(solu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(solu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(290, 290, 290))))
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(probBT)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sos1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sos2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sos3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sos4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mot1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mot2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mot3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mot4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mot5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mot6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(part1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(part2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(part3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(part4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(part5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(part6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lug1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lug2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lug3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lug4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lug5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lug6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lug7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lug8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(arm1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arm2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arm3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arm4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(arm5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(arm6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(arm7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arm8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lug9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(actFB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(canPar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actBT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numRes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tiempoAl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(probBT)
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(solu1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solu3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solu4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solu5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(solu2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        numRes.setVisible(false);
        canPar.setVisible(false);
        probBT.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sos1ActionPerformed

    private void actFBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actFBActionPerformed
        // Activamos la animación del algoritmo de Fuerza Bruta
        tiempoBack = 0;       
        try {
            TodoCel(); // ponemos todos los botones celestes
        } catch (InterruptedException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            jLabel1.setText("Fuerza Bruta");
                            Empezar();                            
                        } catch (InterruptedException ex) {
                            System.out.print("Error");
                        }
                    }
                });
        
    }//GEN-LAST:event_actFBActionPerformed

    private void actBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actBTActionPerformed
        // Activamos la animación del algoritmo de Bactracking
        numRes.setVisible(true);
        canPar.setVisible(true);
        probBT.setVisible(true);
        try {
            TodoCel();
        } catch (InterruptedException ex) {
            Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i=0; i != 5; i++){
            asesino[i]=0;
        }
        int ayuda[][][] = new int[0][2][2];
        restriccion = ayuda.clone();
        
        int matrizAyuda[][] = {{1,2,3,4,5,6,7},
                             {1,2,3,4,5,6,7,8},
                             {1,2,3,4,5,6},
                             {1,2,3,4,5,6},
                             {1,2,3,4,5,6,7,8,9},
                             {0}};
        this.matriz = matrizAyuda.clone();
        tiempoBack = 0;
    }//GEN-LAST:event_actBTActionPerformed

    private void probBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_probBTActionPerformed
        // TODO add your handling code here:
        
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {                                  
                            jLabel1.setText("Backtracking");
                            tiempoBack = 10;                            
                            Seleccionar(matriz);//Selecciona de manera random la combinacion ganadora
                            
                            Scanner scanner = new Scanner(System.in);//Input para que ingrese el numero de parejas que quiere restringir
                            
                            String inpuTex = (numRes.getText()).replace(" ",""); // Comprobamos que el string sea un número                            
                            boolean isNumeric =  inpuTex.matches("[+-]?\\d*(\\.\\d+)?");                            
                            if(isNumeric == false || inpuTex == ""){
                                JOptionPane.showMessageDialog(null, " "
                                + "\nError, Número mal insertado");
                            }else{
                                int input = Integer.parseInt(inpuTex);   
                                Restricciones(input);//Genera las parejas de restricciones
                                SuggestSol();//Resuelve el juego 
                                
                                int matrizAyuda[][] = {{1,2,3,4,5,6,7},
                                                        {1,2,3,4,5,6,7,8},
                                                        {1,2,3,4,5,6},
                                                        {1,2,3,4,5,6},
                                                        {1,2,3,4,5,6,7,8,9},
                                                        {0}};
                                matriz = matrizAyuda.clone();
                                
                                long startTime = System.nanoTime();     
                                SuggestSol2();//Resuelve el juego                                 
                                long endTime = System.nanoTime();
                                long tiempo = (endTime-startTime);
                                tiempoAl.setText("Tiempo en nanoSegundos Backtracking: "+(tiempo));

                            }
                            numRes.setText("");                            
                            
                        } catch (InterruptedException ex) {
                            JOptionPane.showMessageDialog(null, " "
                                + "\nError, Intentelo de nuevo");
                        }
                    }
                });
            
            numRes.setVisible(false);
            canPar.setVisible(false);
            probBT.setVisible(false);
    }//GEN-LAST:event_probBTActionPerformed

    private void solu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_solu1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Pantalla().setVisible(true);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pantalla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actBT;
    private javax.swing.JButton actFB;
    private javax.swing.JButton arm1;
    private javax.swing.JButton arm2;
    private javax.swing.JButton arm3;
    private javax.swing.JButton arm4;
    private javax.swing.JButton arm5;
    private javax.swing.JButton arm6;
    private javax.swing.JButton arm7;
    private javax.swing.JButton arm8;
    private javax.swing.JLabel canPar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton lug1;
    private javax.swing.JButton lug2;
    private javax.swing.JButton lug3;
    private javax.swing.JButton lug4;
    private javax.swing.JButton lug5;
    private javax.swing.JButton lug6;
    private javax.swing.JButton lug7;
    private javax.swing.JButton lug8;
    private javax.swing.JButton lug9;
    private javax.swing.JButton mot1;
    private javax.swing.JButton mot2;
    private javax.swing.JButton mot3;
    private javax.swing.JButton mot4;
    private javax.swing.JButton mot5;
    private javax.swing.JButton mot6;
    private javax.swing.JTextField numRes;
    private javax.swing.JButton part1;
    private javax.swing.JButton part2;
    private javax.swing.JButton part3;
    private javax.swing.JButton part4;
    private javax.swing.JButton part5;
    private javax.swing.JButton part6;
    private javax.swing.JButton probBT;
    private javax.swing.JButton solu1;
    private javax.swing.JButton solu2;
    private javax.swing.JButton solu3;
    private javax.swing.JButton solu4;
    private javax.swing.JButton solu5;
    private javax.swing.JButton sos1;
    private javax.swing.JButton sos2;
    private javax.swing.JButton sos3;
    private javax.swing.JButton sos4;
    private javax.swing.JButton sos5;
    private javax.swing.JButton sos6;
    private javax.swing.JButton sos7;
    private javax.swing.JLabel tiempoAl;
    // End of variables declaration//GEN-END:variables
}
