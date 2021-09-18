package com.demo.spring.mock;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.demo.spring.model.Product;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class MockData {
	public static ImmutableList<Product> getProducts() throws IOException {
		InputStream inputStream = Resources.getResource("printer.json").openStream();

		String json = IOUtils.toString(inputStream);
		Type listType = new TypeToken<ArrayList<Product>>() {
		}.getType();
		List<Product> products = new Gson().fromJson(json, listType);
		return ImmutableList.copyOf(products);

	}
}
