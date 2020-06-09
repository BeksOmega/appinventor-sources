// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import com.google.appinventor.components.annotations.OptionList;
import java.util.HashMap;
import java.util.Map;

public enum ScreenAnimation implements OptionList {
  // @Default
  Default("default"),
  Fade("fade"),
  Zoom("zoom"),
  SlideHorizontal("slidehorizontal"),
  SlideVertical("slidevertical"),
  None("none");

  private String value;

  ScreenAnimation(String anim) {
    this.value = anim;
  }

  public String getValue() {
    return value;
  }

  private static final Map<String, ScreenAnimation> lookup = new HashMap<>();

  static {
    for(ScreenAnimation anim : ScreenAnimation.values()) {
      lookup.put(anim.getValue(), anim);
    }
  }

  public static ScreenAnimation get(String anim) {
    return lookup.get(anim);
  }
}
