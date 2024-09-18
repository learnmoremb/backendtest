package com.example.pract.domain.dto.request;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;



@Data
public class ItemRequest{
         public long device_id;
        public String label;
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        public ZonedDateTime expiryDate;
        public String model;

}


