package com.mypackage;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        Cart cart = Cart.getInstance();
        for (int i = 0; i <= 100; i++) {
            Product product = new Product("Product " + i,random.nextInt(9 - 1 + 1) + 1,random.nextInt(9 - 1 + 1) + 1);
            cart.addProduct(product);
        }

        cart.checkout();
        cart.clear();
        cart.checkout();
    }
}
