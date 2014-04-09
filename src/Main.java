import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import dhbw.employee.generated.Test;

public class Main {
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("Aufgabe 3-4/beispieldokument.xml");

		Test test = JAXB.unmarshal(fis, Test.class);

		System.out.println("abc      : " + test.getAbc());
		System.out.println("def start: " + test.getDef().getStartTime());
		System.out.println("def end  : " + test.getDef().getEndTime());
		System.out.println();
		System.out.println("Als XML: \n" + toString(test));
	}

	private static String toString(Object object) throws JAXBException {
		StringWriter writer = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(object.getClass());
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		m.marshal(object, writer);
		return writer.toString();
	}

}
