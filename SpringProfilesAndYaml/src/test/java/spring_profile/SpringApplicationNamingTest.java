package spring_profile;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("prod")
@Slf4j
class SpringApplicationNamingTest extends AbstractTest {

    @Value("${custom.string}")
    private String string;

    @Test
    void entityManager_readDatabaseUsername_thenSuccess() {
        assertEquals("ProdAboba", string);
    }

}

