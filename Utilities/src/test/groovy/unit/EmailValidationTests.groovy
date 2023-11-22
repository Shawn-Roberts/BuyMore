package unit

import com.BuyMore.Utilities.EmailValidation
import com.BuyMore.Utilities.StringValidation
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.MockedStatic
import org.mockito.Mockito

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThatThrownBy
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension.class)
class EmailValidationTests {

    //To Do
    //Add argument captor to ensure correct args being passed to StringValidator


    MockedStatic<StringValidationTests> validateStringMock

    @BeforeEach
    void setUp() { validateStringMock = Mockito.mockStatic(StringValidation.class) }

    @AfterEach
    void tearDown() { validateStringMock.close() }


    @Test
    void validateEmailReturnsTrueWithValidEmails()
    {
        validateStringMock.when { EmailValidation.validateEmailField("email@test.com","email")}
        .thenReturn(true)

        assertThat(EmailValidation.validateEmailField("email@test.com","email")).isTrue()

    }

    @Test
    void validateEmailThrowsIllegalArgumentExceptionWithInvalidEmail() {
        validateStringMock.when { EmailValidation.validateEmailField("emailtest.com","email")}
                .thenReturn(true)
        assertThatThrownBy {EmailValidation.validateEmailField("emailtest.com","email")}.isInstanceOf(IllegalArgumentException.class)
    }

}
