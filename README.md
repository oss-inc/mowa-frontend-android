# MoWA's Android Application
**Mo**notoring the elder with **W**i-Fi sensing and **A**I

<br/>

<!-- Skill -->
<div>
    <img src="https://img.shields.io/badge/android-3DDC84?style=for-the-badge&logo=android&logoColor=white">
    <img src="https://img.shields.io/badge/androidstudio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white">
    <img src="https://img.shields.io/badge/kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white">
    <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
</div>
<div>
    <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
    <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
    <img src="https://img.shields.io/badge/amazonrds-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white">
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
</div>
<br/>
<br/>

## <b>Table of Contents</b>
1. [Introduction](#1-introduction)
2. [Motivation](#2-motivation)
3. [Installation & Execution](#3-installation-&-execution)
4. [Demo & Utilization](#4-demo-&-utilization)
5. [Reference](#5-reference)

<br/>
<br/>

## <b>1. Introduction</b>

<br/>

![ic_mowa_not_title](https://github.com/GachonMoWA/mowa-app-android/assets/77925666/126ee4c4-8150-47e7-b65a-c0af31b7805b)

MoWA, our project, stands for "Monitoring the elder with Wi-Fi sensing and AI(Artificial Intelligence)" and is a system that monitors the elder living alone using Wi-Fi Sensing and AI Speaker. 
It is an Android project that acts as an interface with users in the MoWA project. 
Users can use the MoWA service by installing the MoWA application on their Android phones. 
Users can check their activity and risk levels through the Android application.

✅ Monitoring the elder with Wi-Fi sensing and AI  
✅ Monitor the elder's activities  
✅ Check whether the elder is in danger  

<br/>
<br/>

## <b>2. Motivation</b>

Our project "MoWA" aims to help cope with accidents that may occur by monitoring the elder living alone and ensure the activity of the elderly living alone. 
The behavior of the elder living alone is monitored and checked through Wi-Fi Sensing. In addition, the Android application allows users to utilize their own statistics and various functions. 
In other words, an Android application is an application designed to make MoWA services more intuitive and easy for users to access. 
Therefore, we designed the UI focusing on accessibility and intuition. 
It was implemented with the goal and motivation to make it easy and convenient for the elderly living alone, which is the target of our service.

<br/>

<img src="https://www.medi-press.co.kr/data/photos/20150208/art_1424142057.jpg" height="200px" alt="The elder" />

<br/>
<br/>

## <b>3. Installation & Execution</b>

Now, I would like to introduce how to install the MoWA application and how to run it. 
Unfortunately, the MoWA Android application is not currently on Google Play store. 
Therefore, as of this time (2023.09), the only way to install the MoWA application on the user's mobile phone is to download the repository to the computer and connect the mobile phone to install it. 
Although the installation method is somewhat complicated, a method of installing and executing using the method is described below.

<br/>
<br/>

### <b>3.1 Our Settings</b>

For reference, the environment in which the Android project was developed is as follows. 
For users who want to install, you should check the difference from your environment. 
This is because sometimes there may be problems that cannot be executed depending on the version. 
In addition to what is written below, we recommend that you check the build.gradle file for more detailed settings and versions of this android project.

<br/>

For reference, the developer's own environment who developed the project is as follows.

- Windows 10
- Windows 11
- macOS Ventura 13.5.1

<br/>

| Category | Version |
| -------- | ------- |
| Android Studio | Android Studio Giraffe \| 2022.3.1 |
| Compile SDK Version | 33 (API 33: Android 13.0 (Tiramisu)) |
| Target SDK Version | 33 (API 33: Android 13.0 (Tiramisu)) |
| Min SDK Version | 26 (API 26: Android 8.0 (Oreo)) |
| Source Compatibility | 1.8 (Java 8) |
| Target Compatibility | 1.8 (Java 8) |
| Android Gradle Plugin Version | 8.1.0 |
| Gradle Version | 8.0 |
| Gradle JDK | jbr-17 (JetBrains Runtime version 17.0.6 |

<i>Last checked 2023. 09. 04 (Mon)</i>

<br/>

<img width="686" alt="image" src="https://github.com/oss-inc/mowa-frontend-android/assets/77925666/63c6639b-fc00-4c00-9643-efa3075e70b8">

<br/>
<br/>

### <b>3.2 Installation</b>

This time is to tell you how to install the MoWA application in the mobile phone. 
Since it is not in Google Play store, the method of download is to download the android project to computer that is connected with the user's own mobile phone. 
For reference, '3.2 Installation' and '3.3 Execution' are related to installation and execution methods of the application and execution method of execution, so if you already know then pass these parts.

<br/>

1. Download the Android project repository.

    ```bash
    git clone https://github.com/oss-inc/mowa-frontend-android.git
    ```

2. Open the Android Studio to open the downloaded registration.

3. After connecting your computer to your mobile phone, make sure that the connection appear properly in Android Studio.

4. Press the Run button to install the application on the mobile phone.

<br/>
<br/>

### <b>3.3 Execution</b>

If the application is installed on the user's own mobile phone, this time I will tell you how to run it. 
If you know how to run the Android application again this time, it's okay to go straight to '4. Demo & Utilization'.

<br/>

1. Verify that the application is properly installed on the phone.

2. If the installation is successful, click to run the installed application.

<br/>
<br/>

## <b>4. Demo & Utilization</b>

Here, we introduce the core functions of the MoWA application. 
It shows a screenshot of the demo and explains how it can be used together.

<br/>

- Start (Splash & Guide)
  
    <div style="display: flex; flex-direction: row;">
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/d90025ef-d575-45c2-b032-4585ff8c3f23" height="400px"/> 
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/a2aa43be-9594-44f0-9641-5d3fa2dec9ac" height="400px"/> 
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/270fcb4e-14ef-4bc2-b6ed-98f807c90a25" height="400px"/> 
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/2389fc96-135c-4abd-9086-7299944bf395" height="400px"/> 
    </div>

<br/>

- Login

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/31969b34-3610-46e0-8b61-dd37771f63c1" height="400px" />

    </div>

<br/>

- Sign up

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/31969b34-3610-46e0-8b61-dd37771f63c1" height="400px" />

    </div>

<br/>

- Home - Check the user's daily activities

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/a0d7c1b9-7d89-4caf-8bcf-ca64317b6cad" height="400px" />

    </div>

<br/>

- Statistics - Check the user's monthly activities

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/f232dffc-6242-4d75-8fe5-dec32e8d6670" height="400px" />

    </div>

<br/>

- Phone book - View some welfare centers

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/57e3225d-3560-4dbd-9d37-8448643433ac" height="400px" />

    </div>

<br/>

- Phone book - View a phone book

    <div style="display: flex; flex-direction: row;">
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/db5d7498-913e-4c47-959f-8221d9e95b47" height="400px" />
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/8f938326-02d3-4002-98ef-7557da98d600" height="400px" />
    </div>

<br/>

- Setting - Allow the notification permission

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/3da9bdb3-7424-4127-838d-51a50bb8f5f1" height="400px" />

    </div>

<br/>
<br/>

## <b>5. Reference</b>
- Image: http://medi-press.co.kr/news/article.html?no=537

<br/>
<br/>
