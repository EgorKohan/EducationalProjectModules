package com.rest.assured.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class OddModel {

    private Long id;

    private Data data;

    private List<Odd> odds = new ArrayList<>();

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data {
        private long leagueId;
        private String homeTeam;
        private String visitingTeam;
    }

    @lombok.Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Odd{
        private float price;
        private String name;
    }

    public OddModel(Data data, List<Odd> odds) {
        this.data = data;
        this.odds = odds;
    }
}
