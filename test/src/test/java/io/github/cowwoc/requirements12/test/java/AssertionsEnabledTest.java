/*
 * Copyright (c) 2025 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.cowwoc.requirements12.test.java;

import io.github.cowwoc.requirements12.java.internal.scope.ApplicationScope;
import io.github.cowwoc.requirements12.test.TestValidators;
import io.github.cowwoc.requirements12.test.TestValidatorsImpl;
import io.github.cowwoc.requirements12.test.scope.TestApplicationScope;
import org.testng.annotations.Test;

import static io.github.cowwoc.requirements12.java.TerminalEncoding.NONE;

public final class AssertionsEnabledTest
{
	@Test(expectedExceptions = AssertionError.class)
	public void assertionsEnabled()
	{
		assert false;
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void assertRequireThat()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			boolean value = true;
			assert validators.requireThat(value, "value").isFalse().elseThrow();
		}
	}

	@Test(expectedExceptions = AssertionError.class)
	public void assertassertThat()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			boolean value = true;
			assert new TestValidatorsImpl(scope).that(value, "value").isFalse().elseThrow();
		}
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void assertCheckIf()
	{
		try (ApplicationScope scope = new TestApplicationScope(NONE))
		{
			TestValidators validators = TestValidators.of(scope);

			boolean value = true;
			assert new TestValidatorsImpl(scope).checkIf(value, "value").isFalse().elseThrow();
		}
	}
}