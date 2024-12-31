package repository.impl;

import repository.SpeakerImp;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("Bose")
@Primary
public class BoseSpeaker implements SpeakerImp {

    @Override
    public String makeSound(Song song) {
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Bose speakers";
    }

}
