/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.pkg1;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
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
    static int asesino[] = {0,0,0,0,0};//Array del resultado ganador
    static int restriccion[][][];//Array de arrays donde estan las parejas restringidas
    int tiempoBack;
    
    public Pantalla() throws InterruptedException {
        initComponents();
        
        Nombres();
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            Empezar();
                        } catch (InterruptedException ex) {
                            System.out.print("Error");
                        }
                    }
                });
        */
        jLabel1.setText("Backtracking");
        tiempoBack = 10;
        Seleccionar(matriz);//Selecciona de manera random la combinacion ganadora
        Scanner scanner = new Scanner(System.in);//Input para que ingrese el numero de parejas que quiere restringir
        System.out.println("Digite la cantidad de parejas que quiere restringir: ");
        int input = scanner.nextInt();
        Restricciones(input);//Genera las parejas de restricciones
        SuggestSol();//Resuelve el juego 

    }
    
    public void Empezar() throws InterruptedException{

        int[][] Matriz = {{1,2,3,4,5,6},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6,7,8,9}};
        int[] Secuencia = {Random(6),Random(8),Random(6),Random(6),Random(9)};   
        int[] Pareja ={Random(6),Random(6)};
        //int[] Secuencia = {1,1,1,1,1};

        ArrayList<Integer>[] resultado =AuxFuerzaBrutaSug(Matriz,Secuencia);
        // lo ponemos en un arreglo todo bonito y ordenado bien
        int i=0;
        int[] salida = new int[5];
        while(i!=5){
            salida[4-i]=resultado[0].get(i);
            i++;
        }

        // comprobamos que este todo bien
        i = 0;
        while(i!=5){
            System.out.print("Solución: "+Secuencia[i]+"\n" + "Solución por fuerza :"+salida[i]+"\n");
            i++;
        }
    } 
    public int Random(int num1){
        return (int)Math.floor(Math.random()*(num1-1+1)+1);
    }
    public void Nombres(){
            
            sos1.setText("Mejor amigo/a");
            sos2.setText("Novio/a");
            sos3.setText("Vecino/a");
            sos4.setText("Mensajero");
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

        Timer timer2 = new Timer(((((int)tiempo/10)*500)), (ActionEvent arg0) -> { 
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
                        sos5.setBackground(new java.awt.Color(red, green, black ));
                    }
                    else if(aux2 == 5){
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
  

    
    public ArrayList<Integer>[] AuxFuerzaBrutaSug(int[][] Matriz,int[] Secuencia) throws InterruptedException{
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        int[][] aux = {{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3,-3}};
        long tiempo = 10;
   
        return fuerzaBrutaSug(Matriz,Secuencia,(Matriz.length-1),aux,0,tiempo,auxiliar);
    }   
    public boolean AuxFuerzaBrutaSug2(ArrayList<Integer> resultado,int[] Secuencia,long tiempo,int[][] Matriz) throws InterruptedException{       
        int i = Secuencia.length-1;        
        boolean salida = true;
        while(i != -1){            
            //System.out.print("Resultado "+((Secuencia.length-1)-i)+"-"+resultado.get((Secuencia.length-1)-i)+" Secuencia "+i+"-"+Secuencia[i]+"\n");
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
        System.out.print("tiempo nara y verde " +tiempo+"\n");
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
        System.out.print("tiempo azul " +tiempo+"\n");
        return salida;
    }   
    public ArrayList<Integer>[] fuerzaBrutaSug(int[][] Matriz,int[] Secuencia, int aux,int[][] aux2,int aux3,long tiempo,ArrayList<Integer>...resultado) throws InterruptedException{        
        // aux es el tamaño de nuestra matriz,aux2 es el tamaño de su ultima fila,aux 3 tamaño de secuencia
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
        
        //System.out.print("tiempo rojo " +(tiempo+20)+"\n");
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
   
        // Mi compa 

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
            System.out.print("Solución:   ");
            System.out.print(Sospechosos[sol[0]-1]+"-");                
            System.out.print(Armas[sol[1]-1]+"-");                
            System.out.print(Motivos[sol[2]-1]+"-");                
            System.out.print(ParteCuerpo[sol[3]-1]+"-");                
            System.out.print(Lugares[sol[4]-1]+"\n");                
    }
    public void Eliminar() throws InterruptedException {//Elimina una carta incorrecta de manera aleatoria
            Random rand = new Random();
            int seccion = rand.nextInt(5);//Escoge de que seccion se va a eliminar
            int carta = rand.nextInt(matriz[seccion].length);//Escoge la carta a eliminar
            if (matriz[seccion][carta] != -1) {//Si no es una carta eliminada
                    if(matriz[seccion][carta] != asesino[seccion]) {//Si no es una carta de la solucion
                            System.out.print("Eliminado: ");
                            System.out.print(seccion);
                            System.out.print("-");
                            System.out.println(carta);//Indica que seccion y que carta se elimino
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
                    System.out.print("Sugerencia:   ");
                    System.out.print(Sospechosos[sol[0]-1]+"-");
                    System.out.print(Armas[sol[1]-1]+"-");
                    System.out.print(Motivos[sol[2]-1]+"-");
                    System.out.print(ParteCuerpo[sol[3]-1]+"-");
                    System.out.print(Lugares[sol[4]-1]+"\n");
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
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sos2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sos6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arm2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arm1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arm3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arm4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arm5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arm6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arm7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(arm8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mot2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mot1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mot3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mot4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mot5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mot6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(lug9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(366, 366, 366))))
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
                        .addComponent(sos4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sos5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sos6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(arm5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arm6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arm7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arm8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lug9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sos1ActionPerformed

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
    private javax.swing.JButton arm1;
    private javax.swing.JButton arm2;
    private javax.swing.JButton arm3;
    private javax.swing.JButton arm4;
    private javax.swing.JButton arm5;
    private javax.swing.JButton arm6;
    private javax.swing.JButton arm7;
    private javax.swing.JButton arm8;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JButton part1;
    private javax.swing.JButton part2;
    private javax.swing.JButton part3;
    private javax.swing.JButton part4;
    private javax.swing.JButton part5;
    private javax.swing.JButton part6;
    private javax.swing.JButton sos1;
    private javax.swing.JButton sos2;
    private javax.swing.JButton sos3;
    private javax.swing.JButton sos4;
    private javax.swing.JButton sos5;
    private javax.swing.JButton sos6;
    // End of variables declaration//GEN-END:variables
}
