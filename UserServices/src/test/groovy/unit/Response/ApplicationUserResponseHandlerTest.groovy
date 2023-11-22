package unit.Response

import com.BuyMore.UserServices.Response.ApplicationUserResponseHandler
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThatThrownBy

class ApplicationUserResponseHandlerTest {

    private String message = "hello"
    private HttpStatus status = HttpStatus.ACCEPTED
    private String data = "some data"

    @BeforeEach
    void setup(){}

    @AfterEach
    void tearDown(){}

    @Test
    void generateResponseWithValidArgsReturnsResponseEntity()
    {
        ResponseEntity<Object> response = ApplicationUserResponseHandler.generateResponse(message,status,data)
        assertThat(response).isInstanceOf(ResponseEntity<Object>)
    }

}
