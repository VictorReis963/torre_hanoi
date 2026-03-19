/*
 Classe JogoHanoi
  
  Responsável por controlar toda a lógica do jogo Torre de Hanoi.
  Gerencia as três torres e as interações com o usuário.
  
  Funções principais:
 * - Inicializar o jogo
 * - Exibir menu de opções
 * - Movimentar discos entre torres (com validação)
 * - Mostrar estado atual das torres
 * - Reiniciar o jogo
 * - Verificar condição de vitória
  
 obs: Esta classe funciona como o "controlador"/"cérebro" do sistema.
 */

import java.util.Scanner;

public class JogoHanoi{

    public void iniciar(){
        
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do{
            

            System.out.println("1: Mover disco \n");
            System.out.println("2: Mostrar torres \n");
            System.out.println("3: Reiniciar\n");
            System.out.println("4: Sair\n");

            

            opcao=entrada.nextInt();
            
        
            switch(opcao){
                case 1:
                System.out.println("Movendo discos \n");
                mover_disco();
                break;

                case 2:
                System.out.println("Exibindo torres \n");
                mostrar_torres();
                break;

             case 3:
                System.out.println("Jogo reiniciado \n");
                reiniciar();
                break;
             case 4:
                System.out.println("fim de jogo \n");
                break;
             default:
                System.out.println("Opção inválida \n");
        }

    } while(opcao!=4);
}
}
