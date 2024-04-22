

```cpp
#include <iostream>
#include <unordered_map>

class JCacheManagerCustomizer {
public:
    void createCache(std::string cacheName, Configuration configuration) {
        // Implementation here
    }
};

class Configuration {
public:
    bool statisticsEnabled;
};

class MutableConfiguration : public Configuration {
public:
    MutableConfiguration() {
        statisticsEnabled = false;
    }
};

class CacheConfig {
public:
    JCacheManagerCustomizer cacheManagerCustomizer() {
        return JCacheManagerCustomizer();
    }

    MutableConfiguration createCacheConfiguration() {
        MutableConfiguration config;
        config.statisticsEnabled = true;
        return config;
    }
};
```
