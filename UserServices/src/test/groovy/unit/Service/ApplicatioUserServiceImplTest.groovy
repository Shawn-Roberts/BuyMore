package unit.Service

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension.class)
class ApplicatioUserServiceImplTest {

    @BeforeEach
    void setUp(){}

    @AfterEach
    void tearDown(){}

    @Test
    void findAllReturnsResponseEntityWhenNoException(){}

    @Test
    void findAllReturnsResponseEntityWhenException(){}

    @Test
    void findAllCallsDAOMethodFindAll(){}
}
