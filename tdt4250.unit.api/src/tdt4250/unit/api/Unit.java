package tdt4250.unit.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Unit {
	String getUnitName();
	String getUnitConversion();
	UnitSearchResult convert(String convertNumber);
}
