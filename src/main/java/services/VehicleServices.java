package services;

import repository.SpeakerImp;
import repository.TyresImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleServices {

    private SpeakerImp speaker;
    private TyresImp tyres;

    public SpeakerImp getSpeaker() {
        return speaker;
    }
    public void playMusic(){
        String music = speaker.makeSound();
        System.out.println(music);
    }

    public void moveVehicle(){
        String status = tyres.moveCar();
        System.out.println(status);
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
