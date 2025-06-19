/*
 * Copyright (c) 2025 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.cowwoc.requirements12.test.java;

/**
 * A class whose instances have the same single-line toString() and hashCode() values but are never equal.
 */
public final class SameLineAndHashCodeWithDifferentIdentity
{
	@Override
	public String toString()
	{
		return "SameToStringAndHashCodeDifferentIdentity.toString()";
	}

	@Override
	public int hashCode()
	{
		return 0;
	}
}
