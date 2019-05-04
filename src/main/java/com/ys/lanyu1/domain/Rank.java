package com.ys.lanyu1.domain;

import java.io.Serializable;

public class Rank  implements Serializable {

    private  Integer rank;

    private  String  name;

    private  Integer score;

//    private  Integer  id;
//
//    public Integer getId() {
//        return id;
//    }
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
