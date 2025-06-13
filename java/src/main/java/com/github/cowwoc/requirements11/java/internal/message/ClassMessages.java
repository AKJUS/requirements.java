package com.github.cowwoc.requirements11.java.internal.message;

import com.github.cowwoc.requirements11.java.GenericType;
import com.github.cowwoc.requirements11.java.internal.message.section.MessageBuilder;
import com.github.cowwoc.requirements11.java.internal.validator.AbstractValidator;

/**
 * Generates failure messages for classes.
 */
public final class ClassMessages
{
	private ClassMessages()
	{
	}

	/**
	 * @param validator the validator
	 * @return a message for the validation failure
	 */
	public static MessageBuilder isPrimitiveFailed(AbstractValidator<?, ?> validator)
	{
		return ValidatorMessages.constraintFailed(validator, "must be a primitive type");
	}

	/**
	 * @param validator the validator
	 * @param subtype   the subtype
	 * @return a message for the validation failure
	 */
	public static MessageBuilder isSupertypeOfFailed(AbstractValidator<?, ?> validator, GenericType<?> subtype)
	{
		String name = validator.getName();
		MessageBuilder messageBuilder = new MessageBuilder(validator,
			MessageBuilder.quoteName(name) + " must be a supertype of " + subtype + ".");
		validator.value.ifValid(v -> messageBuilder.withContext(v, name));
		return messageBuilder;
	}

	/**
	 * @param validator the validator
	 * @param supertype the supertype
	 * @return a message for the validation failure
	 */
	public static MessageBuilder isSubtypeOfFailed(AbstractValidator<?, ?> validator, GenericType<?> supertype)
	{
		String name = validator.getName();
		MessageBuilder messageBuilder = new MessageBuilder(validator,
			MessageBuilder.quoteName(name) + " must be a subtype of " + supertype + ".");
		validator.value.ifValid(v -> messageBuilder.withContext(v, name));
		return messageBuilder;
	}
}