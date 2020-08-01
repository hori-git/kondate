package obj;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JSONMenu {
	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("meal_time")
	private String mealTime;

	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp mealDate;

	public Timestamp getMealDate() {
		return mealDate;
	}

	public void setMealDate(Timestamp mealDate) {
		this.mealDate = mealDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMealTime() {
		return mealTime;
	}

	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}

}
