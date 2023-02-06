package com.howaky.howatemplate.config;

import lombok.Getter;
import net.william278.annotaml.YamlFile;
import net.william278.annotaml.YamlKey;

@Getter
@YamlFile()
public class Settings {

    @YamlKey("example")
    public int example;

}
