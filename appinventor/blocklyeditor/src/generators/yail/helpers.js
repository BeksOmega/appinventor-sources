// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2013-2014 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

Blockly.Yail['helpers_dropdown'] = function() {
  var optionList = this.workspace.getComponentDatabase()
      .getOptionList(this.key_);
  var enumConstantName = this.getFieldValue('OPTION');

  // TODO: This will be used after we add abstraction.
  // See https://www.gnu.org/software/kawa/Enumerations.html
  //var code = optionList.className + ":" + enumConstantName;

  var option = optionList.options.find(function(opt) {
    return opt.name == enumConstantName;
  });

  var code = option.value;
  if (optionList.underlyingType == "java.lang.String") {
    code = Blockly.Yail.quote_(code);
  } // Otherwise assume it doesn't need to be quoted.

  return [code, Blockly.Yail.ORDER_ATOMIC]
}
