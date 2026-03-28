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
public class JogoHanoi {
   
    private Torre[] torres;
    private int quantidadeDiscos;
    private Scanner scanner;

    public JogoHanoi() {
        this.torres = new Torre[3];
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        configurarJogo();
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Mover disco");
            System.out.println("2 - Mostrar torres");
            System.out.println("3 - Reiniciar jogo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    moverDisco();
                    break;
                case 2:
                    mostrarTorres();
                    break;
                case 3:
                    configurarJogo();
                    break;
                case 4:
                    executando = false;
                    System.out.println("Encerrando o simulador da Torre de Hanoi...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void configurarJogo() {
        System.out.print("Informe a quantidade inicial de discos: ");
        this.quantidadeDiscos = scanner.nextInt();


        
        for (int i = 0; i < 3; i++) {
            torres[i] = new Torre(quantidadeDiscos);
        }
        for (int i = quantidadeDiscos; i >= 1; i--) {
            Disco d = new Disco();
            d.setSize(i);
            torres[0].push(d);
        }
        
        System.out.println("Jogo configurado com " + quantidadeDiscos + " discos.");
    }

    private void moverDisco() {
        System.out.print("Informe a torre de origem (1, 2 ou 3): ");
        int origem = scanner.nextInt() - 1; 
        System.out.print("Informe a torre de destino (1, 2 ou 3): ");
        int destino = scanner.nextInt() - 1;

        if (origem < 0 || origem > 2 || destino < 0 || destino > 2) {
            System.out.println("Erro: Torre inválida.");
            return;
        }

        
        Disco d = torres[origem].pop();
        
        if (d == null) {
            System.out.println("Erro de movimento: A torre de origem está vazia.");
            return;
        }

       
        if (torres[destino].push(d)) {

            System.out.println("Movimento realizado com sucesso.");
            
            
            if (verificarVitoria()) {
                System.out.println("");
                System.out.println("Você venceu!");
            }
        } else {
            System.out.println("Erro de movimento: Não é possível colocar um disco maior sobre um menor.");
            torres[origem].push(d);
        }
    }

    private boolean verificarVitoria() {
        return torres[1].sizeElements() == quantidadeDiscos || torres[2].sizeElements() == quantidadeDiscos;
    }

    private void mostrarTorres() {
        System.out.println();
        for (int nivel = quantidadeDiscos - 1; nivel >= 0; nivel--) {
            for (int t = 0; t < 3; t++) {
                int[] discos = torres[t].getDiscos();
                String representacaoDisco = "";
                
                if (nivel < discos.length) {
                    for (int i = 0; i < discos[nivel]; i++) {
                        representacaoDisco += "*";
                    }
                }
                System.out.printf("%-" + (quantidadeDiscos + 4) + "s", representacaoDisco);
            }
            System.out.println();
        }
        System.out.printf("%-" + (quantidadeDiscos + 4) + "s", "TORRE1 ");
        System.out.printf("%-" + (quantidadeDiscos + 4) + "s", "TORRE2 ");
        System.out.printf("%-" + (quantidadeDiscos + 4) + "s\n", "TORRE3");
    }
}
