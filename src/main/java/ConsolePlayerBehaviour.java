import java.util.Scanner;

public class ConsolePlayerBehaviour implements Behaviour {
    private Scanner scanner;

    public ConsolePlayerBehaviour(Scanner scanner) {
        this.scanner =scanner;
    }

    @Override
    public MoveTypes getCurrentMove() {
        String value = scanner.nextLine();
        return moveTypeFor(value);
    }

    public static MoveTypes moveTypeFor(String value) {
        if (value.equals("CH")) return MoveTypes.CHEAT;
        if (value.equals("CO")) return MoveTypes.COOPERATE;
        throw new IllegalArgumentException(value + " is not valid MoveType. Valid inputs are CH and CO");
    }
}
