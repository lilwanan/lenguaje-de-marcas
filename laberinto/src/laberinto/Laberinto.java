package laberinto;

import java.util.ArrayList;
import java.util.Random;


public class Laberinto {
	
	 private int dimensionX;
	 private int dimensionY;
	 private char[][] matriz;
	    private int prb;
	    private int iniX;
	    private int iniY;
	    private int objX;
	    private int objY;
	    private boolean solucionable;


	    public Laberinto (int dimensionX, int dimensionY,int prb) {
	        this.dimensionX = dimensionX;
	        this.dimensionY = dimensionY;
	        this.prb=prb;
	        this.matriz = new char [dimensionX] [dimensionY];


	    }

	    public void generarLaberinto(int semilla) {
	        Random random=new Random(semilla);
	        iniX = random.nextInt(this.dimensionX);
	        iniY = random.nextInt(this.dimensionY);
	        objX = random.nextInt(this.dimensionX);
	        objY = random.nextInt(this.dimensionY);

	        matriz[iniX][iniY]= 'I';
            matriz[objX][objY]= 'G';
	        for (int i=0;i<dimensionX;i++){
	            for(int j=0;j<dimensionY;j++){

	            	
	            	if(!(i == iniX && j == iniY||i == objX && j == objY))
	            	{
	                if (random.nextInt(100) <= prb) {
	                    matriz[i][j] = '▉';
	                } else {
	                    matriz[i][j] = ' ';
	                }
	            }
	            }
	        }
	    }
	        
	        public void mostrarLaberinto() {
	        	int tempX = 0;
	        	int tempY = 0;
	        	while(tempY < this.dimensionY) {
	        		System.out.print(this.matriz[tempX][tempY]);
	        		
	        		if(tempX == this.dimensionX-1)
	        		{
	        			System.out.println();
	        			tempX = 0;
	        			tempY++;
	        		}
	        		else
	        			tempX++;
	        	}
	        }

	        public void pintarSolucion(ArrayList<Nodo> solucion)
	        {
	   
	        	int tempX = 0;
	        	int tempY = 0;
	        	
	        	if(this.solucionable== true)
	        	while(tempY < this.dimensionY) {
	        		if((tempX == objX && tempY == objY)||(tempX == iniX && tempY == iniY))
	        			System.out.print(this.matriz[tempX][tempY]);
	        		else if(esParte(tempX, tempY, solucion))
	        			System.out.print("+");
	        		else
		        		System.out.print(this.matriz[tempX][tempY]);

	        		
	        			if(tempX == this.dimensionX-1)
	        			{
	        				System.out.println();
	        				tempX = 0;
	        				tempY++;
	        			}
	        			else
	        				tempX++;
	        		}
	        	else
	        	{
	        		this.mostrarLaberinto();
	        		System.out.println("No existe solución");
	        	}
	        	
	        }
	        
	        //implementación Algoritmo
	        
	        public int distManhattan(Nodo n1)
	        {
	            int distancia = Math.abs(n1.cordX - this.objX) + Math.abs(n1.cordY - this.objY);
	            return distancia;
	        }
	        
	        public int distEuclidea(Nodo n1)
	        {
	            int distancia = (int)Math.sqrt(Math.pow(n1.cordX - this.objX, 2) + Math.pow(n1.cordY - this.objY,2));
	            return distancia;
	        }
	        
	        public int h(Nodo n)
	        {
	            return distEuclidea(n);
	        }
	        
	        public int g(Nodo n)
	        {
	        	return n.costeG;
	        }
	        
	        public boolean esParte(int cordX, int cordY, ArrayList<Nodo> listaNodos) {
	            int size = listaNodos.size();
	            for(int i = 0; i < size; i++) {
	                Nodo n = listaNodos.get(i);
	                if(n.cordX == cordX && n.cordY == cordY) {
	                    return true;
	                }
	            }
	            return false;
	        }
 
	        public ArrayList<Nodo> resolverSolucion() {
	            // Creamos el nodo inicial y lo añadimos a la lista abierta
	            Nodo inicial = new Nodo(this.iniX, this.iniY, null);
	            inicial.costeG = 0;
	            ArrayList<Nodo> abierta = new ArrayList<>();
	            abierta.add(inicial);

	            // Creamos la lista cerrada
	            ArrayList<Nodo> cerrada = new ArrayList<>();

	            // Mientras haya nodos en la lista abierta
	            while (!abierta.isEmpty()) {
	                // Obtenemos el nodo con menor valor de f(n) de la lista abierta
	            	
	                Nodo actual = abierta.get(0);
	                //System.out.printf("comprobando (%d, %d), padre (%s)\n",actual.cordX,actual.cordY, actual.padre!=null?actual.padre.toString():"null");
	                for (Nodo n : abierta) {
	                    if (n.costeG + h(n) < actual.costeG + h(actual)) {
	                        actual = n;
	                    }
	                }

	                // Si el nodo actual es el objetivo, hemos encontrado la solución
	                if (actual.cordX == this.objX && actual.cordY == this.objY) {
	                    ArrayList<Nodo> solucion = new ArrayList<>();
	                    int i = 0;
	                    while (actual != null) {
	                        solucion.add(i++, actual);
	                        actual = actual.padre;
	                    }
	                    this.solucionable = true;
	                    return solucion;
	                }

	                // Movemos el nodo actual de la lista abierta a la cerrada
	                abierta.remove(actual);
	                cerrada.add(actual);

	                // Generamos los sucesores del nodo actual
	                for (int i = -1; i <= 1; i++) {
	                    for (int j = -1; j <= 1; j++) {
	                        if (i == j || i == -j) {
	                            continue;
	                        }
	                        int x = actual.cordX + i;
	                        int y = actual.cordY + j;
	                        if (x < 0 || x >= this.dimensionX || y < 0 || y >= this.dimensionY) {
	                            continue;
	                        }
	                        Nodo sucesor = new Nodo(x, y, actual);
	                        sucesor.costeG = actual.costeG + 1;
	                        if (this.matriz[x][y] == '▉') {
	                        	cerrada.add(sucesor);
	                            continue;
	                        }
	                        if (this.esParte(sucesor.cordX, sucesor.cordY, cerrada)) {
	                            continue;
	                        }
	                        if (!this.esParte(sucesor.cordX, sucesor.cordY, abierta) && !this.esParte(sucesor.cordX, sucesor.cordY, cerrada)) {
	                            abierta.add(sucesor);
	                        }
	                    }
	                }
	            }

	            // No se ha encontrado solución
	            this.solucionable = false;
	            return new ArrayList<>();
	        }

	        
	        

	    }





