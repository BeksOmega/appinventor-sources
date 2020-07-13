// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a MapFeature type used by various components than can be added to a map.
 */
public enum MapFeature implements OptionList {
  Circle("Circle"),
  LineString("LineString"),
  Marker("Marker"),
  Polygon("Polygon"),
  Rectangle("Rectangle");

  private String value;

  MapFeature(String feat) {
    this.value = feat;
  }

  public String getValue() {
    return value;
  }

  private static final Map<String, MapFeature> lookup = new HashMap<>();

  static {
    for(MapFeature feat : MapFeature.values()) {
      lookup.put(feat.getValue(), feat);
    }
  }

  public static MapFeature get(int feat) {
    return lookup.get(feat);
  }
}