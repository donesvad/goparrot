package com.goparrot.test.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DriverType {
    FIREFOX("firefox"),
    CHROME("chrome");

    private final String name;
    }
