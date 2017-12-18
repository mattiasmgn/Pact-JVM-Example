package se.ff.bs;

/**
 * Created by set842 on 29/11/17.
 */
public class BusInfo {
    String station;
    String nr;
    Integer eta;


    public BusInfo(String station, String nr, Integer eta) {
        this.station=station;
        this.nr = nr;
        this.eta = eta;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public Integer getEta() {
        return eta;
    }

    public void setEta(Integer eta) {
        this.eta = eta;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}
