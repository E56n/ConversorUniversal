# Currency Converter Challenge - Alura

Hello everyone! This repository contains the solution to the challenge proposed by Alura, where a currency converter is developed using Java and consuming an API. Below, the challenge is described, and the implemented code is explained.

## Challenge Description

The goal of this challenge is to create a console application that allows converting different currencies using exchange rates obtained from an API. The application should offer a menu with several conversion options and allow the user to enter values to convert.

### Importance

In a globalized world, it is essential to know the exchange rates of different currencies to conduct proper transactions. This project not only helps in understanding data handling in JSON but also provides experience in API consumption, a fundamental aspect in backend development.

## Features

The application includes the following features:

- An interactive menu that allows selecting different conversion options.
- Conversion between multiple currencies (Dollar, Euro, Brazilian Real, etc.).
- Obtaining exchange rates from the Exchange Rate API.
- Calculating and presenting results in a readable format.

## Code Structure

The code is divided into several classes and methods to better organize the application logic. Below is a detailed structure of the code:

### Main Classes

1. **Main**:
    - This is the main class where the application execution starts.
    - Contains the main menu and manages user input.

2. **Converter**:
    - This class handles currency conversions.
    - It has methods to convert between different currencies using exchange rates obtained from the API.

3. **ApiService**:
    - This class manages communication with the Exchange Rate API.
    - Responsible for making HTTP requests and handling JSON responses.

### Key Methods

- **showMenu()**: Displays the available menu options and requests user input.
- **performConversion()**: Calls the corresponding method in the `Converter` class to perform the desired conversion based on the user’s selection.
- **getExchangeRates()**: Located in the `ApiService` class, this method requests exchange rates from the API.

### Usage Example

When starting the application, a menu with conversion options is presented. The user can select an option and enter the value to convert. For example:

1. If the user chooses to convert 25 dollars to Mexican pesos, the application will display the corresponding result based on the current exchange rate.
2. The user can perform multiple conversions without restarting the application, thanks to a loop that allows returning to the menu after each conversion.

## Requirements

- JDK 21 TLS.
- Internet connection to access the Exchange Rate API.

## Instructions to Run the Project

1. Clone this repository to your local machine.
2. Ensure that the JDK is configured on your system.
3. Open the project in your favorite IDE (recommended IntelliJ IDEA).
4. Run the `Main` class.

## Conclusions

This challenge is an excellent opportunity to practice the knowledge gained about Java and API consumption. I hope this project is useful and that you enjoy developing your own currency converter.
