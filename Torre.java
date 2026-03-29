/*
 * Classe Torre
 * * Responsável por representar uma torre do jogo.
 * Implementa uma estrutura de dados do tipo Pilha utilizando vetor.
 * * Funções principais:
 * - Empilhar discos (push)
 * - Desempilhar discos (pop)
 * - Verificar o disco do topo
 * - Verificar se a torre está vazia
 * * Regras:
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
        return this.topoTorre == -1;
    }

    public boolean isFull() {
        return this.topoTorre == this.tam - 1;
    }

    public boolean push(Disco d) {
        if (!this.isFull()) {
            // Verifica se a torre não está vazia e se o disco é maior que o do topo
            if (!this.isEmpty() && d.getSize() > this.e[this.topoTorre].getSize()) {
                return false;
            }
            
            this.e[++this.topoTorre] = d;
            return true;
        } else {
            return false;
        }
    }

    public Disco pop() {
        if (!this.isEmpty()) {
            return this.e[this.topoTorre--];
        } else {
            return null;
        }
    }

    public Disco topo() {
        if (!this.isEmpty()) {
            return this.e[this.topoTorre];
        } else {
            return null;
        }
    }

    public int sizeElements() {
        return this.topoTorre + 1;
    }

    public int[] getDiscos() {
        int n = sizeElements();
        int[] discos = new int[n];
        for (int i = 0; i < n; i++) {
            discos[i] = e[i].getSize();
        }
        return discos;
    }
}
