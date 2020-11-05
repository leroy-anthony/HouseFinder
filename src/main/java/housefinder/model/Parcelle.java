package housefinder.model;

public class Parcelle {
	
	private String prefixe;
	private String section;
	private String numero;
	private String urlFranceCadastre;
	private String urlGoogleMaps;
	private String urlGoogleMapsSearch;
	private String lat;
	private String lon;
	
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getUrlGoogleMapsSearch() {
		return urlGoogleMapsSearch;
	}

	public void setUrlGoogleMapsSearch(String urlGoogleMapsSearch) {
		this.urlGoogleMapsSearch = urlGoogleMapsSearch;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getPrefixe() {
		return prefixe;
	}

	public void setPrefixe(String prefixe) {
		this.prefixe = prefixe;
	}

	public String getSection() {
		return section;
	}
	
	public void setSection(String section) {
		this.section = section;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getUrlFranceCadastre() {
		return urlFranceCadastre;
	}

	public void setUrlFranceCadastre(String urlFranceCadastre) {
		this.urlFranceCadastre = urlFranceCadastre;
	}

	public String getUrlGoogleMaps() {
		return urlGoogleMaps;
	}

	public void setUrlGoogleMaps(String urlGoogleMaps) {
		this.urlGoogleMaps = urlGoogleMaps;
	}
	
	

}
