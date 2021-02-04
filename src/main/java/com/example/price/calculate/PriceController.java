package com.example.price.calculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController // To start Controller
public class PriceController {
    @Autowired //Object Injection
    private PriceService priceService;
    @RequestMapping("/prices") //For mapping url
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }
    @RequestMapping(method= RequestMethod.POST,value="/prices")
    public void addTopic(@RequestBody Price price) {
        priceService.addPrice(price);
    }
    @RequestMapping(method= RequestMethod.GET,value = "/pricesSpecific")
    public int getSpecific(@RequestParam String hotel_id, @RequestParam(required=false) String room_category_id , @RequestParam(required=false) String date, @RequestParam int occupancy) {
        return priceService.getprice(hotel_id, room_category_id, date, occupancy);
    }
    @RequestMapping(method=RequestMethod.PUT,value="/updatePrice")
    public void updateTopic(@RequestParam String hotel_id, @RequestParam(required=false) String room_category_id , @RequestParam(required=false) String date, @RequestParam int occupancy,@RequestParam int price) {
        priceService.updatePrice(hotel_id,room_category_id,date,occupancy,price);
    }
}
