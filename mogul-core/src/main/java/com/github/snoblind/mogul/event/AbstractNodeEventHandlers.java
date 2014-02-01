package com.github.snoblind.mogul.event;

import com.github.snoblind.mogul.EventListener;
import com.github.snoblind.mogul.NodeEventHandlers;
import com.github.snoblind.mogul.OnErrorEventHandler;

public abstract class AbstractNodeEventHandlers implements NodeEventHandlers {
	
	private EventListener onblur;
	private OnErrorEventHandler onerror;
	private EventListener onfocus;
	private EventListener onload;
	private EventListener onscroll;

	public EventListener getOnblur() {
		return onblur;
	}

	public void setOnblur(EventListener onblur) {
		this.onblur = onblur;
	}

	public OnErrorEventHandler getOnerror() {
		return onerror;
	}

	public void setOnerror(OnErrorEventHandler onerror) {
		this.onerror = onerror;
	}

	public EventListener getOnfocus() {
		return onfocus;
	}

	public void setOnfocus(EventListener onfocus) {
		this.onfocus = onfocus;
	}

	public EventListener getOnload() {
		return onload;
	}

	public void setOnload(EventListener onload) {
		this.onload = onload;
	}

	public EventListener getOnscroll() {
		return onscroll;
	}

	public void setOnscroll(EventListener onscroll) {
		this.onscroll = onscroll;
	}
}
