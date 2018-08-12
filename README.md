# full-screen-image-view-library
This is a library to help developer faster on view an image full screen which has some gesture like double tap to zoom, span, zoom in/out, move.

![FullScreenImageViewGIF](FullScreenImageViewGIF.gif)


# Setup
1. Add to build.gradle in app level
```
implementation 'com.github.tntkhang:full-screen-image-view-library:1.0.0'
```

2. Call open a FullScreenImageViewActivity whenever need open it in full screen
```
Intent fullImageIntent = new Intent(MainActivity.this, FullScreenImageViewActivity.class);
// uriString is an ArrayList<String> of URI of all images
fullImageIntent.putExtra(FullScreenImageViewActivity.URI_LIST_DATA, uriString);
// pos is the position of image will be showned when open
fullImageIntent.putExtra(FullScreenImageViewActivity.IMAGE_FULL_SCREEN_CURRENT_POS, pos);
startActivity(fullImageIntent);
```
