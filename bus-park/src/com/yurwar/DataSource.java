package com.yurwar;

import com.yurwar.model.Bus;
import com.yurwar.model.Driver;

public class DataSource {
    private Bus[] busArray = {
            new Bus(new Driver("Bruce", "Robertson"), "AB 0652 AA", 35, "Hyundai", 2003, 389_465),
            new Bus(new Driver("Boris", "Jones"), "AE 0012 AB", 26, "Isuzu", 2017, 96_455),
            new Bus(new Driver("Carl", "Murphy"), "AA 9112 TK", 26, "Mercedes", 2007, 180_971),
            new Bus(new Driver("Cliff", "Birds"), "BI 2792 BT", 228, "Daewoo", 2018, 41_378),
            new Bus(new Driver("Curtis", "Cook"), "BH 0200 BM", 102, "Solaris", 2001, 453_164),
            new Bus(new Driver("Dexter", "Round"), "BH 7777 TP", 102, "PAZ", 1983, 956_179),
            new Bus(new Driver("James", "Allford"), "BE 9175 CH", 465, "Isuzu", 2004, 301_506),
            new Bus(new Driver("Matthew", "Turner"), "AE 4564 AB", 437, "Iveco", 2009, 135_145),
            new Bus(new Driver("Norman", "Young"), "AB 8980 AA", 587, "Volvo", 2015, 91_862),
            new Bus(new Driver("Roger", "Gill"), "AA 6556 AB", 35, "LAZ", 1992, 743_784)
    };
    public Bus[] getBusArray() {
        return busArray;
    }
}
