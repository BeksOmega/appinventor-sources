// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a Units type used by the Map component.
 */
public enum Units implements OptionList {
  Metric(1),
  Imperial(2);

  private Integer value;

  Units(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  private static final Map<Integer, Units> lookup = new HashMap<>();

  static {
    for(Units unit : Units.values()) {
      lookup.put(unit.getValue(), unit);
    }
  }

  public static Units get(Integer unit) {
    return lookup.get(unit);
  }
}
