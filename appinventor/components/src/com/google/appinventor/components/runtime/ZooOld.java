
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

  @SimpleProperty()
  public String FavoriteAnimal() {
    return favoriteAnimal;
  }

  @SimpleProperty
  public void FavoriteAnimal(String animal) {
    favoriteAnimal = animal;
  }

  @SimpleProperty
  public Animal FavoriteAnimalOptions() {
      return Animal.Lion;
  }

  @SimpleProperty
  public void FavoriteAnimalOptions(Animal animal) { }

  @SimpleProperty
  public String LeastFavoriteAnimal() {
    return "dodo";
  }

  @SimpleProperty
  public String DancingAnimal() {
      return dancingAnimal;
  }

  @SimpleProperty
  public String RunningAnimal() {
      return runningAnimal;
  }

  @SimpleFunction(
    description="Make the animal dance."
  )
  public void MakeDance(String animal) {
      dancingAnimal = animal;
  }

  @SimpleFunction
  public String MakeRun(String animal) {
    runningAnimal = animal;
    return animal;  
  }

  @SimpleFunction
  public String MakeRunOptions(Animal animal) {
      return "lion";
  }

  @SimpleEvent(
    description="An animal has just become hungry!"
  )
  public void OnHungry(String animal) {
    EventDispatcher.dispatchEvent(this, "OnHungry", animal);
  }

  @SimpleEvent
  public void OnHungryOptions(Animal animal) {

  }
}