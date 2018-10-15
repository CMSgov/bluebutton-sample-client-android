Blue Button Sample Client Application - Android Version
======================================================

## Introduction

This client demonstrates authenticating to the [Blue Button API](https://bluebutton.cms.gov/). It currently does not include FHIR API calls and is being used for authentication testing only.  It demonstrates the [RFC 8252 - OAuth 2.0 for Native Apps](https://tools.ietf.org/html/rfc8252) Server Side web application flow utilizing the [PKCE](https://tools.ietf.org/html/rfc7636) extension and a custom URI scheme redirect.

This client is built using the [AppAuth SDK](https://appauth.io/) and more specifically the [AppAuth for Android client SDK](https://github.com/openid/AppAuth-Android). 

A frontend client configuration SQLite database was inspired by blog examples from [AnujAroshA / Android-SQLite](https://github.com/AnujAroshA/Android-SQLite).

[Android Studio](https://developer.android.com/studio/) was used for a development IDE.


## Status and Contributing

This demo app is still a work in progress! 

The goal of this demo is to provide examples of the technical interaction with the [Blue Button API](https://bluebutton.cms.gov/).

The application is in active development so check back often for updates.
Please consider improving this code with your contributions. Pull requests welcome ;) 

## Prerequisite [Android Studio](https://developer.android.com/studio/) Software Requirement

Please follow the information at the above link for installation instructions on your development platform.

## Clone the [AppAuth for Android client SDK](https://github.com/openid/AppAuth-Android) Repository

    git clones https://github.com/openid/AppAuth-Android.git

## Clone the client Repository

    git clone https://github.com/dtisza1/bluebutton-sample-client-android
    cd bluebutton-sample-client-android


## Setup with in [Android Studio](https://developer.android.com/studio/)

1. Import the project via File -> New -> Import project -> Choose: bluebutton-sample-client-android
2. Click OK to use gradle wrapper
3. Import SDK module via File -> New -> ImportModule -> Choose: AppAuth-Android 
   Select the "library" location for import
4. Edit the settings.gradle file. Add :library for the line to become:
   "include ':app', ':library'"
5. Sync the gradle files via File -> Sync project with gradle files
6. Build the project and library via Build -> Make Project
7. Run the client app via Run-> Run 'app'

    NOTE: If having an issue running in the emulator, disble the "Instant Run" option under settings->Execution. 


## Setting Up a Sandbox Application

To use this demo application, you will need to signup for a developer account
at our https://sandbox.bluebutton.cms.gov/ site.

Please reference our documentation for more information at: https://bluebutton.cms.gov/developers/ .

Once you have your developer account created and you've verified your email address,
you'll need to set up an application. Log in to your new account, and select
"Applications" -> "Applications You Created" -> "Register New Application". From
here, you can fill out the form with the following options:

    Scope: [you likely want to select all available]
    Name: [your choice]
    Client type: Confidential
    Authorization grant type: Authorization Code
    Redirect uris: gov.cms.bluebutton.oauthtester:/oauth2redirect/example-provider

Once you submit the form, you should receive an application key and secret that
can be be added to the test configuration entry of the client app.



## Setting Up a test configuration in the android app

In the android app, click the "+" in the upper right to create a new configuration entry. This was designed as a tester type app to have multiple test configurations. You can create one for your sandbox app by setting the following fields:

    BB_CLIENT_ID: "<enter client id here>"
    BB_CLIENT_SECRET: "<enter client secret here>"
    BB_REDIRECT_URI: "gov.cms.bluebutton.oauthtester:/oauth2redirect/example-provider"
    BB_AUTHORIZE_URL: "https://sandbox.bluebutton.cms.gov/v1/o/authorize/"
    BB_TOKEN_URL: "https://sandbox.bluebutton.cms.gov/v1/o/token/"
    BB_USERINFO_URI: "https://sandbox.bluebutton.cms.gov/v1/connect/userinfo"

Press the <update> button to save the configation and the <connect> to test a connection.

The authorization state will persist, so to try another connection you will have to click the <logout> button before trying again.


## This README and demo app is still a work in progress :-)

This README and demo app is still in progress! More to come :-)
