package com.java.web.tps.tp2.entities;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Match {
    private String competition;
    private int year;
    private String round;
    private String team1;
    private String team2;
    private int team1goals;
    private int team2goals;


}
