import java.util.Scanner;

public class JogoHanoi{

    public void iniciar(){
        
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.println("1: Mover disco \n");
            System.out.println("2: Mostrar torres \n");
            System.out.println("3: Reiniciar\n");
            System.out.println("4: Sair\n");
            
            entrada.nextInt();
            opcao.nextInt();
        
            switch(opcao){
                case 1:
                System.out.println("Movendo discos \n");
                mover_disco();
                continue;

                case 2:
                System.out.println("Exibindo torres \n");
                jogo.Mostrar_torres();
                continue;

             case 3:
                System.out.println("Jogo reiniciado \n");
                jogo.Reiniciar();
                continue;
             case 4:
                System.out.println("fim de jogo \n");
                break;
        }

    } while(opcao!=4);
}
