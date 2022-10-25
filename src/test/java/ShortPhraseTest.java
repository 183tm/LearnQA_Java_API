import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShortPhraseTest {

    @ParameterizedTest
    @ValueSource(strings ={"abcdefghjklmnopt","klmnopabcdefghj","edca"} )

    public void shortPhTest(String letter){

        assertTrue(letter.length() > 15, "bad");

        }

}
