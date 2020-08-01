package obj;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DTOMenu {

	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Timestamp date;

	@JsonProperty("meal_time")
	private String mealTime;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("meal_id")
	private int mealId;

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getMealTime() {
		return mealTime;
	}

	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

}
