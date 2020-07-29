// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a NxtMotorPort type used by the NxtDirectCommands component.
 */
public enum NxtMotorPort implements OptionList<String> {
  PortA("A", 0),
  PortB("B", 1),
  PortC("C", 2);

  private String value;
  private int intValue;

  NxtMotorPort(String port, int intPort) {
    this.value = port;
    this.intValue = intPort;
  }

  public String toUnderlyingValue() {
    return value;
  }

  public Integer toInt() {
    return intValue;
  }

  private static final Map<String, NxtMotorPort> lookup = new HashMap<>();

  static {
    for(NxtMotorPort port : NxtMotorPort.values()) {
      lookup.put(port.toUnderlyingValue(), port);
    }
  }

  public static NxtMotorPort fromUnderlyingValue(String port) {
    return lookup.get(port);
  }
}

