/*clase disco com atributos encapsulados
 Responsável por representar um disco do jogo Torre de Hanoi.
 Cada disco possui um tamanho (valor inteiro), que define sua posição na torre.
 
 Regras importantes:
 * - O tamanho do disco não deve ser alterado após sua criação. */



public class Disco{
    private int tamanho;

    public int getSize() {
        return tamanho;
    }
    public void setSize(int tam){
        this.tamanho=tam;
    }

}