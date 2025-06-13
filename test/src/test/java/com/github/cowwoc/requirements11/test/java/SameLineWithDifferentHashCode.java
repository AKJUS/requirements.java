/*
 * Copyright (c) 2017 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package com.github.cowwoc.requirements11.test.java;

/**
 * A class whose instances have the same single-line toString() but are never equal.
 */
public final class SameLineWithDifferentHashCode
{
	@Override
	public String toString()
	{
		return "SameToStringDifferentHashCode.toString()";
	}
}
