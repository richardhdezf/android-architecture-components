Android architecture components sample
=================

An application illustrating the use of android jetpack components and the recommended app
architecture.

Introduction
------------

This sample demonstrates implementation of the android jetpack components, recommended architecture
and best practices. The app was build using kotlin programming language.

Getting Started
---------------

Clone or download the project, then run it.

Screenshots
-----------

![password app video](screenshots/arch_video.gif "architecture components sample")

Libraries Used
--------------

* [Foundation][0] - Components for core system capabilities and support for multidex and automated
  testing.
    * [AppCompat][1] - Degrade gracefully on older versions of Android.
    * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
    * [Test][4] - An Android testing framework for unit and runtime UI tests.
* [Coroutines][3] - for asynchronous programming.
* [Flow][5] - To receive live updates from a database.
* [Architecture][10] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
    * [Data Binding][11] - Declaratively bind observable data to UI elements.
    * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
    * [LiveData][13] - Build data objects that notify views when the underlying database changes.
    * [Navigation][14] - Handle everything needed for in-app navigation.
    * [Room][16] - Access your app's SQLite database with in-app objects and compile-time checks.
    * [Paging][18] - Access your app's SQLite database with in-app objects and compile-time checks.
    * [LiveData][13] - Build data objects that notify views when the underlying database changes.
    * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
      asynchronous tasks for optimal execution.
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
    * [Material design][32] - for an expressive and adaptable design system.
    * [Fragment][34] - A basic unit of composable UI.
    * [Layout][35] - Lay out widgets using different algorithms.
* Third party and miscellaneous libraries
    * [retrofit][89] for network api
    * [Glide][90] for image loading
    * [Kotlin Coroutines][91] for managing background threads with simplified code and reducing
      needs for callbacks

[0]: https://developer.android.com/jetpack/components

[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat

[2]: https://developer.android.com/kotlin/ktx

[4]: https://developer.android.com/training/testing/

[3]: https://developer.android.com/kotlin/coroutines

[5]: https://developer.android.com/kotlin/flow

[10]: https://developer.android.com/jetpack/arch/

[11]: https://developer.android.com/topic/libraries/data-binding/

[12]: https://developer.android.com/topic/libraries/architecture/lifecycle

[13]: https://developer.android.com/topic/libraries/architecture/livedata

[14]: https://developer.android.com/topic/libraries/architecture/navigation/

[16]: https://developer.android.com/topic/libraries/architecture/room

[17]: https://developer.android.com/topic/libraries/architecture/viewmodel

[18]: https://developer.android.com/topic/libraries/architecture/paging/v3-overview

[30]: https://developer.android.com/guide/topics/ui

[32]: https://material.io/develop/android

[34]: https://developer.android.com/guide/components/fragments

[35]: https://developer.android.com/guide/topics/ui/declaring-layout

[89]:https://square.github.io/retrofit/

[90]: https://bumptech.github.io/glide/

[91]: https://kotlinlang.org/docs/reference/coroutines-overview.html

License
-------

Copyright 2018 Google, Inc.

Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.
See the NOTICE file distributed with this work for additional information regarding copyright
ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License. You may obtain a copy of the
License at

https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is
distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
implied. See the License for the specific language governing permissions and limitations under the
License.