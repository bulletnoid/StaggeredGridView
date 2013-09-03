StaggeredGridView
=================

## A sweeter version of StaggeredGridView

![](snapchot/snap.png)
This project is based on [maurycyw/StaggeredGridView][1], which is a modification of Android's experimental StaggeredGridView: [com.android.ex.widget.StaggeredGridView][2]

## Features

* Stability and high performance

  This project fix many of the major bugs of [maurycyw/StaggeredGridView][1]. Such as when fling the view, the scroll sometimes slow down and speed up later.

  Notice that the image load also has a contribution to the perfomance. I use [square/Picasso][3], it gives the best performance I've ever seen.
* Header and Footer View and an Adapter to wrap all the child views, Just like android.widget.ListView
* Load more when get to the bottom
* Work with PullToRefresh

  A compatible to enable this widget to be pulled to refresh.

## Restriction

* You have to determine the dimension of each child view in the widget before the parent call the child.measure()

  eg. When you display photo in the widget, and the photo is loaded from network, you have to let this widget know the size of each child, such as overwrite the onMeasure method of the child. Pinterset use this method.
* Load more is lazy

  When oad more, the widget only add new items to the old ones, the old ones is not reloaded.

## Project structure

In order to avoid some depandency problems, I add the libs into one project, but it is easy to use the libs.
* StaggeredGridView

  code: src/com.bulletoid.android.widget.StaggeredGridView
  
  res: res/stgv_*.xml
* PullToRefresh

  code: src/com.handmark.pulltorefresh.library
  
  res: res/ptr_*.xml

## Usage

Please refer to the Demo of how to use the widget and use it with PullToRefresh.

[1]: https://github.com/maurycyw/StaggeredGridView
[2]: http://grepcode.com/file/repository.grepcode.com/java/ext/com.google.android/android/4.3_r2.1/com/android/ex/widget/StaggeredGridView.java?av=f
[3]: https://github.com/square/picasso
