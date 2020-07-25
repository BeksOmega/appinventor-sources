
// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.annotations.Options;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import android.util.Log;

public class OptionHelper {
  private static final String TAG = "OptionHelper";

  public static Object optionListFromValue(Component c, String func, Object value, Object...args) {
    try {
      Method calledFunc = c.getClass().getMethod(func, argsToClasses(args));
      Options annotation = calledFunc.getAnnotation(Options.class);
      if (annotation == null) {
        return value;
      }
      Class<?> optionListClass = annotation.value();
      Method fromValue = optionListClass.getMethod("get", Object.class);
      return fromValue.invoke(optionListClass, value);
    } catch (NoSuchMethodException e) {
      return value;
    } catch (IllegalAccessException e) {
      return value;
    } catch (InvocationTargetException e) {
      return value;
    }
  }

  public static Object[] optionListsFromValues(Component c, String func, Object...args) {
    if (args.length == 0) {
      return args;
    }
    Log.d(TAG, "called optionListsFromValues. func: " + func);
    try {
      Method calledFunc = c.getClass().getMethod(func, argsToClasses(args));
      Log.d(TAG, "got function");
      Annotation[][] paramAnnotations = calledFunc.getParameterAnnotations();
      Log.d(TAG, "got annotations: " + paramAnnotations.length);
      int i = 0;
      for (Annotation[] annotations : paramAnnotations) {
        for (Annotation annotation : annotations) {
          Log.d(TAG, "has annotation: " + annotation);
          if (annotation.annotationType() == Options.class) {
            Log.d(TAG, "annotation is of type Options");
            Options castAnnotation = (Options) annotation;
            Class<?> optionListClass = castAnnotation.value();
            Log.d(TAG, "got option list class");
            Method fromValue = optionListClass.getMethod("get", Object.class);
            Log.d(TAG, "got get method");
            Log.d(TAG, "invoking method: "+ fromValue.invoke(optionListClass, args[i]));
            args[i] = fromValue.invoke(optionListClass, args[i]);
            break;
          }
        }
        i++;
      }
    } catch (NoSuchMethodException e) {
      Log.d(TAG, "couldn't get method");
      Log.d(TAG, e.toString());
    } catch (IllegalAccessException e) {
      Log.d(TAG, "illegal access");
    } catch (InvocationTargetException e) {
      Log.d(TAG, "badd invocation target");
    } finally {
      return args;
    }
  }

  private static Class[] argsToClasses(Object...args) {
    Class[] classes = new Class[args.length];
    for (int i = 0; i < args.length; i++) {
      if (args[i] == null) {
        return null;
      }
      classes[i] = args[i].getClass();
      Log.d(TAG, "arg type: " + classes[i].getSimpleName());
    }
    return classes;
  }
}