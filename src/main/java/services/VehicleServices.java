package services;

import implementation.MichelinTyres;
import implementation.SonySpeaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    private SonySpeaker speaker;
    private MichelinTyres tyres;

    public SonySpeaker getSpeaker() {
        return speaker;
    }
    @Autowired
    public void setSpeaker(SonySpeaker speaker) {
        this.speaker = speaker;
    }

    public MichelinTyres getTyres() {
        return tyres;
    }
    @Autowired
    public void setTyres(MichelinTyres tyres) {
        this.tyres = tyres;
    }


}
