package tdt4250.unit.rest;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//import javax.json.JsonObject;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import com.fasterxml.jackson.core.JsonProcessingException;

import tdt4250.unit.api.Unit;
import tdt4250.unit.api.UnitSearch;
import tdt4250.unit.api.UnitSearchResult;

@Component(service=UnitResource.class)
@JaxrsResource
@Path("unit")
public class UnitResource {

	@Reference(
			policy = ReferencePolicy.DYNAMIC
			)
	private volatile Collection<Unit> conversions;
	
	public UnitSearch getUnitSearch() {
		return new UnitSearch(conversions.toArray(new Unit[conversions.size()]));
	}
	
	@GET
	@Path("/{conversion}")
	@Produces(MediaType.APPLICATION_JSON)
	public UnitSearchResult search(@PathParam("conversion") String conversion, @QueryParam("q") String q) throws JsonProcessingException {
		return getUnitSearch().search(conversion, q);
	}
}
