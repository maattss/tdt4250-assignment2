package tdt4250.unit.util;


import java.util.HashMap;
import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import javax.script.*;

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
		setUnitName(config.unitName());
		setUnitConversion(config.unitConversion());
	}

	public UnitSearchResult convert(String convertNumber) {
		Map<String, Object> vars = new HashMap<String, Object>();
		String result = "";
		Double numb = Double.parseDouble(convertNumber);
		try {
			vars.put("x", Double.parseDouble(convertNumber));
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
			result = String.format("%.2f", engine.eval(conversion, new SimpleBindings(vars)));
		} catch (Exception e) {
			if (e instanceof ScriptException) {
				String msg = "Ups! Something wrong happened when evaulating the expression, " + conversion + ".";
				return new UnitSearchResult(false, msg, null);
			} else if (e instanceof NumberFormatException) {
				String msg = "Illegal input parameter, " + convertNumber + ". Please try another one!";
				return new UnitSearchResult(false, msg, null);
			}	
		} 
		return new UnitSearchResult(true, String.format("%s: %.2f converted to %s", getUnitName(), numb, result), null);
	}

}
