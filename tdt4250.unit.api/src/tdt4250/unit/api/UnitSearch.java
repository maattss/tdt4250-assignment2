package tdt4250.unit.api;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UnitSearch {

	private static final String DEFAULT_MESSAGE = "Sorry, no matches";
	private Collection<Unit> conversions = new ArrayList<Unit>();
	
	public void addConversion(Unit unit) {
		conversions.add(unit);
	}

	public void removeConversion(Unit unit) {
		conversions.remove(unit);
	}
	
	public UnitSearch(Unit... units) {
		conversions.addAll(Arrays.asList(units));
	}
	
	private UnitSearchResult search(String searchKey, Iterable<Unit> conversions) {
		StringBuilder messages = new StringBuilder();
		URI link = null;
		boolean success = false;
		for (Unit unit : conversions) {
			UnitSearchResult result = unit.search(searchKey);
			if (result.isSuccess()) {
				messages.append(result.getMessage());
				messages.append("(" + unit.getUnitName() + ")\n");
				success = true;
				if (link == null) {
					link = result.getLink();
				}
			}
		}
		if (messages.length() == 0) {
			messages.append(DEFAULT_MESSAGE);
		}
		return new UnitSearchResult(success, messages.toString(), link);
	}

	public UnitSearchResult search(String dictKey, String searchKey) {
		return search(searchKey, conversions.stream().filter(dict -> dict.getUnitName().equals(dictKey)).collect(Collectors.toList()));
	}

	public UnitSearchResult search(String searchKey) {
		return search(searchKey, conversions);
	}
}
