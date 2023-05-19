import java.util.Random;
import java.util.Scanner;
public class JogoDaForca {
	public static void main(String[] args) {
		Random sort = new Random();
		Scanner input = new Scanner(System.in);
		System.out.println("------ Jogo da forca! ------");
		System.out.println(
				"aproveite o jogo!");
		String[] palavras = { "cofre", "lantejola", "balde ", "lapis","vassoura", "cadeira",
				"celular", "computador", "bola", "controle", "chinelo"};
		String sorteio = palavras[sort.nextInt(palavras.length)].toUpperCase();
		char[] PDividir = sorteio.toCharArray();
		char[] posicoes = new char[PDividir.length];
		for (int i = 0; i < PDividir.length; i++) {
			posicoes[i] = '_';
			System.out.print(posicoes[i] + " ");
		}
		System.out.println(" ");
		int n = 0;

		int chances = 6;
		int z = 0;

		int t = (PDividir.length + 6);
		String utilizadas = "";

		while (chances != 0) {
			if (z != 0) {
				break;
			}

			int corretos = 0;
			int errados = 0;
			System.out.println(" ");
			System.out.println("digite uma letra: ");
			String informado = input.next().toUpperCase();
			char letra = informado.charAt(0);
			utilizadas += letra;
			for (int q = 0; q < PDividir.length; q++) {
				if (letra == PDividir[q]) {
					posicoes[q] = letra;
					n++;

				}

				if (letra != PDividir[q]) {
					errados += 1;

				}
			}
			for (int o = 0; o < PDividir.length; o++) {
				if (errados >= PDividir.length) {
					chances--;

					if (chances == 0) {
						System.out.println("Derrota!");
						chances = 0;
						System.out.println("palavra correta: ");
						for (int y = 0; y < PDividir.length; y++) {

							System.out.print(PDividir[y]);

						}
						
						break;

					}
					System.out.println(" ");
					System.out.println("errado! tente mais " + chances + " vezes antes de perder.");
					System.out.println("------ Dica: Objetos! -----");
					break;
				} else {

					System.out.print(posicoes[o] + " ");
				}

			}
			System.out.println(" ");
			System.out.println("já usou essas letras: " + utilizadas);
			for (int i = 0; i < PDividir.length; i++) {
				if (posicoes[i] != '_') {
					corretos++;
					if (corretos >= PDividir.length) {
						System.out.println(" ");
						System.out.println("Você ganhou!");
						z++;
					}
				}
			}
		}
	}



}
