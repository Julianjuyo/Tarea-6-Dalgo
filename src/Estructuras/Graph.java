package Estructuras;

import java.util.ArrayList;

public class Graph {
	

    /**
     * 
     * @author julianoliveros
     *
     */
    static class Vertice{
    	
    	private Integer rutaMasCorta;
    	private boolean marcado;
    	private Vertice verticePredecesor;
    	
    	
    	public  Vertice() {
    		rutaMasCorta = 0;
    		verticePredecesor = null;
    		marcado = false;
		}
    	
		public int getRutaMasCorta() {
			return rutaMasCorta;
		}
		public void setRutaMasCorta(int rutaMasCorta) {
			this.rutaMasCorta = rutaMasCorta;
		}
		public boolean isMarcado() {
			return marcado;
		}
		public void setMarcado(boolean marcado) {
			this.marcado = marcado;
		}
		public Vertice getVerticePredecesor() {
			return verticePredecesor;
		}
		public void setVerticePredecesor(Vertice verticePredecesor) {
			this.verticePredecesor = verticePredecesor;
		}
    	
    	
    }


    private ArrayList<Vertice> grafo ;
    
    
    /**
     * 
     */
    public Graph() {
    	setGrafo(new ArrayList<Vertice>());	
    }
    
    
    /**
     * 
     * @param numeroVertices
     * @param verticeInicial
     * @return
     */
    public ArrayList<Vertice> crearEInicializarGrafo(int numeroVertices, int verticeInicial) {
    	
		int infinito = Integer.MAX_VALUE;
		
		System.out.println("Entro a el grafo");
		
		for (int i = 0; i < numeroVertices; i++) {
			
			
			Vertice actual = new Vertice();
			

			actual.setRutaMasCorta(infinito);
			//System.out.println(actual.getRutaMasCorta());
			
			actual.setMarcado(false);
			
			actual.setVerticePredecesor(null);
			//System.out.println(actual.getVerticePredecesor());
					
			getGrafo().add(actual);
			
		}
		getGrafo().get(verticeInicial).setRutaMasCorta(0);
		
		return getGrafo();
    }

    
    /**
     * 
     * @param inicial
     * @param vfinal
     * @param peso
     */
    public void Relax(Vertice inicial, Vertice vfinal , int peso) {
    	
    	if(vfinal.getRutaMasCorta() > inicial.getRutaMasCorta() + peso ) {
    		
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
