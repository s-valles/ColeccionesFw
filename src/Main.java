import java.util.Scanner;

public class Main {
    Deck Play = new Deck();
    boolean continue_game = true;
    public void ShowMenu(){
        System.out.println(
                """
                        \t Poker 52
                         Opciónes de Juego:\s
                         1 - Shuffle - Mezclar el Deck
                         2 - Head - Sacar una Carta
                         3 - Pick - Carta al Azar
                         4 - Hand - Obtener Mano de 5 Cartas
                        \s
                         0 - Salir Del Juego\s
                        """);
    }

    private int ask() {
        Scanner ent = new Scanner(System.in);
        System.out.print("Elija una opcion: ");
        return ent.nextInt();
    }

    public void Show_Switch(int menu) throws Exception {

        switch (menu) {
            case 1 -> Play.shuffle();
            case 2 -> {
                Play.randomHead();
                Play.head();
            }
            case 3 -> Play.pick();
            case 4 -> Play.hand();
            case 0 -> {
                System.out.println("\nJuego Terminado");
                continue_game = false;
            }
        }
    }
    public void Option_Message() {
        do{
            line();
            ShowMenu();
            try {
                var menu = ask();
                if (menu <0 || menu >4){
                    throw new Exception("Elija una Opción del Menu (0-4)");
                }
                Show_Switch(menu);

            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }while (continue_game);
    }
    void line(){
        System.out.println("\n---------------------------------------");
    }
    public static void main(String[] args) {
        Main Menu = new Main();
        Menu.Option_Message();
    }
}
