package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {
	//オブジェクト型からJSON(String型)へ変換する。
	public String object2json(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String respoceJson = mapper.writeValueAsString(object);
		return respoceJson;
	}
}
