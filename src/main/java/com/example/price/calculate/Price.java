package com.example.price.calculate;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;
@Entity //Means that can be map on a table.
@Table(name = "price2")
public class Price {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private  String hotel_id;
 private String  room_category_id;
 private String date;
 private int price;
 private int occupancy;
 public Price() {
 }
 public Price(String hotel_id, String room_category_id, String date, int price, int occupancy) {
  this.hotel_id = hotel_id;
  this.room_category_id = room_category_id;
  this.date = date;
  this.price = price;
  this.occupancy = occupancy;
 }
 public void setId(Long id) {
  this.id = id;
 }

 public void setHotel_id(String hotel_id) {
  this.hotel_id = hotel_id;
 }

 public void setRoom_category_id(String room_category_id) {
  this.room_category_id = room_category_id;
 }

 public void setDate(String date) {
  this.date = date;
 }

 public void setPrice(int price) {
  this.price = price;
 }

 public void setOccupancy(int occupancy) {
  this.occupancy = occupancy;
 }

 public Long getId() {
  return id;
 }

 public String getHotel_id() {
  return hotel_id;
 }

 public String getRoom_category_id() {
  return room_category_id;
 }

 public String getDate() {
  return date;
 }
 public int getPrice() {
  return price;
 }
 public int getOccupancy() {
  return occupancy;
 }
}