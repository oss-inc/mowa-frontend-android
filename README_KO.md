# MoWA 안드로이드 애플리케이션
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
    <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
</div>
<br/>
<br/>

## <b>목차</b>
1. [프로젝트 소개](#1-프로젝트-소개)
2. [프로젝트 동기](#2-프로젝트-동기)
3. [설치 및 실행 방법](#3-설치-및-실행-방법)
4. [시연 화면](#4-시연-화면)
5. [참고 문헌](#5-참고-문헌)

<br/>
<br/>

## <b>1. 프로젝트 소개</b>

<br/>

![ic_mowa_not_title](https://github.com/GachonMoWA/mowa-app-android/assets/77925666/126ee4c4-8150-47e7-b65a-c0af31b7805b)

MoWA(이하 모와) 프로젝트는 'Monitoring the elder with Wi-Fi sensing and AI(Artificial Intelligence, 인공지능)'의 약자로, 와이파이 센싱 기술과 인공지능 기술을 활용하여 독거 노인을 모니터링하는 시스템입니다.
본 프로그램은 MoWA 프로젝트에서 사용자와의 인터페이스 역할을 하는 안드로이드 애플리케이션으로, 사용자는 안드로이드 휴대 전화에 해당 애플리케이션을 설치함으로써 MoWA 서비스를 이용할 수 있습니다.
사용자는 안드로이드 애플리케이션을 통해 자신의 활동 통계와 위험 정도를 확인할 수 있습니다.

✅ 와이파이 센싱과 인공지능 기술을 이용한 독거 노인 모니터링  
✅ 독거 노인의 활동 모니터링  
✅ 독거 노인의 위험 상태 파악 및 대처  

<br/>
<br/>

## <b>2. 프로젝트 동기</b>

MoWA 프로젝트는 독거 노인을 모니터링함으로써 발생할 수 있는 사고에 대처하고 독거 노인의 활동성을 보장하는 것을 목표로 합니다.
독거 노인의 행동은 와이파이 센싱 기술을 통해 모니터링되며, 안드로이드 애플리케이션을 통해 사용자는 자신의 활동 통계 확인 등 다양한 기능을 활용할 수 있습니다.
즉, 안드로이드 애플리케이션은 사용자가 보다 직관적이고 쉽게 MoWA 서비스를 이용할 수 있도록 설계되었으며,이를 위해 접근성과 직관성에 중점을 두고 UI/UX를 설계하였습니다.
서비스 대상인 독거 노인이 쉽고 편리하게 애플리케이션을 사용하는 것이 최우선이자 최대 목표입니다.

<br/>

<img src="https://www.medi-press.co.kr/data/photos/20150208/art_1424142057.jpg" height="200px" alt="The elder" />

<br/>
<br/>

## <b>3. 설치 및 실행 방법</b>

지금부터는 MoWA 애플리케이션을 설치 및 실행하는 방법에 대해 소개하고 있습니다. MoWA 애플리케이션은 일반적으로 흔히 사용되는 Google Play 스토어에는 등록되어 있지 않습니다.
따라서 현재(2023.09) 시점에서 사용자의 안드로이드 휴대 전화에 MoWA 애플리케이션을 다운로드하는 유일한 방법은 해당 리포지토리(repository)를 컴퓨터에 다운로드한 후 휴대 전화를 연결하여 설치하는 방법입니다.
설치 방법은 다소 복잡하지만, 해당 방법을 사용하여 설치 및 실행하는 방법에 대해서는 아래에 기재하였습니다.

<br/>
<br/>

### <b>3.1 프로젝트 환경 설정</b>

본 안드로이드 프로젝트가 개발된 환경에 대해서는 아래에 적힌 내용을 참고해 주시면 됩니다.
각각의 구성 요소의 버전에 따라 실행이 되지 않는 문제가 있을 수 있기 때문에 설치를 원하는 사용자는 자신의 환경과 차이가 있는지 살펴보아야 합니다.
해당 안드로이드 프로젝트에 대한 자세한 설정과 버전은 아래에 기재된 내용 외에도 build.gradle 파일을 확인해 보시기를 권장합니다.

<br/>

참고로 프로젝트를 개발할 때 사용한 여러 컴퓨터의 환경은 다음과 같습니다.

- Windows 10
- Windows 11
- macOS Ventura 13.5.1

<br/>

| 구분 | 버전 |
| -------- | ------- |
| Android Studio | Android Studio Giraffe \| 2022.3.1 |
| Compile SDK Version | 33 (API 33: Android 13.0 (Tiramisu)) |
| Target SDK Version | 33 (API 33: Android 13.0 (Tiramisu)) |
| Min SDK Version | 26 (API 26: Android 8.0 (Oreo)) |
| Source Compatibility | 1.8 (Java 8) |
| Target Compatibility | 1.8 (Java 8) |
| Android Gradle Plugin Version | 8.1.0 |
| Gradle Version | 8.0 |
| Gradle JDK | jbr-17 (JetBrains Runtime version 17.0.6) |

<i>마지막 확인 및 수정: 2023. 09. 04 (월)</i>

<br/>

<img width="686" alt="image" src="https://github.com/oss-inc/mowa-frontend-android/assets/77925666/63c6639b-fc00-4c00-9643-efa3075e70b8">

<br/>
<br/>

### <b>3.2 설치 방법</b>

이번에는 안드로이드 휴대 전화에 MoWA 애플리케이션을 설치하는 방법은 설명하고자 합니다.
다운로드 방법은 사용자 본인의 휴대 전화와 연결된 컴퓨터에 본 리포지토리를 다운로드하는 방법입니다.
참고로 '3.2 설치 방법'과 '3.3 실행 방법'은 안드로이드 애플리케이션의 설치 및 실행 방법이므로, 관련 내용을 이미 알고 계신 분들은 넘어가셔도 됩니다.

<br/>

1. 아래 명령어를 이용하여 Android 프로젝트인 해당 리포지토리를 다운로드합니다.

    ```bash
    git clone https://github.com/oss-inc/mowa-frontend-android.git
    ```

2. Android Studio 프로그램을 열어 다운로드한 프로젝트를 확인합니다.

3. 컴퓨터에 휴대 전화를 연결한 후 Android Studio에 연결이 제대로 표시되는지 확인합니다.

4. Android Studio 우측 상단의 실행 버튼을 클릭해 휴대 전화에 애플리케이션을 설치합니다.

<br/>
<br/>

### <b>3.3 실행 방법</b>

사용자 휴대 전화에 MoWA 애플리케이션이 설치된 후에는 아래의 실행 방법을 통해 애플리케이션을 실행할 수 있습니다.
이번에도 마찬가지로 애플리케이션 실행 방법을 알고 계신 분은 바로 '4. 시연 화면'으로 넘어가셔도 됩니다.

<br/>

1. MoWA 애플리케이션이 휴대 전화에 제대로 설치되었는지 확인합니다. (제대로 설치가 되었다면, 컴퓨터와의 연결을 해제하여도 됩니다.)

2. 설치가 완료된 후 설치된 애플리케이션을 클릭하여 애플리케이션을 실행합니다.

<br/>
<br/>

## <b>4. 시연 화면</b>

여기서는 MoWA 애플리케이션의 핵심 기능을 소개합니다.
시연 화면 캡처 사진과 함께 사용 방법을 간단하게 설명합니다.

<br/>

- 시작 화면 (스플래시 & 설명 화면)
  
    <div style="display: flex; flex-direction: row;">
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/d90025ef-d575-45c2-b032-4585ff8c3f23" height="400px"/> 
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/a2aa43be-9594-44f0-9641-5d3fa2dec9ac" height="400px"/> 
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/270fcb4e-14ef-4bc2-b6ed-98f807c90a25" height="400px"/> 
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/2389fc96-135c-4abd-9086-7299944bf395" height="400px"/> 
    </div>

<br/>

- 로그인 화면

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/31969b34-3610-46e0-8b61-dd37771f63c1" height="400px" />

    </div>

<br/>

- 회원가입 화면

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/31969b34-3610-46e0-8b61-dd37771f63c1" height="400px" />

    </div>

<br/>

- 홈 화면 - 사용자의 일별 활동 확인

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/a0d7c1b9-7d89-4caf-8bcf-ca64317b6cad" height="400px" />

    </div>

<br/>

- 통계 화면 - 사용자의 월별 활동 확인

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/f232dffc-6242-4d75-8fe5-dec32e8d6670" height="400px" />

    </div>

<br/>

- 전화번호부 화면 (1) - 공공 복지 시설 연락처 확인

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/57e3225d-3560-4dbd-9d37-8448643433ac" height="400px" />

    </div>

<br/>

- 전화번호부 화면 (2) - 사용자의 연락처 확인

    <div style="display: flex; flex-direction: row;">
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/db5d7498-913e-4c47-959f-8221d9e95b47" height="400px" />
        <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/8f938326-02d3-4002-98ef-7557da98d600" height="400px" />
    </div>

<br/>

- 설정 화면 - 알림 권한 허용 등

    <div style="display: flex; flex-direction: row;">

    <img src="https://github.com/GachonMoWA/mowa-app-android/assets/77925666/3da9bdb3-7424-4127-838d-51a50bb8f5f1" height="400px" />

    </div>

<br/>
<br/>

## <b>5. 참고 문헌</b>
- 이미지 출처: http://medi-press.co.kr/news/article.html?no=537

<br/>
<br/>
