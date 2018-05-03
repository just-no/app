package com.just.mediaplayer;

import android.media.MediaPlayer;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.net.Uri;

public class MediaPlayerModule extends ReactContextBaseJavaModule {

  public MediaPlayerModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return "MediaPlayer";
  }

@ReactMethod
public void playMusic(String path) {
  Uri musicUri = Uri.parse(path);
  MediaPlayer player = MediaPlayer.create(getReactApplicationContext(), musicUri);
  player.start();
}

}
