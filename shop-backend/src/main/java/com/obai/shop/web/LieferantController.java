package com.obai.shop.controller; // Dein Package Name anpassen

import org.springframework.web.bind.annotation.*;
import com.obai.shop.model.Lieferant;
import java.util.List;

@RestController  // <--- DAS macht es zur API!
@RequestMapping("/api/lieferanten") // <--- Das ist die URL
public class LieferantController {

    // Hier bräuchtest du normalerweise noch ein "Repository", 
    // aber für den Anfang reicht auch ein Dummy-Test:

    @GetMapping
    public List<String> getAlleLieferanten() {
        return List.of("DHL", "UPS", "Hermes"); 
        // Später holst du hier echte Daten aus der Datenbank
    }
}