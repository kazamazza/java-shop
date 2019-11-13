package com.mypackage;

import java.util.ArrayList;

class Cart
{
    private static ArrayList<Product> items = new ArrayList<Product>();
    private static Cart instance;
    private static int total = 0;
    private Cart(){}

    public static Cart getInstance(){
        if(instance == null){
            instance = new Cart();
        }
        return instance;
    }

    public static void addProduct(Product product) {
        if (product.getStock() >= 1) {
            items.add(product);
            product.setStock(product.getStock() - 1);
            String message =  String.format("%s was added to cart", product.getName());
        } else {
            String message =  String.format("Sorry, %s is out of stock", product.getName());
        }
    }

    public static void removeProduct(Product product) {
        items.remove(product);
        product.setStock(product.getStock() + 1);
    }

    public static void clear() {
        if (items.size() > 0) {
            for (Product p : items) {
                p.setStock(p.getStock() + 1);
            }
            items.clear();
        }
        total = 0;
    }

    public static void checkout() {
        for (Product p: items) {
            String message = String.format("Product name: %s Price: %d Stock: %s",p.getName(),p.getPrice(),p.getStock());
            System.out.println(message);
            total += p.getPrice();
        }
        getTotal();
    }
     private static void getTotal() {
        System.out.println("Total cart value is "+ total);
     }
}

