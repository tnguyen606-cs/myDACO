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

**A mobile application** that could assist **DACOs** in determining the load plans for airborne operations and quickly recommend the optimal `bump plan` when aircraft go down based on a variety of factors (#/type of aircraft, # of equipment, # of personnel, location of aircraft on the airfield, etc). 

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

> Follow this [INTRUCTION](https://developer.android.com/codelabs/build-your-first-android-app#2) to create a new Android project for your first app.  

Read more about [here](https://developer.android.com/codelabs/build-your-first-android-app#0).

<!-- RELEASE NOTES -->
# Release Notes
## Version 1.0.0

### New Features
* Ability for users to log into the app using a valid SSO
* Ability for users to reset password via name and employee Id added
* Ability for users to sign up new account
* New dashboard view for users with personel, cargo, and planes information

### Bug Fixes
* Fixed login page redirecting to the sign-up screen and forgor password screen
* Fixed the app as using Firebase

### Known Issues
N/A

---
