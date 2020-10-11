import java.util.List;


public class Sort {
    List<Edge> colecao;
    public Sort(final List<Edge> colecao) {
        this.colecao = colecao;
    }

    public List<Edge> InsertionSort() {
        final List<Edge> colecao = this.colecao;
        final int n = colecao.size();
        for (int i = 1; i < n; ++i) {
            final Edge key = colecao.get(i);
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are greater than key, to one position
             * ahead of their current position
             */
            while (j >= 0 && colecao.get(j).peso > key.peso) {
                colecao.set(j + 1, colecao.get(j));
                j = j - 1;
            }
            colecao.set(j + 1, key);
        }
        return colecao;
    }

    public void QuickSort(final List<Edge> vetor, final int inicio, final int fim) {
        if (inicio < fim) {
            int posicaoPivo = this.Quick_Particionar(vetor, inicio, fim);
            this.QuickSort(vetor, inicio, posicaoPivo - 1);
            this.QuickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private int Quick_Particionar(List<Edge> vetor, int inicio, int fim) {

        Edge pivo = vetor.get(fim);
        int i = (inicio-1); // pegar o indice do menor elemento
        
        for(int j=inicio; j<fim; j++){
            if(vetor.get(j).peso<pivo.peso){
                i++;

                Edge temp = vetor.get(i);
                vetor.set(i, vetor.get(j));
                vetor.set(j, temp);

            }
        }

        Edge temp = vetor.get(i+1);
        vetor.set(i+1, vetor.get(fim));
        vetor.set(fim, temp);


        return i+1;
    }

    private void Merge(final List<Edge> Colecao, final int l, final int m, final int r) {
        // misturar dois subconjuntos de colecao
        // o primeiro vai de colecao[l..m]
        // o segundo vai de colecao[m+1..r]

        int n1 = m - l + 1; // vamos pegar os tamnhos dos dois subconjuntos
        int n2 = r - m; // e colocar em n1 e n2

        // criar vetores temporários
        Edge L[] = new Edge[n1]; // criar listas temporárias pra armazenar
        Edge R[] = new Edge[n2]; //os vetores do lado esquerdo e direito
                
        for (int i = 0; i<n1;++i)
            L[i] = colecao.get(l+i);
        for (int j = 0; j<n2; ++j)
            R[j] = colecao.get(m+1+j);
        
        //****juntar as listas temporarias****

            //Indices iniciais da primeira e segunda lista
        int i=0, j=0;

            //juntar os primeiros arrays enquanto o indice permanecer igual

        int k =l;
        while(i<n1 && j<n2){
            if(L[i].peso <= R[j].peso){
                colecao.set(k, L[i]);
                i++;    
            }else{
                colecao.set(k, R[j]);
                j++;
            }
            k++;
        }

        //copiar os elementos restantes de L
        while(i< n1){
            colecao.set(k,L[i]);
            i++;
            k++;
        }
        while(j<n2){
            colecao.set(k, R[j]);
            j++;
            k++;
        }
    }
    public void MergeSort(List<Edge> colecao, int l, int r){
        if(l<r){
            //achar o meio da lista
            int m = (l+r)/2;
            //ordenar as duas partes a serem dividias
            this.MergeSort(colecao, l, m);
            this.MergeSort(colecao, m+1, r);

            //unir as partes ordenando-as
            this.Merge(colecao, l, m, r);

        }
    }

    public void HeapSort(){
        int n = this.colecao.size();

        //construir o heap e organizar a colecao
        for(int i =n/2-1;i>=0; i--){
            this.HeapMax(this.colecao, n, i);
        }

        //extrair cade elemento do heap
        for (int i = n-1; i>0; i--){
            
            //mover a raiz atual para o fim
            Edge temp = this.colecao.get(0);
            colecao.set(0, this.colecao.get(i));
            colecao.set(i, temp);

            //chamar o max heap no heap reduzido
            this.HeapMax(this.colecao, i, 0);
        }

    }

    private void HeapMax(List<Edge> colecao, int n, int i){
        int maior = i; //maior como raiz
        int l = 2*i +1; // lado esquerdo
        int r = 2*i +2; //lado direito

        //checar se o filho a esquerda eh menor
        if (l<n && (colecao.get(l).peso > colecao.get(maior).peso)){
            maior = l;
        }

        if (r<n && (colecao.get(r).peso > colecao.get(maior).peso)){
            maior = r;
        }

        //se o maior nao for a raiz
        if (maior !=i){
            Edge troca = colecao.get(i);
            colecao.set(i,colecao.get(maior));
            colecao.set(maior, troca);

            //inicia a recursividade do heapfy as sub-arvores afetadas
            this.HeapMax(colecao, n, maior);
        }
    }

    public List<Edge> ShellSort(){
        int n = this.colecao.size();

        for(int gap = n/2; gap>0; gap/=2){
            //executar o insertion sort dentro do gap

            for(int i = gap; i<n; i+=1){
                
                Edge temp = this.colecao.get(i);

                int j;
                for (j=i;(j>=gap) && (this.colecao.get(j-gap).peso>temp.peso);j -=gap)
                    this.colecao.set(j, this.colecao.get(j-gap));
                
                this.colecao.set(j, temp);
            }
        }
        return colecao;
    }

    public void QuickSort_parcial(final List<Edge> vetor, final int inicio, final int fim, int L) {
        if (inicio < fim) {
            int posicaoPivo = this.Quick_Particiona_Parcial(vetor, inicio, fim, L);
            this.QuickSort_parcial(vetor, inicio, posicaoPivo - 1, L);
            this.QuickSort_parcial(vetor, posicaoPivo + 1, fim, L);
        }
    }

    private int Quick_Particiona_Parcial(List<Edge> vetor, int inicio, int fim, int L) {

        if(vetor.size()<=L){
            int valor = (inicio-1);

            for (int i = 1; i < fim; ++i) {
                final Edge key = colecao.get(i);
                int j = i - 1;
    
                /*
                 * Move elements of arr[0..i-1], that are greater than key, to one position
                 * ahead of their current position
                 */
                while (j >= 0 && colecao.get(j).peso > key.peso) {
                    colecao.set(j + 1, colecao.get(j));
                    j = j - 1;
                }
                colecao.set(j + 1, key);
                valor++;
            }
            return valor+1;
        }
        Edge pivo = vetor.get(fim);
        int i = (inicio-1); // pegar o indice do menor elemento
        
        for(int j=inicio; j<fim; j++){
            if(vetor.get(j).peso<pivo.peso){
                i++;

                Edge temp = vetor.get(i);
                vetor.set(i, vetor.get(j));
                vetor.set(j, temp);

            }
        }

        Edge temp = vetor.get(i+1);
        vetor.set(i+1, vetor.get(fim));
        vetor.set(fim, temp);


        return i+1;
    }

    public void QuickSort_final(final List<Edge> vetor, final int inicio, final int fim, int L) {
        if (inicio < fim) {
            int posicaoPivo = this.Quick_Particiona_final(vetor, inicio, fim, L);
            this.QuickSort_final(vetor, inicio, posicaoPivo - 1, L);
            this.QuickSort_final(vetor, posicaoPivo + 1, fim, L);
        }
    }

    private int Quick_Particiona_final(List<Edge> vetor, int inicio, int fim, int L) {

        if(vetor.size()>L){
            int valor = (inicio-1);

            for (int i = 1; i < fim; ++i) {
                final Edge key = colecao.get(i);
                int j = i - 1;
    
                /*
                 * Move elements of arr[0..i-1], that are greater than key, to one position
                 * ahead of their current position
                 */
                while (j >= 0 && colecao.get(j).peso > key.peso) {
                    colecao.set(j + 1, colecao.get(j));
                    j = j - 1;
                }
                colecao.set(j + 1, key);
                valor++;
            }
            return valor+1;
            
        }
        return inicio-1;
       
        
    }


}
