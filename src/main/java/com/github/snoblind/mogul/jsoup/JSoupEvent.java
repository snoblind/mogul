package com.github.snoblind.mogul.jsoup;

import com.github.snoblind.mogul.EventTarget;
import com.github.snoblind.mogul.event.AbstractEvent;

import static org.apache.commons.lang.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang.builder.ToStringStyle.MULTI_LINE_STYLE;

public class JSoupEvent extends AbstractEvent {

	protected void setTarget(EventTarget target) {
		this.target = target;
	}

	public String toString() {
		return reflectionToString(this, MULTI_LINE_STYLE);
	}
}
