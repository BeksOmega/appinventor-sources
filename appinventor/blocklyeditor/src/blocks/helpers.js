// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2013-2014 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0


/**
 * @license
 * @fileoverview Helper block definitions. These are created based on the
 *     component database, and are meant to be connected to component
 *     method/setter inputs to make coding faster for users.
 */

'use strict';

goog.provide('Blockly.Blocks.helpers');

goog.require('Blockly.Blocks.Utilities');

Blockly.COLOUR_HELPERS = "#BF4343";

/*Blockly.Blocks['helper'] = {
  // Numeric value.
  category: 'Math',
  helpUrl: Blockly.Msg.LANG_MATH_NUMBER_HELPURL,
  init: function () {
    this.setColour(Blockly.COLOUR_HELPERS);
    this.appendDummyInput().appendField(
        new Blockly.FieldTextInput('0', Blockly.Blocks.math_number.validator), 'NUM');
    this.setOutput(true, Blockly.Blocks.Utilities.YailTypeToBlocklyType("number", Blockly.Blocks.Utilities.OUTPUT));
    this.setTooltip(Blockly.Msg.LANG_MATH_NUMBER_TOOLTIP);
  },
  typeblock: [{translatedName: Blockly.Msg.LANG_MATH_MUTATOR_ITEM_INPUT_NUMBER}]
};*/

Blockly.Blocks['helpers_dropdown'] = {
  init: function() {
    /**
     * The key to the OptionList associated with this block.
     * @private
     */
    this.key_ = "";

    // TODO: Do we want to do anything for tooltips on this guy?
    this.setColour(Blockly.COLOUR_HELPERS);
    // Everything else gets hander by domToMutaiton.
  },
 
  mutationToDom: function() {
    var mutation = document.createElement('mutation');
    mutation.setAttribute('key', this.key_);
    return mutation;
  },

  domToMutation: function(xml) {
    this.key_ = xml.getAttribute('key');
    this.setOutput(true, this.key_ + 'Enum');
    this.appendDummyInput()
        .appendField(this.key_)
        .appendField(new Blockly.FieldDropdown(this.getDropdownData()));
  },

  getDropdownData: function() {
    var optionList = this.workspace.getComponentDatabase()
        .getOptionList(this.key_);
    var options = [];
    for (var i = 0, option; option = optionList.options[i]; i++) {
      var value = option[0];
      var details = option[1];
      options.push([details.name, value]);
    }
    return options;
  }
}
