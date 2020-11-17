<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h2>Orarend</h2>
				<table>
					<tr>
						<th></th>
						<th>hetfo</th>
						<th>kedd</th>
						<th>szerda</th>
						<th>csutortok</th>
					</tr>

					<xsl:for-each select="orarend/ora">
						<tr>
							<td><xsl:value-of select="idopont/tol"></xsl:value-of> - <xsl:value-of select="idopont/ig"></xsl:value-of></td>
							<td><xsl:value-of select="targy"></xsl:value-of></td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>