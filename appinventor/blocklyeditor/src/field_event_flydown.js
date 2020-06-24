// -*- mode: java; c-basic-offset: 2; -*-
// Copyright © 2013-2016 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

/**
 * @license
 * @fileoverview Non-editable field with flydown representing a component event
 *     parameter.
 */

'use strict';

goog.provide('AI.Blockly.FieldEventFlydown');

goog.require('AI.Blockly.FieldParameterFlydown');

/**
 * Flydown field representing a component event parameter.
 * @param {!ParameterDescriptor} param The parameter this flydown is representing.
 * @param {!Blockly.ComponentDatabase} componentDb The component database the
 *     previous ParameterDescriptor is associated with.
 * @param {string} opt_displayLocation The location to display the flydown at
 *     Either: Blockly.FieldFlydown.DISPLAY_BELOW,
 *             Blockly.FieldFlydown.DISPLAY_RIGHT
 *     Defaults to DISPLAY_RIGHT.
 */
Blockly.FieldEventFlydown = function(param, componentDb, opt_displayLocation) {
    this.componentDb = componentDb;
    this.param = param;

    var name = componentDb.getInternationalizedParameterName(param.name);

    Blockly.FieldParameterFlydown.superClass_.constructor.call(
        this, name, false, opt_displayLocation);
}
goog.inherits(Blockly.FieldParameterFlydown, Blockly.FieldFlydown);
