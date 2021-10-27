/*******************************************************************************
 * Copyright (c) 2014 Faktor Zehn AG.
 * 
 * Alle Rechte vorbehalten.
 *******************************************************************************/

package de.faktorzehn.training.linkki.partner.ui;

import org.linkki.core.binding.manager.BindingManager;
import org.linkki.core.binding.manager.DefaultBindingManager;
import org.linkki.core.binding.validation.ValidationService;
import org.linkki.core.vaadin.component.page.AbstractPage;

import com.vaadin.flow.component.html.Label;

import de.faktorzehn.training.linkki.TrainingStyles;
import de.faktorzehn.training.linkki.partner.PartnerRepository;

public class PartnerPage extends AbstractPage {

	private static final long serialVersionUID = 1L;

	private final BindingManager bindingManager = new DefaultBindingManager(ValidationService.NOP_VALIDATION_SERVICE);
	private final PartnerRepository partnerRepository;

	public PartnerPage(PartnerRepository partnerRepository) {
		this.partnerRepository = partnerRepository;
	}

	@Override
	public void createContent() {
		setMargin(true);

		Label heading = new Label("Partnerverwaltung");
		heading.setSizeFull();
		heading.addClassName(TrainingStyles.HEADING);
		add(heading);
		addSearchSection();
	}

	private void addSearchSection() {
		addSection(new HelloWorldSectionPmo());
	}

	@Override
	protected BindingManager getBindingManager() {
		return bindingManager;
	}

}
