// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2013-2014 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

Blockly.Yail['helpers_dropdown'] = function() {
  var optionList = this.workspace.getComponentDatabase()
      .getOptionList(this.key_);
  // See https://www.gnu.org/software/kawa/Enumerations.html
  var code = optionList.className + ":" +
      this.getFieldValue('OPTION');
  return [code, Blockly.Yail.ORDER_ATOMIC]
}
