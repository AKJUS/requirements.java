/*
 * Copyright (c) 2025 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.cowwoc.requirements12.java.internal.validator;

import io.github.cowwoc.requirements12.java.ValidationFailure;
import io.github.cowwoc.requirements12.java.internal.Configuration;
import io.github.cowwoc.requirements12.java.internal.message.ObjectMessages;
import io.github.cowwoc.requirements12.java.internal.message.StringMessages;
import io.github.cowwoc.requirements12.java.internal.scope.ApplicationScope;
import io.github.cowwoc.requirements12.java.internal.util.Pluralizer;
import io.github.cowwoc.requirements12.java.internal.util.ValidationTarget;
import io.github.cowwoc.requirements12.java.validator.PrimitiveUnsignedIntegerValidator;
import io.github.cowwoc.requirements12.java.validator.StringValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public final class StringValidatorImpl extends AbstractObjectValidator<StringValidator, String>
	implements StringValidator
{
	/**
	 * @param scope         the application configuration
	 * @param configuration the validator configuration
	 * @param name          the name of the value
	 * @param value         the value being validated
	 * @param context       the contextual information set by a parent validator or the user
	 * @param failures      the list of validation failures
	 * @throws NullPointerException     if {@code name} is null
	 * @throws IllegalArgumentException if {@code name} contains whitespace, or is empty
	 * @throws AssertionError           if {@code scope}, {@code configuration}, {@code value}, {@code context}
	 *                                  or {@code failures} are null
	 */
	public StringValidatorImpl(ApplicationScope scope, Configuration configuration, String name,
		ValidationTarget<String> value, Map<String, Optional<Object>> context, List<ValidationFailure> failures)
	{
		super(scope, configuration, name, value, context, failures);
	}

	@Override
	public StringValidator isEmpty()
	{
		if (value.validationFailed(String::isEmpty))
		{
			failOnNull();
			addIllegalArgumentException(
				ObjectMessages.isEmptyFailed(this).toString());
		}
		return this;
	}

	@Override
	public StringValidator isNotEmpty()
	{
		if (value.validationFailed(v -> !v.isEmpty()))
		{
			failOnNull();
			addIllegalArgumentException(
				ObjectMessages.isNotEmptyFailed(this).toString());
		}
		return this;
	}

	@Override
	public StringValidator isBlank()
	{
		if (value.validationFailed(String::isBlank))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.isBlank(this).toString());
		}
		return this;
	}

	@Override
	public StringValidator isNotBlank()
	{
		if (value.validationFailed(v -> !v.isBlank()))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.isNotBlank(this).toString());
		}
		return this;
	}

	@Override
	public StringValidator isTrimmed()
	{
		if (value.validationFailed(StringValidatorImpl::isTrimmed))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.isTrimmed(this).toString());
		}
		return this;
	}

	/**
	 * @param value a value
	 * @return {@code true} if the value is trimmed, or {@code false} if it is undefined, {@code null} or
	 * contains leading or trailing whitespace
	 */
	private static boolean isTrimmed(String value)
	{
		int length = value.length();
		if (length == 0)
			return true;
		boolean foundWhitespace = (value.charAt(0) & 0xff) <= ' ';
		if (!foundWhitespace && length > 1)
			foundWhitespace = (value.charAt(length - 1) & 0xff) <= ' ';
		return !foundWhitespace;
	}

	@Override
	public StringValidator isStripped()
	{
		if (value.validationFailed(StringValidatorImpl::isStripped))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.isStripped(this).toString());
		}
		return this;
	}

	/**
	 * @param value a value
	 * @return {@code true} if the value is stripped, or {@code false} if it is undefined, {@code null} or
	 * contains leading or trailing Unicode whitespace
	 */
	private static boolean isStripped(String value)
	{
		int length = value.length();
		if (length == 0)
			return true;
		int codepoint = value.codePointAt(0);
		boolean foundWhitespace = Character.isWhitespace(codepoint);
		if (!foundWhitespace && length > 1)
		{
			codepoint = value.codePointAt(length - 1);
			foundWhitespace = Character.isWhitespace(codepoint);
		}
		return !foundWhitespace;
	}

	@Override
	public StringValidator startsWith(String prefix)
	{
		scope.getInternalValidators().requireThat(prefix, "prefix").isNotNull();
		if (value.validationFailed(v -> v.startsWith(prefix)))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.startsWith(this, prefix).toString());
		}
		return this;
	}

	@Override
	public StringValidator doesNotStartWith(String prefix)
	{
		scope.getInternalValidators().requireThat(prefix, "prefix").isNotNull();
		if (value.validationFailed(v -> !v.startsWith(prefix)))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.doesNotStartWith(this, prefix).toString());
		}
		return this;
	}

	@Override
	public StringValidator endsWith(String suffix)
	{
		scope.getInternalValidators().requireThat(suffix, "suffix").isNotNull();
		if (value.validationFailed(v -> v.endsWith(suffix)))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.endsWith(this, suffix).toString());
		}
		return this;
	}

	@Override
	public StringValidator doesNotEndWith(String suffix)
	{
		scope.getInternalValidators().requireThat(suffix, "suffix").isNotNull();
		if (value.validationFailed(v -> !v.endsWith(suffix)))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.doesNotEndWith(this, suffix).toString());
		}
		return this;
	}

	@Override
	public StringValidator contains(String expected)
	{
		scope.getInternalValidators().requireThat(expected, "expected").isNotNull();
		if (value.validationFailed(v -> v.contains(expected)))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.contains(this, expected).toString());
		}
		return this;
	}

	@Override
	public StringValidator doesNotContain(String unwanted)
	{
		scope.getInternalValidators().requireThat(unwanted, "unwanted").isNotNull();
		if (value.validationFailed(v -> !v.contains(unwanted)))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.doesNotContain(this, unwanted).toString());
		}
		return this;
	}

	@Override
	public StringValidator doesNotContainWhitespace()
	{
		if (value.validationFailed(v ->
		{
			int length = v.length();
			if (length == 0)
				return true;
			for (int i = 0; i < length; ++i)
			{
				int codepoint = v.codePointAt(i);
				if (Character.isWhitespace(codepoint))
					return false;
			}
			return true;
		}))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.doesNotContainWhitespace(this).toString());
		}
		return this;
	}

	@Override
	public StringValidator matches(String regex)
	{
		return matches(Pattern.compile(regex));
	}

	@Override
	public StringValidator matches(Pattern regex)
	{
		scope.getInternalValidators().requireThat(regex, "regex").isNotNull();
		if (value.validationFailed(v -> regex.matcher(v).matches()))
		{
			failOnNull();
			addIllegalArgumentException(
				StringMessages.matches(this, regex).toString());
		}
		return this;
	}

	@Override
	public PrimitiveUnsignedIntegerValidator length()
	{
		failOnNull();
		return new ObjectSizeValidatorImpl(scope, configuration, this, name + ".length()",
			value.nullToInvalid().map(String::length), Pluralizer.CHARACTER, context, failures);
	}
}