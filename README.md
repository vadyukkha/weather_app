# WeatherApp

WeatherApp — это Android-приложение, позволяющее пользователю выбрать один из популярных городов России и период прогноза, после чего открывается соответствующая страница Яндекс.Погоды в браузере устройства.

## How to Run

1. Клонировать репозиторий:

   ```bash
   git clone https://github.com/vadyukkha/weather_app.git
   ```

2. Открыть проект в **Android Studio**.

3. Дождаться завершения Gradle Sync.

4. Запустить приложение:

    * выбрать эмулятор или подключённое устройство,
    * нажать **Run ▶**.

После запуска:

* выбрать город,
* выбрать период прогноза,
* нажать кнопку «Запустить» — откроется браузер с соответствующей страницей Яндекс.Погоды.

## Minimum Requirements

* **Android Studio**
* **Gradle**
* **Android SDK**
* Устройство или эмулятор с Android 11+
* Наличие установленного браузера на устройстве

## Technologies Used

* Kotlin
* Jetpack Compose
* Material 3
* Android Activity Lifecycle
* Implicit Intent (`ACTION_VIEW`)
