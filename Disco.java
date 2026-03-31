/*
Componentes:
Victor Reis RA:10420297
Caroline Rhe Ree Lee RA:10264791
Renan Dos Santos Jesus RA:10748027

clase disco com atributos encapsulados
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
