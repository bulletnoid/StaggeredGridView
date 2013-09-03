StaggeredGridView
=================

## A sweeter version of StaggeredGridView

This project is based on https://github.com/maurycyw/StaggeredGridView, which is a modification of Android' experimental StaggeredGridView

You can find its code here: https://github.com/maurycyw/StaggeredGridView, http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.3_r2.1/com/android/ex/widget/StaggeredGridView.java?av=f

## Features

* Stable and high performance

This project fix many of the major bugs of https://github.com/maurycyw/StaggeredGridView. Such as when fling the view, the scroll slow down and speed up later.

Notice that the image load also has a contribution to the perfomance. I use https://github.com/square/picasso, it gives the best performance I've ever seen.
* Load more when touches the bottom
* Work with PullToRefresh

A compatible to enable this widget to be pulled to refresh.

## Restriction

* You have to determine the dimension of each child view in the widget

eg. When you display photo in the widget, and the photo is loaded from network, you have to let this widget know the size of each child, such as overwrite the onMeasure method of the child. Pinterset may also use this method.
* Load more is lazy

When oad more, the widget only add new items to the old ones, the old ones is not reloaded.

## Project structure

In order to avoid some depandency problems, I add the libs into one project, but it is easy to use the libs.
* StaggeredGridView lib

code: src/com.bulletoid.android.widget.StaggeredGridView
res: res/stgv_*.xml
* PullToRefresh

code: src/com.handmark.pulltorefresh.library
res: res/ptr_*.xml

## Usage

Please refer to the Demo of how to use the widget and use it with PullToRefresh.
