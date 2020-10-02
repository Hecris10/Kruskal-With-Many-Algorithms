import java.util.ArrayList;
import java.util.List;

public class Graph {
	List<Vertex> V;
	List<Edge> E = new ArrayList<Edge>();
	String alg;
	//public Graph(List<Edge> edges, String alg) {
	public Graph(List<Edge> edges) {
		this.E = edges;			
		
	}
	
	// use E.set(5,(edge)) para adicionar no quinto espaço do vetor
	// use E.get(5) para saber o valor do quinto espaço do vetor
	public List<Edge> ordenate(List<Edge> arestas){
		/*Collections.shuffle(arestas);
		while(!isSorted(arestas)) {
			Collections.shuffle(arestas);			
		} */
		Sort ordenar = new Sort(arestas);
		/*if(this.alg=="HeapSort"){
			ordenar.HeapSort();
			return arestas;
		}else if(this.alg=="InsertSort"){
			arestas = ordenar.InsertionSort();
			return arestas;
		}else if(this.alg=="MergeSort"){
			ordenar.MergeSort(arestas, 0, arestas.size()-1);
			return arestas;
		}else if(this.alg=="QuickSort"){
			ordenar.QuickSort(arestas, 0, arestas.size()-1);
			return arestas;
		}else if(this.alg=="ShellSort"){
			arestas = ordenar.ShellSort();
			return arestas;
		} */

		ordenar.MergeSort(arestas, 0, arestas.size()-1);
		
		return arestas;
	}
	
	public boolean isSorted(List<Edge> lista) {	
		
		for(int i = 0; i < lista.size()-1; i++ ) {
			if(lista.get(i).peso>lista.get(i+1).peso) {
				return false;				
			}		
		}	
		return true;	
		
	}
	
	public List<Edge> Kruskal(){
		List<List<Integer>> floresta = createFloresta();
		List<Edge> mst = new ArrayList<Edge>(); 
		List<Edge> arestas = this.ordenate(this.E);	
		
		
		while(!arestas.isEmpty()) {
			Edge aux = arestas.remove(0);
			
			
				List<Integer> tree1 = getTree(aux.v,floresta);
				List<Integer> tree2 = getTree(aux.w,floresta);
				if(tree1 != tree2) {
					floresta = removeTreeByVertex(aux.v,floresta);
					floresta = removeTreeByVertex(aux.w,floresta);
				
					tree1.addAll(tree2);
				
					floresta.add(tree1);
					mst.add(aux);
				}
				
			
			
		}
		
		return mst;
	}
	
	public  List<List<Integer>> removeTreeByVertex(int vertex, List<List<Integer>> floresta){
		List<Integer> removed;
		removed = getTree(vertex,floresta);
		floresta.remove(floresta.indexOf(removed));
		return floresta;		
	}
	
	
	public boolean isConector(Edge aresta,List<List<Integer>> floresta) {
		List<Integer> source = getTree(aresta.v,floresta);
		List<Integer> target = getTree(aresta.w,floresta);
		if(source != target ) {
			if(isInTree(aresta.w,source) && isInTree(aresta.v,target)) {
				return true;
				}			
		}
		
		return false;
	}
	public boolean isInTree(int vertice, List<Integer> tree) {
		if(tree.contains(vertice)){
			return true;
			}		
		return false;
	}
	
	public List<Integer> getTree(int vertice,  List<List<Integer>> floresta){		
		for(List<Integer> row:floresta) {
			if(row.contains(vertice)) {
				return row;				
			}			
		}		
		return null;		
	}
	

	
	public List<List<Integer>> createFloresta(){
		List<List<Integer>> floresta = new ArrayList<List<Integer>>();		
		for(Edge e : this.E ) {
			List<Integer> aux1 = new ArrayList<Integer>();
			List<Integer> aux2 = new ArrayList<Integer>();
			aux1.add(e.v);
			aux2.add(e.w);
			if(!floresta.contains(aux1))
				floresta.add(aux1);	
			if(!floresta.contains(aux2))
				floresta.add(aux2);
		}
		
		return floresta;
	}
	
	

}
