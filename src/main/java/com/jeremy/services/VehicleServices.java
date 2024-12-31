package com.jeremy.services;

import com.jeremy.repository.SpeakerImp;
import com.jeremy.repository.TyresImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.jeremy.repository.impl.Song;

import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class VehicleServices {

    private Logger logger = Logger.getLogger(VehicleServices.class.getName());

    private SpeakerImp speaker;
    private TyresImp tyres;

    public SpeakerImp getSpeaker() {
        return speaker;
    }

    // Logger with Aspect Oriented Programming
    public String playMusic(boolean vehicleStarted, Song song){
        String music = null;
        if(vehicleStarted){
            music = speaker.makeSound(song);
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
        return speaker.makeSound(song);
    }

    // Logger with Aspect Oriented Programming
    public String moveVehicle(boolean vehicleStarted){
        String status = null;
        if(vehicleStarted){
            status = tyres.rotate();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
        return tyres.rotate();
    }

    // Logger with Aspect Oriented Programming
    public String applyBrake(boolean vehicleStarted){
        String status = null;
        if(vehicleStarted){
            status = tyres.stop();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
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
