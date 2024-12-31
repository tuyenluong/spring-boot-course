package com.jeremy.services;

import com.jeremy.repository.LogAspect;
import com.jeremy.repository.SpeakerImp;
import com.jeremy.repository.TyresImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jeremy.repository.impl.Song;

@Component
public class VehicleServices {

    private SpeakerImp speaker;
    private TyresImp tyres;

    public SpeakerImp getSpeaker() {
        return speaker;
    }

    // Logger using AOP
    // Vehicle started validation using AOP
    @LogAspect
    public String playMusic(boolean vehicleStarted, Song song){
        return speaker.makeSound(song);
    }

    // Logger using AOP
    // Vehicle started validation using AOP
    @LogAspect
    public String moveVehicle(boolean vehicleStarted){
        return tyres.rotate();
    }

    // Logger using AOP
    // Vehicle started validation using AOP
    @LogAspect
    public String applyBrake(boolean vehicleStarted){
        return tyres.stop();
    }

    public SpeakerImp getSpeakers() {
        return speaker;
    }

    @Autowired
    public void setSpeakers(SpeakerImp speakers) {
        this.speaker = speakers;
    }

    public TyresImp getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(TyresImp tyres) {
        this.tyres = tyres;
    }


}
