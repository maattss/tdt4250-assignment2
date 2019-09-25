package tdt4250.unit.milestokm;

import org.osgi.service.component.annotations.Component;

import tdt4250.unit.api.Unit;
import tdt4250.unit.util.UnitsConvert;

@Component(
		property = {
				UnitsConvert.UNIT_NAME_PROP + "=milestokm",
				UnitsConvert.UNIT_CONVERSION_PROP + "=x*1.609344"}
		)
public class MilesToKm extends UnitsConvert implements Unit {
}
