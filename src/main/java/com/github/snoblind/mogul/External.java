package com.github.snoblind.mogul;

public interface External {
	void AddSearchProvider(String engineURL);
	long IsSearchProviderInstalled(String engineURL);
}
