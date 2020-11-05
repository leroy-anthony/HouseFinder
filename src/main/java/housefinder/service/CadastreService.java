package housefinder.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import housefinder.model.Parcelle;
import housefinder.model.Result;

@Service
public class CadastreService {

	public List<Parcelle> listBySize(int value, int codeinsee) {

		WebClient webClient = WebClient.builder()
				.exchangeStrategies(ExchangeStrategies.builder()
						.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build())
				.build();
		String json = webClient.get().uri(
				"https://cadastre.data.gouv.fr/bundler/cadastre-etalab/communes/" + codeinsee + "/geojson/parcelles")
				.exchange().block().bodyToMono(String.class).block();

		ObjectMapper mapper = new ObjectMapper();

		List<Parcelle> parcelles = new ArrayList<>();

		try {

			// convert JSON string to Map
			Map<String, ArrayList> map = mapper.readValue(json, Map.class);
			List<Map<String, Object>> list = map.get("features");
			for (Map<String, Object> map2 : list) {
				Map<String, Object> geometryMap = (Map<String, Object>) map2.get("geometry");
				Map<String, Object> m3 = (Map<String, Object>) map2.get("properties");

				if (m3.containsKey("contenance") && m3.get("contenance").equals(value)) {

					try {
						List<List<Double>> coords = ((ArrayList<List<List<Double>>>) geometryMap.get("coordinates")).get(0);
	
						Double lon = coords.get(0).get(0);
						Double lat = coords.get(0).get(1);
						String id = (String) m3.get("id");
						String prefixe = (String) m3.get("prefixe");
						String section = (String) m3.get("section");
						String numero = (String) m3.get("numero");
						String urlFranceCadastre = "https://cadastre.data.gouv.fr/map?style=ortho&parcelleId=" + id + "#19/"
								+ lat + "/" + lon + "";
						String urlGoogleMaps = "https://www.google.com/maps/@" + lat + "," + lon + ",19.5z";
						Parcelle parcelle = new Parcelle();
						parcelle.setLat(lat + "");
						parcelle.setLon(lon + "");
						parcelle.setNumero(numero);
						parcelle.setPrefixe(prefixe);
						parcelle.setSection(section);
						parcelle.setUrlFranceCadastre(urlFranceCadastre);
						parcelle.setUrlGoogleMaps(urlGoogleMaps);
	
						String url = "https://api-adresse.data.gouv.fr/reverse/?lon=" + lon + "&lat=" + lat;
						Result address = webClient.get().uri(url).exchange().block().bodyToMono(Result.class).block();
						parcelle.setAddress(address.getFeatures().get(0).getProperties());
						parcelle.getAddress().getLabel().replaceAll(" ", "+");
	
						String urlGoogleMapsSearch = "https://www.google.com/maps/place/"
								+ parcelle.getAddress().getLabel().replaceAll(" ", "+");
						parcelle.setUrlGoogleMapsSearch(urlGoogleMapsSearch);
	
						parcelles.add(parcelle);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return parcelles;
	}
	
}
