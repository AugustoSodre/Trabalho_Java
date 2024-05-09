import java.util.Scanner;

public class PisoCEUB {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int altura = sc.nextInt();
        int largura = sc.nextInt();
        int lajTipo1 = 0, lajTipo2 = 0, lajTipo3 = 0, lajTotal = 0;
        int contPico = 1, numFileiras;

        //Lajotas do tipo3 são constantemente 4
        //Lajotas do tipo2 caem na fórmula
        lajTipo3 = 4;
        lajTipo2 = 2 * (altura / largura - 2);

        //Definindo a altura do pico da sala
        for (int i = 1; i < altura; i++){
            contPico += 2;
        }

        //Descobrindo o número de lajotas do tipo 1
        numFileiras = (altura + largura) - 1;
        int primeiraMetade = (numFileiras+1)/2;
        int segundaMetade = numFileiras - primeiraMetade;
        int nivelLajotaAtual = 1;

        //Calculando a primeira metade de lajotas da sala
        //Ou a única parte, caso numFileiras <= 2
        for (int i = 1; i <= primeiraMetade; i ++){
            if (nivelLajotaAtual < contPico){
                lajTipo1 += nivelLajotaAtual;
                nivelLajotaAtual += 2;
            } else {
                lajTipo1 += nivelLajotaAtual;
            }
        }
        //Calculando a segunda metade de lajotas da sala
        //Por ser a segunda metade, só vai descrescendo o número de lajotas por nível
        for (int i = 1; i <= segundaMetade; i++){
            lajTipo1 += nivelLajotaAtual;
            nivelLajotaAtual -= 2;
        }

        //Calculando total de lajotas
        lajTotal = lajTipo1 + lajTipo2 + lajTipo3;

        //Output
        System.out.println("Lajotas do tipo 2: " + lajTipo2);
        System.out.println("Lajotas do tipo 3: " + lajTipo3);
        System.out.println("Lajotas totais: " + lajTotal);
    }
}
