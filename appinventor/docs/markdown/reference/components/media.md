---
layout: documentation
title: Media
---

[&laquo; Back to index](index.html)
# Media

Table of Contents:

* [Player](#Player)
* [VideoPlayer](#VideoPlayer)

## Player  {#Player}

Multimedia component that plays audio and controls phone vibration. The name of a multimedia
 file is specified in the [`Source`](#Player.Source) property, which can be set in the Designer or
 in the Blocks Editor. The length of time for a vibration is specified in the Blocks Editor in
 milliseconds (thousandths of a second).

 For supported audio formats, see
 [Android Supported Media Formats](//developer.android.com/guide/appendix/media-formats.html).

 This component is best for long sound files, such as songs, while the [`Sound`](#Sound) component is
 more efficient for short files, such as sound effects.



### Properties  {#Player-Properties}

{:.properties}

{:id="Player.IsPlaying" .boolean .ro .bo} *IsPlaying*
: Reports whether the media is playing.

{:id="Player.Loop" .boolean} *Loop*
: If true, the `Player` will loop when it plays. Setting `Loop` while the player is playing will
 affect the current playing.

{:id="Player.PlayOnlyInForeground" .boolean} *PlayOnlyInForeground*
: If true, the `Player` will pause playing when leaving the current screen; if false
 (default option), the `Player` continues playing whenever the current screen is displaying or
 not.

{:id="Player.Source" .text} *Source*
: Sets the audio source.

{:id="Player.Volume" .number .wo} *Volume*
: Sets the volume property to a number between 0 and 100.

### Events  {#Player-Events}

{:.events}

{:id="Player.Completed"} Completed()
: Indicates that the media has reached the end

{:id="Player.OtherPlayerStarted"} OtherPlayerStarted()
: This event is signaled when another player has started (and the current player is playing or
 paused, but not stopped).

### Methods  {#Player-Methods}

{:.methods}

{:id="Player.Pause" class="method"} <i/> Pause()
: Suspends playing the media if it is playing.

{:id="Player.Start" class="method"} <i/> Start()
: Plays the media.  If it was previously paused, the playing is resumed.
 If it was previously stopped, it starts from the beginning.

{:id="Player.Stop" class="method"} <i/> Stop()
: Stops playing the media and seeks to the beginning of the song.

{:id="Player.Vibrate" class="method"} <i/> Vibrate(*milliseconds*{:.number})
: Vibrates for specified number of milliseconds.

## VideoPlayer  {#VideoPlayer}

A multimedia component capable of playing videos. When the application is run, the `VideoPlayer`
 will be displayed as a rectangle on-screen. If the user touches the rectangle, controls will
 appear to play/pause, skip ahead, and skip backward within the video. The application can also
 control behavior by calling the [`Start`](#VideoPlayer.Start), [`Pause`](#VideoPlayer.Pause), and [`SeekTo`](#VideoPlayer.SeekTo)
 methods.

 Video files should be in 3GPP (.3gp) or MPEG-4 (.mp4) formats. For more details about legal
 formats, see
 [Android Supported Media Formats](//developer.android.com/guide/appendix/media-formats.html).

 App Inventor only permits video files under 1 MB and limits the total size of an application to
 5 MB, not all of which is available for media (video, audio, and sound) files. If your media
 files are too large, you may get errors when packaging or installing your application, in which
 case you should reduce the number of media files or their sizes. Most video editing software,
 such as Windows Movie Maker and Apple iMovie, can help you decrease the size of videos by
 shortening them or re-encoding the video into a more compact format.

 You can also set the media source to a URL that points to a streaming video, but the URL must
 point to the video file itself, not to a program that plays the video.



### Properties  {#VideoPlayer-Properties}

{:.properties}

{:id="VideoPlayer.FullScreen" .boolean .bo} *FullScreen*
: Sets whether the video should be shown in fullscreen or not.

{:id="VideoPlayer.Height" .number .bo} *Height*
: Specifies the component's vertical height, measured in pixels.

{:id="VideoPlayer.HeightPercent" .number .wo .bo} *HeightPercent*
: Specifies the `VideoPlayer`'s vertical height as a percentage
 of the [`Screen`'s `Height`](userinterface.html#Screen.Height).

{:id="VideoPlayer.Source" .text .wo} *Source*
: Sets the "path" to the video. Usually, this will be the name of the video file, which should be
 added in the Designer.

{:id="VideoPlayer.Visible" .boolean} *Visible*
: Specifies whether the `VideoPlayer` should be visible on the screen.  Value is `true`{:.logic.block}
 if the `VideoPlayer` is showing and `false`{:.logic.block} if hidden.

{:id="VideoPlayer.Volume" .number .wo} *Volume*
: Sets the volume property to a number between 0 and 100. Values less than 0
 will be treated as 0, and values greater than 100 will be treated as 100.

{:id="VideoPlayer.Width" .number .bo} *Width*
: Specifies the component's horizontal width, measured in pixels.

{:id="VideoPlayer.WidthPercent" .number .wo .bo} *WidthPercent*
: Specifies the horizontal width of the `VideoPlayer` as a percentage
 of the [`Screen`'s `Width`](userinterface.html#Screen.Width).

### Events  {#VideoPlayer-Events}

{:.events}

{:id="VideoPlayer.Completed"} Completed()
: Indicates that the video has reached the end

### Methods  {#VideoPlayer-Methods}

{:.methods}

{:id="VideoPlayer.GetDuration" class="method returns number"} <i/> GetDuration()
: Returns duration of the video in milliseconds.

{:id="VideoPlayer.Pause" class="method"} <i/> Pause()
: Pauses playback of the video.  Playback can be resumed at the same location by calling the
 [`Start`](#VideoPlayer.Start) method.

{:id="VideoPlayer.SeekTo" class="method"} <i/> SeekTo(*ms*{:.number})
: Seeks to the requested time (specified in milliseconds) in the video. If the video is paused, the frame shown will not be updated by the seek. The player can jump only to key frames in the video, so seeking to times that differ by short intervals may not actually move to different frames.

{:id="VideoPlayer.Start" class="method"} <i/> Start()
: Plays the media specified by the [`Source`](#VideoPlayer.Source).

{:id="VideoPlayer.Stop" class="method"} <i/> Stop()
: Resets to start of video and pauses it if video was playing.
