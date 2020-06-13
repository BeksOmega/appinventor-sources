// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2013-2014 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

Blockly.Yail['helpers_dropdown'] = function(block) {
  var optionList = block.workspace.getComponentDatabase()
      .getOptionList(block.key_);
  //var code = optionList.className + ":" +
      //block.getFieldValue('OPTION');
  var code = "com.google.appinventor.components.runtime.Component:TYPEFACE_MONOSPACE";
  return [code, Blockly.Yail.ORDER_ATOMIC]
}
