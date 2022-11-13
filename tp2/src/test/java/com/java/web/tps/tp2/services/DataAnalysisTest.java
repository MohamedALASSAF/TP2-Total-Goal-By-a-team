package com.java.web.tps.tp2.services;

import com.java.web.tps.tp2.entities.Match;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataAnalysisTest {

    @Test
    void getAllMatch() {
        String team="Barcelona";
        String year = "2011";

        assertEquals(DataAnalysis.totalGoals(year,team), 35);
        team="AC Milan";
        year = "2011";

        assertEquals(DataAnalysis.totalGoals(year,team), 60);
    }
}