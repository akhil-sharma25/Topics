package com.example.price.calculate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.databind.ObjectMapper;
@Slf4j 
@Component
public class CacheService {
    @Autowired
    RmsCache rmsCache;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void setPriceDetailsInCache (Price price)
    {
        try {
            String key = "Price_DETAILS" + "_" + price.getHotel_id()+price.getRoom_category_id()+price.getDate()+Integer.toString(price.getOccupancy());
            Long ttl=Long.valueOf(2*24*60*60*1000);
            rmsCache.set(key, objectMapper.writeValueAsString(price),ttl);
        }catch (Exception ex){
            log.error("exception occured while setting property_details in cache :: {}",price.toString());
        }
    }
    public Price getPriceDetailsFromCache (String hotel_id, String room_category_id, String date, int occupancy)
    {
        String id=hotel_id+room_category_id+date+Integer.toString(occupancy);
        try {
            log.info("fetching topic details from cache :: {}",id);
            String key = "Price_DETAILS" + "_" + id;
            String value=rmsCache.get(key);
            Price response= objectMapper.readValue(value,Price.class);
            log.info("null nhi return hua h");
            return response;
        }catch (Exception ex){
            log.info("exception occured while fetching property_details in cache :: {}",id);
        }
        return null;
    }

}