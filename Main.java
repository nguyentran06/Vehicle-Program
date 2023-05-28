import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        while (true) {
            String[] options = { "Add vehicle", "Remove vehicle", "Look for the vehicle",
                    "Find lowest price vehicle", "Find highest price vehicle", "Exit" };

            int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Vehicle Management System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            
            switch (choice) {
            
            case 0: // Add vehicle
                String[] vehicleOptions = { "Motorcycle", "Car", "Truck" };
                int vehicleTypeChoice = JOptionPane.showOptionDialog(null, "What type of vehicle?", "Add truck",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, vehicleOptions,
                        vehicleOptions[0]);

                String make = JOptionPane.showInputDialog("Enter the make:");
                String model = JOptionPane.showInputDialog("Enter the model:");
                String bodyStyle = JOptionPane.showInputDialog("Enter the body style:");

                int year = 0;
                boolean isValidYear = false;
                while (!isValidYear) {
                    String yearInput = JOptionPane.showInputDialog("Enter the year of manufacture:");
                    if (yearInput != null) {
                        try {
                            year = Integer.parseInt(yearInput);
                            isValidYear = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid integer.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid integer.");
                    }
                }

                double price = 0.0;
                boolean isValidPrice = false;
                while (!isValidPrice) {
                    String priceInput = JOptionPane.showInputDialog("Enter the price:");
                    if (priceInput != null) {
                        try {
                            price = Double.parseDouble(priceInput);
                            isValidPrice = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter a decimal number");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter a decimal number");
                    }
                }

                if (vehicleTypeChoice == 0) { // Motor
                    int cubicCentimeter = 0;
                    boolean isValidCubicCentimeter = false;
                    while (!isValidCubicCentimeter) {
                        String cubicCentimeterInput = JOptionPane.showInputDialog("Enter the cubic centimeter of the engine of the motorcycle:");
                        if (cubicCentimeterInput != null) {
                            try {
                                cubicCentimeter = Integer.parseInt(cubicCentimeterInput);
                                isValidCubicCentimeter = true;
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please enter an integer");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter an integer");
                        }
                    }
                    vehicles.add(new Motor(make, model, bodyStyle, year, price, cubicCentimeter));
                } else if (vehicleTypeChoice == 1) { // Car
                    String color = JOptionPane.showInputDialog("Enter the color of the car:");
                    vehicles.add(new Car(make, model, bodyStyle, year, price, color));
                } else { // Vehicle
                    vehicles.add(new Vehicle(make, model, bodyStyle, year, price));
                }

                JOptionPane.showMessageDialog(null, "Vehicle added successfully!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                    break;

            case 1: // Remove vehicle
                String makeToRemove = JOptionPane.showInputDialog("Enter the make of the vehicle to remove:");
                String modelToRemove = JOptionPane.showInputDialog("Enter the model of the vehicle to remove:");
                int yearToRemove = 0;
                boolean isValidYearToRemove = false;
                while (!isValidYearToRemove) {
                    String yearToRemoveInput = JOptionPane.showInputDialog("Enter the year of manufacture of the vehicle to remove:");
                    if (yearToRemoveInput != null) {
                        try {
                            yearToRemove = Integer.parseInt(yearToRemoveInput);
                            isValidYearToRemove = true;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please enter an integer.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter an integer.");
                    }
                }

                boolean isRemoved = false;

                Iterator<Vehicle> iterator = vehicles.iterator();
                while (iterator.hasNext()) {
                    Vehicle v = iterator.next();
                    if (v.getMake().equalsIgnoreCase(makeToRemove) && v.getModel().equalsIgnoreCase(modelToRemove) && v.getYear() == yearToRemove) {
                        iterator.remove();
                        isRemoved = true;
                        break;
                    }
                }

                if (isRemoved) {
                    JOptionPane.showMessageDialog(null, "Vehicle removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Vehicle not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;

                case 2: // Look for based on make of vehicle
                	System.out.println("case 3");
                    String searchMake = JOptionPane.showInputDialog("Enter the make of the vehicle to search for:");

                    boolean isFound = false;

                    String searchResult = "Search result:\n";

                    for (Vehicle v : vehicles) {

                        if (v.getMake().equalsIgnoreCase(searchMake)) {

                            searchResult += v + "\n";

                            isFound = true;

                        }
                    }
                    if (isFound) {

                        JOptionPane.showMessageDialog(null, searchResult);
                    } else {

                        JOptionPane.showMessageDialog(null, "No vehicle found with the make " + searchMake);
                    }
                    break;
                	
                case 3: // Find lowest price vehicle
                	double lowestPrice = Double.MAX_VALUE;
                    String lowestPriceVehicle = "";
                    for (Vehicle v : vehicles) {
                        if (v.getPrice() < lowestPrice) {
                            lowestPrice = v.getPrice();
                            lowestPriceVehicle = v.toString();
                        }
                    }
                    if (lowestPriceVehicle.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No vehicle found!");
                    } else {
                        JOptionPane.showMessageDialog(null, "The lowest price vehicle:\n" + lowestPriceVehicle);
                    }
                    break;
                    
                case 4: // Find highest price vehicle

                    double highestPrice = Double.MIN_VALUE;
                    String highestPriceVehicle = "";
                    for (Vehicle v : vehicles) {
                        if (v.getPrice() > highestPrice) {
                            highestPrice = v.getPrice();
                            highestPriceVehicle = v.toString();
                        }
                    }
                    if (highestPriceVehicle.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No vehicle found!");
                    } else {
                        JOptionPane.showMessageDialog(null, "The highest price vehicle:\n" + highestPriceVehicle);
                    }
                    break;
                    
                case 5: 
                	System.exit(0);
                    break;
                            
               
                            
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice! Please select an option from the menu.");
                    break;
                    
                }
            }
        }
    }