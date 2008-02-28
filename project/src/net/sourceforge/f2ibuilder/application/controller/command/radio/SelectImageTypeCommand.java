package net.sourceforge.f2ibuilder.application.controller.command.radio;

import javax.swing.JRadioButtonMenuItem;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class SelectImageTypeCommand extends RadioCommand
{  
    public SelectImageTypeCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    protected void action(JRadioButtonMenuItem radio)
    {
        if (radio.getName().equalsIgnoreCase("BMP")){
            options.setImageType(Options.IMAGE_TYPE_BMP);
        } else {
            options.setImageType(Options.IMAGE_TYPE_PNG);                    
        }
    }
}
