package com.project.exceptions;

import com.project.util.MessageUtils;

public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
		super(MessageUtils.NO_RECORDS_FOUND);
	}
}
