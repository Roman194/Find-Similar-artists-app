# Find simiar artists app
## Note
It's an app which shows similar artists to the one the user entered. </br>
It was made as the base for prompt No. 3 In ["AI Compare in Android development"](https://github.com/Roman194/AI-Compare-in-Android-development) research.

## Used features
The find similar artists app uses such technoligies as:
- Jetpack Compose<br/>
- Retrofit<br/>
- Moshi<br/>
- Interceptors<br/>
- Working with the [tastedive API](https://tastedive.com/read/api)

## Video
Here you can see the video of the working of this app: </br>

https://github.com/user-attachments/assets/47f03e4c-2fbd-4397-ac36-67680784d74b

## How to run

* You need Android Studio (at least Ladybug) with Kotlin plugin (at least 2.0.0)
* Register on the website [testdive](https://tastedive.com/read/api)
* Get API_KEY
* Create file `secret.properties` in the main directory
* Add your API_KEY as `TASTE_DIVE_API_KEY=<YourKey>` in this file, for example `TASTE_DIVE_API_KEY="0945degbe7c90hhfc2k7ec88d85c34dd"`
* Run -> Run 'app'
