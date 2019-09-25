package tdt4250.unit.fahrenheittocelsius;

import org.osgi.service.component.annotations.Component;

import tdt4250.unit.api.Unit;
import tdt4250.unit.util.UnitsConvert;

@Component(
		property = {
				UnitsConvert.UNIT_NAME_PROP + "=fahrenheittocelsius",
				UnitsConvert.UNIT_CONVERSION_PROP + "=(x-32)/1.8"}
		)
public class FahrenheitToCelsius extends UnitsConvert implements Unit {
}
