package tdt4250.unit.gogo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import tdt4250.unit.api.Unit;

public class Activator implements BundleActivator {

	private static Activator SINGLETON = null;
	
	static Activator getActivator() {
		return SINGLETON;
	}
	
	@Override
	public void start(BundleContext context) throws Exception {
		SINGLETON = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		SINGLETON = null;
	}
	
	private Map<String, ServiceRegistration<Unit>> serviceRegistrations = new HashMap<String, ServiceRegistration<Unit>>();

	public boolean isManual(String dictName) {
		return serviceRegistrations.containsKey(dictName);
	}

	public Collection<String> getAllDictComponentNames() {
		Collection<String> allNames = new ArrayList<>();
		// iterate through all Unit service objects
		BundleContext bc = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		try {
			for (ServiceReference<Unit> serviceReference : bc.getServiceReferences(Unit.class, null)) {
				Unit dict = bc.getService(serviceReference);
				try {
					allNames.add(dict.getUnitName());
				} finally {
					bc.ungetService(serviceReference);
				}
			}
		} catch (InvalidSyntaxException e) {
		}
		return allNames;
	}
	
	public boolean addDict(Unit unit) {
		boolean existed = removeDict(unit.getUnitName());
		BundleContext bc = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		ServiceRegistration<Unit> serviceRegistration = bc.registerService(Unit.class, unit, null);
		serviceRegistrations.put(unit.getUnitName(), serviceRegistration);
		return existed;
	}
	
	public boolean removeDict(String name) {
		if (serviceRegistrations.containsKey(name)) {
			serviceRegistrations.get(name).unregister();
			serviceRegistrations.remove(name);
			return true;
		}
		return false;
	}
}
