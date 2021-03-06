/**
 * Copyright (c) 2009-2010 Zauber S.A. <http://www.zauber.com.ar/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.zauber.labs.kraken.vocabularies.tagging;


/**
 * Constantes de namespace
 * 
 * 
 * @author Cecilia Hagge
 * @since Jan 15, 2010
 */
public interface TagNamespaceUtils {

   String NAMESPACE_TAGS = "http://www.holygoat.co.uk/owl/redwood/0.1/tags/";
    
   String TYPE_TAGEABLE = NAMESPACE_TAGS + "Tageable";
   
   String TYPE_TAGRESOURCE = NAMESPACE_TAGS + "taggedResource";
   
   String TYPE_TAGWITH = NAMESPACE_TAGS + "taggedWithTag";
  
   
}
