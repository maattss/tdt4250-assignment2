package tdt4250.unit.util;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import tdt4250.unit.api.Unit;
import tdt4250.unit.api.UnitSearchResult;

@Component(
		configurationPid = UnitsConvert.FACTORY_PID,
		configurationPolicy = ConfigurationPolicy.REQUIRE
		)
public class UnitsConvert implements Unit {
	
	public static final String FACTORY_PID = "tdt4250.unit.util.UnitsConvert";
	
	public static final String UNIT_NAME_PROP = "unitName";
	public static final String UNIT_CONVERSION_PROP = "unitConversion";
	

	private String name;
	private String conversion;
	
	@Override
	public String getUnitName() {
		return name;
	}

	protected void setUnitName(String name) {
		this.name = name;
	}
	
	@Override
	public String getUnitConversion() {
		return conversion;
	}
	
	protected void setUnitConversion(String conversion) {
		this.conversion = conversion;
	}
	
	public @interface UnitsConvertConfig {
		String unitName();
		String unitConversion() default "";
	}

	@Activate
	public void activate(BundleContext bc, UnitsConvertConfig config) {
		update(bc, config);
	}

	@Modified
	public void modify(BundleContext bc, UnitsConvertConfig config) {
		update(bc, config);		
	}
	
	protected void update(BundleContext bc, UnitsConvertConfig config) {
		System.out.println("Initializing conversion: " + config.unitName() + " " + config.unitConversion());
		setUnitName(config.unitName());
		setUnitConversion(config.unitConversion());
	}
	
	protected String getSuccessMessageStringFormat() {
		return "Yes, %s was found!";
	}

	protected String getFailureMessageStringFormat() {
		return "No, %s was not found!";
	}

	public UnitSearchResult convert(String convertNumber) {
		if (conversion != null) {
			return new UnitSearchResult(true, String.format(getSuccessMessageStringFormat(), convertNumber), null);
		} else {
			return new UnitSearchResult(false, String.format(getFailureMessageStringFormat(), convertNumber), null);
		}
	}

}
