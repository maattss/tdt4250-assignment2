package tdt4250.unit.gogo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.felix.service.command.Descriptor;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;

import tdt4250.unit.api.Unit;
import tdt4250.unit.api.UnitSearchResult;

// see https://enroute.osgi.org/FAQ/500-gogo.html

@Component(
		service = UnitCommands.class,
		property = {
			"osgi.command.scope=dict",
			"osgi.command.function=list",
			"osgi.command.function=lookup",
			"osgi.command.function=add",
			"osgi.command.function=remove"
		}
	)
public class UnitCommands {

//	@Descriptor("list available dictionaries")
//	public void list() {
//		Activator activator = Activator.getActivator();
//		System.out.print("Dictionaries: ");
//		for (String dictName : activator.getAllDictComponentNames()) {
//			System.out.print(dictName);
//			if (activator.isManual(dictName)) {
//				System.out.print("*");						
//			}
//			System.out.print(" ");
//		}
//		System.out.println();
//	}
//
//	@Descriptor("look up a word in each available dictionary")
//	public void lookup(
//			@Descriptor("the word to look up")
//			String s
//			) {
//		BundleContext bc = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
//		try {
//			// iterate through all Unit service objects
//			for (ServiceReference<Unit> serviceReference : bc.getServiceReferences(Unit.class, null)) {
//				Unit dict = bc.getService(serviceReference);
//				try {
//					UnitSearchResult search = dict.search(s);
//					System.out.println(dict.getUnitName() + ": " + search.getMessage());
//				} finally {
//					bc.ungetService(serviceReference);
//				}
//			}
//		} catch (InvalidSyntaxException e) {
//		}
//	}
	
	// TODO: Add and remove unit converters
//	@Descriptor("Add a dictionary, with content from a URL and/or specific words")
//	public void add(
//			@Descriptor("the name of the new dictionary")
//			String name,
//			@Descriptor("the URL of file with the words, or a simple word to add to the dictionary")
//			String urlStringOrWord,
//			@Descriptor("additional words to add to the dictionary")
//			String... ss
//			) {
//		MutableWords words = null;
//		try {
//			URL url = new URL(urlStringOrWord);
//			try {
//				words = new ResourceWords(url.openStream());
//			} catch (IOException e) {
//				System.err.println("Couldn't read from " + url);
//				return;
//			}
//		} catch (MalformedURLException e) {
//			words = new SortedSetWords();
//			words.addWord(urlStringOrWord);
//		}
//		for (String s : ss) {
//			words.addWord(s);
//		}
//		boolean existed = Activator.getActivator().addDict(new CommandDict(name, words));
//		System.out.println("\"" + name + "\" dictionary " + (existed ? "replaced" : "added"));
//	}
//	
//	@Descriptor("remove a (manually added) dictionary")
//	public void remove(
//			@Descriptor("the name of the (manually added) dictionary to remove")
//			String name
//			) {
//		boolean removed = Activator.getActivator().removeDict(name);
//		System.out.println("\"" + name + "\" dictionary " + (removed ? "removed" : "was not added manually"));
//	}
}
