import java.util.Scanner;

public class GameOfTrust {

    public static void main(String[] args){
        System.out.println("Game has started:");
        Scanner scanner=new Scanner(System.in);
        Player player1 = new Player(new ConsolePlayerBehaviour(scanner));
        Player player2 = new Player(new ConsolePlayerBehaviour(scanner));
        RulesEngine rulesEngine = new RulesEngine();
        Game game = new Game(player1, player2, rulesEngine, System.out);
        game.playFor(2);

        System.out.println("Game ended\n Final scores are player1:"
                +game.scoreFor(player1)
                +", Player2:" +game.scoreFor(player2));
    }

}
