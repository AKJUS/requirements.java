/*
 * Copyright (c) 2025 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.cowwoc.requirements12.java.validator;

import io.github.cowwoc.requirements12.java.validator.component.ObjectComponent;
import io.github.cowwoc.requirements12.java.validator.component.ValidatorComponent;

import java.net.InetAddress;

/**
 * Validates the state of an {@code InetAddress}.
 */
public interface InetAddressValidator extends
	ValidatorComponent<InetAddressValidator, InetAddress>,
	ObjectComponent<InetAddressValidator, InetAddress>
{
	/**
	 * Ensures that the value is an IP v4 address.
	 *
	 * @return this
	 * @throws NullPointerException     if the value is null
	 * @throws IllegalArgumentException if the value is not an IP v4 address
	 */
	InetAddressValidator isIpV4();

	/**
	 * Ensures that the actual value is an IP v6 address.
	 *
	 * @return this
	 * @throws NullPointerException     if the value is null
	 * @throws IllegalArgumentException if the value is not an IP v6 address
	 */
	InetAddressValidator isIpV6();
}