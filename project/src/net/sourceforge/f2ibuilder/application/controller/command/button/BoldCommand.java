package net.sourceforge.f2ibuilder.application.controller.command.button;

import javax.swing.JToggleButton;

import net.sourceforge.f2ibuilder.application.model.FontText;
import net.sourceforge.f2ibuilder.application.model.Options;


public class BoldCommand extends ButtonCommand
{
    public BoldCommand(Options options, FontText fontText)
    {
        super(options,fontText);
    }

    @Override
    protected void action(JToggleButton button)
    {
        if (button.isSelected()){
            fontText.setBold(true);
        } else {
            fontText.setBold(false);                   
        }
    }   
}
