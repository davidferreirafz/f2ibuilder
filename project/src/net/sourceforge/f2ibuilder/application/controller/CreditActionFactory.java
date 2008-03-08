/**
 * 
 */
package net.sourceforge.f2ibuilder.application.controller;

import java.awt.event.MouseListener;

import net.sourceforge.f2ibuilder.application.controller.generics.OpenWebSite;

/**
 * 
 * Designer Pattern : DiS - StaticFactory
 * 
 * @author David Ferreira <davidferreira.fz@gmail.com>
 * 
 * Project: F2IBuilder
 * Date: 08/03/2008
 *
 */
public class CreditActionFactory extends ActionFactory
{

    public static MouseListener makeOpenWebSite()
    {
        return new OpenWebSite();
    }

}
