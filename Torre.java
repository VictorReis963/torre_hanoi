/*
Componentes:
Victor Reis RA:10420297
Caroline Rhe Ree Lee RA:10264791
Renan Dos Santos Jesus RA:10748027

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
        // inicializa a torre com tamanho definido
        this.tam = tam;
        this.e = new Disco[tam];
        this.topoTorre = -1;
    }

    public boolean isEmpty() {
        // verifica se a torre está vazia (topo = -1)
        if (this.topoTorre == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        // verifica se a torre está cheia (topo no limite)
        if (this.topoTorre == this.tam - 1)
            return true;
        else
            return false;
    }

    public boolean push(Disco d) {
        // insere um disco no topo respeitando a regra do jogo
        if (!this.isFull()) {
            // não permite disco maior sobre menor
            if (!this.isEmpty() && d.getSize() > this.e[this.topoTorre].getSize())
                return false;
            this.e[++this.topoTorre] = d;
            return true;
        } else
            return false;
    }

    public Disco pop() {
        // remove e retorna o disco do topo
        if (!this.isEmpty())
            return this.e[this.topoTorre--];
        else
            return null;
    }

    public Disco topo() {
        // retorna o disco do topo sem remover
        if (!this.isEmpty())
            return this.e[this.topoTorre];
        else
            return null;
    }

    public int sizeElements() {
        // retorna quantidade de discos na torre
        return this.topoTorre + 1;
    }
}