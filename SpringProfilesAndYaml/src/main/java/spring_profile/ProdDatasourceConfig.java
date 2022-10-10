package spring_profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
@Slf4j
public class ProdDatasourceConfig implements DatasourceConfig {

    @Override
    public String setup() {
        return "Setting up datasource for PRODUCTION environment";
    }

}
