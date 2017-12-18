package se.ff.bs;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class BusCtrl {



    @RequestMapping("/bus/{station}/{nr}")
    public BusInfo bus(@PathVariable String station, @PathVariable String nr) {
        int eta = getEtaBasedOnGpsAndOtherAdcancedStuff();
        BusInfo b = new BusInfo(station, nr, eta);
        return b;
    }

    private int getEtaBasedOnGpsAndOtherAdcancedStuff() {
        Random rn = new Random();
        int min = 1;
        int max = 7;
        return rn.nextInt(max - min + 1) + min;
    }


}

// http://localhost:8111/bus/Central-park/201