//package edu.javacourse.city.domain;
//
//import jakarta.xml.bind.annotation.adapters.XmlAdapter;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
//    @Override
//    public LocalDate unmarshal(String s) throws Exception {
//        return LocalDate.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//    }
//
//    @Override
//    public String marshal(LocalDate localDate) throws Exception {
//        return localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//    }
//}
