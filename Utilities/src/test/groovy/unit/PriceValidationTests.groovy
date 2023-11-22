package unit

import com.BuyMore.Utilities.PriceValidation
import org.junit.jupiter.api.Test

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThatNullPointerException
import static org.assertj.core.api.Assertions.assertThatThrownBy


class PriceValidationTests {

    @Test
    void validatePriceFieldReturnsTrueWithValidPrice() {
        ArrayList<BigDecimal> validPrices = new ArrayList<BigDecimal>(List.of(3.99,1.60,4.85,0.50,0.51))
        validPrices.each {it-> assertThat(PriceValidation.validatePriceField(it,"price")).isTrue()}
    }



    @Test
    void validatePriceFieldThrowsNullExceptionWhenNullPassedIn() {
        Double invalidNull = null
        assertThatNullPointerException().isThrownBy {PriceValidation.validatePriceField(invalidNull,"price")}
    }

    @Test
    void validatePriceFieldThrowsIllegalArgumentExceptionWhenPriceBelowFiftyCents()
    {
        ArrayList<BigDecimal> invalidPrices = new ArrayList<Double>(List.of(-0.01,-2.84,-9.99,-98.09))
        invalidPrices.forEach {val -> assertThatThrownBy {(PriceValidation.validatePriceField(val,"rating"))}.isInstanceOf(IllegalArgumentException.class)}
    }

}
