package jogoSenha;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
        jogar();
    }

    public static void jogar() {
    	
    	Scanner sc = new Scanner(System.in);
    	
        int[] senha = preencheSenha();
        
        System.out.println("|---------------------BEM VINDO!---------------------|");
        System.out.println("| Tente adivinhar a senha de 4 números entre 0 e 6.  |");
        System.out.println("| Você tem 10 tentativas.                            | ");
        System.out.println("|----------------------------------------------------|");
        
        int tentativas = 10;

        for(int i = 0; i < tentativas; i++) {
            
            int[] tentativa = preencheTentativa(sc);
            
            mostrar(tentativa, "Sua Tentativa");
            
            int[] resultado = verificarTentativa(senha, tentativa);
            System.out.println("\nDígitos corretos: " + resultado[0]);
            System.out.println("Dígitos deslocados: " + resultado[1]);
            
            if (resultado[0] == 4) {
                System.out.println("Parabéns! Você acertou a senha!");
                sc.close();
                return;
            }

            System.out.println("\nTentativas restantes: " + (tentativas - i - 1));
        }

        System.out.print("Suas tentativas acabaram. ");
        mostrar(senha, "Senha");
        sc.close();
    }

    public static int[] preencheSenha() {
        Random rand = new Random();
        
        int[] senha = new int[4];
        
        for (int i = 0; i < senha.length; i++) {
            senha[i] = rand.nextInt(7); 
        }
        
        return senha;
    }

    public static int[] preencheTentativa(Scanner sc) {
        int[] tentativa = new int[4];

        for (int i = 0; i < tentativa.length; i++) {
            System.out.print("\nDigite um número entre 0 a 6 para posição " + i + " : ");
            tentativa[i] = sc.nextInt();

            while (tentativa[i] < 0 || tentativa[i] > 6) {
                System.out.print("Número inválido! Tente novamente um número entre 0 a 6: ");
                tentativa[i] = sc.nextInt();
            }
        }

        return tentativa;
    }
    
    public static void mostrar(int[] v, String nome) {
    	
        System.out.print(nome + ": ");
        
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }

    public static int[] verificarTentativa(int[] s, int[] t) {
    	
        int corretos = 0;
        int deslocados = 0;

        boolean[] senhaUsada = new boolean[4];
        boolean[] tentativaUsada = new boolean[4];

        for (int i = 0; i < 4; i++) {
            if (t[i] == s[i]) {
                corretos++;
                senhaUsada[i] = true;
                tentativaUsada[i] = true;
            }
        }

        for (int i = 0; i < 4; i++) {
            if (!tentativaUsada[i]) {
                for (int j = 0; j < 4; j++) {
                    if (!senhaUsada[j] && t[i] == s[j]) {
                        deslocados++;
                        senhaUsada[j] = true;
                        break;
                    }
                }
            }
        }

        return new int[]{corretos, deslocados};
    }
    
}
