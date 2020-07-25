
// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a ImageAnimation type used by the Image component.
 */
public enum ImageAnimation implements OptionList {
  ScrollRightSlow("ScrollRightSlow"),
  ScrollRight("ScrollRight"),
  ScrollRightFast("ScrollRightFast"),
  ScrollLeftSlow("ScrollLeftSlow"),
  ScrollLeft("ScrollLeft"),
  ScrollLeftFast("ScrollLeftFast"),
  Stop("Stop");

  private String value;

  ImageAnimation(String anim) {
    this.value = anim;
  }

  public String getValue() {
    return value;
  }

  private static final Map<String, ImageAnimation> lookup = new HashMap<>();

  static {
    for(ImageAnimation anim : ImageAnimation.values()) {
      lookup.put(anim.getValue(), anim);
    }
  }

  public static ImageAnimation get(String anim) {
    return lookup.get(anim);
  }
}
