---
layout: documentation
title: User Interface
---

[&laquo; Back to index](index.html)
# User Interface

Table of Contents:

* [Notifier](#Notifier)
* [Screen](#Screen)
* [WebViewer](#WebViewer)

## Notifier  {#Notifier}

The Notifier component displays alert messages and creates Android log entries through
 an assortment of methods.



### Properties  {#Notifier-Properties}

{:.properties}

{:id="Notifier.BackgroundColor" .color .wo} *BackgroundColor*
: Specifies the background color for alerts (not dialogs).

{:id="Notifier.NotifierLength" .number .do} *NotifierLength*
: Specifies the length of time that the alert is shown -- either "short" or "long".

{:id="Notifier.TextColor" .color} *TextColor*
: Specifies the text color for alerts (not dialogs).

### Events  {#Notifier-Events}

{:.events}

{:id="Notifier.AfterChoosing"} AfterChoosing(*choice*{:.text})
: Event after the user has made a selection for
 [`ShowChooseDialog`](#Notifier.ShowChooseDialog).

{:id="Notifier.AfterTextInput"} AfterTextInput(*response*{:.text})
: Event raised after the user has responded to [`ShowTextDialog`](#Notifier.ShowTextDialog).

{:id="Notifier.ChoosingCanceled"} ChoosingCanceled()
: Event raised when the user cancels choosing an option.
 [`ShowChooseDialog`](#Notifier.ShowChooseDialog).

{:id="Notifier.TextInputCanceled"} TextInputCanceled()
: Event raised when the user cancels
 [`ShowChooseDialog`](#Notifier.ShowChooseDialog),
 [`ShowPasswordDialog`](#Notifier.ShowPasswordDialog), or
 [`ShowTextDialog`](#Notifier.ShowTextDialog).

### Methods  {#Notifier-Methods}

{:.methods}

{:id="Notifier.DismissProgressDialog" class="method"} <i/> DismissProgressDialog()
: Dismisses the alert created by the ShowProgressDialog block

{:id="Notifier.LogError" class="method"} <i/> LogError(*message*{:.text})
: Writes an error message to the Android system log. See the Google Android documentation for
 how to access the log.

{:id="Notifier.LogInfo" class="method"} <i/> LogInfo(*message*{:.text})
: Writes an information message to the Android log.

{:id="Notifier.LogWarning" class="method"} <i/> LogWarning(*message*{:.text})
: Writes a warning message to the Android log. See the Google Android documentation for how to
 access the log.

{:id="Notifier.ShowAlert" class="method"} <i/> ShowAlert(*notice*{:.text})
: Display a temporary notification.

{:id="Notifier.ShowChooseDialog" class="method"} <i/> ShowChooseDialog(*message*{:.text},*title*{:.text},*button1Text*{:.text},*button2Text*{:.text},*cancelable*{:.boolean})
: Shows a dialog box with two buttons, from which the user can choose. If `cancelable` is
 `true`{:.logic.block} there will be an additional CANCEL button. Pressing a button will raise
 the [`AfterChoosing`](#Notifier.AfterChoosing) event. The "choice" parameter to
 [`AfterChoosing`](#Notifier.AfterChoosing) will be the text on the button that was pressed, or "Cancel" if
 the CANCEL button was pressed. If canceled, the [`TextInputCanceled`](#Notifier.TextInputCanceled) event will also
 run.

{:id="Notifier.ShowMessageDialog" class="method"} <i/> ShowMessageDialog(*message*{:.text},*title*{:.text},*buttonText*{:.text})
: Display an alert dialog with a single button that dismisses the alert.

{:id="Notifier.ShowPasswordDialog" class="method"} <i/> ShowPasswordDialog(*message*{:.text},*title*{:.text},*cancelable*{:.boolean})
: Shows a dialog box where the user can enter password (input is masked), after which the
 [`AfterTextInput`](#Notifier.AfterTextInput) event will be raised. If `cancelable` is `true`{:.logic.block}
 there will be an additional CANCEL button. The [`AfterTextInput`](#Notifier.AfterTextInput) and
 [`TextInputCanceled`](#Notifier.TextInputCanceled) events behave the same way as described in
 [`ShowTextDialog`](#Notifier.ShowTextDialog).

{:id="Notifier.ShowProgressDialog" class="method"} <i/> ShowProgressDialog(*message*{:.text},*title*{:.text})
: Shows a dialog box with an optional title and message (use empty strings if they are not
 wanted). This dialog box contains a spinning artifact to indicate that the program is working.
 It cannot be canceled by the user but must be dismissed by the App Inventor Program by using
 the [`DismissProgressDialog`](#Notifier.DismissProgressDialog) method.

{:id="Notifier.ShowTextDialog" class="method"} <i/> ShowTextDialog(*message*{:.text},*title*{:.text},*cancelable*{:.boolean})
: Shows a dialog box where the user can enter text, after which the
 [`AfterTextInput`](#Notifier.AfterTextInput)  event will be raised. If `cancelable` is `true`{:.logic.block}
 there will be an additional CANCEL button. Entering text will raise the
 [`AfterTextInput`](#Notifier.AfterTextInput) event. The "response" parameter to
 [`AfterTextInput`](#Notifier.AfterTextInput)  will be the text that was entered, or "Cancel" if the CANCEL
 button was pressed. If canceled, the [`TextInputCanceled`](#Notifier.TextInputCanceled) event will also run.

## Screen  {#Screen}

Top-level component containing all other components in the program.



### Properties  {#Screen-Properties}

{:.properties}

{:id="Screen.AboutScreen" .text} *AboutScreen*
: Information about the screen. It appears when "About this Application" is selected from the
 system menu. Use it to tell users about your app. In multiple screen apps, each screen has its
 own `AboutScreen` info.

{:id="Screen.AccentColor" .color .do} *AccentColor*
: This is the accent color used for highlights and other user interface accents in newer
 versions of Android. Components affected by this property include dialogs created by the
 [`Notifier`](#Notifier), the [`DatePicker`](#DatePicker), and others.

{:id="Screen.AlignHorizontal" .number} *AlignHorizontal*
: A number that encodes how contents of the screen are aligned horizontally. The choices are:
 `1` (left aligned), `2` (horizontally centered), `3` (right aligned).

{:id="Screen.AlignVertical" .number} *AlignVertical*
: A number that encodes how the contents of the arrangement are aligned vertically. The choices
 are: `1` (aligned at the top), `2` (vertically centered), `3` (aligned at the bottom). Vertical
 alignment has no effect if the screen is scrollable.

{:id="Screen.AppName" .text .wo .do} *AppName*
: This is the display name of the installed application in the phone. If the `AppName` is blank,
 it will be set to the name of the project when the project is built.

{:id="Screen.BackgroundColor" .color} *BackgroundColor*
: Specifies the `Screen`'s background color as an alpha-red-green-blue
 integer.  If an [`BackgroundImage`](#Screen.BackgroundImage) has been set, the color
 change will not be visible until the [`BackgroundImage`](#Screen.BackgroundImage) is removed.

{:id="Screen.BackgroundImage" .text} *BackgroundImage*
: Specifies the path of the `Screen`'s background image. If there is both an `BackgroundImage`
 and a [`BackgroundColor`](#Screen.BackgroundColor) specified, only the `BackgroundImage` will be visible.

{:id="Screen.BlocksToolkit" .text .wo .do} *BlocksToolkit*
: A JSON string representing the subset for the screen. Authors of template apps can use this to control what components, designer properties, and blocks are available in the project.

{:id="Screen.CloseScreenAnimation" .text} *CloseScreenAnimation*
: Sets the animation type for the transition of this form closing and returning
 to a form behind it in the activity stack.

{:id="Screen.Height" .number .ro .bo} *Height*
: Returns the Screen height in pixels (y-size).

{:id="Screen.Icon" .text .wo .do} *Icon*
: The image used for your App's display icon should be a square png or jpeg image with dimensions
 up to 1024x1024 pixels. Larger images may cause compiling or installing the app to fail.
 The build server will generate images of standard dimensions for Android devices.

{:id="Screen.OpenScreenAnimation" .text} *OpenScreenAnimation*
: The animation for switching to another screen. Valid options are `default`, `fade`, `zoom`,
 `slidehorizontal`, `slidevertical`, and `none`.

{:id="Screen.Platform" .text .ro .bo} *Platform*
: Gets the name of the underlying platform running the app. Currently, this is the text
 "Android". Other platforms may be supported in the future.

{:id="Screen.PlatformVersion" .text .ro .bo} *PlatformVersion*
: Gets the version number of the platform running the app. This is typically a dotted version
 number, such as 10.0. Any value can be returned, however, so you should take care to handle
 unexpected data. If the platform version is unavailable, the empty text will be returned.

{:id="Screen.PrimaryColor" .color .do} *PrimaryColor*
: This is the primary color used as part of the Android theme, including coloring the `Screen`'s
 title bar.

{:id="Screen.PrimaryColorDark" .color .do} *PrimaryColorDark*
: This is the primary color used when the Theme property is specified to be Dark. It applies to
 a number of elements, including the `Screen`'s title bar.

{:id="Screen.ScreenOrientation" .text} *ScreenOrientation*
: Declares the requested screen orientation, specified as a text value. Commonly used values are
 `landscape`, `portrait`, `sensor`, `user` and `unspecified`. See the Android developer
 documentation for the complete list of possible
 [options](https://developer.android.com/reference/android/R.attr.html#screenOrientation).

{:id="Screen.Scrollable" .boolean} *Scrollable*
: When checked, there will be a vertical scrollbar on the screen, and the height of the
 application can exceed the physical height of the device. When unchecked, the application
 height is constrained to the height of the device.

{:id="Screen.ShowListsAsJson" .boolean .do} *ShowListsAsJson*
: If `true`{:.logic.block} (the default), lists will be shown as strings in JSON/Python notation
 for example [1, "a", true]. If `false`{:.logic.block}, lists will be shown in the LISP
 notation, for example (1 a true).

   **Note:** This property appears only in Screen1 and the value for Screen1 determines the
 behavior for all screens in the app.

{:id="Screen.ShowStatusBar" .boolean} *ShowStatusBar*
: The status bar is the topmost bar on the screen. This property reports whether the status bar
 is visible.

{:id="Screen.Sizing" .text .wo .do} *Sizing*
: If set to responsive (the default), screen layouts will use the actual resolution of the
 device. See the [documentation on responsive design](../other/responsiveDesign.html) in App
 Inventor for more information.
 If set to fixed, screen layouts will be created for a single fixed-size screen and autoscaled.

   **Note:** This property appears on Screen1 only and controls the sizing for all screens in
 the app.

{:id="Screen.Theme" .text .wo .do} *Theme*
: Selects the theme for the application. Theme can only be set at compile time and the Companion
 will approximate changes during live development. Possible options are:

   * `Classic`, which is the same as older versions of App Inventor;
   * `Device Default`, which gives the same theme as the version of Android running on the
     device and uses PrimaryColor for the Action Bar and has light buttons;
   * `Black Title Text`, which is the `Device Default` theme but with black title text; and
   * `Dark`, which is a dark version of the `Device Default` theme using `PrimaryColorDark` and
     having dark grey components.

{:id="Screen.Title" .text} *Title*
: Title property setter method: sets a new caption for the form in the
 form's title bar.

{:id="Screen.TitleVisible" .boolean} *TitleVisible*
: The title bar is the top gray bar on the screen. This property reports whether the title bar
 is visible.

{:id="Screen.TutorialURL" .text .wo .do} *TutorialURL*
: A URL which will be opened on the left side panel (which can be toggled once it is open). This
 is intended for projects that have an in-line tutorial as part of the project. For security
 reasons, only tutorials hosted on http://appinventor.mit.edu or linked to from our URL
 shortener (http://appinv.us) may be used here. Other URLs will be silently ignored.

{:id="Screen.VersionCode" .number .wo .do} *VersionCode*
: An integer value which must be incremented each time a new Android Application Package File
 (APK) is created for the Google Play Store.

{:id="Screen.VersionName" .text .wo .do} *VersionName*
: A string which can be changed to allow Google Play Store users to distinguish between
 different versions of the App.

{:id="Screen.Width" .number .ro .bo} *Width*
: Returns the Screen width in pixels (x-size).

### Events  {#Screen-Events}

{:.events}

{:id="Screen.BackPressed"} BackPressed()
: Device back button pressed.

{:id="Screen.ErrorOccurred"} ErrorOccurred(*component*{:.component},*functionName*{:.text},*errorNumber*{:.number},*message*{:.text})
: Event raised when an error occurs. Only some errors will raise this condition.  For those errors, the system will show a notification by default.  You can use this event handler to prescribe an error behavior different than the default.

{:id="Screen.Initialize"} Initialize()
: The Initialize event is run when the Screen starts and is only run once per screen.

{:id="Screen.OtherScreenClosed"} OtherScreenClosed(*otherScreenName*{:.text},*result*{:.any})
: Event raised when another screen has closed and control has returned to this screen.

{:id="Screen.PermissionDenied"} PermissionDenied(*component*{:.component},*functionName*{:.text},*permissionName*{:.text})
: Event to handle when the app user has denied a needed permission.

{:id="Screen.PermissionGranted"} PermissionGranted(*permissionName*{:.text})
: Event to handle when the app user has granted a needed permission. This event is only run when permission is
 granted in response to the [`AskForPermission`](#Screen.AskForPermission) method.

{:id="Screen.ScreenOrientationChanged"} ScreenOrientationChanged()
: Screen orientation changed

### Methods  {#Screen-Methods}

{:.methods}

{:id="Screen.AskForPermission" class="method"} <i/> AskForPermission(*permissionName*{:.text})
: Ask the user to grant access to a sensitive permission, such as `ACCESS_FINE_LOCATION`. This
 block is typically used as part of a [`PermissionDenied`](#Screen.PermissionDenied)
 event to ask for permission. If the user grants permission, the
 [`PermissionGranted`](#Screen.PermissionGranted) event will be run. If the user denies permission, the
 [`PermissionDenied`](#Screen.PermissionDenied) event will be run.

   **Note:** It is a best practice to only ask for permissions at the time they are needed,
 which App Inventor components will do when necessary. You should not use `AskForPermission`
 in your [`Initialize`](#Screen.Initialize) event unless access to that permission is critical to the
 behavior of your app and is needed up front, such as location services for a navigation app.

{:id="Screen.HideKeyboard" class="method"} <i/> HideKeyboard()
: Hide the soft keyboard

## WebViewer  {#WebViewer}

Component for viewing Web pages.

 ![WebViewer icon](images/webviewer.png)

 The [`HomeUrl`](#WebViewer.HomeUrl) can be specified in the Designer or in the Blocks Editor. The view can be
 set to follow links when they are tapped, and users can fill in Web forms.

 **Warning:** This is not a full browser. For example, pressing the phone's hardware Back key
 will exit the app, rather than move back in the browser history.

 You can use the [`WebViewString`](#WebViewer.WebViewString) property to communicate between your app and
 Javascript code running in the `WebViewer` page. In the app, you get and set
 [`WebViewString`](#WebViewer.WebViewString) to "hello", then the web page will show
 ```
 The answer is hello.
 ```
 And if the Web page contains Javascript that executes the command
 ```javascript
 windowAppInventor.setWebViewString("hello from Javascript"),
 ```
 then the value of the [`WebViewString`](#WebViewer.WebViewString) property will be
 ```
 hello from Javascript.
 ```
 Calling `setWebViewString` from JavaScript will also run the [`WebViewStringChange`](#WebViewer.WebViewStringChange)
 event so that the blocks can handle when the [`WebViewString`](#WebViewer.WebViewString) property changes.



### Properties  {#WebViewer-Properties}

{:.properties}

{:id="WebViewer.CurrentPageTitle" .text .ro .bo} *CurrentPageTitle*
: Returns the title of the page currently being viewed

{:id="WebViewer.CurrentUrl" .text .ro .bo} *CurrentUrl*
: Returns the URL currently being viewed. This could be different from the [`HomeUrl`](#WebViewer.HomeUrl)
 if new pages were visited by following links.

{:id="WebViewer.FollowLinks" .boolean} *FollowLinks*
: Determines whether to follow links when they are tapped in the `WebViewer`. If you follow
 links, you can use [`GoBack`](#WebViewer.GoBack) and [`GoForward`](#WebViewer.GoForward) to navigate the browser history.

{:id="WebViewer.Height" .number .bo} *Height*
: Specifies the `WebViewer`'s vertical height, measured in pixels.

{:id="WebViewer.HeightPercent" .number .wo .bo} *HeightPercent*
: Specifies the `WebViewer`'s vertical height as a percentage
 of the [`Screen`'s `Height`](userinterface.html#Screen.Height).

{:id="WebViewer.HomeUrl" .text} *HomeUrl*
: Specifies the URL of the page the `WebViewer` should initially open to. Setting this will
 load the page.

{:id="WebViewer.IgnoreSslErrors" .boolean} *IgnoreSslErrors*
: Determine whether or not to ignore SSL errors. Set to `true`{:.logic.block} to ignore errors.
 Use this to accept self signed certificates from websites.

{:id="WebViewer.PromptforPermission" .boolean} *PromptforPermission*
: Determine if the user should be prompted for permission to use the geolocation API while in
 the `WebViewer`. If `true`{:.logic.block}, prompt the user of the `WebViewer` to give
 permission to access the geolocation API. If `false`{:.logic.block}, assume permission is
 granted.

{:id="WebViewer.UsesLocation" .boolean .wo .do} *UsesLocation*
: Specifies whether or not this `WebViewer` can access the JavaScript
 geolocation API.

{:id="WebViewer.Visible" .boolean} *Visible*
: Specifies whether the `WebViewer` should be visible on the screen.  Value is `true`{:.logic.block}
 if the `WebViewer` is showing and `false`{:.logic.block} if hidden.

{:id="WebViewer.WebViewString" .text .bo} *WebViewString*
: Gets the `WebView`'s String, which is viewable through Javascript in the `WebView` as the
 `window.AppInventor` object.

{:id="WebViewer.Width" .number .bo} *Width*
: Specifies the horizontal width of the `WebViewer`, measured in pixels.

{:id="WebViewer.WidthPercent" .number .wo .bo} *WidthPercent*
: Specifies the horizontal width of the `WebViewer` as a percentage
 of the [`Screen`'s `Width`](userinterface.html#Screen.Width).

### Events  {#WebViewer-Events}

{:.events}

{:id="WebViewer.BeforePageLoad"} BeforePageLoad(*url*{:.text})
: When a page is about to load this event is run.

{:id="WebViewer.ErrorOccurred"} ErrorOccurred(*errorCode*{:.number},*description*{:.text},*failingUrl*{:.text})
: When an error occurs this event is run.

{:id="WebViewer.PageLoaded"} PageLoaded(*url*{:.text})
: When a page is finished loading this event is run.

{:id="WebViewer.WebViewStringChange"} WebViewStringChange(*value*{:.text})
: Event that runs when the `AppInventor.setWebViewString` method is called from JavaScript.
 The new [`WebViewString`](#WebViewer.WebViewString) is given by the `value`{:.variable.block} parameter.

### Methods  {#WebViewer-Methods}

{:.methods}

{:id="WebViewer.CanGoBack" class="method returns boolean"} <i/> CanGoBack()
: Returns true if the WebViewer can go back in the history list.

{:id="WebViewer.CanGoForward" class="method returns boolean"} <i/> CanGoForward()
: Returns true if the WebViewer can go forward in the history list.

{:id="WebViewer.ClearCaches" class="method"} <i/> ClearCaches()
: Clear the internal webview cache, both ram and disk. This is useful
 when using the `WebViewer` to poll a page that may not be sending
 appropriate cache control headers.

{:id="WebViewer.ClearCookies" class="method"} <i/> ClearCookies()
: Clear the webview's cookies. This is useful if you want to
 sign the user out of a website that uses them to store logins.

{:id="WebViewer.ClearLocations" class="method"} <i/> ClearLocations()
: Clear Stored Location permissions. When the geolocation API is used in
 the `WebViewer`, the end user is prompted on a per URL basis for whether
 or not permission should be granted to access their location. This
 function clears this information for all locations.

  As the permissions interface is not available on phones older then
  Eclair, this function is a no-op on older phones.

{:id="WebViewer.GoBack" class="method"} <i/> GoBack()
: Go back to the previous page in the history list. Does nothing if there is no previous page.

{:id="WebViewer.GoForward" class="method"} <i/> GoForward()
: Go forward to the next page in the history list. Does nothing if there is no next page.

{:id="WebViewer.GoHome" class="method"} <i/> GoHome()
: Loads the  page from the home URL.  This happens automatically when
 home URL is changed.

{:id="WebViewer.GoToUrl" class="method"} <i/> GoToUrl(*url*{:.text})
: Load the page at the given URL.

{:id="WebViewer.Reload" class="method"} <i/> Reload()
: Reload the current page.

{:id="WebViewer.RunJavaScript" class="method"} <i/> RunJavaScript(*js*{:.text})
: Run JavaScript in the current page.

{:id="WebViewer.StopLoading" class="method"} <i/> StopLoading()
: Stop loading a page.
