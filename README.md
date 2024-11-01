# Reto de Conversor de Monedas - Alura

¡Hola a todos! Este repositorio contiene la solución al reto propuesto por Alura, donde se desarrolla un conversor de monedas utilizando Java y consumiendo una API. A continuación, se describe el reto y se explica el código implementado.

## Descripción del Reto

El objetivo de este reto es crear una aplicación de consola que permita convertir diferentes monedas utilizando tasas de cambio obtenidas de una API. La aplicación debe ofrecer un menú con varias opciones de conversión y debe permitir al usuario ingresar valores a convertir.

### Importancia

En un mundo globalizado, es esencial poder conocer la cotización de diferentes monedas para realizar transacciones adecuadas. Este proyecto no solo ayuda a entender el manejo de datos en JSON, sino que también proporciona experiencia en el consumo de APIs, un aspecto fundamental en el desarrollo backend.

## Funcionalidades

La aplicación cuenta con las siguientes características:

- Un menú interactivo que permite seleccionar diferentes opciones de conversión.
- Conversión entre múltiples monedas (Dólar, Euro, Real Brasileño, etc.).
- Obtención de tasas de cambio desde la API de Exchange Rate.
- Cálculo y presentación de los resultados en un formato legible.

## Estructura del Código

El código se divide en varias clases y métodos para organizar mejor la lógica de la aplicación. A continuación, se detalla la estructura del código:

### Clases Principales

1. **Main**:
    - Esta es la clase principal donde se inicia la ejecución de la aplicación.
    - Contiene el menú principal y gestiona las entradas del usuario.

2. **Conversor**:
    - Esta clase se encarga de realizar las conversiones de monedas.
    - Tiene métodos que permiten convertir entre diferentes monedas utilizando las tasas de cambio obtenidas de la API.

3. **ApiService**:
    - Esta clase gestiona la comunicación con la API de Exchange Rate.
    - Se encarga de realizar las peticiones HTTP y manejar las respuestas en formato JSON.

### Métodos Clave

- **mostrarMenu()**: Muestra las opciones disponibles en el menú y solicita la entrada del usuario.
- **realizarConversion()**: Llama al método correspondiente de la clase `Conversor` para realizar la conversión deseada según la selección del usuario.
- **obtenerTasasDeCambio()**: Se encuentra en la clase `ApiService` y se encarga de solicitar las tasas de cambio a la API.

### Ejemplo de Uso

Al iniciar la aplicación, se presenta un menú con las opciones de conversión. El usuario puede seleccionar una opción e ingresar el valor a convertir. Por ejemplo:

1. Si el usuario elige convertir 25 dólares a pesos mexicanos, la aplicación mostrará el resultado correspondiente basado en la tasa de cambio actual.
2. El usuario puede realizar múltiples conversiones sin necesidad de reiniciar la aplicación, gracias al uso de un bucle que permite volver al menú después de cada conversión.

## Requisitos

- JDK 21 TLS.
- Conexión a Internet para acceder a la API de Exchange Rate.

## Instrucciones para Ejecutar el Proyecto

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener configurado el JDK en tu sistema.
3. Abre el proyecto en tu IDE favorito (recomendado IntelliJ IDEA).
4. Ejecuta la clase `Main`.

## Conclusiones

Este reto es una excelente oportunidad para poner en práctica los conocimientos adquiridos sobre Java y consumo de APIs. Espero que este proyecto te sea útil y que disfrutes desarrollando tu propio conversor de monedas. ¡Buena suerte!

#ConversorUniversal2
