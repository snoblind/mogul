#mogul

Java interfaces representing the standard HTML5/JavaScript web objects (window, navigator, location, history, screen, etc.) with at least one implementation.

[javadoc](http://snoblind.github.io/mogul/apidocs/overview-summary.html)


###Example Demo Usage:

```bash
$ mvn clean compile exec:java -q
```

```javascript
location.href = 'http://www.nytimes.com/';
console.log(document.getElementById('date').innerText);
var bylines = document.querySelectorAll('h6.byline');
for (var i = 0; i < bylines.length; i++) {
    var headline = bylines[i].parentNode.querySelector('h1,h2,h3,h4,h5,h6,h7,h8');
    console.log(headline.innerText.trim() + ' ' + bylines[i].innerText.trim());
}
exit();
.
```

####Example Output:
> Sunday, October 6, 2013 Last Update: 10:48 AM ET  
A Federal Budget Crisis Months in the Planning By SHERYL GAY STOLBERG and MIKE McINTIRE  
Libyan Government Wants Explanation After U.S. Raid By DAVID D. KIRKPATRICK, NICHOLAS KULISH and ERIC SCHMITT  
Bible College Helps Some at Louisiana Prison Find Peace By ERIK ECKHOLM  
Brian Blanco for The New York Times By DAVID SEGAL  
Karzai to Be There for Successor. Right There. By MATTHEW ROSENBERG  
Selling Secrets of Smartphone Users to Advertisers By CLAIRE CAIN MILLER and SOMINI SENGUPTA  
Greeks Call for World War II Reparations By SUZANNE DALEY  
Video Feature:  Snap. Hold. Kick.   
Marseille, the Secret Capital of France By MICHAEL KIMMELMAN  
Opinion By ÓSCAR MARTÍNEZ  
Editorial: The Supreme Court Returns By THE EDITORIAL BOARD  
