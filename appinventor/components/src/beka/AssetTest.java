
// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2018 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package beka;

import android.os.Build;
import android.support.v4.content.FileProvider;
import com.google.appinventor.components.annotations.Asset;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.*;
import beka.helpers.Animal;

 @DesignerComponent(version = 1,
   description = "This is my custom zoo component",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = "images/extension.png")
@SimpleObject(external = true)
public class AssetTest extends AndroidNonvisibleComponent {

  public AssetTest(ComponentContainer container) {
    super(container.$form());
  }

  private String picPath;

  @SimpleProperty
  public void Picture(@Asset({".png", ".jpeg", ".jpg"}) String picturePath) {
    picPath = picturePath;
  }
  
  @SimpleFunction
  public void FadeInAudio(
    @Asset({".mp3", ".wav"}) String audioPath,
    float secs
  ) {
    // Fade in the given audio file in the given number of seconds.
  }

  @SimpleFunction
  public int GetFileSize(@Asset String assetPath) {
    // Return the file size of the given asset.
    return 1;
  }

}
