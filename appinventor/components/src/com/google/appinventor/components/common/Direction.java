// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import com.google.appinventor.components.annotations.OptionList;
import java.util.HashMap;
import java.util.Map;

public enum Direction implements OptionList {
  North(1),
  Northeast(2),
  // @Default
  East(3),
  Southeast(4),
  South(-1),
  Southwest(-2),
  West(-3),
  Northwest(-4);

  private int value;

  Direction(int dir) {
    this.value = dir;
  }

  public int getValue() {
    return value;
  }

  private static final Map<Integer, Direction> lookup = new HashMap<>();

  static {
    for(Direction dir : Direction.values()) {
      lookup.put(dir.getValue(), dir);
    }
  }

  public static Direction get(int dir) {
    return lookup.get(dir);
  }
}
