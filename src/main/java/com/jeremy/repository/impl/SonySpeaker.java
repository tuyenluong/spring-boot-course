package com.jeremy.repository.impl;

import com.jeremy.repository.SpeakerImp;
import org.springframework.stereotype.Component;

@Component("Sony")
public class SonySpeaker implements SpeakerImp {

    @Override
    public String makeSound(Song song) {
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Bose speakers";
    }

    @Override
    public String toString(){
        return "- "+ "This is Sony speaker";
    }
}
