// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
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
    this.setColour(Blockly.COLOUR_HELPERS);
    // Everything else gets handled by domToMutaiton.
  },
 
  mutationToDom: function() {
    var mutation = document.createElement('mutation');
    mutation.setAttribute('key', this.key_);
    return mutation;
  },

  domToMutation: function(xml) {
    this.key_ = xml.getAttribute('key');

    var db = this.getTopWorkspace().getComponentDatabase();
    var optionList = db.getOptionList(this.key_);
    var tag = db.getInternationalizedOptionListTag(optionList.tag);
    var dropdown = new Blockly.FieldInvalidDropdown(
        this.getValidOptions(), this.getInvalidOptions());

    // Setting the output check to be the OptionList type only allows this block
    // to connect to inputs which expect its specific type of enum. Currently
    // this is only used for Blockly connection checks, as no output types are
    // encoded in Yail.
    this.setOutput(true, this.getOutputType());
    this.appendDummyInput()
        .appendField(tag)
        .appendField(dropdown, 'OPTION');
    
    var value = xml.getAttribute('value') || optionList.defaultOpt;
    this.setFieldValue(value, 'OPTION');
  },

  getOutputType: function() {
    var check = [];
    var blocklyType = Blockly.Blocks.Utilities.YailTypeToBlocklyType(
        'enum', Blockly.Blocks.Utilities.OUTPUT);
    if (blocklyType) {
      if (Array.isArray(blocklyType)) {
        // Clone array.
        check = blocklyType.slice();
      } else {
        check.push(blocklyType);
      }
    }

    var helperType = Blockly.Blocks.Utilities.helperKeyToBlocklyType(
      { type: 'OPTION_LIST', key: this.key_ }, this);
    if (helperType && helperType != blocklyType) {
      check.push(helperType);
    }

    return !check.length ? null : check;
  },

  /**
   * Returns a list of tuples defining the valid dropdown values. The first
   * element in the tuple is the human readable name. The second element is the
   * language neutral value.
   */
  getValidOptions: function() {
    var db = this.getTopWorkspace().getComponentDatabase();
    var optionList = db.getOptionList(this.key_);
    var options = [];
    for (var i = 0, option; option = optionList.options[i]; i++) {
      var key = optionList.tag + option.name;
      var i18nName = db.getInternationalizedOptionName(key, option.name);
      if (!option.deprecated) {
        options.push([i18nName, option.name]);
      }
    }
    return options;
  },

  /**
   * Returns a list of tuples defining the /invalid/ dropdown values. The first
   * element in the tuple is the human readable name. The second element is the
   * language neutral value.
   */
  getInvalidOptions: function() {
    var db = this.getTopWorkspace().getComponentDatabase();
    var optionList = db.getOptionList(this.key_);
    var options = [];
    for (var i = 0, option; option = optionList.options[i]; i++) {
      var key = optionList.tag + option.name;
      var i18nName = db.getInternationalizedOptionName(key, option.name);
      if (option.deprecated) {
        options.push([i18nName, option.name]);
      }
    }
    return options;
  },

  typeblock: function() {
    var db = Blockly.mainWorkspace.getComponentDatabase();
    var tb = [];

    db.forEachOptionList(function(optionList) {
      for (var i = 0, option; option = optionList.options[i]; i++) {
        var tag = db.getInternationalizedOptionListTag(optionList.tag);
        var key = optionList.tag + option.name;
        var i18nName = db.getInternationalizedOptionName(key, option.name);
        tb.push({
          // TODO: This doesn't handle rtl langs, anyway to fix that?
          translatedName: tag + i18nName,
          mutatorAttributes: {
            key: optionList.tag,
            value: option.name
          }
        });
      }
    });

    return tb;
  }
}

Blockly.Blocks['helpers_screen_names'] = {
  init: function() {
    var utils = Blockly.Blocks.Utilities;
    var dropdown = new Blockly.FieldInvalidDropdown(
        this.generateOptions.bind(this));

    this.setColour(Blockly.COLOUR_HELPERS);

    this.setOutput(true, utils.YailTypeToBlocklyType('text', utils.OUTPUT));
    this.appendDummyInput()
        .appendField(dropdown, 'SCREEN');
  },

  domToMutation: function(xml) {
    var value = xml.getAttribute('value');
    this.setFieldValue(value, 'SCREEN');
  },

  getScreens: function() {
    return Blockly.mainWorkspace.getScreenList();
  },

  generateOptions: function() {
    if (!this.workspace) {
      return [['', '']]
    }
    var screens = this.getScreens();
    if (!screens.length) {
      return [['', '']]
    }
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
