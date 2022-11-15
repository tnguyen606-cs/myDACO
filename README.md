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
## Version 0.4.0

### New Features
* New UI Options
  * Ability for users to switch between views and add items to the airfield from each view
    * Option 1: Master list of Personnels within airfield
    * Option 2: Master list of Cargos within airfield
    * Option 3: Master list of Planes within airfield (Default option)
* Ability for users to manually designate certain items to certain planes before every Bump Plan (Pre-existing Inputs Feature)
* Ability for users to search for specific items with the new Airfield Smart Search Feature

### Bug Fixes
* Functionality of Menu Bar
* Users can now switch between views from menu bar
* Fixed bugs caused by querying data from Firebase

### Known Issues
* Application takes up a lot of RAM and Memory 
* Firebase Authentication guest sign in feature crashes application (Users must sign in through email or be a current user)
* Settings menu has no information
* Bump plan UI button has no functionality

## Version 0.3.0

### New Features
* Ability for users to add/remove planes to current Airfield Page
* Ability for users to add/remove planes to current mission --> seen on Mission Page
* Ability for users to mark planes as active/inactive
* Displays current planes being utilized on mission from Mission Page
* Addition of menu bar w/search feature & settings accessibility

### Bug Fixes
* Fixed the Firebase user permissions 
* Fixed query issues from Firestore
* Migrated all previous application database logic to Firestore

### Known Issues
* Application takes up a lot of RAM and Memory 
* Firebase Authentication guest sign in feature crashes application (Users must sign in through email or be a current user)
* Users cannot access settings & navigate through pages from main menu button

## Version 0.2.0

### New Features
* Ability for users to see the current airfield manifest including all the aircrafs
* Ability for users to select a particular plane in the current airfield page
* Ability for users to see the plane's manifest including cargos and personnels
* Ability for users to remove an unused plane from the airfield manifest page

### Bug Fixes
* Fixed a bug to migrate database with add/remove a plane with FirebaseFirestore
* Fixed a bug for Edit's icon context-menu in plane manifest to a triple horizontal dots icon
* Fixed a bug for Delete action in Edit menu that allows users to delete a plane and update a new list of planes in airfield manifest page
* Added 2 tableview for cargos and personnels in plane's manifest
* Added a `Start Mission` button in airfield manifest page

### Known Issues
* Query the given database to Firebase database in real-time
* Retrieving data by invoking a blocking method on a database reference with Firebase

----
## Version 0.1.0

### New Features
* Ability for users to log into the app using a valid SSO
* Ability for users to reset password via name and employee Id added
* Ability for users to sign up new account
* New dashboard view for users with personel, cargo, and planes information

### Bug Fixes
N/A

### Known Issues
N/A
