# Automation on search engine GUI

This java application uses selenium to automate bing and google search engine GUI 
and print the total search results returned by  the chosen search engine as well as the top N URLs in the results 
page(only 1st page at the moment).

#### Note that this currently only works on Mac os. To execute this on Linux or Windows os, download the chrome driver for the respective os. Change the path of the chrome driver in search.java file and recreate a jar.


The following inputs are accepted from the command line
 1. Name of the search engine ('google' or 'bing' only)
 2. Search term
 3. The number of results (URLs) from the results page.( For 'google' between 1 to  10, 'bing' between 1 to  7)
 

## Example
To run this application, execute the following command:
```shell

cd /path/to/the/repo
java -jar search.jar
Enter the search engine
bing
Enter the search term
selenium
Enter the number of results
6
```
### Output
```shell
Starting ChromeDriver 79.0.3945.36 (3582db32b33893869b8c1339e8f4d9ed1816f143-refs/branch-heads/3945@{#614}) on port 12123
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Dec 12, 2019 9:50:46 AM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: W3C
number of results: 23.300.000
List of urls: 
https://de.wikipedia.org/wiki/Selenium
https://www.netdoktor.de/schuessler-salze/schuessler-salz-nr-26-selenium/
https://www.hallo-homoeopathie.de/mittel/selenium
https://www.heise.de/download/product/selenium-54709
https://www.dict.cc/englisch-deutsch/selenium.html
https://de.wikipedia.org/wiki/Selen


```
Google doesn't like its page used by automated scripts, therefore it interrupts with Captcha. If you are testing multiple times start with bing and then adapt to google.
