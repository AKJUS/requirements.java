/*
 * Copyright (c) 2025 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.cowwoc.requirements12.java.validator;

import io.github.cowwoc.requirements12.java.validator.component.ArrayComponent;
import io.github.cowwoc.requirements12.java.validator.component.ObjectComponent;
import io.github.cowwoc.requirements12.java.validator.component.ValidatorComponent;

import java.util.Comparator;

/**
 * Validates the state of a {@code double[]}.
 */
public interface PrimitiveDoubleArrayValidator extends
	ValidatorComponent<PrimitiveDoubleArrayValidator, double[]>,
	ObjectComponent<PrimitiveDoubleArrayValidator, double[]>,
	ArrayComponent<PrimitiveDoubleArrayValidator, double[], Double>
{
	/**
	 * Ensures that the array contains an element.
	 *
	 * @param expected the element
	 * @return this
	 * @throws NullPointerException     if the value is null
	 * @throws IllegalArgumentException if the array does not contain {@code expected}
	 */
	PrimitiveDoubleArrayValidator contains(double expected);

	/**
	 * Ensures that the array contains an element.
	 *
	 * @param expected the element
	 * @param name     the name of the element
	 * @return this
	 * @throws NullPointerException     if the value or {@code name} are null
	 * @throws IllegalArgumentException if:
	 *                                  <ul>
	 *                                    <li>{@code name} is empty</li>
	 *                                    <li>{@code name} contains whitespace</li>
	 *                                    <li>{@code name} is already in use by the value being validated or
	 *                                    the validator context</li>
	 *                                    <li>the array does not contain {@code expected}</li>
	 *                                  </ul>
	 */
	PrimitiveDoubleArrayValidator contains(double expected, String name);

	/**
	 * Ensures that the array does not contain {@code unwanted}.
	 *
	 * @param unwanted the unwanted element
	 * @return this
	 * @throws NullPointerException     if the value is null
	 * @throws IllegalArgumentException if the array contains {@code unwanted}
	 */
	PrimitiveDoubleArrayValidator doesNotContain(double unwanted);

	/**
	 * Ensures that the array does not contain {@code unwanted}.
	 *
	 * @param unwanted the unwanted element
	 * @param name     the name of the unwanted element
	 * @return this
	 * @throws NullPointerException     if the value or {@code name} are null
	 * @throws IllegalArgumentException if:
	 *                                  <ul>
	 *                                    <li>{@code name} is empty</li>
	 *                                    <li>{@code name} contains whitespace</li>
	 *                                    <li>{@code name} is already in use by the value being validated or
	 *                                    the validator context</li>
	 *                                    <li>the array contains {@code unwanted}</li>
	 *                                  </ul>
	 */
	PrimitiveDoubleArrayValidator doesNotContain(double unwanted, String name);

	/**
	 * Ensures that the array is sorted by its natural ordering.
	 *
	 * @return this
	 * @throws NullPointerException if the value is null
	 * @see Comparator#naturalOrder()
	 */
	PrimitiveDoubleArrayValidator isSorted();
}