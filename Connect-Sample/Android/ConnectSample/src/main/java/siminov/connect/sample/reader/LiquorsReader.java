/** 
 * [SIMINOV FRAMEWORK]
 * Copyright [2015] [Siminov Software Solution LLP|support@siminov.com]
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
 **/

package siminov.connect.sample.reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import siminov.connect.sample.Constants;
import siminov.connect.sample.model.Liquor;
import siminov.core.exception.DeploymentException;
import siminov.core.log.Log;
import siminov.core.reader.SiminovSAXDefaultHandler;

public class LiquorsReader extends SiminovSAXDefaultHandler implements Constants {

	private Collection<Liquor> liquors = new ArrayList<Liquor>();
	private Liquor liquor = null;
	
	
	private StringBuilder tempValue = new StringBuilder();

	
	public LiquorsReader(InputStream data) {
		
		if(data == null) {
			return;
		}
		
		
		try {
			parseMessage(data);
		} catch(Exception exception) {
			Log.error(getClass().getName(), "Constructor", "Exception caught while parsing Liquors, " + exception.getMessage());
			throw new DeploymentException(getClass().getName(), "Constructor", "Exception caught while parsing Liquors, " + exception.getMessage());
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		tempValue = new StringBuilder();
		
		if(localName.equalsIgnoreCase(GET_LIQUORS_WS_LIQUOR)) {
			liquor = new Liquor();
		}
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		
		String value = new String(ch,start,length);
		
		if(value == null || value.length() <= 0 || value.equalsIgnoreCase(NEW_LINE)) {
			return;
		}
		
		value = value.trim();
		tempValue.append(value);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		
		if(localName.equalsIgnoreCase(GET_LIQUORS_WS_LIQUOR)) {
			liquors.add(liquor);
		} else if(localName.equalsIgnoreCase(GET_LIQUORS_WS_LIQUOR_NAME)) {
			liquor.setLiquorType(tempValue.toString());
		} else if(localName.equalsIgnoreCase(GET_LIQUORS_WS_LIQUOR_DESCRIPTION)) {
			liquor.setDescription(tempValue.toString());
		} else if(localName.equalsIgnoreCase(GET_LIQUORS_WS_LIQUOR_HISTROY)) {
			liquor.setHistory(tempValue.toString());
		} else if(localName.equalsIgnoreCase(GET_LIQUORS_WS_LIQUOR_LINK)) {
			liquor.setLink(tempValue.toString());
		} else if(localName.equalsIgnoreCase(GET_LIQUORS_WS_LIQUOR_ALCHOL_CONTENT)) {
			liquor.setAlcholContent(tempValue.toString());
		}
	}
	
	public Iterator<Liquor> getLiquors() {
		return this.liquors.iterator();
	}
}
