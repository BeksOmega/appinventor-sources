// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a HorizontalAlignment used by a variety of classes including Form, VerticalArrangement,
 * and Marker.
 */
public enum HorizontalAlignment implements OptionList {
  Left(1),
  Center(3), // Yes this is correct.
  Right(2);

  private int value;

  HorizontalAlignment(int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  private static Map<Integer, HorizontalAlignment> lookup = new HashMap<>();

  static {
    for(HorizontalAlignment alignment : HorizontalAlignment.values()) {
      lookup.put(alignment.getValue(), alignment);
    }
  }

  public static HorizontalAlignment get(int alignment) {
    return lookup.get(alignment);
  }
}
