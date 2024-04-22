package org.springframework.samples.petclinic.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;

/**
 * Cache configuration intended for caches providing the JCache API. This configuration creates the used cache for the
 * application and enables statistics that become accessible via JMX.
 *
 * @author Antoine Rey
 * @author Stephane Nicoll
 * @author Jens Wilke
 */
@org.springframework.context.annotation.Configuration(proxyBeanMethods = false)
@EnableCaching
public class CacheConfig {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return it -> it.createCache("vets", createCacheConfiguration());
    }

    /**
     * Create a simple configuration that enable statistics via the JCache programmatic configuration API.
     * <p>
     * Within the configuration object that is provided by the JCache API standard, there is only a very limited set of
     * configuration options. The really relevant configuration options (like the size limit) must be set via a
     * configuration mechanism that is provided by the selected JCache implementation.
     */
    private Configuration<Object, Object> createCacheConfiguration() {
        return new MutableConfiguration<>().setStatisticsEnabled(true);
    }
}