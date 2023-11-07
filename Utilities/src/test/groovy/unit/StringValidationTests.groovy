package unit

import com.BuyMore.Utilities.RatingValidation
import com.BuyMore.Utilities.StringValidation
import org.junit.jupiter.api.Test

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThatNullPointerException
import static org.assertj.core.api.Assertions.assertThatThrownBy

class StringValidationTest {

    @Test
    void validateStringFieldReturnsTrueWithValidString() {
        ArrayList<String> validStrings = new ArrayList<String>(List.of("valid name", "valid description", "other important text", "a"))
        validStrings.each {it-> assertThat(StringValidation.validateStringField(it,"string")).isTrue()}
    }

    @Test
    void validateStringReturnsTrueWithTypeCasting()
    {
        char[] answer =['h','e','l','l','o']
        assertThat(StringValidation.validateStringField(answer as String,"it")).isTrue()
    }

    @Test
    void validateStringFieldThrowsNullExceptionWhenNullPassedIn() {
        String invalidNull = null
        assertThatNullPointerException().isThrownBy {StringValidation.validateStringField(invalidNull,"string")}
    }

    @Test
    void validateStringFieldThrowsIllegalArgumentExceptionWhenBlankPassedIn() {
        String blankString = "   "
        assertThatThrownBy {StringValidation.validateStringField(blankString,"string") }.isInstanceOf(IllegalArgumentException.class)
    }

    @Test
    void validateStringFieldThrowsIllegalArgumentExceptionWhenEmptyPassedIn() {
        String emptyString = new String()
        assertThatThrownBy{StringValidation.validateStringField(new String(),"string")}.isInstanceOf(IllegalArgumentException.class)
    }


}
