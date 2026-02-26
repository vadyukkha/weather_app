package com.example.weatherapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.net.toUri
import android.widget.Toast
import com.example.weatherapp.model.City
import com.example.weatherapp.theme.WeatherAppTheme
import com.example.weatherapp.ui.WeatherScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "onCreate() has been called!", Toast.LENGTH_SHORT).show()

        setContent {
            WeatherAppTheme {
                WeatherScreen { city, period ->
                    openWeather(city, period)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart() has been called!", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume() has been called!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause() has been called!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop() has been called!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy() has been called!", Toast.LENGTH_SHORT).show()
    }

    private fun openWeather(city: City, period: String) {

        val baseUrl = "https://yandex.ru/pogoda/${city.slug}"

        val finalUrl = when (period) {
            "Сегодня" -> baseUrl
            "Завтра" -> "$baseUrl/details/tomorrow"
            "3 дня" -> "$baseUrl/details/3-day-weather"
            "10 дней" -> "$baseUrl/details"
            else -> baseUrl
        }

        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = finalUrl.toUri()
            addCategory(Intent.CATEGORY_BROWSABLE)
        }

        try {
            val packageManager = packageManager
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "На устройстве нет приложения для открытия ссылок",
                    Toast.LENGTH_LONG
                ).show()
            }
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}
