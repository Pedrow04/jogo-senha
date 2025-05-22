package jogoSenha;

import java.util.Random;
import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int[] senha = new int [4];
	    
	    preencheSenha(senha);
	    mostra(senha);
	    System.out.println("-----------Bem vindo ao jogo da senha!----------");
	    System.out.println("Acerte o código de 4 digitos em 10 tentativas !!");
	    
	    for (int i = 1; i<= 2; i++) {
	    	System.out.println("\n--- Tentativa "+ i +" ---");
	    	int[] num = preencheTentativas();
	    	
		    	for (int j=0; j<num.length; j++) {
		    		System.out.print(num[j]+ " ");
		    		
		    		/*System.out.println(num[j]);
		    		if(num[j]==senha[j]){
			    		System.out.println("parabens! voce acertou");
			    		
			    	}else{
			    		
			    		System.out.println("tente novamente");
			    	}*/

		    	}
		    
	    }
	    
	    System.out.println("\nGame Over! Senha correta : ");
	    mostra(senha);
	}
		
	public static void preencheSenha(int[] v) {
		Random rand = new Random();
		
		for(int i=0; i<v.length; i++) {
			v[i]=rand.nextInt(7);
		}
	}
	
	public static void mostra(int[] v) {
		for(int i=0; i<v.length; i++) {
			System.out.print(v[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] preencheTentativas() {
		Scanner sc = new Scanner(System.in);
		
		int[] tentativa = new int[4];
		
		for (int i = 0; i<4 ; i++) {
			do {
				tentativa[i] = sc.nextInt();
				
				if (tentativa[i] > 6) {
					System.out.println("Digite um número menor ou igual a 6");
				}
			}while(tentativa[i] > 6);
		}
		return tentativa;
	}
	
	public static void verificarSenha() {
		
	}
	
}
