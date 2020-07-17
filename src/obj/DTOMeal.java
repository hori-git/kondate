package obj;

import com.fasterxml.jackson.annotation.JsonProperty;

//DTOとプレゼンテーション層で使用するオブジェクトに分ける。
public class DTOMeal {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("isBreakfast")
	private boolean isBreakfast;

	@JsonProperty("isLunch")
	private boolean isLunch;

	@JsonProperty("isDinner")
	private boolean isDinner;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBreakfast(boolean isBreakfast) {
		this.isBreakfast = isBreakfast;
	}

	public void setLunch(boolean isLunch) {
		this.isLunch = isLunch;
	}

	public void setDinner(boolean isDinner) {
		this.isDinner = isDinner;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isBreakfast() {
		return isBreakfast;
	}

	public boolean isLunch() {
		return isLunch;
	}

	public boolean isDinner() {
		return isDinner;
	}


}
