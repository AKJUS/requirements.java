/*
 * Copyright (c) 2017 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package com.github.cowwoc.requirements11.test.java;

import com.github.cowwoc.requirements11.java.internal.scope.ApplicationScope;
import com.github.cowwoc.requirements11.test.TestValidators;
import com.github.cowwoc.requirements11.test.TestValidatorsImpl;
import com.github.cowwoc.requirements11.test.scope.TestApplicationScope;
import org.testng.annotations.Test;

import static com.github.cowwoc.requirements11.java.TerminalEncoding.NONE;

@SuppressWarnings("ConstantConditions")
public final class CharacterTest
{
	@Test(expectedExceptions = NullPointerException.class)
	public void nameIsNull()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '1';
			validators.requireThat(actual, null);
		}
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void nameIsEmpty()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '1';
			validators.requireThat(actual, "");
		}
	}

	@Test
	public void isBetween_actualIsLowerBound()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '0';
			char first = '0';
			char last = '2';
			validators.requireThat(actual, "actual").isBetween(first, last);
		}
	}

	@Test
	public void isBetween_actualIsInBounds()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '1';
			char first = '0';
			char last = '2';
			validators.requireThat(actual, "actual").isBetween(first, last);
		}
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void isBetween_actualIsUpperBound()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '2';
			char first = '0';
			char last = '2';
			validators.requireThat(actual, "actual").isBetween(first, last);
		}
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void isBetween_actualIsBelow()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '1';
			char first = '3';
			char last = '4';
			validators.requireThat(actual, "actual").isBetween(first, last);
		}
	}

	@Test
	public void isBetweenClosed_actualIsUpperBound()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '2';
			char first = '0';
			char last = '2';
			validators.requireThat(actual, "actual").isBetween(first, true, last, true);
		}
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertionsEnabled()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			char actual = '1';
			assert new TestValidatorsImpl(scope).that(actual, "actual").isGreaterThan(actual).elseThrow();
		}
	}
}
