<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/tnguyen606-cs/myDACO">
    <img src="images/aircaft_icon.png" alt="Logo" width="150" height="200">
  </a>

  <h1 align="center">myDACO</h1>

  <p align="center">
    myDACO is developed using Android Studio and Java
  </p>
</p>


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#getting-started">Getting Started</a></li>
    <ul>
        <li><a href="#installation">Installation</a></li>
        <ul>
          <li><a href="#installing-android-studio">Installing Android Studio</a></li>
          <li><a href="#installing-github-desktop">Installing Github Desktop</a></li>
          <li><a href="#cloning-the-mydaco-repository">Cloning the myDACO Repository</a></li>
        </ul>
        <li><a href="#opening-and-running-mydaco">Opening and running myDACO</a></li>
        <ul>
          <li><a href="#opening-mydaco-with-android-studio">Opening myDACO with Android Studio</a></li>
          <li><a href="#running-the-mydaco-application-with-an-android-emulator">Running the application on an Android emulator</a></li>
        </ul>
    </ul>
    <li>
      <a href="#release-notes">Release Notes</a>
      <ul>
        <li><a href="#version-10">Version 1.0</a></li>
        <ul>
          <li><a href="#new-features">New Features</a></li>
          <li><a href="#bug-fixes">Bug Fixes</a></li>
          <li><a href="#known-issues">Known Issues</a></li>
        </ul>
      </ul>
    </li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
# About The Project

During tactical airborne operations, the departure airfield coordination officer (**DACO**) is responsible for managing accountability of all personnel and equipment on the airfield. When aircraft become inoperable (for any variety of reasons), the **DACO** must determine how to most efficiently redistribute the *personnel* and *equipment* that were assigned to the `downed` aircraft to the remaining aircraft. This process becomes incredibly *time consuming* and *prone to human error* when executed under stressful conditions (night, minimal sleep, combat, etc).  

myDACO is **a mobile application** that assists **DACOs** in determining the load plans for airborne operations and quickly recommends the optimal `bump plan` when aircraft go down based on a variety of factors (#/type of aircraft, # of equipment, # of personnel). With this application, DACOs can update manifest data and perform bumps as needed.

<!-- GETTING STARTED -->
# Getting Started
This section provides instructions on getting started with myDACO, from installing the required software (Android Studio and Github Desktop) to running the application.  
The [**Installation**](https://github.com/tnguyen606-cs/myDACO/edit/main/README.md#installation) subsection provides instructions on how to install Android Studio and Github Desktop and clone the repository to the user's local machine.  
The [**Opening and running myDACO**](https://github.com/tnguyen606-cs/myDACO/edit/main/README.md#opening-and-running-mydaco) subsection provides instructions on opening myDACO in Android Studio, and running the application itself on a virtual Android device.
## Installation

### Installing Android Studio
>Android Studio is required to develop the myDACO application.  

Android Studio is available for computers running Windows, Linux, and MacOS. The OpenJDK (Java Development Kit) is bundled with Android Studio.

1. Navigate to the [Android Studio](https://developer.android.com/studio/) download page.
2. Click "Download Android Studio" and accept all terms and conditions, then click the "Download Android Studio ..." button to download the `.exe` installer for Android Studio.
3. Open the `.exe` file downloaded in the previous step, accept the default configurations for all steps, and ensure that all components are selected for installation. A video showing the installation process can be found [here.](https://developer.android.com/static/studio/videos/studio-install-windows.mp4)
4. After the install is complete, the setup wizard downloads and installs additional components, including the Android SDK. This process may take some time, depending on your internet speed.
5. When the installation completes, Android Studio starts, and you are ready to clone the myDACO repository.

### Installing Github Desktop

To clone the myDACO code repository, you must have an account added to this repository and git must be installed on your machine. This section will walk through installing Github Desktop, a user-friendly desktop app for using git.

1. Download the appropriate version of Github Desktop for your OS from [here.](https://desktop.github.com/)
2. Install the Github Desktop install wizard `GitHubDesktopSetup.exe` downloaded in step 1.
3. After installation is complete, open the Github Desktop program.
4. At the top bar of Github Desktop, click `File` then `Options`. In the `Accounts` tab, next to GitHub.com, click sign-in and follow the steps to log in to your account.

### Cloning the myDACO repository

This section provides instructions on how to clone the myDACO repository on your machine using Github Desktop.

1. Open Github Desktop.
2. Click `File` at the top bar of the UI. 
3. Click `Clone Repository` in the drop-down menu. There are three tabs in the popup menu. Click `URL`.
4. In the URL field, paste the following link `https://github.com/tnguyen606-cs/myDACO`. This is the link to the myDACO repository.
5. Choose the location on your local machine where you want the code files to be installed by clicking `Choose...` and navigating to your desired location in the local file directory.

## Opening and running myDACO

### Opening myDACO with Android Studio

This section includes steps on opening the cloned repository with Android Studio. Now that the myDACO code repository is on your machine, you can open myDACO with Android Studio.

1. Open Android Studio.
2. Click on the `File` tab at the far left of the top menu bar. 
3. Click `Open...`
4. A file navigation menu will open. Navigate to the location where you installed myDACO. This should be a folder titled `myDACO`. 
5. Expand this folder and there will be another folder with an Android icon also titled `myDACO`. 
6. Expand this folder and there will be a folder with an Android icon titled `MyDacoApp`. Click on this folder to highlight it. The window should look similar to the image pictured in the collapsible section below. After confirming that MyDacoApp is highlighted, press the `OK` button.
<details>
  <summary>Click me</summary>
  
![image](https://user-images.githubusercontent.com/111911764/205509082-8b027c8c-9cc1-416d-8bc6-1be72cc95411.png)
</details>

7. The development environment should now be configured on your Android Studio instance.

### Running the myDACO application with an Android Emulator

This section includes steps on running the application on a virtual Android device in Android Studio.

1. First, we will create a virtual Android device. At the top bar, click on `Tools`, and then `Device Manager` to access the Device Manager. This will open a widget for managing your virtual Android devices.
2. In the widget click `Create Device`. This will open a window where you can select a virtual device to create. For this tutorial, we will use the Google Pixel 4a as the virtual device. Select `Pixel 4a` in this menu.
3. Next, you will be shown a list where you can select the system image of the virtual device. Select `Tiramisu` as the system image.
4. A verification screen will be shown that contains information about the device you will create. If you want to allocate more RAM to the device, click `Show Advanced Settings` and adjust the RAM accordingly.
5. Click `Finish` to create the device.
6. Your device is now successfully created. The device manager should now appear with a single device, as shown below.

<details>
  <summary>Device Manager</summary>
  
![image](https://user-images.githubusercontent.com/111911764/205509888-a383d0d1-c1fe-4bf0-a92d-5ab6fca3e120.png)
</details>

  7. Now a device can be selected for running the app on the emulator. At the device selection dropdown menu (pictured below), select the device you just created in the previous step. Below is an image of the menu after the device is selected
  
 <details>
  <summary>Selected a device</summary>
  
![image](https://user-images.githubusercontent.com/111911764/205510000-1b3eb46d-26ed-431b-9aab-fcb8d8c15647.png)
</details>

 8. Click the run button. In the above image, it is the green icon shaped like a play button.
 9. Your device will launch for the first time. This may take several minutes, as the device is being set up. After a few minutes, the initial screen (login screen) of myDACO should appear on your device, indicating that the app is open on the emulator.

 <details>
  <summary>App Initial Screen on the emulator</summary>
  
![image](https://user-images.githubusercontent.com/111911764/205510275-6a563118-3c71-40d8-b83a-97243de6f9b7.png)
</details>



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
* Users cannot undo a Bump Plan (the User must manually reassign each cargo and personnel or perform another bump)
* Firebase Authentication guest sign in feature crashes application (Users must sign in through email)
