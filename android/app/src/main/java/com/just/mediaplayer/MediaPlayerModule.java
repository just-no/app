package com.just.mediaplayer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

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
  public void playMusic(String path, final Callback cb) {

    Uri musicUri = Uri.parse(path);

    MediaPlayer player = MediaPlayer.create(getReactApplicationContext(), musicUri);
    player.setOnCompletionListener(new OnCompletionListener() {

      @Override
      public synchronized void onCompletion(MediaPlayer mp) {
          cb.invoke(true);
          mp.release();
      }
    });
    player.start();
  }

}
