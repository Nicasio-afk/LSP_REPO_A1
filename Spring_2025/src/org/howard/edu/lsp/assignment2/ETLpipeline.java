// package org.howard.edu.lsp.assignment2;

// import java.io.*;
// import java.util.*;

// public class ETLpipeline {
//     public static void main(String[] args) {
//         String inputFile = "data/products.csv";
//         String outputFile = "data/transformed_products.csv";
        
//         List<String[]> transformedData = extractAndTransform(inputFile);
//         if (transformedData != null) {
//             load(outputFile, transformedData);
//         }
//     }

//     private static List<String[]> extractAndTransform(String inputFile) {
//         List<String[]> transformedData = new ArrayList<>();
//         transformedData.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});
        
//         try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
//             String line;
//             br.readLine(); // Skip header
            
//             while ((line = br.readLine()) != null) {
//                 String[] parts = line.split(",");
//                 if (parts.length < 4) continue; // Skip invalid rows
                
//                 String productId = parts[0];
//                 String name = parts[1].toUpperCase();
//                 double price = Double.parseDouble(parts[2]);
//                 String category = parts[3];
                
//                 // Apply discount to Electronics
//                 if (category.equals("Electronics")) {
//                     price *= 0.9; // 10% discount
//                     price = Math.round(price * 100.0) / 100.0; // Round to 2 decimal places
//                 }
                
//                 // Adjust category if price > 500
//                 if (price > 500) {
//                     category = "Premium Electronics";
//                 }
                
//                 // Determine PriceRange
//                 String priceRange;
//                 if (price <= 10) {
//                     priceRange = "Low";
//                 } else if (price <= 100) {
//                     priceRange = "Medium";
//                 } else if (price <= 500) {
//                     priceRange = "High";
//                 } else {
//                     priceRange = "Premium";
//                 }
                
//                 transformedData.add(new String[]{productId, name, String.valueOf(price), category, priceRange});
//             }
//         } catch (FileNotFoundException e) {
//             System.err.println("Error: Input file not found: " + inputFile);
//             return null;
//         } catch (IOException e) {
//             System.err.println("Error reading file: " + inputFile);
//             return null;
//         } catch (NumberFormatException e) {
//             System.err.println("Error: Invalid number format in input file.");
//             return null;
//         }
        
//         return transformedData;
//     }
    
//     private static void load(String outputFile, List<String[]> data) {
//         try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
//             for (String[] row : data) {
//                 bw.write(String.join(",", row));
//                 bw.newLine();
//             }
//             System.out.println("Transformation successful! Output saved to " + outputFile);
//         } catch (IOException e) {
//             System.err.println("Error writing to file: " + outputFile);
//         }
//     }
// }


package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

public class ETLpipeline {
    public static void main(String[] args) {
        String inputFile = "data/products.csv";
        String outputFile = "data/transformed_products.csv";
        
        List<String[]> transformedData = extractAndTransform(inputFile);
        if (transformedData != null) {
            load(outputFile, transformedData);
        }
    }

    private static List<String[]> extractAndTransform(String inputFile) {
        List<String[]> transformedData = new ArrayList<>();
        transformedData.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            br.readLine(); // Skip header
            
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 4) continue; // Skip invalid rows
                
                String productId = parts[0];
                String name = parts[1].toUpperCase();
                double price = Double.parseDouble(parts[2]);
                String category = parts[3];
                
                // Apply discount to Electronics
                if (category.equals("Electronics")) {
                    price *= 0.9; // 10% discount
                }
                
                // Adjust category if price > 500
                if (price > 500) {
                    category = "Premium Electronics";
                }
                
                // Round price to 2 decimal places
                price = Math.round(price * 100.0) / 100.0;
                
                // Determine PriceRange
                String priceRange = determinePriceRange(price);
                
                transformedData.add(new String[]{productId, name, String.valueOf(price), category, priceRange});
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found: " + inputFile);
            return null;
        } catch (IOException e) {
            System.err.println("Error reading file: " + inputFile);
            return null;
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in input file.");
            return null;
        }
        
        return transformedData;
    }
    
    private static String determinePriceRange(double price) {
        if (price <= 10) {
            return "Low";
        } else if (price <= 100) {
            return "Medium";
        } else if (price <= 500) {
            return "High";
        } else {
            return "Premium";
        }
    }
    
    private static void load(String outputFile, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
            System.out.println("Transformation successful! Output saved to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + outputFile);
        }
    }
}