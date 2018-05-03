var reactNative = require('react-native');

reactNative.NativeModules.MediaPlayer = {
  playMusic: jest.fn()
};

module.exports = reactNative;
