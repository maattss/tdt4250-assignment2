package tdt4250.unit.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Unit {
	String getUnitName();
	UnitSearchResult search(String searchKey);

}
