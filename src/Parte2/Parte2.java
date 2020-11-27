package Parte2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Parte2 {
	/**
	 * @author Camilo Rozo
	 */
	public static void main(String[] args) {
		String  path = args[0]; // ruta al archivo ingresa por argumentos del programa.
		int[][] matrizAdyacencia = null;
		try {
			matrizAdyacencia = cargarMatriz(path);
		}
		catch(FileNotFoundException e) {System.out.println("archivo "+args[0]+" no encontrado");} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(matrizAdyacencia!=null) {
			LinkedList<Integer>[] componentes = hallarComponentesConectados(matrizAdyacencia);
			System.out.println("Los componentes conectados son:");
			int i = 0;
			for(LinkedList<Integer>j:componentes)
			{

				System.out.println("Componente Conectado #"+i);
				for(int k:j)
				{
					System.out.append("\t"+k);
				}
				System.out.append("\n");
			i++;
			}
		}	
		else {
			System.out.println("No se cargó la matriz correctamente");}
	}


	private static int[][] cargarMatriz(String path) throws IOException,FileNotFoundException {


		BufferedReader br = new BufferedReader(new FileReader(path));
		br.mark(1000000); //el tamaño máximo de la matriz es de 500000
		int i = br.readLine().split("\t").length;//sacar el tamaño a partir de la primera línea
		br.reset(); // reiniciar el reader para cargar la matriz completa
		String linea;
		int[][] matriz = new int[i][i];
		for(int j=0;(linea = br.readLine())!=null;j++) //el índice j es necesario para cargar la matriz
		{
			String[] values = linea.split("\t");
			for(int k=0;k<j;k++) //basta con leer la diagonal inferior de la matriz porque es simétrica -> a[i][j] = a[j][i]
			{
				matriz[j][k]=Integer.parseInt(values[k]);
				matriz[k][j]=matriz[j][k];
			}
		}
		br.close();

		return matriz;
	}

	private static LinkedList<Integer>[] hallarComponentesConectados(int[][] matrizAdyacencia) {
		int[] id_componenteConectado=new int[matrizAdyacencia.length];
		boolean[] marcados = new boolean[matrizAdyacencia.length];
		Queue<Integer> colaBFS = new ConcurrentLinkedQueue<>();
		colaBFS.add(0);
		for(int id=0;id<matrizAdyacencia.length;id++)// para cada componente conectado de id == id
		{					

			if(!marcados[id]) //no he pasado por ahí todavía
			{
				marcados[id]=true; //ya pasé por aquí
				colaBFS.add(id);
				while(!colaBFS.isEmpty()) //mientras tenga vertices pendientes dentro de mi componente conectado
				{
					int actual = colaBFS.poll(); 
					id_componenteConectado[actual]=id; //pertenezco al componente conectado actual
					for(int w =0;w<matrizAdyacencia.length;w++) //cada uno de mis adyacentes
					{
						if ( w == actual || matrizAdyacencia[actual][w]==-1) continue; //si soy yo o no hay camino entre id y w, no hago nada
						else if(!marcados[w]) //si si hay camino y no he pasado por ahí
						{
							marcados[w] = true; //ya pasé por aquí
							colaBFS.add(w); //agregar adyacente a la cola

						}

					}

				}

			}
			//terminé el componente conectado actual
		}

		//Esta parte se encarga de organizar los vértices por su componente conectado

		int a = 0; //cantidad de componentes conectados
		for(int i:id_componenteConectado)//hallar número de componentes conectados diferentes
		{
			if(i>a)
			{
				a=i;
			}
		}
		LinkedList<Integer>[] componentesConectados= new LinkedList[a+1];
		for(int i =0;i<id_componenteConectado.length ;i++) 
		{
			if(componentesConectados[id_componenteConectado[i]] !=null)
			{
				componentesConectados[id_componenteConectado[i]].add(i);
			}
			else
			{
				componentesConectados[id_componenteConectado[i]] = new LinkedList<Integer>();
				componentesConectados[id_componenteConectado[i]].add(i);
			}
		}
		
		return componentesConectados;
	}
}
