package com.example.weatherapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.model.City

@Composable
fun WeatherScreen(
    onOpenClick: (City, String) -> Unit
) {

    val cities = remember {
        listOf(
            City("Москва", "moscow"),
            City("Санкт-Петербург", "saint-petersburg"),
            City("Новосибирск", "novosibirsk"),
            City("Екатеринбург", "yekaterinburg"),
            City("Казань", "kazan"),
            City("Нижний Новгород", "nizhny-novgorod"),
            City("Челябинск", "chelyabinsk"),
            City("Самара", "samara"),
            City("Ростов-на-Дону", "rostov-na-donu"),
            City("Уфа", "ufa")
        )
    }

    val periods = remember {
        listOf("Сегодня", "Завтра", "3 дня", "10 дней")
    }

    var selectedCity by remember { mutableStateOf(cities.first()) }
    var selectedPeriod by remember { mutableStateOf(periods.first()) }

    Scaffold(
        bottomBar = {
            LaunchButton {
                onOpenClick(selectedCity, selectedPeriod)
            }
        }
    ) { padding ->

        WeatherContent(
            modifier = Modifier.padding(padding),
            cities = cities,
            periods = periods,
            selectedCity = selectedCity,
            selectedPeriod = selectedPeriod,
            onCitySelected = { selectedCity = it },
            onPeriodSelected = { selectedPeriod = it }
        )
    }
}

@Composable
private fun WeatherContent(
    modifier: Modifier = Modifier,
    cities: List<City>,
    periods: List<String>,
    selectedCity: City,
    selectedPeriod: String,
    onCitySelected: (City) -> Unit,
    onPeriodSelected: (String) -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Text(
            text = "Выберите город",
            style = MaterialTheme.typography.titleMedium
        )

        CityDropdown(
            cities = cities,
            selectedCity = selectedCity,
            onCitySelected = onCitySelected
        )

        Text(
            text = "Выберите период",
            style = MaterialTheme.typography.titleMedium
        )

        PeriodDropdown(
            periods = periods,
            selectedPeriod = selectedPeriod,
            onPeriodSelected = onPeriodSelected
        )
    }
}

@Composable
private fun CityDropdown(
    cities: List<City>,
    selectedCity: City,
    onCitySelected: (City) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(selectedCity.displayName)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            cities.forEach { city ->
                DropdownMenuItem(
                    text = { Text(city.displayName) },
                    onClick = {
                        onCitySelected(city)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun PeriodDropdown(
    periods: List<String>,
    selectedPeriod: String,
    onPeriodSelected: (String) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    Box {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(selectedPeriod)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            periods.forEach { period ->
                DropdownMenuItem(
                    text = { Text(period) },
                    onClick = {
                        onPeriodSelected(period)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun LaunchButton(
    onClick: () -> Unit
) {
    Surface(
        tonalElevation = 4.dp
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
        ) {
            Text("Запустить")
        }
    }
}
