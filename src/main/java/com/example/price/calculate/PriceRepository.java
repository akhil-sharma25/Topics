package com.example.price.calculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.data.annotation.Id;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price,String> {
   @Query(value = "Select * from Price2 p where p.hotel_id = :hotel_id and p.room_category_id= :room_category_id and p.date=:date  and p.occupancy=:occupancy",nativeQuery = true)
   Price  findPriceByHotel_idAndRoom_category_idAndDateAndOccupancy(@Param("hotel_id") String hotel_id, @Param("room_category_id") String room_category_id, @Param("date") String date, @Param("occupancy") int occupancy);
  @Modifying(clearAutomatically = true)
  @Transactional
  @Query(value="UPDATE Price2 price SET price=:price where hotel_id = :hotel_id and room_category_id= :room_category_id and date=:date  and occupancy=:occupancy",nativeQuery = true)
  void getId(@Param("hotel_id") String hotel_id, @Param("room_category_id") String room_category_id, @Param("date") String date, @Param("occupancy") int occupancy,@Param("price") int price);
}