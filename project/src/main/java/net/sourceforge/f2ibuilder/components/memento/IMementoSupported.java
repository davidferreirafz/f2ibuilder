/**
 * 
 */
package net.sourceforge.f2ibuilder.components.memento;

/**
 * @author David Ferreira <davidferreira.fz@gmail.com>
 *
 * Project: F2IBuilder
 * Date: 14/04/2008
 *
 */
public interface IMementoSupported
{
    /**
     * Suporte para recuperação de um estado anterior
     * 
     * Suporte ao design pattern: GoF - Memento
     * 
     * @param memento objeto com o estado anterior
     */
    public void setMemento(ProjectMemento memento);
    
    /**
     * Implementação do suporte para a externalização do estado da classe, sem expor
     * seus valores para manipulação de outras classes.
     * 
     * Suporte ao design pattern: GoF - Memento
     */
    public ProjectMemento createMemento();
}
