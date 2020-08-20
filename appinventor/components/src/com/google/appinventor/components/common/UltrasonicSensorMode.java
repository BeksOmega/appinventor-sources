// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a UltrasonicSensorMode type used by the Lego Ev3 ultrasonic sensor.
 */
public enum UltrasonicSensorMode implements OptionList<String> {
  Centimeters("cm", 0),
  Inches("inch", 1);

  private String value;
  private int intValue;

  UltrasonicSensorMode(String mode, int intMode) {
    this.value = mode;
    this.intValue = intMode;
  }

  public String toUnderlyingValue() {
    return value;
  }

  public Integer toInt() {
    return this.intValue;
  }

  private static final Map<String, UltrasonicSensorMode> lookup = new HashMap<>();

  static {
    for (UltrasonicSensorMode mode : UltrasonicSensorMode.values()) {
      lookup.put(mode.toUnderlyingValue(), mode);
    }
  }

  public static UltrasonicSensorMode fromUnderlyingValue(String mode) {
    return lookup.get(mode);
  }
}

