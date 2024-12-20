package services;

import implementation.MichelinTyres;
import implementation.SonySpeaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON) // SCOPE_SINGLETON is the default scope of a bean in Spring
                                       // So if you don't declare the @Scope for the @Component it still created as SCOPE_SINGLETON
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
