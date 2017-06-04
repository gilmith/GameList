<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text"/> 
	<xsl:template match="/">
	<xsl:param name="paranmobre"/>
		<xsl:for-each select="Data/Game">
			<xsl:value-of select="$paramnombre"/>
			<xsl:text>ID=</xsl:text>
			<xsl:value-of select="id"/>
			<xsl:text>&#10;</xsl:text>
			<xsl:text>GameTitle=</xsl:text>
			<xsl:value-of select="GameTitle"/>
			<xsl:text>&#10;</xsl:text>
			<xsl:text>ReleaseDate=</xsl:text>
			<xsl:value-of select="ReleaseDate" />
			<xsl:text>&#10;</xsl:text>   
			<xsl:text>Overview=</xsl:text>
			<xsl:value-of select="Overview"/>
			<xsl:text>&#10;</xsl:text>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>