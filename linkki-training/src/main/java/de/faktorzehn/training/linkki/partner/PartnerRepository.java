/*******************************************************************************
 * Copyright (c) 2014 Faktor Zehn AG.
 * 
 * Alle Rechte vorbehalten.
 *******************************************************************************/

package de.faktorzehn.training.linkki.partner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.faktorips.runtime.ClassloaderRuntimeRepository;
import org.faktorips.runtime.IRuntimeRepository;

import de.faktorzehn.partnermodel.AddressGermany;
import de.faktorzehn.partnermodel.EmailAddress;
import de.faktorzehn.partnermodel.Gender;
import de.faktorzehn.partnermodel.NaturalPerson;
import de.faktorzehn.partnermodel.Partner;

public class PartnerRepository {

	public final static IRuntimeRepository PRODUCT_REPOSITORY = ClassloaderRuntimeRepository
			.create("de/faktorzehn/partnermodel/internal/german-default-repository-toc.xml");

	private final static PartnerRepository PARTNER_REPOSITORY = new PartnerRepository();

	private final List<Partner> partners = new ArrayList<>();

	private PartnerRepository() {
		partners.add(NaturalPerson.builder() //
				.givenName("John") //
				.surname("Doe") //
				.dateOfBirth(LocalDate.of(1975, 6, 1)) //
				.gender(Gender.MALE) //
				.add().address(AddressGermany.builder() //
						.streetName("Hansastr").number("10a")) //
				.getResult());

		partners.add(NaturalPerson.builder() //
				.givenName("Jane") //
				.surname("Doe") //
				.dateOfBirth(LocalDate.of(1980, 9, 15)) //
				.gender(Gender.FEMALE) //
				.add().emailAddress(EmailAddress.builder() //
						.localPart("jane.doe").domainPart("thedoes.com"))
				.add().address(AddressGermany.builder() //
						.streetName("Foo-Str").number("10a")) //
				.getResult());

		partners.add(NaturalPerson.builder() //
				.givenName("Jimmy") //
				.surname("Doe") //
				.dateOfBirth(LocalDate.of(1980, 9, 15)) //
				.gender(Gender.MALE) //
				.add().address(AddressGermany.builder() //
						.streetName("Bar-Str").number("10a")) //
				.getResult());
	}

	public List<Partner> getPartners() {
		return Collections.unmodifiableList(partners);
	}

	public List<NaturalPerson> getNaturalPersons() {
		return partners.stream().filter(p -> p instanceof NaturalPerson).map(p -> (NaturalPerson) p)
				.collect(Collectors.toList());
	}

	public List<NaturalPerson> search(String vorname, String nachname, LocalDate gebDatum) {
		return getNaturalPersons().stream().filter(np -> match(np, vorname, nachname, gebDatum))
				.collect(Collectors.toList());
	}

	private boolean match(NaturalPerson np, String vorname, String nachname, LocalDate gebDatum) {
		if (!matchPattern(vorname, np.getGivenName())) {
			return false;
		}
		if (!matchPattern(nachname, np.getSurname())) {
			return false;
		}
		if (gebDatum != null && !gebDatum.equals(np.getDateOfBirth())) {
			return false;
		}
		return true;
	}

	private boolean matchPattern(String pattern, String text) {
		return StringUtils.isBlank(pattern) || (text != null && text.matches(pattern + ".*"));
	}

	public int getSize() {
		return partners.size();
	}

	public void addPartner(Partner p) {
		partners.add(p);
	}

	public void removePartner(Partner p) {
		partners.remove(p);
	}

	public static PartnerRepository get() {
		return PARTNER_REPOSITORY;
	}
}
