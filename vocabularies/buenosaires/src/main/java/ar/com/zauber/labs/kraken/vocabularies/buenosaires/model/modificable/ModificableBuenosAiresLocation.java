/**
 *  Copyright (c) 2009-2010 Zauber S.A.  -- All rights reserved
 */
package ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.modificable;

import org.openrdf.elmo.annotations.rdf;

import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.BuenosAiresLocation;
import ar.com.zauber.labs.kraken.vocabularies.buenosaires.model.NamespaceUtils;
import ar.com.zauber.labs.kraken.vocabularies.location.modificable.ModificableLocation;

/**
 * {@link BuenosAiresLocation} que es modificable (para carga) 
 * 
 * @author Juan F. Codagnone
 * @since Nov 20, 2009
 */
@rdf(NamespaceUtils.TYPE_BUE_LOCATION)
public interface ModificableBuenosAiresLocation extends 
                    BuenosAiresLocation, ModificableLocation {

    /** @see BuenosAiresLocation#getBlock() */
    void setBlock(String  block);

    /** @see BuenosAiresLocation#getSection() */
    void setSection(Integer section);

    /** @see BuenosAiresLocation#getLot()*/
    @rdf(NamespaceUtils.BUE_LOCATION_LOT)
    void setLot(String lot);
    
    /** @see BuenosAiresLocation#getDoorCode() */
    void setDoorCode(Integer  doorCode);

    // XXX DUPLICO METODOS DE COMPANY PARA QUE ELMO FUNCIONE (ME SUENA A BUG) //
    /** @return la manzana donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_BLOCK)
    String getBlock();

    /** @return la sección donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_SECTION)
    Integer getSection();

    /** @return la parcela donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_LOT)
    String getLot();
    
    /** @return el codigo de puerta de donde está el local (dato de catastro) */
    @rdf(NamespaceUtils.BUE_LOCATION_DOORCODE)
    Integer getDoorCode();
}
