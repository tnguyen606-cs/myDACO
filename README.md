<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/tnguyen606-cs/myDACO">
    <img src="images/aircaft_icon.png" alt="Logo" width="150" height="200">
  </a>

  <h1 align="center">MyDACO App</h1>

  <p align="center">
    Use Android Studio and Java to write MyDACO Android app
  </p>
</p>


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <li>
      <a href="#release-notes">Release Notes</a>
      <ul>
        <li><a href="#new-features">New Features</a></li>
        <li><a href="#bug-fixes">Bug Fixes</a></li>
      </ul>
    </li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
# About The Project

During tactical airborne operations, the departure airfield coordination officer (**DACO**) is responsible for managing accountability of all personnel and equipment on the airfield. When aircraft become inoperable (for any variety of reasons), the **DACO** must determine how to most efficiently redistribute the *personnel* and *equipment* that were assigned to the `downed` aircraft to the remaining aircraft. This process becomes incredibly *time consuming* and *prone to human error* when executed under stressful conditions (night, minimal sleep, combat, etc).  

This is **a mobile application** that assists **DACOs** in determining the load plans for airborne operations and quickly recommends the optimal `bump plan` when aircraft go down based on a variety of factors (#/type of aircraft, # of equipment, # of personnel, location of aircraft on the airfield, etc). 

<!-- GETTING STARTED -->
# Getting Started
## Installation

> You can download Android Studio 3.6 from the [Android Studio](https://developer.android.com/studio/) page.   

Android Studio is available for computers running Windows or Linux, and for Macs running macOS. The OpenJDK (Java Development Kit) is bundled with Android Studio.

1. Navigate to the [Android Studio](https://developer.android.com/studio/) page and follow the instructions to download and install [Android Studio](https://developer.android.com/studio/install.html). 
2. Accept the default configurations for all steps, and ensure that all components are selected for installation.
3. After the install is complete, the setup wizard downloads and installs additional components, including the Android SDK. Be patient, because this process might take some time, depending on your internet speed.
4. When the installation completes, Android Studio starts, and you are ready to create your first project.

## Get started

> Follow this [INSTRUCTION](https://developer.android.com/codelabs/build-your-first-android-app#2) to create a new Android project for your first app.  

Read more about [here](https://developer.android.com/codelabs/build-your-first-android-app#0).

<!-- RELEASE NOTES -->
---
# Release Notes
## Version 1.0
### New Features
* Ability for users to view the items on the airfield from three different views:
  * Option 1: Master list of Planes within airfield (Default option)
  * Option 2: Master list of Cargo within airfield
  * Option 3: Master list of Personnel within airfield
* Ability for users to add items to the airfield: users can add personnel, cargo, and planes to the manifest.
* Ability for users to see a individual plane's manifest including its cargo and personnel
* Ability for users to view and update individual cargo and personnel's attributes (name, weight, priority) and plane assignment
* Ability for users to search for specific planes, personnel, and cargo with the Airfield Smart Search Feature
* Ability for users to mark planes as active/downed and add/remove them to the mission
* Ability for users to view a list of planes on a mission
* Ability for users to execute a Bump Plan based on mission planes (reassign cargo and personnel from downed mission planes to operable mission planes)
* Ability for users to manually designate certain items to certain planes before every Bump Plan (Pre-existing Inputs Feature)
* Ability for users to view the results of a Bump Plan (view the downed planes, reassigned cargo, and reassigned personnel)

### Bug Fixes
* Fixed app not displaying plane data in real time
* Fixed app crash after navigating back to the previous screen after navigating to the search screen
* Fixed functionality of the navigation menu bar (Users can now switch between views from menu bar)
* Fixed single plane manifest not showing cargo and personnel names
* Fixed bump results screen not allowing user to see a downed plane's manifest by adding "View Manifest" option in the plane's context menu
* Fixed bugs caused by wrong query references in Firestore
* Fixed Firebase user permissions 

### Known Issues
* Application takes up a lot of RAM and Memory (Android Studio emulator issue)
* There is no feature to unassign cargo and personnel from a plane or delete planes
* Users cannot undo a Bump Plan
* Firebase Authentication guest sign in feature crashes application (Users must sign in through email)
