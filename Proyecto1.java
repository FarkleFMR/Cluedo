package proyecto.pkg1;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Proyecto1 {
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
    
    
    
    /*
    String[] sospechoso = {"Mejor amigo/a","Novio/a","Vecino/a","Mensajero","Hermanastro/a","Colega detrabajo"};
    String[] arma = {"Pistola","Cuchillo","Machete","Pala","Bate","Botella","Tubo","Cuerda"};
    String[] motivo = {"Vengaza","Celos","Dinero","Accidente","Drogas","Robo"};
    String[] parte_del_cuerpo = {"Cabeza","Pecho","Abdomen","Espalda","Piernas","Brazos"};
    String[] lugar = {"Sala","Comedor","Baño","Terraza","Cuarto","Garage","Patio","Balcón","Cocina"};
    */
    public int Random(int num1){
        return (int)Math.floor(Math.random()*(num1-1+1)+1);
    }
    
    public ArrayList<Integer>[] AuxFuerzaBrutaSug(int[][] Matriz,int[] Secuencia){
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        int[][] aux = {{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3},{-3,-3,-3,-3,-3,-3,-3,-3,-3}};
        return fuerzaBrutaSug(Matriz,Secuencia,(Matriz.length-1),aux,0,auxiliar);
    }
   
    public boolean AuxFuerzaBrutaSug2(ArrayList<Integer> resultado,int[] Secuencia){      
        int i = Secuencia.length-1;
        while(i != -1){            
            System.out.print("Resultado "+resultado.get((Secuencia.length-1)-i)+" Secuencia "+Secuencia[i]+"\n");
            if (resultado.get((Secuencia.length-1)-i) != Secuencia[i]){
                return false;
            }
            i -= 1;
        }        
        return true;
    }
    
        // aux es el tamaño de nuestra matriz,aux2 es el tamaño de su ultima fila,aux 3 tamaño de secuencia
    public ArrayList<Integer>[] fuerzaBrutaSug(int[][] Matriz,int[] Secuencia, int aux,int[][] aux2,int aux3,ArrayList<Integer>...resultado){
         
        if(Matriz.length-1 == aux){
            int aux4 = aux;
            while (aux4 != -1){
                resultado[0].add(Matriz[aux4][0]);
                aux4--;             
            }
        }
        if (AuxFuerzaBrutaSug2(resultado[0],Secuencia)){
                return resultado;  
        }           
        aux3 = Random(resultado[0].size())-1; //elegimos una posición random de nuestra posible respuesta
        int aux9 =Random(Matriz[4-aux3].length)-1;        
        
        while(aux2[4-aux3][aux9] == -2){
            if(4-aux3 == 0){
                if(Matriz[4-aux3][aux9]== Secuencia[0])
                    break;
            }else if(4-aux3 == 1){
                if(Matriz[4-aux3][aux9]== Secuencia[1])
                    break;
            }else if(4-aux3 == 2){
                if(Matriz[4-aux3][aux9]== Secuencia[2])
                    break;
            }else if(4-aux3 == 3){
                if(Matriz[4-aux3][aux9]== Secuencia[3])
                    break;
            }else{
                if(Matriz[4-aux3][aux9]== Secuencia[4])
                    break;
            }            

            aux3 = Random(resultado[0].size())-1;
            aux9 =Random(Matriz[4-aux3].length)-1; 
          
        }
        aux2[4-aux3][aux9] = -2; 
        resultado[0].set(aux3,Matriz[4-aux3][aux9]); // elegimos aleatoriamente otro resultado no probado
        
        return fuerzaBrutaSug(Matriz,Secuencia,0,aux2,aux3+1,resultado);   
    }
    
    
    
    
    
    
    
    
    // aux es el tamaño de nuestra matriz,aux2 es el tamaño de su ultima fila,aux 3 tamaño de secuencia
    public ArrayList<Integer>[] fuerzaBruta(int[][] Matriz,int[] Secuencia, int aux,int aux2,int aux3,ArrayList<Integer>...resultado){

        //Si ya buscamos en toda nuestra matriz salimos y retornamos nuestra lista | si se nos acabaron las opciones tambien
        if (aux == -1 || aux3 == -1)
            return resultado;  
        if (aux2 == -1){ // Si no encontramosningun elemento parecido
            aux2 = Matriz[aux-1].length - 1; //Le ponemos la longitud de la anterior fila de la matriz
            return fuerzaBruta(Matriz,Secuencia,aux-1,aux2,aux3,resultado); // Cambiamos a la fila anterior
        }
        if ( Matriz[aux][aux2] == Secuencia[aux3] ){ // Si encontramos en nuestra matriz el ultimo elemento de la secuencia
            resultado[0].add( Matriz[aux][aux2]);    // Agregamos el elemento de la matriz a resultado

            if(aux!=0)
                aux2 = Matriz[aux-1].length - 1;           // Le ponemos la longitud de la anterior fila de la matriz
            return fuerzaBruta(Matriz,Secuencia,aux-1,aux2,aux3-1,resultado); // retornamos decrementando la fila y el indice de la secuencia para buscar el siguiente elemento
        }
        return fuerzaBruta(Matriz,Secuencia,aux,aux2-1,aux3,resultado);
    }
    
        // aux es el tamaño de nuestra matriz,aux2 es el tamaño de su ultima fila,aux 3 tamaño de secuencia
    public ArrayList<Integer>[] fuerzaBruta2(int[][] Matriz,int[] Secuencia, int aux,int aux2,int aux3,ArrayList<Integer>...resultado){
        
        //Si ya buscamos en toda nuestra matriz salimos y retornamos nuestra lista
        if (aux == -1 || aux3 == -1)
            return resultado;   
        if (aux2 == -1){
            aux--;
            if(aux != -1){
                aux2 = (Matriz[aux].length - 1);           // Le ponemos la longitud de la anterior fila de la matriz
            }
            return fuerzaBruta2(Matriz,Secuencia,aux,aux2,aux3-1,resultado);
        }        
        if ( Matriz[aux][aux2] == Secuencia[aux3] ){ // Si encontramos en nuestra matriz el ultimo elemento de la secuencia
            resultado[0].add( Matriz[aux][aux2]);    // Agregamos el elemento de la matriz a resultado

            System.out.print("encontrado\n");
            System.out.print("Aux "+aux+" aux2: "+aux2+"-----sec "+Secuencia[aux3]+" --mat" +Matriz[aux][aux2]+"\n");            
        }        
        return fuerzaBruta2(Matriz,Secuencia,aux,aux2-1,aux3,resultado);// retornamos decrementando la fila y el indice de la secuencia para buscar el siguiente elemento
    }
    
    public ArrayList<Integer>[] AuxFuerzaBruta2(int[][] Matriz,int[] Secuencia){
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        return fuerzaBruta2(Matriz,Secuencia,(Matriz.length-1),(Matriz[Matriz.length-1].length-1),(Secuencia.length-1),auxiliar);
    }
    
    public ArrayList<Integer>[] AuxFuerzaBruta(int[][] Matriz,int[] Secuencia){
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        return fuerzaBruta(Matriz,Secuencia,(Matriz.length-1),(Matriz[Matriz.length-1].length-1),(Secuencia.length-1),auxiliar);
    }
         
    public void Proyecto1(){
        Seleccionar(matriz);//Selecciona de manera random la combinacion ganadora
        Scanner scanner = new Scanner(System.in);//Input para que ingrese el numero de parejas que quiere restringir
        System.out.println("Digite la cantidad de parejas que quiere restringir: ");
        int input = scanner.nextInt();
        Restricciones(input);//Genera las parejas de restricciones
        SuggestSol();//Resuelve el juego
        
        /*
        int[][] Matriz = {{1,2,3,4,5,6},{1,2,3,4,5,6,7,8},{1,2,3,4,5,6},{1,2,3,4,5,6},{1,2,3,4,5,6,7,8,9}};
        int[] Secuencia = {Random(6),Random(8),Random(6),Random(6),Random(9)};       
        //int[] Secuencia = {1,1,1,1,1};       
        //int[] Secuencia = {6,8,6,6,9};       
        /*
        long startTime = System.nanoTime();
        ArrayList<Integer>[] resultado =AuxFuerzaBruta2(Matriz,Secuencia);
        long endTime = System.nanoTime();
        long tiempo = (endTime-startTime);
        System.out.print("\nTiempo Fuerza Bruta 2: " + tiempo + "\n");
        
        startTime = System.nanoTime();
        ArrayList<Integer>[] resultado2 =AuxFuerzaBruta(Matriz,Secuencia);
        endTime = System.nanoTime();
        tiempo = (endTime-startTime);
        System.out.print("\nTiempo Fuerza Bruta 1: " + tiempo + "\n");
        *//*
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

        // Mensaje final
            System.out.print( "\n\nSospechoso: "+sospechoso[salida[0]-1]+"\n"
                             +"Arma: "+arma[salida[1]-1]+"\n"
                             +"Motivo: "+motivo[salida[2]-1]+"\n"
                             +"Parte del cuerpo: "+parte_del_cuerpo[salida[3]-1]+"\n"
                             +"Lugar: "+lugar[salida[4]-1]+"\n");
            */

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
	public void Restricciones(int parejas) {//Escoge las parejas restringidas
		Random rand = new Random();
		int newpareja[][][] = new int[parejas][2][2]; //El primer[] es la cantidad de parejas, el segundo[] es para indicar la fila de la matriz y el dato y la tercera es para la fila en la matriz y el dato de la pareja
		for (int i = 0; i < parejas;i++) {
			int seccion1 = rand.nextInt(5);//Escoge una seccion random osea escoge sospechoso,armas etc
			int seccion2 = rand.nextInt(5);//Escoge otra seccion random osea escoge sospechoso,armas etc
			newpareja[i][0][0] = seccion1;//La ingresa en el campo de fila
			newpareja[i][1][0] = seccion2;//La ingresa en el campo fila de la pareja
			newpareja[i][0][1] = matriz[seccion1][rand.nextInt(matriz[seccion1].length)];//Ingresa el dato restringido 1
			newpareja[i][1][1] = matriz[seccion2][rand.nextInt(matriz[seccion2].length)];//Ingresa el dato restringido 2 apartir de ahora estos dos datos no pueden ir juntos
		}
		restriccion = newpareja;//Ingresa los datos en restriccion
	}
	public boolean isSafe(int clasificacion,int select,int sol[]) {//Se asegura que el dato escogido no sea uno que haya sido descartado
		if (matriz[clasificacion][select] == -1)//Si fue descartado return false
			return false;
		return true;
	}
	public boolean SuggestSol() {//Funcion para solucionar el cluedo
		int Sol[] = {0,0,0,0,0,0};//Array donde se guarda la posible solucion
		if (SuggestUtil(0,Sol) == false) {//Si no existe una combinacion correcta
			System.out.print("No existe solucion\n");
			return false;
		}
		printSolucion(Sol);//Imprimir la solucion en caso de que exista una solucion correcta
		return true;
	}
	public void printSolucion(int[] sol) {//Imprime la solucion
		System.out.print("Solución:   ");
		System.out.print(Sospechosos[sol[0]-1]+"-");
		System.out.print(Armas[sol[1]-1]+"-");
		System.out.print(Motivos[sol[2]-1]+"-");
		System.out.print(ParteCuerpo[sol[3]-1]+"-");
		System.out.print(Lugares[sol[4]-1]+"\n");
	}
	public void Eliminar() {//Elimina una carta incorrecta de manera aleatoria
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
			}
		}
	}
	public boolean SuggestUtil(int i,int sol[]) {//Algoritmo de bactracking para solucionar el cluedo
		if (i > 5) {//Si tiene un posible resultado
			Eliminar();//Elimine una incorrecta y luego imprime sugerencia
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
      
    public static void main(String[] args) {
 
        
        java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Proyecto1 proyecto1 = new Proyecto1();
                        proyecto1.Proyecto1();
                    }
                });
        
    }
    
}

/*
            JOptionPane.showMessageDialog(null, "ERROR"
                    + "\nNo has seleccionado ningun objeto.");
*/

        /*
        // aux es el tamaño de nuestra matriz,aux2 es el tamaño de su ultima fila,aux 3 tamaño de secuencia
    public ArrayList<Integer>[] fuerzaBruta2(int[][] Matriz,int[] Secuencia, int aux,int aux2,int aux3,ArrayList<Integer>...resultado) throws InterruptedException{
         ColorBot(aux,aux2,2);  
        //Si ya buscamos en toda nuestra matriz salimos y retornamos nuestra lista
        if (aux == -1 || aux3 == -1)
            return resultado;   
        if (aux2 == -1){
            aux--;
            if(aux != -1){
                aux2 = (Matriz[aux].length - 1);           // Le ponemos la longitud de la anterior fila de la matriz
            }
            return fuerzaBruta2(Matriz,Secuencia,aux,aux2,aux3-1,resultado);
        }        
        if ( Matriz[aux][aux2] == Secuencia[aux3] ){ // Si encontramos en nuestra matriz el ultimo elemento de la secuencia
            resultado[0].add( Matriz[aux][aux2]);    // Agregamos el elemento de la matriz a resultado
            ColorBot(aux,aux2,1);           
            return fuerzaBruta2(Matriz,Secuencia,aux,aux2-1,aux3,resultado);// retornamos decrementando la fila y el indice de la secuencia para buscar el siguiente elemento
        }else{
            ColorBot(aux,aux2,3);  
            return fuerzaBruta2(Matriz,Secuencia,aux,aux2-1,aux3,resultado);// retornamos decrementando la fila y el indice de la secuencia para buscar el siguiente elemento
        }
    }
    
    public ArrayList<Integer>[] AuxFuerzaBruta2(int[][] Matriz,int[] Secuencia) throws InterruptedException{
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        return fuerzaBruta2(Matriz,Secuencia,(Matriz.length-1),(Matriz[Matriz.length-1].length-1),(Secuencia.length-1),auxiliar);
    }
    
        // aux es el tamaño de nuestra matriz,aux2 es el tamaño de su ultima fila,aux 3 tamaño de secuencia
    public ArrayList<Integer>[] fuerzaBruta(int[][] Matriz,int[] Secuencia, int aux,int aux2,int aux3,ArrayList<Integer>...resultado) throws InterruptedException{
        ColorBot(aux,aux2,2); 
        //Si ya buscamos en toda nuestra matriz salimos y retornamos nuestra lista | si se nos acabaron las opciones tambien
        if (aux == -1 || aux3 == -1)
            return resultado;  
        if (aux2 == -1){ // Si no encontramosningun elemento parecido
            aux2 = Matriz[aux-1].length - 1; //Le ponemos la longitud de la anterior fila de la matriz
            return fuerzaBruta(Matriz,Secuencia,aux-1,aux2,aux3,resultado); // Cambiamos a la fila anterior
        }
        if ( Matriz[aux][aux2] == Secuencia[aux3] ){ // Si encontramos en nuestra matriz el ultimo elemento de la secuencia
            resultado[0].add( Matriz[aux][aux2]);    // Agregamos el elemento de la matriz a resultado
            ColorBot(aux,aux2,1); 
            if(aux!=0)
                aux2 = Matriz[aux-1].length - 1;           // Le ponemos la longitud de la anterior fila de la matriz
            
            return fuerzaBruta(Matriz,Secuencia,aux-1,aux2,aux3-1,resultado); // retornamos decrementando la fila y el indice de la secuencia para buscar el siguiente elemento
        }else{
            ColorBot(aux,aux2,3); 
            return fuerzaBruta(Matriz,Secuencia,aux,aux2-1,aux3,resultado);
        }
    }
    
    public ArrayList<Integer>[] AuxFuerzaBruta(int[][] Matriz,int[] Secuencia) throws InterruptedException{
        ArrayList<Integer> auxiliar = new ArrayList<Integer>();
        return fuerzaBruta(Matriz,Secuencia,(Matriz.length-1),(Matriz[Matriz.length-1].length-1),(Secuencia.length-1),auxiliar);
    } 
    */