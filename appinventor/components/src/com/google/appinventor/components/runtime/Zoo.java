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
public class Zoo extends AndroidNonvisibleComponent {

  private Animal favoriteAnimal = Animal.Lion;

  public Zoo(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleProperty(
    description="The favorite animal at the zoo."
  )
  /**
   * Get the zoo's favorite animal.
   */
  public Animal FavoriteAnimal() {
    return favoriteAnimal;
  }

  /*@DesignerProperty(
    editorType=PropertyTypeConstants.PROPERTY_TYPE_INTEGER,
    defaultValue="1"
  )
  @SimpleProperty
  *//**
   * Set the given animal as the zoo's favorite.
   */
  /*public void FavoriteAnimal(Animal animal) {
    //favoriteAnimal = animal;
  }*/

  @SimpleFunction(
    description="Make the animal dance."
  )
  /**
   * Make the given animal dance.
   */
  public @Options(Animal.class) String MakeDance(/* @Options(Animal.class) int animal */) {
    return favoriteAnimal.getValue();
  }

  @SimpleEvent(
    description="An animal has just become hungry!"
  )
  /**
   * Fired when an animal is hungry.
   */
  public void OnHungry(Animal animal) {
    EventDispatcher.dispatchEvent(this, "OnHungry", animal);
  }
}

/* @DesignerComponent(version = 1,
   description = "This is my custom zoo component",
   category = ComponentCategory.EXTENSION,
   nonVisible = true,
   iconName = "images/extension.png")
@SimpleObject(external = true)
public class Zoo extends AndroidNonvisibleComponent {

  private int favoriteAnimal = 0;

  public Zoo(ComponentContainer container) {
    super(container.$form());
  }

  @SimpleProperty(
    description="The favorite animal at the zoo."
  )
  *//**
   * Get the zoo's favorite animal.
   *//*
  public int FavoriteAnimal() {
    return favoriteAnimal;
  }

  @DesignerProperty(
    editorType=PropertyTypeConstants.PROPERTY_TYPE_INTEGER,
    defaultValue="1"
  )
  @SimpleProperty
  *//**
   * Set the given animal as the zoo's favorite.
   *//*
  public void FavoriteAnimal(@Options(Animal.class) int animal) {
    favoriteAnimal = animal;
  }

  @SimpleFunction(
    description="Make the animal dance."
  )
  *//**
   * Make the given animal dance.
   *//*
  public void MakeDance(@Options(Animal.class) int animal) {

  }

  @SimpleEvent(
    description="An animal has just become hungry!"
  )
  *//**
   * Fired when an animal is hungry.
   *//*
  public void OnHungry(@Options(Animal.class) int animal) {
    EventDispatcher.dispatchEvent(this, "OnHungry", animal);
  }
}*/