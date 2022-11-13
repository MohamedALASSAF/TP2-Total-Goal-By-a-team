package com.java.web.tps.tp2.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.java.web.tps.tp2.entities.Match;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIResponse {
    Integer page;
    Integer per_page;
    Integer total;
    Integer total_pages ;
    List<Match> data;
}
