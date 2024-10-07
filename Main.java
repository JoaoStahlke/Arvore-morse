import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArvoreMorse arvore = new ArvoreMorse();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigite uma mensagem em código Morse (usando . e -), separando letras por espaço:");
            System.out.println("Digite 'imprimir' para visualizar a árvore");
            System.out.println("(Digite 'sair' para encerrar)");

            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("sair")) {
                System.out.println("Saindo...");
                break;
            }
            else if (entrada.equalsIgnoreCase("imprimir")) {
                System.out.println("Árvore Binária de Busca construída:");
                arvore.imprimirArvore();
            }
            else {
                if (arvore.isCodigoMorseValido(entrada)) {
                    String mensagemDecodificada = arvore.decodificarMensagem(entrada);
                    System.out.println("Mensagem decodificada: " + mensagemDecodificada);
                } else {
                    System.out.println("Erro: Código Morse inválido!");
                    System.out.println("Use apenas pontos (.) e traços (-), separando as letras com espaço.");
                    System.out.println("Exemplo válido: ... --- ... (para SOS)");
                }
            }
        }

        scanner.close();
    }
}