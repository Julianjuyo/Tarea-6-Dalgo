package Parte1;

import java.util.*;


public class Dijsktra {
	

    /**
     * 
     * @author julianoliveros
     *
     */
     class Vertice implements Comparator<Vertice> {
    	
    	private int ID;
    	private Integer rutaMasCorta;
    	private Vertice verticePredecesor;
    	
    	
    	public  Vertice() {
    		this.setID(0);
    		this.rutaMasCorta = 0;
    		this.verticePredecesor = null;
    		
		}
    	
		public int getRutaMasCorta() {
			return rutaMasCorta;
		}
		public void setRutaMasCorta(int rutaMasCorta) {
			this.rutaMasCorta = rutaMasCorta;
		}

		public Vertice getVerticePredecesor() {
			return verticePredecesor;
		}
		public void setVerticePredecesor(Vertice verticePredecesor) {
			this.verticePredecesor = verticePredecesor;
		}
		private int getID() {
			return ID;
		}
		
		private void setID(int iD) {
			ID = iD;
		}

		
		@Override
		public int compare(Vertice node1, Vertice node2) 
	    { 
	        if (node1.rutaMasCorta < node2.rutaMasCorta) 
	            return -1; 
	        if (node1.rutaMasCorta > node2.rutaMasCorta) 
	            return 1; 
	        return 0; 
	    }

    	
    	
    }




    private ArrayList<Vertice> grafo ;
    private PriorityQueue<Vertice> minPQ;
    private Set<Integer> S; 

        
    /**
     * 
     */
    public Dijsktra() {
    	setGrafo(new ArrayList<Vertice>());
    	S = new HashSet<Integer>();
    	
    }
    
    
    

    public ArrayList<Vertice>  DijkstraAlgoritmo(int[][] matrizDeAdj, int verticeInicial)
    {
    	
    	System.out.println("Entro al algoritmo" );
    	
    	int numVertices = matrizDeAdj.length;
    	//System.out.println("num vertices"+ numVertices );
    	
    	crearEInicializarGrafo(numVertices, verticeInicial);
    	
    	minPQ = new PriorityQueue<Vertice>(numVertices, new Vertice());
    	
    	minPQ.add(grafo.get(verticeInicial));
    	//System.out.println("vertice que entra "+ minPQ.contains(grafo.get(verticeInicial)) );
    	
    	
    	while (S.size() != numVertices){
    		
    		Vertice uVertice = minPQ.remove();
    		int uID = uVertice.ID;
    		
    		//System.out.println("vertice que sale de la cola"+ uID );
    		
    		S.add(uID);
    		
    		
    		for (int i = 0; i < matrizDeAdj[uID].length ; i++) { 

    			int pesoEje = matrizDeAdj[i][uID];
    			
    			Vertice vVertice = grafo.get(i);
    			int pesoActualDeV = vVertice.getRutaMasCorta();
    			
    			//System.out.println("\n"+"U VERTICE"+ uVertice.ID );
    			//System.out.println("V VERTICE"+ vVertice.ID );
    			//System.out.println("PESO"+ pesoActualDeV );
    			
    			if(pesoEje>0 && !S.contains(vVertice.ID)){
    				
    				//System.out.println("ENTRO AL IF: "+pesoEje + !S.contains(vVertice.ID) );
    				Relax(uVertice, vVertice, pesoEje);
    				
    				minPQ.add(vVertice);
    			}	
    		}		
    	}
    	return grafo;
    }
    
    
	public void Imprimir(ArrayList<Vertice> path_array,int num_Vertices , int ini)   { 
		System.out.println("Vertice# \t Distancia minima desde el vertice origen: "+ini); 
		for (int i = 0; i < num_Vertices; i++) 
			System.out.println(i + " \t\t\t " + path_array.get(i).getRutaMasCorta()); 
	}
	
    
    
    /**
     * 
     * @param numeroVertices
     * @param verticeInicial
     * @return
     */
    public void crearEInicializarGrafo(int numeroVertices, int verticeInicial) {
    	
		int infinito = Integer.MAX_VALUE;
		
		//System.out.println("Entro a Inicializar");
		
		for (int i = 0; i < numeroVertices; i++) {
			
			
			Vertice actual = new Vertice();

			actual.setID(i);
			//System.out.println(actual.getID());
			
			actual.setRutaMasCorta(infinito);
			//System.out.println(actual.getRutaMasCorta());
			
			actual.setVerticePredecesor(null);
			//System.out.println(actual.getVerticePredecesor());
					
			getGrafo().add(actual);
			
		}
		getGrafo().get(verticeInicial).setRutaMasCorta(0);
		//System.out.println("inicial "+getGrafo().get(verticeInicial).getID() );

    }
    
   
    
    /**
     * 
     * @param inicial
     * @param vfinal
     * @param peso
     */
    public void Relax(Vertice inicial, Vertice vfinal , int peso) {
    	
    	if(vfinal.getRutaMasCorta() > inicial.getRutaMasCorta() + peso ) {
    		
    		//System.out.println("\n"+"ruta actual"+ vfinal.getRutaMasCorta());
    		//System.out.println("nueva ruta "+ (inicial.getRutaMasCorta() + peso));
    		
    		vfinal.setRutaMasCorta(inicial.getRutaMasCorta() + peso);
    		vfinal.setVerticePredecesor(inicial);
    		
    	}
    }
    
    

    /**
     * 
     * @return
     */
	public ArrayList<Vertice> getGrafo() {
		return grafo;
	}

	/**
	 * 
	 * @param grafo
	 */
	public void setGrafo(ArrayList<Vertice> grafo) {
		this.grafo = grafo;
	}
    
    

}
