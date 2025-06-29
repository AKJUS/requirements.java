/*
 * Copyright (c) 2025 Gili Tzabari
 * Licensed under the Apache License, Version 2.0: http://www.apache.org/licenses/LICENSE-2.0
 */
package io.github.cowwoc.requirements12.java.internal.validator;

import io.github.cowwoc.requirements12.java.ValidationFailure;
import io.github.cowwoc.requirements12.java.internal.Configuration;
import io.github.cowwoc.requirements12.java.internal.scope.ApplicationScope;
import io.github.cowwoc.requirements12.java.internal.util.ValidationTarget;
import io.github.cowwoc.requirements12.java.validator.PrimitiveDoubleValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class PrimitiveDoubleValidatorImpl
	extends AbstractPrimitiveValidator<PrimitiveDoubleValidator, Double>
	implements PrimitiveDoubleValidator
{
	private final Doubles<PrimitiveDoubleValidator> doubles = new Doubles<>(this);

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
	public PrimitiveDoubleValidatorImpl(ApplicationScope scope, Configuration configuration, String name,
		ValidationTarget<Double> value, Map<String, Optional<Object>> context, List<ValidationFailure> failures)
	{
		super(scope, configuration, name, value, context, failures);
	}

	@Override
	public double getValue()
	{
		return value.orThrow(VALUE_IS_UNDEFINED);
	}

	@Override
	public double getValueOrDefault(double defaultValue)
	{
		return value.or(defaultValue);
	}

	@Override
	public PrimitiveDoubleValidator isEqualTo(double expected)
	{
		return doubles.isEqualTo(expected);
	}

	@Override
	public PrimitiveDoubleValidator isEqualTo(double expected, String name)
	{
		return doubles.isEqualTo(expected, name);
	}

	@Override
	public PrimitiveDoubleValidator isNotEqualTo(double unwanted)
	{
		return doubles.isNotEqualTo(unwanted);
	}

	@Override
	public PrimitiveDoubleValidator isNotEqualTo(double unwanted, String name)
	{
		return doubles.isNotEqualTo(unwanted, name);
	}

	@Override
	public PrimitiveDoubleValidator isNegative()
	{
		return doubles.isNegative();
	}

	@Override
	public PrimitiveDoubleValidator isNotNegative()
	{
		return doubles.isNotNegative();
	}

	@Override
	public PrimitiveDoubleValidator isZero()
	{
		return doubles.isZero();
	}

	@Override
	public PrimitiveDoubleValidator isNotZero()
	{
		return doubles.isNotZero();
	}

	@Override
	public PrimitiveDoubleValidator isPositive()
	{
		return doubles.isPositive();
	}

	@Override
	public PrimitiveDoubleValidator isNotPositive()
	{
		return doubles.isNotPositive();
	}

	@Override
	public PrimitiveDoubleValidator isLessThan(double maximumExclusive)
	{
		return doubles.isLessThan(maximumExclusive);
	}

	@Override
	public PrimitiveDoubleValidator isLessThan(double maximumExclusive, String name)
	{
		return doubles.isLessThan(maximumExclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isLessThanOrEqualTo(double maximumInclusive)
	{
		return doubles.isLessThanOrEqualTo(maximumInclusive);
	}

	@Override
	public PrimitiveDoubleValidator isLessThanOrEqualTo(double maximumInclusive, String name)
	{
		return doubles.isLessThanOrEqualTo(maximumInclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThanOrEqualTo(double minimumInclusive)
	{
		return doubles.isGreaterThanOrEqualTo(minimumInclusive);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThanOrEqualTo(double minimumInclusive, String name)
	{
		return doubles.isGreaterThanOrEqualTo(minimumInclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThan(double minimumExclusive)
	{
		return doubles.isGreaterThan(minimumExclusive);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThan(double minimumExclusive, String name)
	{
		return doubles.isGreaterThan(minimumExclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isBetween(double minimumInclusive, double maximumExclusive)
	{
		return doubles.isBetween(minimumInclusive, maximumExclusive);
	}

	@Override
	public PrimitiveDoubleValidator isBetween(double minimum, boolean minimumIsInclusive, double maximum,
		boolean maximumIsInclusive)
	{
		return doubles.isBetween(minimum, minimumIsInclusive, maximum, maximumIsInclusive);
	}

	@Override
	public PrimitiveDoubleValidator isMultipleOf(double factor)
	{
		return doubles.isMultipleOf(factor);
	}

	@Override
	public PrimitiveDoubleValidator isMultipleOf(double factor, String name)
	{
		return doubles.isMultipleOf(factor, name);
	}

	@Override
	public PrimitiveDoubleValidator isNotMultipleOf(double factor)
	{
		return doubles.isNotMultipleOf(factor);
	}

	@Override
	public PrimitiveDoubleValidator isNotMultipleOf(double factor, String name)
	{
		return doubles.isNotMultipleOf(factor, name);
	}

	@Override
	public PrimitiveDoubleValidator isLessThan(Double maximumExclusive)
	{
		return doubles.isLessThan(maximumExclusive);
	}

	@Override
	public PrimitiveDoubleValidator isLessThan(Double maximumExclusive, String name)
	{
		return doubles.isLessThan(maximumExclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isLessThanOrEqualTo(Double maximumInclusive)
	{
		return doubles.isLessThanOrEqualTo(maximumInclusive);
	}

	@Override
	public PrimitiveDoubleValidator isLessThanOrEqualTo(Double maximumInclusive, String name)
	{
		return doubles.isLessThanOrEqualTo(maximumInclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThanOrEqualTo(Double minimumInclusive)
	{
		return doubles.isGreaterThanOrEqualTo(minimumInclusive);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThanOrEqualTo(Double minimumInclusive, String name)
	{
		return doubles.isGreaterThanOrEqualTo(minimumInclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThan(Double minimumExclusive)
	{
		return doubles.isGreaterThan(minimumExclusive);
	}

	@Override
	public PrimitiveDoubleValidator isGreaterThan(Double minimumExclusive, String name)
	{
		return doubles.isGreaterThan(minimumExclusive, name);
	}

	@Override
	public PrimitiveDoubleValidator isBetween(Double minimumInclusive, Double maximumExclusive)
	{
		return doubles.isBetween(minimumInclusive, maximumExclusive);
	}

	@Override
	public PrimitiveDoubleValidator isBetween(Double minimum, boolean minimumIsInclusive, Double maximum,
		boolean maximumIsInclusive)
	{
		return doubles.isBetween(minimum, minimumIsInclusive, maximum, maximumIsInclusive);
	}

	@Override
	public PrimitiveDoubleValidator isNumber()
	{
		return doubles.isNumber();
	}

	@Override
	public PrimitiveDoubleValidator isNotNumber()
	{
		return doubles.isNotNumber();
	}

	@Override
	public PrimitiveDoubleValidator isFinite()
	{
		return doubles.isFinite();
	}

	@Override
	public PrimitiveDoubleValidator isInfinite()
	{
		return doubles.isInfinite();
	}

	@Override
	public PrimitiveDoubleValidator isWholeNumber()
	{
		return doubles.isWholeNumber();
	}

	@Override
	public PrimitiveDoubleValidator isNotWholeNumber()
	{
		return doubles.isNotWholeNumber();
	}
}