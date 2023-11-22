package unit.Entity

import com.BuyMore.UserServices.Entity.ApplicationUser
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest

import static org.assertj.core.api.Assertions.assertThatNullPointerException
import static org.assertj.core.api.Assertions.assertThat
import static org.assertj.core.api.Assertions.assertThatThrownBy

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ApplicationUserTest {

   private ApplicationUser underTest
    String validFirstName = 'FIRST'
    String validLastName = 'LAST'
    String validEmail = 'email@test.com'


    @BeforeEach
    void setUp() {
        underTest = ApplicationUser.createUser()
                .firstName(validFirstName)
                .lastName(validLastName)
                .email(validEmail)
                .build()
    }

    @AfterEach
    void tearDown() {}

    @Test
    void NoArgsConstructorReturnsValidClassImplementation()
    {
        ApplicationUser noArgs = new ApplicationUser()
        assertThat(noArgs).isInstanceOf(ApplicationUser.class)
    }

    @Test
    void BuilderReturnsValidClassImplementation() { assertThat(underTest).isInstanceOf(ApplicationUser.class) }

    @Test
    void BuilderThrowsNullPointerWithNoArgs() { assertThatNullPointerException().isThrownBy {ApplicationUser.createUser().build()} }

    @Test
    void BuilderReturnsClassWithAUniqueID(){ assertThat(underTest.getUniqueID()).isNotNull() }


    @Test
    void getUniqueIDReturnsValidValue() { assertThat(underTest.getUniqueID()).isNotNull() }

    @Test
    void getFirstNameReturnsCorrectValue() { assertThat(underTest.getFirstName()).isEqualTo(validFirstName) }

    @Test
    void getLastName() { assertThat(underTest.getLastName()).isEqualTo(validLastName)}

    @Test
    void getEmail() { assertThat(underTest.getEmail()).isEqualTo(validEmail)}

    @Test
    void setFirstNameWithValidArgumentCorrectlySetsName()
    {
        underTest.setFirstName(validFirstName)
        assertThat(underTest.getFirstName()).isEqualTo(validFirstName)
    }

    @Test
    void setFirstNameWithBlankStringReturnsIllegalArgumentException()
    {
        assertThatThrownBy {underTest.setFirstName(new String())}.isInstanceOf(IllegalArgumentException.class)
    }

    @Test
    void setFirstNameWithNullStringReturnsNullPointerException()
    {
        assertThatThrownBy {underTest.setFirstName(null)}.isInstanceOf(NullPointerException.class)
    }

    @Test
    void setLastNameWithValidArgumentCorrectlySetsName()
    {
        underTest.setLastName(validLastName)
        assertThat(underTest.getLastName()).isEqualTo(validLastName)
    }

    @Test
    void setLastNameWithBlankStringReturnsIllegalArgumentException()
    {
        assertThatThrownBy {underTest.setLastName(new String())}.isInstanceOf(IllegalArgumentException.class)
    }

    @Test
    void setLastNameWithNullStringReturnsNullPointerException()
    {
        assertThatThrownBy {underTest.setLastName(null)}.isInstanceOf(NullPointerException.class)
    }

    @Test
    void setEmailWithValidArgumentCorrectlySetsName()
    {
        underTest.setEmail(validEmail)
        assertThat(underTest.getEmail()).isEqualTo(validEmail)
    }

    @Test
    void setEmailWithBlankStringReturnsIllegalArgumentException()
    {
        assertThatThrownBy {underTest.setEmail(new String())}.isInstanceOf(IllegalArgumentException.class)
    }

    @Test
    void setEmailWithNullStringReturnsNullPointerException()
    {
        assertThatThrownBy {underTest.setEmail(null)}.isInstanceOf(NullPointerException.class)
    }
}