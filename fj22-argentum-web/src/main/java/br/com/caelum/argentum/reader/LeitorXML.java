package br.com.caelum.argentum.reader;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXML {
	
	public List<Negociacao> carrega(InputStream inputStream) {
		XStream stream = new XStream(new DomDriver());
		// clear out existing permissions and set own ones
		stream.addPermission(NoTypePermission.NONE);
		// allow some basics
		stream.addPermission(NullPermission.NULL);
		stream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		stream.allowTypeHierarchy(Collection.class);
		stream.allowTypesByWildcard(new String[] {
			    "br.com.caelum.argentum.modelo.**"
			});
		stream.alias("negociacao", Negociacao.class);				
		return (List<Negociacao>) stream.fromXML(inputStream);
		
	}

}
