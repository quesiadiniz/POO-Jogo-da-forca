import java.util.Random;

public class Dicionario {

    String palavra;
    int indice;

    String[] dicionario = {
        "Banana", "Abacaxi", "Morango", "Cereja", "Laranja", "Melancia", "Cenoura", "Batata", 
        "Escola", "Livro", "Alambique", "Algodao", "Almanaque", "Capcioso","Congratular", 
        "Estojo", "Ditadura","Frugal", "Garanhao", "Humildade", "Xicara", "Ziper", "Queijo", 
        "Jiboia", "Polvora", "Bicicleta", "Lapis", "Engenhoca", "Dicionario", "Raciocinar"
    };

    private static Random random = new Random();

    public String palavraForca(){
        this.indice = random.nextInt(dicionario.length);

        //System.out.println(dicionario[indice]);
        return dicionario[indice];
    }

    /*public static void main(String[] args) {
        Dicionario teste = new Dicionario();
        teste.palavraForca();
    }*/
}