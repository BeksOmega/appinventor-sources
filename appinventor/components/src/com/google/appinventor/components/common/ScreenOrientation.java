// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a ScreenOrientation type used by the Form component to specify orientation.
 */
public enum ScreenOrientation implements OptionList {
  Unspecified("unspecified"),
  Landscape("landscape"),
  Portrait("portrait"),
  Sensor("sensor"),
  User("user"),
  Behind("behind"),
  NoSensor("nosensor"),
  FullSensor("fullSensor"),
  ReverseLandscape("reverseLandscape"),
  ReversePortrait("reversePortrait"),
  SensorLandscape("sensorLandscape"),
  SensorPortrait("sensorPortrait");

  private String value;

  ScreenOrientation(String anim) {
    this.value = anim;
  }

  public String getValue() {
    return value;
  }

  private static final Map<String, ScreenOrientation> lookup = new HashMap<>();

  static {
    for(ScreenOrientation orientation : ScreenOrientation.values()) {
      lookup.put(orientation.getValue().toLowerCase(), orientation);
    }
  }

  public static ScreenOrientation get(String orientation) {
    return lookup.get(orientation.toLowerCase());
  }
}
