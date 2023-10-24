package unit

import com.BuyMore.Utilities.RatingValidation
import org.junit.jupiter.api.Test

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThatNullPointerException
import static org.assertj.core.api.Assertions.assertThatThrownBy


class RatingValidationTest {

    @Test
    void validateRatingFieldReturnsTrueWithValidRating() {
        ArrayList<Double> validRatings = new ArrayList<Double>(List.of(3.99,1.60,4.85,0.05,0.00))
        validRatings.each {it-> assertThat(RatingValidation.validateRatingField(it,"rating")).isTrue()}
    }

    @Test
    void validateRatingFieldThrowsNullExceptionWhenNullPassedIn() {
        Double invalidNull = null
        assertThatNullPointerException().isThrownBy {RatingValidation.validateRatingField(invalidNull,"rating")}
    }

    @Test
    void validateRatingFieldThrowsIllegalArgumentExceptionWhenRatingBelowZero()
    {
        ArrayList<Double> invalidRatingsBelowZero = new ArrayList<Double>(List.of(-0.01,-2.84,-9.99,-98.09))
        invalidRatingsBelowZero.forEach {val -> assertThatThrownBy {(RatingValidation.validateRatingField(val,"rating"))}.isInstanceOf(IllegalArgumentException.class)}
    }

    @Test
    void validateRatingFieldThrowsInvalidArgumentExceptionWhenRatingAbove5(){
        ArrayList<Double> invalidRatingsAboveFive = new ArrayList<Double>(List.of(5.01,12.84,9.99,98.09))
        invalidRatingsAboveFive.forEach {val -> assertThatThrownBy {(RatingValidation.validateRatingField(val,"rating"))}.isInstanceOf(IllegalArgumentException.class)}
    }


}