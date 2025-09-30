import java.util.Scanner;

public class Jogo {

    private static final int errosTotal = 6; // quantidade maxima de erros
    private int acertou = 0; // conta os acertos
    private int erros = 0; // conta os erros
    private String rodadaPalavra;
    Scanner scanner = new Scanner(System.in);
    Dicionario palavra = new Dicionario(); //objeto do tipo Dicionário para pegar uma palavra
    public char[] palavraEscondida;

    private char letraEntrada() { // le a letra do usuario
        System.out.print("\nDigite uma letra: ");
        String letra = scanner.next().toUpperCase();
        return letra.charAt(0);
    }

    private void iniciaPalavra() { // inicia a palavra pegando aleatoriamente do Dicionario
        rodadaPalavra = palavra.palavraForca().toUpperCase();
        palavraEscondida = new char[rodadaPalavra.length()]; // palavra escondida é um array de char com _ do tamanho da palavra
        for (int i = 0; i < rodadaPalavra.length(); i++) { // adiciona _ ao array
            palavraEscondida[i] = '_';
        }
        System.out.println("Quantidade de letras: " + rodadaPalavra.length()); // avisa a quantidade de letras que tem a palavra
    }

    private void mostrarPalavra() { // mostra a palavra aos poucos conforme a letra é acertada
        for (char c : palavraEscondida) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private void errouAcertou(char tentativa) { // verifica a cada letra tentada se foi ecerto ou não
        boolean acerto = false; // sempre retorna acerto para false a cada tentativa

        for (int i = 0; i < rodadaPalavra.length(); i++) {
            if (rodadaPalavra.charAt(i) == tentativa && palavraEscondida[i] == '_') {
                palavraEscondida[i] = tentativa;
                acertou++;
                acerto = true;
            }
        }

        if (!acerto) {
            erros++;
            System.out.println("Errou! Restam " + (errosTotal - erros) + " tentativas.");
        }
    }

    public void hangMan() { // inicializa o jodo rodandoo com os metodos criaidos
        iniciaPalavra();
        char[] tentativas = new char[errosTotal + rodadaPalavra.length()]; // array para guardar todasas tentativas
        int i =0;

        while (acertou != rodadaPalavra.length() && erros < errosTotal) {
            mostrarPalavra();
            char tentativa = letraEntrada();
            tentativas[i] = tentativa;
            i++;
            errouAcertou(tentativa);
            
            System.out.print("Todas as suas tentativas até agora: [ "); // lalo que mostra as tentivas
            for (int j=0; j<i; j++){
                System.out.print(tentativas[j] + " ");
            }
            System.out.println("]");
        }

        mostrarPalavra(); // mostra palavra final

        if (acertou == rodadaPalavra.length()) { 
            System.out.println("Parabéns! Você acertou: " + rodadaPalavra);
        } else {
            System.out.println("Você perdeu! A palavra era: " + rodadaPalavra);
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.hangMan();
    }
}
/*import java.util.Scanner;

public class Jogo{

    private static final int errosTotal = 6;
    private int acertou = 0;
    private int erros = 0;
    private String rodadaPalavra;
    Scanner scanner = new Scanner(System.in);
    Dicionario palavra = new Dicionario();
    public char[] palavraEscondida;
    

    private char letraEntrada(){ // lê do usuário uma letra
        String letra = scanner.next();
        char tentativa = letra.charAt(0); // garante que pegue o primeiro char

        return tentativa; //retorna a letra
    }
    

    private void iniciaPalavra(){
        rodadaPalavra = palavra.palavraForca();
        //int acertos = rodadaPalavra.length();
        palavraEscondida = new char[rodadaPalavra.length()];

        System.out.println("Quantidade de letras: " + palavra.palavraForca().length());
    }

    private void palavraOculta(){
                
        for (int i =0; i<rodadaPalavra.length(); i++){ //faz o arrays com _ to tamanho da palavra a ser descobreta
            this.palavraEscondida[i] = '_';
        }

        for (char c : palavraEscondida){ //print o array com _
            System.out.print(c +" ");
        }
    }

    private void errouAcertou(char tentativa){

        boolean acerto = false;

        for (int i =0; i<rodadaPalavra.length(); i++){
            if (rodadaPalavra.charAt(i)==tentativa){
                palavraEscondida[i] = tentativa;
                acertou++;
                acerto=true;
            } 
        }

        if(acerto==false){
            erros++;
            System.out.println("Errou! Restam "+ (errosTotal-erros)+" tentativas.");
        }
    }
    
    public void hangMan(){

        iniciaPalavra();
        palavraOculta();

        while(acertou!=rodadaPalavra.length() && erros<errosTotal){
            char tentativa = letraEntrada();

            errouAcertou(tentativa);
        }

        if (acertou == rodadaPalavra.length()) {
            System.out.println("Parabéns! Você acertou: " + rodadaPalavra);
        } else {
            System.out.println("Você perdeu! A palavra era: " + rodadaPalavra);
        }
        
    }
}*/