package de.faktorzehn.training.linkki;

import org.linkki.framework.ui.application.ApplicationConfig;
import org.linkki.framework.ui.application.menu.ApplicationMenuItemDefinition;
import org.linkki.util.Sequence;

/**
 * An {@link ApplicationConfig} that defines no menu items and uses {@link TrainingApplicationInfo}.
 */
public class TrainingApplicationConfig implements ApplicationConfig {

	@Override
	public TrainingApplicationInfo getApplicationInfo() {
		return new TrainingApplicationInfo();
	}

	@Override
	public Sequence<ApplicationMenuItemDefinition> getMenuItemDefinitions() {
		return Sequence.empty();
	}

}
