package com.bancolombia.cuentas.crosscutting.helpers;

import java.util.UUID;

public final class UUIDHelper {

	private static final String DEFAULT_UUID_STRING = "00000000-0000-0000-0000-000000000000";

	private UUIDHelper() {

	}

	public static UUID convertToUUID(final String uuidAsString) {
		return UUID.fromString(uuidAsString);
	}

	public static UUID getDefault(final UUID value, final UUID defaultValue) {
		return ObjectHelper.getDefault(value, defaultValue);
	}

	public static UUID getDefault() {
		return convertToUUID(DEFAULT_UUID_STRING);
	}

	public static UUID generate() {
		return UUID.randomUUID();
	}

	public static boolean isDefault(final UUID value) {
		return getDefault(value, getDefault()).equals(getDefault());
	}

}