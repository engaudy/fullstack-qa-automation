package com.demoblaze.ui.utils;

import java.util.List;

public class CategoryUtils {

    public static List<String> getExpectedKeywordsForCategory(String category) {
        return switch (category.toLowerCase()) {
            case "phones" -> List.of(
                    "phone", "iphone", "samsung", "nokia", "pixel", "htc", "xperia", "nexus", "lumia", "galaxy", "sony"
            );
            case "laptops" -> List.of(
                    "laptop", "macbook", "dell", "vaio", "notebook", "asus", "hp", "lenovo", "sony"
            );
            case "monitors" -> List.of(
                    "monitors", "apple", "asus"
            );
            default -> throw new IllegalArgumentException("Unsupported category: " + category);
        };
    }
}
