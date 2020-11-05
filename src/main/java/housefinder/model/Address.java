package housefinder.model;

public class Address {
	
	String label;
    Double score;
    String housenumber;
    String id;
    String type;
    String name;
    String postcode;
    String citycode;
    Double x;
    Double y;
    String city;
    String context;
    Double importance;
    String street;
    
	@Override
	public String toString() {
		return "Address [label=" + label + ", score=" + score + ", housenumber=" + housenumber + ", id=" + id
				+ ", type=" + type + ", name=" + name + ", postcode=" + postcode + ", citycode=" + citycode + ", x=" + x
				+ ", y=" + y + ", city=" + city + ", context=" + context + ", importance=" + importance + ", street="
				+ street + "]";
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getHousenumber() {
		return housenumber;
	}
	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Double getImportance() {
		return importance;
	}
	public void setImportance(Double importance) {
		this.importance = importance;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
    
    
}
