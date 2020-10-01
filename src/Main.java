import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {




	public static void main(String[] args) {
		
		String entrada = args[0];
		String alg = args[1];
		
		List<Edge> edges;
		//O arquivo deve conter as arestas em csv onde cada linha do cs representa: source,weigth,target
		edges = readCsvFile(entrada);
		
		

		Graph graph = new Graph(edges, alg);
		List<Edge> mst= graph.Kruskal();
		for(Edge e : mst) {
			System.out.println(e.v+" ,"+e.peso+","+e.w);			
		}

	}
	
	
	public static List<Edge> readCsvFile(String path){
		String Str;
		List<Edge> tableLine = new ArrayList<Edge>();


		//A estrutura try-catch é usada pois o objeto BufferedWriter exige que as
		//excessões sejam tratadas
		try {

		//Criação de um buffer para a ler de uma stream
		BufferedReader StrR = new BufferedReader(new FileReader(path));

	
		//Essa estrutura do looping while é clássica para ler cada linha
		//do arquivo 
		while((Str = StrR.readLine())!= null){
		//Aqui usamos o método split que divide a linha lida em um array de String
		//passando como parametro o divisor ";".
		String[] row = Str.split(",");

		
		tableLine.add(new Edge(Integer.parseInt(row[0]),Integer.parseInt(row[1]),Integer.parseInt(row[2])));
		


		}
		StrR.close();
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException ex){
		ex.printStackTrace();
		}
		return tableLine;

		}

}
