package com.example.price.calculate;
import jdk.internal.instrumentation.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private CacheService cacheService;
    public List<Price> getAllPrices(){
        List<Price> hotelList= new ArrayList<>();
        priceRepository.findAll().forEach(hotelList::add);
        return hotelList;
    }
    public void addPrice(Price price) {
        priceRepository.save(price);
    }
    public int getprice(String hotel_id, String room_category_id, String date, int occupancy){
        Price temp=null;
        temp= cacheService.getPriceDetailsFromCache(hotel_id,room_category_id,date,occupancy);
        if(temp==null) {
            Price temp2= priceRepository.findPriceByHotel_idAndRoom_category_idAndDateAndOccupancy(hotel_id, room_category_id, date, occupancy);
            cacheService.setPriceDetailsInCache(temp2);
            return temp2.getPrice();
        }
        else {
            return temp.getPrice();
        }
    }
    public void updatePrice(String hotel_id, String room_category_id, String date, int occupancy,int price){
       priceRepository.getId(hotel_id,room_category_id,date,occupancy,price);
    }
}