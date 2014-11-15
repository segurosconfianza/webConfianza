package com.confianza.webapp.repository.framework.frmperfil;

import java.lang.reflect.Type;

import com.confianza.webapp.utils.TypeConverter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class FrmPerfilSerializer implements JsonSerializer<FrmPerfil>{

	@Override
	public JsonElement serialize(FrmPerfil frmPerfil, Type type, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		TypeConverter tp=new TypeConverter();
		result.add("peficons", new JsonPrimitive(frmPerfil.getPeficons()));
		result.add("pefinomb", new JsonPrimitive(frmPerfil.getPefinomb()));
		result.add("pefidesc", new JsonPrimitive(frmPerfil.getPefidesc()));
		result.add("pefifecr", new JsonPrimitive(tp.dateToString(frmPerfil.getPefifecr())));
		return result;
	}

}
