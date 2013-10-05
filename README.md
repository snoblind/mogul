#mogul

Java interfaces representing the standard JavaScript web objects (window, navigator, location, history, screen, etc.) with at least one implementation.

[javadoc](http://snoblind.github.io/mogul/apidocs/overview-summary.html)

###EXAMPLE DEMO USAGE

```bash
$ mvn clean compile exec:java -q
```

```javascript
location.href = 'http://www.nytimes.com/';
var bylines = document.querySelectorAll('h6.byline');
for (var i = 0; i < bylines.length; i++) { var story = bylines[i].parentNode; var headline = story.querySelector('h1,h2,h3,h4,h5,h6,h7,h8'); console.log(headline.innerText.trim() + ' ' + bylines[i].innerText.trim()); }
exit()
```

U.S. Says Navy SEALs Stage Raid on Somali Militants By NICHOLAS KULISH and ERIC SCHMITT  
Al Qaeda Suspect Wanted in U.S. Said to Be Taken in Libya By DAVID D. KIRKPATRICK  
Rallies Nationwide Push Immigration Overhaul By JULIA PRESTON  
A Frustrated Alex Rodriguez Turned on the Players Union By SERGE F. KOVALESKI and STEVE EDER  
Gabriella Demczuk/The New York Times By JONATHAN WEISMAN  
Hagel Recalls Most Defense Workers By THOM SHANKER and JONATHAN WEISMAN  
Sunday Review | News Analysis By SAM TANENHAUS  
Obama Urges Patience With Health Exchanges By JACKIE CALMES  
The Building Has 1,000 Eyes By JOANNE KAUFMAN  
Deciding Who Sees Students’ Data By NATASHA SINGER  
Character Study By COREY KILGANNON  
Disunion: Maximilian in Mexico By PHIL LEIGH  

__Watch this space!__
