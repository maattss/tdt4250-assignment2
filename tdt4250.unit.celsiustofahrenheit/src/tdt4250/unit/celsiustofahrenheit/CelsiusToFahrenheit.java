package tdt4250.unit.celsiustofahrenheit;

import org.osgi.service.component.annotations.Component;

import tdt4250.unit.api.Unit;
import tdt4250.unit.util.UnitsConvert;

@Component(
		property = {
				UnitsConvert.UNIT_NAME_PROP + "=celsiustofahrenheit",
				UnitsConvert.UNIT_CONVERSION_PROP + "=x*1.8+32"}
		)
public class CelsiusToFahrenheit extends UnitsConvert implements Unit {
}
