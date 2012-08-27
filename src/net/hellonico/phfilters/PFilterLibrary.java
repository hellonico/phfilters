/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package net.hellonico.phfilters;


import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import java.util.HashMap;

import processing.core.PImage;

import com.jhlabs.image.AbstractBufferedImageOp;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 * @example Hello 
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class PFilterLibrary {
	
	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Hello
	 * @param theParent
	 */
	public PFilterLibrary() {
		
	}
	
	public PImage apply(PImage image, AbstractBufferedImageOp filter) {
	     BufferedImage img = (BufferedImage) image.getImage();
	     return new PImage(filter.filter(img, img));
	} 
	public AbstractBufferedImageOp getFilter(String name) {
		return this.getFilter(name, new HashMap());
	}
	public AbstractBufferedImageOp getFilter(String name, HashMap settings) {
		try {
			Class klass = Class.forName("com.jhlabs.image."+name+"Filter");
			Method[] ms = klass.getMethods();
			for(Method m : ms) {
				String name_ = m.getName();
				if(name_.startsWith("set")) {
					Object o = settings.get(name_);
				}
			}
			AbstractBufferedImageOp newFilter = (AbstractBufferedImageOp) klass.newInstance();
			return newFilter;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String version() {
		return VERSION;
	}

}

