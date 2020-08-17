import Enums.MoveEnum;
import View.Input;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputTests {

    @Test
    void whenNumbeIs8_thenMoveEnumIsUP() {
        Input input = new Input();
        MoveEnum result = input.getMoveType(8);
        Assertions.assertEquals(result.toString(), "UP");
    }




}
