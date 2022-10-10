package com.test.web.configs;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.spring.context.SpringManagedContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class HazelcastConfig {

    @Bean
    public Config hazelcastCacheConfig() {
        Config config = new Config();
        config.getNetworkConfig().setPort( 5900 )
                .setPortAutoIncrement( false );

        MapConfig mapConfig = new MapConfig();
        mapConfig.setName( "testMap" )
                .setBackupCount( 2 )
                .setTimeToLiveSeconds( 300 );
        return config;
    }

    @Bean
    public SpringManagedContext managedContext() {
        return new SpringManagedContext();
    }

}
