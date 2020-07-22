// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a MapType type used by the Map component.
 */
public enum MapType implements OptionList {
  Road(1),
  Aerial(2),
  Terrain(3);

  private Integer value;

  MapType(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  private static final Map<Integer, MapType> lookup = new HashMap<>();

  static {
    for(MapType type : MapType.values()) {
      lookup.put(type.getValue(), type);
    }
  }

  public static MapType get(Integer type) {
    return lookup.get(type);
  }
}
