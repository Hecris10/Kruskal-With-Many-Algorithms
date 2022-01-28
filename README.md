## KRUSKAL

THIS FILES CONTAIN THE KRUSKAL BUT YOU CAN CHOOSE THE SORT ALGOTITHM

## Folder Structure

The workspace contains One folder by default, where:

- `src`: the folder to maintain sources

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).


## Instructions
 ### How to run
 In order to execute you should use the following input on Windows CMD:
    CALL THE ALGORITHM + URL TO THE EDGES FILE + SORT ALGORITHM.
    In order to insert the Sort Algorithms your should use the follownig input on the "SORT ALGOTITH".
  
        •	Insertion Sort: InsertSort
        •	Quick Sort: QuickSort
        •	Merge Sort: MergeSort
        •	Shell Sort: ShellSort
        •	Heap Sort: HeapSort
        •	Quick Sort Partial: QuickSort_Parcial 
        •	Quick Sort Final: QuickSort_Final

    For Quick Sort Partial and Final you should add the value for L at the end of the command line.

	  Follows bellow and exemple of the calling using Shell Sort:
    java Main C:\\Users\\Pc\\Docs\\10_vertices.csc ShellSort
    
    Quick Sort:
      C:\\Users\\Pc\\Docs\\10_vertices.csc QuickSort_Final 4
	
   ### About the Input of Edges
        
        This application was implemented to get CSV files with the following standard of edges in each file lines:
          Vertex of Origin, Weight, Vertex of Destination

 ### How to implement your own Sort Algorithms
        
        Go to src/Sort.java and add a Public Method the returns a sorted collection.
        Then add your Method on src/Graph.java on Ordenate Method.
        


@HECRIS 10 - UNIVERSIDADE FEDERAL DO MARANHÃO
