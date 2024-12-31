package services;

import repository.SpeakerImp;
import repository.TyresImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.impl.Song;

import java.time.Duration;
import java.time.Instant;
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

    // Logger without Aspect Oriented Programming
    public String playMusic(boolean vehicleStarted, Song song){
        Instant start = Instant.now();
        logger.info("method execution start");
        String music = null;
        if(vehicleStarted){
            music = speaker.makeSound(song);
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
        return speaker.makeSound(song);
    }

    // Logger without Aspect Oriented Programming
    public String moveVehicle(boolean vehicleStarted){
        Instant start = Instant.now();
        logger.info("method execution start");
        String status = null;
        if(vehicleStarted){
            status = tyres.rotate();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
        return tyres.rotate();
    }

    // Logger without Aspect Oriented Programming
    public String applyBrake(boolean vehicleStarted){
        Instant start = Instant.now();
        logger.info("method execution start");
        String status = null;
        if(vehicleStarted){
            status = tyres.stop();
        }else{
            logger.log(Level.SEVERE,"Vehicle not started to perform the" +
                    " operation");
        }
        logger.info("method execution end");
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        logger.info("Time took to execute the method : "+timeElapsed);
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
