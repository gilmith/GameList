<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:output method="text"/>	<xsl:template match="/">
	<xsl:for-each select="Data/Game">
		<xsl:text>Resultado=</xsl:text>
		<xsl:variable name="posicion" select="position()"/>
		<xsl:value-of select="$posicion" />
		<xsl:text>&#10;</xsl:text>				
		<xsl:if test = "GameTitle" >				
			<xsl:text>Titulo[</xsl:text>
			<xsl:value-of select="$posicion"/>
			<xsl:text>]=</xsl:text>				
			<xsl:value-of select="GameTitle"/>
			<xsl:text>&#10;</xsl:text>						
		</xsl:if>
		<xsl:if test="Publisher">
			<xsl:text>Publicadora[</xsl:text>
			<xsl:value-of select="$posicion"/>
			<xsl:text>]=</xsl:text>
			<xsl:value-of select="Publisher"/>
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test= "Overview" >
			<xsl:text>Resumen[</xsl:text>
			<xsl:value-of select="$posicion"/>
			<xsl:text>]=</xsl:text>
			<xsl:variable name="resumen" select="Overview"/>
			<xsl:value-of select="translate( $resumen,'&#10;','')"/>
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test="Genres">
			<xsl:text>Genero[</xsl:text>
			<xsl:value-of select="$posicion"/>
			<xsl:text>]=</xsl:text>
			<xsl:for-each select="genre">
				<xsl:value-of select="." />
				<xsl:text>,</xsl:text>
			</xsl:for-each>
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test= "id" >
			<xsl:text>id[</xsl:text>
			<xsl:value-of select="$posicion"/>
			<xsl:text>]=</xsl:text>
			<xsl:value-of select="id" />
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test= "Players" >
			<xsl:text>Jugadores[</xsl:text>
			<xsl:value-of select="$posicion"/>
			<xsl:text>]=</xsl:text>
			<xsl:value-of select="Players" />
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test= "ReleaseDate" >
			<xsl:text>Lanzamiento[</xsl:text>
			<xsl:value-of select="$posicion" />
			<xsl:text>]=</xsl:text>
			<xsl:value-of select="ReleaseDate" />
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test= "Developer" >
			<xsl:text>Desarrolladora[</xsl:text>
			<xsl:value-of select="$posicion" />
			<xsl:text>]=</xsl:text>
			<xsl:value-of select="Developer" />
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
		<xsl:if test= "Rating" >
			<xsl:text>Nota[</xsl:text>
			<xsl:value-of select="$posicion" />
			<xsl:text>]=</xsl:text>
			<xsl:value-of select="Rating" />
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
			<xsl:if test= "boxart[@side = 'front']" >
			<xsl:text>Portada[</xsl:text>
			<xsl:value-of select="$posicion" />
			<xsl:text>]=</xsl:text>
			<xsl:value-of select="boxart[@side = 'front']" />
			<xsl:text>&#10;</xsl:text>
		</xsl:if>
	</xsl:for-each>		
	</xsl:template>
	</xsl:stylesheet>
