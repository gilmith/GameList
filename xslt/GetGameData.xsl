<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="text"/>	<xsl:template match="/">
	<xsl:for-each select="Data/Game">
	 	<xsl:param name="paramnombre"/>
		<xsl:text>PARAMETRO=</xsl:text>
		<xsl:value-of select="$paramnombre"/>
		<xsl:text>&#10;</xsl:text>
		<xsl:if test ="$paramnombre=GameTitle" > 
			<xsl:if test ="GameTitle" >				
				<xsl:text>Titulo=</xsl:text>
				<xsl:value-of select="GameTitle"/>
				<xsl:text>&#10;</xsl:text>						
			</xsl:if>
			<xsl:if test="Publisher">
				<xsl:text>Publicadora=</xsl:text>
				<xsl:value-of select="Publisher"/>
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test= "Overview" >
				<xsl:text>Resumen=</xsl:text>
				<xsl:variable name="resumen" select="Overview"/>
				<xsl:value-of select="translate( $resumen,'&#10;','')"/>
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test="Genres">
				<xsl:text>Genero=</xsl:text>
				<xsl:for-each select="Genres/genre">
					<xsl:value-of select="." />
					<xsl:text>,</xsl:text>
				</xsl:for-each>
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test= "id" >
				<xsl:text>id=</xsl:text>
				<xsl:value-of select="id" />
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test= "Players" >
				<xsl:text>Jugadores=</xsl:text>
				<xsl:value-of select="Players" />
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test= "ReleaseDate" >
				<xsl:text>Lanzamiento=</xsl:text>
				<xsl:value-of select="ReleaseDate" />
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test= "Developer" >
				<xsl:text>Desarrolladora=</xsl:text>
				<xsl:value-of select="Developer" />
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test= "Rating" >
				<xsl:text>Nota=</xsl:text>
				<xsl:value-of select="Rating" />
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
			<xsl:if test= "Images/boxart[@side = 'front']" >
				<xsl:text>Portada=</xsl:text>
				<xsl:value-of select="Images/boxart[@side = 'front']" />
				<xsl:text>&#10;</xsl:text>
			</xsl:if>
 		</xsl:if>
 	</xsl:for-each>		
	</xsl:template>
	</xsl:stylesheet>
