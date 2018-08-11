# full-screen-image-view-library
This is an library to help developer faster on view an image full screen which has some guesture like: double tap to zoom, span, zoom in/out, move.

![FullScreenImageViewGIF](https://i.makeagif.com/media/8-11-2018/hGL9hR.gif)

# Setup
1. Add to build.gradle in app level
```
implementation 'com.github.tntkhang:full-screen-image-view-library:1.0.0'
```


3. Init the PreferencesHelper in your CustomApplication.java extend from Application with 2 ways:
   
   - Will use app name as of Preferences file name ```PreferencesHelper.initHelper(this);```
   
   - Will use ```CustomName``` as the name of SharePreferences file ```PreferencesHelper.initHelper(this, "CustomName");```
   
3. How to use
Call open a FullScreenImageViewActivity whenever need open it in full screen
```
Intent fullImageIntent = new Intent(MainActivity.this, FullScreenImageViewActivity.class);
// uriString is an ArrayList<String> of URIs of all images
fullImageIntent.putExtra(FullScreenImageViewActivity.URI_LIST_DATA, uriString);
// pos is the position of image will be showned when open
fullImageIntent.putExtra(FullScreenImageViewActivity.IMAGE_FULL_SCREEN_CURRENT_POS, pos);
startActivity(fullImageIntent);
```
