import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

public class ConversorUniversal {
    private static final String API_KEY = "4c07aaeb9b42f5bcf527557c";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
            int mainOption = scanner.nextInt();
            
            if (mainOption == 3) {
                System.out.println("¡Gracias por usar el conversor universal!");
                break;
            }
            
            switch (mainOption) {
                case 1:
                    processCurrencyMenu();
                    break;
                case 2:
                    processUnitMenu();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n=== Conversor Universal ===");
        System.out.println("1. Conversor de Monedas");
        System.out.println("2. Conversor de Unidades");
        System.out.println("3. Salir");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void showCurrencyMenu() {
        System.out.println("\n=== Conversor de Monedas ===");
        System.out.println("1. USD (Dólar) a otras monedas");
        System.out.println("2. EUR (Euro) a otras monedas");
        System.out.println("3. MXN (Peso Mexicano) a otras monedas");
        System.out.println("4. JPY (Yen Japonés) a otras monedas");
        System.out.println("5. CNY (Yuan Chino) a otras monedas");
        System.out.println("6. Otras monedas a USD");
        System.out.println("7. Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void showTargetCurrencyMenu() {
        System.out.println("\nConvertir a:");
        System.out.println("1. USD (Dólar)");
        System.out.println("2. EUR (Euro)");
        System.out.println("3. MXN (Peso Mexicano)");
        System.out.println("4. JPY (Yen Japonés)");
        System.out.println("5. CNY (Yuan Chino)");
        System.out.println("6. ARS (Peso Argentino)");
        System.out.println("7. BRL (Real Brasileño)");
    }

    private static void showUnitMenu() {
        System.out.println("\n=== Conversor de Unidades ===");
        System.out.println("1. Longitud");
        System.out.println("2. Peso/Masa");
        System.out.println("3. Temperatura");
        System.out.println("4. Volumen");
        System.out.println("5. Volver al menú principal");
        System.out.print("\nSeleccione una opción: ");
    }

    private static void processCurrencyMenu() {
        while (true) {
            showCurrencyMenu();
            int option = scanner.nextInt();
            
            if (option == 7) return;
            
            if (option >= 1 && option <= 6) {
                System.out.print("Ingrese el valor a convertir: ");
                double amount = scanner.nextDouble();
                
                String fromCurrency = getFromCurrency(option);
                
                if (option != 6) {  // Si no es la opción "Otras monedas a USD"
                    showTargetCurrencyMenu();
                    System.out.print("\nSeleccione moneda destino: ");
                    int targetOption = scanner.nextInt();
                    String toCurrency = getTargetCurrency(targetOption);
                    
                    try {
                        double result = convertCurrency(amount, fromCurrency, toCurrency);
                        System.out.printf("%.2f %s = %.2f %s%n", 
                            amount, fromCurrency, result, toCurrency);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error en la conversión: " + e.getMessage());
                    }
                } else {
                    // Para la opción "Otras monedas a USD"
                    try {
                        double result = convertCurrency(amount, fromCurrency, "USD");
                        System.out.printf("%.2f %s = %.2f USD%n", 
                            amount, fromCurrency, result);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Error en la conversión: " + e.getMessage());
                    }
                }
            }
        }
    }

    private static void processUnitMenu() {
        while (true) {
            showUnitMenu();
            int option = scanner.nextInt();
            
            if (option == 5) return;
            
            if (option >= 1 && option <= 4) {
                System.out.print("Ingrese el valor a convertir: ");
                double value = scanner.nextDouble();
                
                switch (option) {
                    case 1:
                        convertLength(value);
                        break;
                    case 2:
                        convertWeight(value);
                        break;
                    case 3:
                        convertTemperature(value);
                        break;
                    case 4:
                        convertVolume(value);
                        break;
                }
            }
        }
    }

    private static String getFromCurrency(int option) {
        switch (option) {
            case 1: return "USD";
            case 2: return "EUR";
            case 3: return "MXN";
            case 4: return "JPY";
            case 5: return "CNY";
            case 6:
                System.out.println("\nIngrese el código de la moneda (ej: BRL): ");
                return scanner.next().toUpperCase();
            default: return "USD";
        }
    }

    private static String getTargetCurrency(int option) {
        switch (option) {
            case 1: return "USD";
            case 2: return "EUR";
            case 3: return "MXN";
            case 4: return "JPY";
            case 5: return "CNY";
            case 6: return "ARS";
            case 7: return "BRL";
            default: return "USD";
        }
    }

    private static double convertCurrency(double amount, String from, String to) 
            throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + from))
                .build();

        HttpResponse<String> response = client.send(request, 
                HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());
        JSONObject rates = json.getJSONObject("conversion_rates");
        double rate = rates.getDouble(to);
        
        return amount * rate;
    }

    private static void convertLength(double value) {
        System.out.println("\n=== Conversión de Longitud ===");
        System.out.println("1. Metros a Pies");
        System.out.println("2. Pies a Metros");
        System.out.println("3. Kilómetros a Millas");
        System.out.println("4. Millas a Kilómetros");
        System.out.print("\nSeleccione una opción: ");
        
        int option = scanner.nextInt();
        double result = 0;
        
        switch (option) {
            case 1:
                result = value * 3.28084;
                System.out.printf("%.2f metros = %.2f pies%n", value, result);
                break;
            case 2:
                result = value / 3.28084;
                System.out.printf("%.2f pies = %.2f metros%n", value, result);
                break;
            case 3:
                result = value * 0.621371;
                System.out.printf("%.2f kilómetros = %.2f millas%n", value, result);
                break;
            case 4:
                result = value / 0.621371;
                System.out.printf("%.2f millas = %.2f kilómetros%n", value, result);
                break;
        }
    }

    private static void convertWeight(double value) {
        System.out.println("\n=== Conversión de Peso ===");
        System.out.println("1. Kilogramos a Libras");
        System.out.println("2. Libras a Kilogramos");
        System.out.println("3. Gramos a Onzas");
        System.out.println("4. Onzas a Gramos");
        System.out.print("\nSeleccione una opción: ");
        
        int option = scanner.nextInt();
        double result = 0;
        
        switch (option) {
            case 1:
                result = value * 2.20462;
                System.out.printf("%.2f kilogramos = %.2f libras%n", value, result);
                break;
            case 2:
                result = value / 2.20462;
                System.out.printf("%.2f libras = %.2f kilogramos%n", value, result);
                break;
            case 3:
                result = value * 0.035274;
                System.out.printf("%.2f gramos = %.2f onzas%n", value, result);
                break;
            case 4:
                result = value / 0.035274;
                System.out.printf("%.2f onzas = %.2f gramos%n", value, result);
                break;
        }
    }

    private static void convertTemperature(double value) {
        System.out.println("\n=== Conversión de Temperatura ===");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        System.out.println("3. Celsius a Kelvin");
        System.out.println("4. Kelvin a Celsius");
        System.out.print("\nSeleccione una opción: ");
        
        int option = scanner.nextInt();
        double result = 0;
        
        switch (option) {
            case 1:
                result = (value * 9/5) + 32;
                System.out.printf("%.2f°C = %.2f°F%n", value, result);
                break;
            case 2:
                result = (value - 32) * 5/9;
                System.out.printf("%.2f°F = %.2f°C%n", value, result);
                break;
            case 3:
                result = value + 273.15;
                System.out.printf("%.2f°C = %.2f K%n", value, result);
                break;
            case 4:
                result = value - 273.15;
                System.out.printf("%.2f K = %.2f°C%n", value, result);
                break;
        }
    }

    private static void convertVolume(double value) {
        System.out.println("\n=== Conversión de Volumen ===");
        System.out.println("1. Litros a Galones");
        System.out.println("2. Galones a Litros");
        System.out.println("3. Mililitros a Onzas líquidas");
        System.out.println("4. Onzas líquidas a Mililitros");
        System.out.print("\nSeleccione una opción: ");
        
        int option = scanner.nextInt();
        double result = 0;
        
        switch (option) {
            case 1:
                result = value * 0.264172;
                System.out.printf("%.2f litros = %.2f galones%n", value, result);
                break;
            case 2:
                result = value / 0.264172;
                System.out.printf("%.2f galones = %.2f litros%n", value, result);
                break;
            case 3:
                result = value * 0.033814;
                System.out.printf("%.2f mililitros = %.2f onzas líquidas%n", value, result);
                break;
            case 4:
                result = value / 0.033814;
                System.out.printf("%.2f onzas líquidas = %.2f mililitros%n", value, result);
                break;
        }
    }
}
