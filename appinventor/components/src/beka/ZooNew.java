// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2018 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package beka;

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
import com.google.appinventor.components.runtime.*;
import beka.helpers.Animal;

 @DesignerComponent(version = 1,
   description = "This is my custom zoo component",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = "images/extension.png")
@SimpleObject(external = true)
public class ZooNew extends AndroidNonvisibleComponent {

  private Animal favoriteAnimal = Animal.Lion;
  private Animal dancingAnimal = null;
  private Animal runningAnimal = null;

  public ZooNew(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleProperty(
    description="The favorite animal at the zoo."
  )
  public Animal FavoriteAnimal() {
    return favoriteAnimal;
  }

  @DesignerProperty(
    editorType=PropertyTypeConstants.PROPERTY_TYPE_INTEGER,
    defaultValue="1"
  )
  @SimpleProperty
  public void FavoriteAnimal(Animal animal) {
    favoriteAnimal = animal;
  }

  @SimpleProperty
  public Animal LeastFavoriteAnimal() {
    return Animal.Dodo;
  }

  @SimpleProperty
  public Animal DancingAnimal() {
      return dancingAnimal;
  }

  @SimpleProperty
  public Animal RunningAnimal() {
      return runningAnimal;
  }

  @SimpleFunction(
    description="Make the animal dance."
  )
  public void MakeDance(Animal animal) {
  }

  @SimpleFunction
  public Animal MakeRun(Animal animal) {
    return animal;  
  }

  @SimpleEvent(
    description="An animal has just become hungry!"
  )
  public void OnHungry(Animal animal) {
    EventDispatcher.dispatchEvent(this, "OnHungry", animal);
  }
}
