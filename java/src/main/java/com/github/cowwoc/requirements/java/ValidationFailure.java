/*
 * Copyright (c) 2019 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package com.github.cowwoc.requirements.java;

/**
 * A failed validation.
 */
public interface ValidationFailure
{
	/**
	 * Returns the message corresponding to the validation failure.
	 *
	 * @return the message corresponding to the validation failure
	 */
	String getMessage();

	/**
	 * Returns the type of exception that is associated with this failure.
	 *
	 * @return the type of exception that is associated with this failure
	 */
	Class<? extends Throwable> getType();

	/**
	 * Returns the exception corresponding to the validation failure.
	 *
	 * @return a {@code RuntimeException} or {@code Error}
	 */
	Throwable getException();
}