
// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2018 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime;

import android.os.Build;
import android.support.v4.content.FileProvider;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.Options;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.common.Animal;

 @DesignerComponent(version = 1,
   description = "This is my custom zoo component",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = "images/extension.png")
@SimpleObject(external = true)
public class ZooOld extends AndroidNonvisibleComponent {

  private String favoriteAnimal = "lion";
  private String dancingAnimal = null;
  private String runningAnimal = null;

  public ZooOld(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleProperty(
    description="The favorite animal at the zoo."
  )
  public @Options(Animal.class) String FavoriteAnimal() {
    return favoriteAnimal;
  }

  @DesignerProperty(
    editorType=PropertyTypeConstants.PROPERTY_TYPE_INTEGER,
    defaultValue="1"
  )
  @SimpleProperty
  public void FavoriteAnimal(@Options(Animal.class) String animal) {
    favoriteAnimal = animal;
  }

  @SimpleProperty
  public @Options(Animal.class) String LeastFavoriteAnimal() {
    return "dodo";
  }

  @SimpleProperty
  public @Options(Animal.class) String DancingAnimal() {
      return dancingAnimal;
  }

  @SimpleProperty
  public @Options(Animal.class) String RunningAnimal() {
      return runningAnimal;
  }

  @SimpleFunction(
    description="Make the animal dance."
  )
  public void MakeDance(@Options(Animal.class) String animal) {
      dancingAnimal = animal;
  }

  @SimpleFunction
  public @Options(Animal.class) String MakeRun(@Options(Animal.class) String animal) {
    runningAnimal = animal;
    return animal;  
  }

  @SimpleEvent(
    description="An animal has just become hungry!"
  )
  public void OnHungry(@Options(Animal.class) String animal) {
    EventDispatcher.dispatchEvent(this, "OnHungry", animal);
  }
}
