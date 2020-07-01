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
    var type = Blockly.Blocks.Utilities.helperKeyToBlocklyType(
      { type: 'OPTION_LIST', key: this.key_ }, this);
      var dropdown = new Blockly.FieldInvalidDropdown(
          this.getValidOptions(), this.getInvalidOptions());

    this.setOutput(true, type);
    this.appendDummyInput()
        .appendField(this.key_)
        .appendField(dropdown, 'OPTION');
    
    var optionList = this.getTopWorkspace().getComponentDatabase()
        .getOptionList(this.key_);
    this.setFieldValue(optionList.defaultOpt, 'OPTION');
  },

  getValidOptions: function() {
    var optionList = this.getTopWorkspace().getComponentDatabase()
        .getOptionList(this.key_);
    var options = [];
    for (var i = 0, option; option = optionList.options[i]; i++) {
      // TODO: First will eventually be the translated name.
      if (!option.deprecated) {
        options.push([option.name, option.value]);
      }
    }
    return options;
  },

  getInvalidOptions: function() {
    var optionList = this.getTopWorkspace().getComponentDatabase()
        .getOptionList(this.key_);
    var options = [];
    for (var i = 0, option; option = optionList.options[i]; i++) {
      // TODO: First will eventually be the translated name.
      if (option.deprecated) {
        options.push([option.name, option.value]);
      }
    }
    return options;
  }
}

Blockly.Blocks['helpers_screen_names'] = {
  init: function() {
    var utils = Blockly.Blocks.Utilities;
    var dropdown = new Blockly.FieldInvalidDropdown(this.generateOptions.bind(this));

    this.setColour(Blockly.COLOUR_HELPERS);

    this.setOutput(true, utils.YailTypeToBlocklyType('text', utils.OUTPUT));
    this.appendDummyInput()
        .appendField(dropdown, 'SCREEN');
  },

  domToMutation: function(xml) {
    var value = xml.getAttribute('value');
    this.setFieldValue(value, 'SCREEN');
  },

  generateOptions: function() {
    var screens = this.workspace.getScreenList();
    return screens.map(function (elem) {
      return [elem, elem];
    });
  },

  typeblock: function() {
    var tb = [];

    var screens = Blockly.mainWorkspace.getScreenList();
    for (var i = 0, screen; (screen = screens[i]); i++) {
      tb.push({
        translatedName: Blockly.Msg.LANG_SCREENS_TITLE + screen,
        mutatorAttributes: {
          value: screen
        }
      })
    }

    return tb;
  }
}
