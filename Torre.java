/*
  Classe Torre
  
  Responsável por representar uma torre do jogo.
  Implementa uma estrutura de dados do tipo Pilha utilizando vetor.
  
  Funções principais:
 * - Empilhar discos (push)
 * - Desempilhar discos (pop)
 * - Verificar o disco do topo
 * - Verificar se a torre está vazia
  
  Regras:
 * - Apenas o disco do topo pode ser removido
 * - Não permite colocar disco maior sobre menor
 */


public class Torre {

    private int topoTorre;
    private Disco e[];
    private int tam;

    public Torre(int tam) {
        this.tam = tam;
        this.e = new Disco[tam];
        this.topoTorre = -1;
    }

    public boolean isEmpty() {
        if (this.topoTorre == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (this.topoTorre == this.tam - 1)
            return true;
        else
            return false;
    }

    public boolean push(Disco d) {
        if (!this.isFull()) {
            if (!this.isEmpty() && d.getSize() > this.e[this.topoTorre].getSize())
                return false;
            this.e[++this.topoTorre] = d;
            return true;
        } else
            return false;
    }

    public Disco pop() {
        if (!this.isEmpty())
            return this.e[this.topoTorre--];
        else
            return null;
    }

    public Disco topo() {
        if (!this.isEmpty())
            return this.e[this.topoTorre];
        else
            return null;
    }

    public int sizeElements() {
        return this.topoTorre + 1;
    }
    public int[] getDiscos() {
     int tamanho = sizeElements();
     int[] discos = new int[tamanho];

     Torre auxiliar = new Torre(this.tam);

     int i = tamanho - 1;

        // esvazia a pilha original
     while (!this.isEmpty()) {
        Disco d = this.pop();
        discos[i--] = d.getSize();
        auxiliar.push(d); // copia para uma torre auxiliar
    }

    // Restaura a pilha original
    while (!auxiliar.isEmpty()) {
        this.push(auxiliar.pop());
    }

    return discos; //retorna o aux
}
}