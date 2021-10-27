/*******************************************************************************
 * Copyright (c) 2014 Faktor Zehn AG.
 * 
 * Alle Rechte vorbehalten.
 *******************************************************************************/

package de.faktorzehn.training.linkki.partner.ui;

import org.linkki.core.ui.element.annotation.UILabel;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;

@UISection
public class HelloWorldSectionPmo {

	private String name;

	public HelloWorldSectionPmo() {
		this.name = "Helen";
	}

	@UITextField(label = "Name: ", position = 1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@UILabel(label = "", position = 2)
	public String getGruss() {
		// TODO
		return "";
	}
}
