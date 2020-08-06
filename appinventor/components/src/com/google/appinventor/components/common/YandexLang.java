// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2020 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.components.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines a YandexLang type used by the YandexTranslate component. The values
 * are ISO 639-1 (sometimes 639-2) codes.
 */
public enum YandexLang implements OptionList<String> {
  Afrikaans("af"),
  Albanian("sq"),
  Amharic("am"),
  Arabic("ar"),
  Armenian("hy"),
  Azerbaijani("az"),
  Bashkir("ba"),
  Basque("eu"),
  Belarusian("be"),
  Bengali("bn"),
  Bosnian("bs"),
  Bulgarian("bg"),
  Burmese("my"),
  Catalan("ca"),
  Cebuano("ceb"), // Only ISO 639-2
  Chinese("zh"),
  Chuvash("cv"),
  Croatian("hr"),
  Czech("cs"),
  Danish("da"),
  Dutch("nl"),
  English("en"),
  Esperanto("eo"),
  Estonian("et"),
  Farsi("fa"),
  Finnish("fi"),
  French("fr"),
  Galician("gl"),
  Georgian("ka"),
  German("de"),
  Greek("el"),
  Gujarati("gu"),
  Haitian("ht"),
  Hebrew("he"),
  HillMari("mrj"), // Only ISO 639-2
  Hindi("hi"),
  Hungarian("hu"),
  Icelandic("is"),
  Indonesian("id"),
  Irish("ga"),
  Italian("it"),
  Japanese("ja"),
  Javanese("jv"),
  Kannada("kn"),
  Kazakh("kk"),
  Khmer("km"),
  Korean("ko"),
  Kyrgyz("ky"),
  Lao("lo"),
  Latin("la"),
  Latvian("lv"),
  Lithuanian("lt"),
  Luxembourgish("lb"),
  Macedonian("mk"),
  Malagasy("mg"),
  Malay("ms"),
  Malayalam("ml"),
  Maltese("mt"),
  Maori("mi"),
  Marathi("mr"),
  Mongolian("mn"),
  Nepali("ne"),
  Norwegian("no"),
  Papiamento("pap"), // Only ISO 639-2
  Polish("pl"),
  Portuguese("pt"),
  Punjabi("pa"),
  Romanian("ro"),
  Russian("ru"),
  ScottishGaelic("gd"),
  Serbian("sr"),
  Sinhalese("si"),
  Slovak("sk"),
  Slovenian("sl"),
  Spanish("es"),
  Sundanese("su"),
  Swahili("sw"),
  Swedish("sv"),
  Tagalog("tl"),
  Tajik("tg"),
  Tamil("ta"),
  Tatar("tt"),
  Telugu("te"),
  Thai("th"),
  Turkish("tr"),
  Udmurt("udm"), // Only ISO 639-2
  Ukrainian("uk"),
  Urdu("ur"),
  Uzbek("uz"),
  Vietnamese("vi"),
  Welsh("cy"),
  Xhosa("xh"),
  Yiddish("yi");

  private String value;

  YandexLang(String langCode) {
    this.value = langCode;
  }

  public String toUnderlyingValue() {
    return value;
  }

  private static final Map<String, YandexLang> lookup = new HashMap<>();

  static {
    for(YandexLang langCode : YandexLang.values()) {
      lookup.put(langCode.toUnderlyingValue(), langCode);
    }
  }

  public static YandexLang fromUnderlyingValue(String langCode) {
    return lookup.get(langCode);
  }
}
