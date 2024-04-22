package org.springframework.samples.petclinic.system;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;

@EnableCaching
public class CacheConfig {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return it -> it.createCache("vets", createCacheConfiguration());
    }

    private Configuration<Object, Object> createCacheConfiguration() {
        return new MutableConfiguration<>().setStatisticsEnabled(true);
    }
}