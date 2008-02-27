package net.sourceforge.f2ibuilder.application.controller.file;

import java.awt.Component;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.f2ibuilder.application.controller.generics.SaveFile;
import net.sourceforge.f2ibuilder.application.model.Options;
import net.sourceforge.f2ibuilder.application.view.image.FontImage;
import net.sourceforge.f2ibuilder.components.dialog.FileDialog;

public class SaveFileImage extends SaveFile
{
    private FontImage fontImage;
    private Options options;
    
    public SaveFileImage(Options options,FontImage fontImage)
    {
        this.options=options;
        this.fontImage=fontImage;
    }

    @Override
    protected void action(Component component)
    {
        FileDialog fd = FileDialog.getInstance(); 
        
        if(fd.showSaveDialogImage(component)){
            
            String filename = fd.getFilePathImage();
            
            RenderedImage image = fontImage.getImage();
            
            try {
                if (image!=null){
                    if (!filename.endsWith(options.getImagemTipo())){
                        filename+="."+options.getImagemTipo();
                    }
                    ImageIO.write(image,options.getImagemTipo(),new File(filename));
                }
                
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }

}
