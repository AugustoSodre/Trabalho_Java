import java.util.Arrays;
import java.util.Scanner;

public class Pinguim {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int numElementos, contadorTrocas = 0, valorVenda = 0;
        System.out.println("Insira número de pinguins: ");
        numElementos = sc.nextInt();
        int[] listaOriginal = new int[numElementos];
        int[] listaOrdenada = new int[numElementos];

        //Preenchendo a lista desordenada, original:
        System.out.println("Digite as alturas dos pinguins em suas respectivas posições: ");
        for (int i = 0; i < numElementos; i++){
            String binaryAnswer = sc.next();
            listaOriginal[i] = Integer.parseInt(binaryAnswer, 2);
        }

        //Organizando a listaOriginal -> Bubble Sort para Descresente
        listaOrdenada = listaOriginal.clone();
        for (int i = 0; i < numElementos; i++){
            for (int j = 0; j < numElementos - 1; j++){
                int elemTemp = 0;
                if (listaOrdenada[j+1] > listaOrdenada[j]){
                    elemTemp = listaOrdenada[j+1];
                    listaOrdenada[j+1] = listaOrdenada[j];
                    listaOrdenada[j] = elemTemp;
                }
            }
        }

        //Comparando a lista original (Desordenada) com a lista ordenada, para ver quais elementos devem ser trocados!
        int[] elementosParaTroca = new int[numElementos];
        for (int i = 0; i < numElementos; i++){
            if (listaOrdenada[i] != listaOriginal[i]){
                elementosParaTroca[contadorTrocas] = listaOriginal[i];
                contadorTrocas++;
            }
        }


        //Organizando a lista dos trocados em ordem decrescente
        for (int i = 0; i < contadorTrocas; i++){
            for (int j = 0; j < contadorTrocas - 1; j++){
                int elemTemp = 0;
                if (elementosParaTroca[j+1] > elementosParaTroca[j]){
                    elemTemp = elementosParaTroca[j+1];
                    elementosParaTroca[j+1] = elementosParaTroca[j];
                    elementosParaTroca[j] = elemTemp;
                }
            }
        }

        //Calculando o valor da venda
        valorVenda = 2250 * Arrays.stream(elementosParaTroca).sum();

        //Outputs
        System.out.println("Lista original: " + Arrays.toString(listaOriginal));
        System.out.println("Número de trocas: " + contadorTrocas);
        System.out.println("Lista de pinguins para troca: " + Arrays.toString(elementosParaTroca));
        System.out.println("Valor da venda: " + valorVenda);
        sc.close();
    }
}