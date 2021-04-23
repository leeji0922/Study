package Role;

public enum Role {

	ADMIN("1"), USER("2"), GUEST("3");

	private String code;
	private String label;

	Role(String code) {
		this.code = name();
		this.label = label;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


}
