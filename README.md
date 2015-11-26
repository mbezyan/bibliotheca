# bibliotheca
A simple library member and asset management prototype

Requires Maven to build:
mvn jetty:run

If the above command produces the following error message:

[ERROR] No plugin found for prefix ‘jetty’ in the current project and in the plugin groups [org.apache.maven.plugin
s, org.codehaus.mojo] available from the repositories [local (C:\Users\JavaHonk\.m2\repository), central (https://repo.
maven.apache.org/maven2)] -> [Help 1]

Then Maven settings.xml needs to be modified to include org.mortbay.jetty.

Modify the following section in [Maven-installation-folder]/conf/settings.xml:

<pluginGroups>
    <!-- pluginGroup
     | Specifies a further group identifier to use for plugin lookup.
    <pluginGroup>com.your.plugins</pluginGroup>
    -->
	<pluginGroup>org.mortbay.jetty</pluginGroup>
</pluginGroups>

Once the application is running Jetty, access it through your browser on:

localhost:8080/bibliotheca
