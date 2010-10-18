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
package ar.com.zauber.labs.kraken.vocabularies.review;

import org.openrdf.elmo.annotations.rdf;

/**
 * Feedback on the review. Expresses whether the review was useful or not. 
 * This term is undergoing testing to determine if it is semantically stable and 
 * its meaning may change in the foreseable future. Having a commenter implies 
 * being a member of this class. Things are a member of this class if they are 
 * the value of a hasFeedback. 
 * 
 * @author Juan F. Codagnone
 * @since Dec 1, 2009
 */
@rdf(ReviewNamespaceUtil.TYPE_FEEDBACK)
public interface Feedback extends Comment {

}
