package spinghg.hungergames.api;

import spinghg.hungergames.libsHg;
import spinghg.hungergames.api.configs.Config;

public class API
 {
 private final Config config = new Config();

public API(libsHg plugin) {}
  
 public Config getConfigManager()
  {
    return this.config;
  }
 }
