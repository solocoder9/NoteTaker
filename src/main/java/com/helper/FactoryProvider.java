package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static SessionFactory factory; // Hibernate SessionFactory instance

    // Method to get the SessionFactory
    public static SessionFactory getFactory() {
        if (factory == null) {
            // Create a Configuration object and configure it using hibernate.cfg.xml
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return factory; // Return the SessionFactory
    }

    // Method to close the SessionFactory
    public static void closeFactory() {
        if (factory != null) {
            factory.close(); // Close the SessionFactory
        }
    }
}
